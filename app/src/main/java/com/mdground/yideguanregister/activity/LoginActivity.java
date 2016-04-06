package com.mdground.yideguanregister.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.mdground.yideguanregister.MedicalAppliction;
import com.mdground.yideguanregister.R;
import com.mdground.yideguanregister.activity.searchpatient.SearchPatientActivity;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.ResponseCode;
import com.mdground.yideguanregister.api.base.ResponseData;
import com.mdground.yideguanregister.api.server.clinic.GetClinic;
import com.mdground.yideguanregister.api.server.global.LoginEmployee;
import com.mdground.yideguanregister.api.utils.DeviceIDUtil;
import com.mdground.yideguanregister.api.utils.DeviceUtils;
import com.mdground.yideguanregister.api.utils.NetworkStatusUtil;
import com.mdground.yideguanregister.api.utils.SharedPreferUtils;
import com.mdground.yideguanregister.bean.Clinic;
import com.mdground.yideguanregister.bean.Employee;
import com.mdground.yideguanregister.constant.MemberConstant;
import com.mdground.yideguanregister.dialog.LoadingDialog;
import com.mdground.yideguanregister.util.MdgConfig;
import com.mdground.yideguanregister.util.PreferenceUtils;
import com.mdground.yideguanregister.view.ResizeLayout;

import org.apache.http.Header;

public class LoginActivity extends Activity implements OnClickListener, ResizeLayout.OnResizeListener {

	private ResizeLayout LoginRootLayout;
	private ScrollView scrollView;
	private EditText et_account, et_password;

	private LoadingDialog mLoadIngDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);
		findViewById();
		setListener();

		mLoadIngDialog = new LoadingDialog(this).initText(getResources().getString(R.string.logining));

		PreferenceUtils.setPrefInt(getApplicationContext(), MemberConstant.LOGIN_STATUS, MemberConstant.LOGIN_OUT);

		autoLogin();
		
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	private void findViewById() {
		LoginRootLayout = (ResizeLayout) this.findViewById(R.id.login_root_layout);
		scrollView = (ScrollView) this.findViewById(R.id.scrollView);
		et_account = (EditText) findViewById(R.id.et_account);
		et_password = (EditText) findViewById(R.id.et_password);

		String username = PreferenceUtils.getPrefString(this, MemberConstant.USERNAME, "");
		if (username != null) {
			et_account.setText(username);
		}
	}

	private void setListener() {
		LoginRootLayout.setOnResizeListener(this);
	}

	private void autoLogin() {
		// 自动登录
		String username = PreferenceUtils.getPrefString(LoginActivity.this, MemberConstant.USERNAME, null);
		String password = PreferenceUtils.getPrefString(LoginActivity.this, MemberConstant.PASSWORD, null);

		if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {

			login(username, password);
		}
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {

		case R.id.btn_login:

			if (!NetworkStatusUtil.isConnected(this)) {
				Toast.makeText(this, "当前网络不可用，请检查网络设置", Toast.LENGTH_SHORT).show();
				return;
			}

			String acccount = et_account.getText().toString().trim();
			String password = et_password.getText().toString().trim();

			if (TextUtils.isEmpty(acccount)) {
				Toast.makeText(getApplicationContext(), "请输入账号", Toast.LENGTH_SHORT).show();
				return;
			}

			if (TextUtils.isEmpty(password)) {
				Toast.makeText(getApplicationContext(), "请输入密码", Toast.LENGTH_SHORT).show();
				return;
			}

			int deviceID = PreferenceUtils.getPrefInt(getApplicationContext(), MemberConstant.DEVICE_ID, -1);

			login(acccount, password);

			break;

		}
	}

	@Override
	public void OnResize(int w, final int h, int oldw, final int oldh) {
		Handler handler = new Handler(Looper.getMainLooper());
		handler.post(new Runnable() {

			@Override
			public void run() {
				int offset = oldh - h;
				if (offset > 0) {
					scrollView.scrollTo(0, offset);
				}
			}
		});
	}

	private void login(final String userName, final String password) {

		new LoginEmployee(this).loginEmployee(userName, password, DeviceUtils.getDeviceInfo(getApplicationContext()), new RequestCallBack() {

			@Override
			public void onStart() {
				mLoadIngDialog.show();
			}

			@Override
			public void onSuccess(ResponseData response) {

				ResponseCode responseCode = ResponseCode.valueOf(response.getCode());

				switch (responseCode) {
					case Normal: {
						Employee employee = response.getContent(Employee.class);

						if (((employee.getEmployeeRole() & Employee.DOCTOR) == 0
								&& (employee.getEmployeeRole() & Employee.NURSE) == 0)) {
							Toast.makeText(getApplicationContext(), "账号异常,请联系客服", Toast.LENGTH_LONG).show();
							return;
						}

						((MedicalAppliction) LoginActivity.this.getApplication()).setLoginEmployee(employee);

						new SharedPreferUtils(getApplicationContext()).put(SharedPreferUtils.ShareKey.DEVICE_ID, employee.getDeviceID());

						PreferenceUtils.setPrefLong(getApplicationContext(), MemberConstant.LOGIN_EMPLOYEE,
								employee.getEmployeeID());
						PreferenceUtils.setPrefInt(getApplicationContext(), MemberConstant.LOGIN_STATUS,
								MemberConstant.LOGIN_IN);
						PreferenceUtils.setPrefString(getApplicationContext(), MemberConstant.USERNAME, employee.getLoginID());
//						PreferenceUtils.setPrefString(getApplicationContext(), MemberConstant.PASSWORD, employee.getLoginPwd());
						PreferenceUtils.setPrefString(getApplicationContext(), MemberConstant.PASSWORD, password);
						PreferenceUtils.setPrefInt(getApplicationContext(), MemberConstant.DEVICE_ID, employee.getDeviceID());
						MdgConfig.setDeviceId(employee.getDeviceID());
						new DeviceIDUtil().saveDeviceIDToSDCard(employee.getDeviceID());

						getClinic();

						break;
					}

					case AppCustom0:
					case AppCustom1:
					case AppCustom2:
					case AppCustom3:
					case AppCustom4:
					case AppCustom5:
					case AppCustom6:
					case AppCustom7:
					case AppCustom8:
					case AppCustom9: {
						Toast.makeText(getApplicationContext(), response.getMessage(), Toast.LENGTH_SHORT).show();
						break;
					}
				}

			}

			@Override
			public void onFinish() {
				mLoadIngDialog.dismiss();
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

			}
		});
	}

	private void getClinic() {
		new GetClinic(getApplicationContext()).getClinic(new RequestCallBack() {
            @Override
            public void onStart() {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onSuccess(ResponseData response) {
                if (response.getCode() == ResponseCode.Normal.getValue()) {
                    MedicalAppliction application = (MedicalAppliction) getApplication();

                    application.mClinic = response.getContent(Clinic.class);

					Intent intent = new Intent(LoginActivity.this, SearchPatientActivity.class);
					startActivity(intent);
					finish();
                }
            }
        });
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
