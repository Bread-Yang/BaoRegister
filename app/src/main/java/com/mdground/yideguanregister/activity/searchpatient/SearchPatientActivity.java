package com.mdground.yideguanregister.activity.searchpatient;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import com.mdground.yideguanregister.MedicalAppliction;
import com.mdground.yideguanregister.R;
import com.mdground.yideguanregister.activity.LoginActivity;
import com.mdground.yideguanregister.activity.base.BaseActivity;
import com.mdground.yideguanregister.activity.doctorlist.DoctorSelectListActivity;
import com.mdground.yideguanregister.adapter.SearchDetailAdapter;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.ResponseCode;
import com.mdground.yideguanregister.api.base.ResponseData;
import com.mdground.yideguanregister.api.server.clinic.GetPatient;
import com.mdground.yideguanregister.api.server.clinic.SavePatient;
import com.mdground.yideguanregister.api.server.global.LogoutEmployee;
import com.mdground.yideguanregister.bean.AppointmentInfo;
import com.mdground.yideguanregister.bean.Employee;
import com.mdground.yideguanregister.bean.Patient;
import com.mdground.yideguanregister.bean.Symptom;
import com.mdground.yideguanregister.constant.MemberConstant;
import com.mdground.yideguanregister.db.dao.SymptomDao;
import com.mdground.yideguanregister.dialog.BirthdayDatePickerDialog;
import com.mdground.yideguanregister.util.DateUtils;
import com.mdground.yideguanregister.util.PreferenceUtils;
import com.mdground.yideguanregister.util.StringUtils;
import com.mdground.yideguanregister.view.ResizeLinearLayout;
import com.mdground.yideguanregister.view.wheelview.OnWheelScrollListener;
import com.mdground.yideguanregister.view.wheelview.WheelView;
import com.mdground.yideguanregister.view.wheelview.adapters.AbstractWheelTextAdapter;
import com.mdground.yideguanregister.view.wheelview.adapters.ArrayWheelAdapter;
import com.socks.library.KLog;

import org.apache.http.Header;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SearchPatientActivity extends BaseActivity implements OnItemClickListener, SearchPatientView, OnEditorActionListener, OnClickListener, DatePickerDialog.OnDateSetListener,
        ResizeLinearLayout.OnResizeListener {

    private RelativeLayout rlt_birthday;

    private EditText et_phone, et_name;

    private TextView tv_log_out, tv_sex, tv_birthday;

    private Button btn_register;

    /**
     * 搜索结果
     **/
    private ListView lv_search_result;

    private ResizeLinearLayout searchRootLayout;

    private SearchDetailAdapter<Patient> searchDetailAdapter;
    private Employee loginEmployee;
    private List<Patient> patientsList = new ArrayList<Patient>();// 搜索结果保存

    private boolean mIsDetail;

    private Dialog dialog_wheelView;
    private ImageView iv_close;
    private WheelView wheelView1;

    private SymptomDao mSymptomDao;
    private SearchPatientPresenter presenter;

    private int mPageIndex = 0;

    private DatePickerDialog datePickerDialog;

    private String[] mSexArray;

    private Patient mPatient = new Patient();

    private boolean mHasSearch;

    Handler mHandler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            showDetail(mIsDetail);
            return false;
        }
    });

    /**
     * ListView直接点击挂号时回掉此函数
     */
    private SearchDetailAdapter.AppiontmentCallBack mAppiontmentCallBack = new SearchDetailAdapter.AppiontmentCallBack() {

        @Override
        public void onAppiontment(Patient patient) {
            createAppointment(patient);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patient);
        findView();
        initMemberData();
        initView();
        setListener();
    }

    @Override
    public void findView() {
        et_phone = (EditText) this.findViewById(R.id.et_phone);
        et_name = (EditText) this.findViewById(R.id.et_name);
        tv_log_out = (TextView) this.findViewById(R.id.tv_log_out);
        tv_sex = (TextView) this.findViewById(R.id.tv_sex);
        tv_birthday = (TextView) this.findViewById(R.id.tv_birthday);
        rlt_birthday = (RelativeLayout) findViewById(R.id.rlt_birthday);
        btn_register = (Button) findViewById(R.id.btn_register);
        lv_search_result = (ListView) this.findViewById(R.id.search_result_listview);
        searchRootLayout = (ResizeLinearLayout) findViewById(R.id.layout_root_search_patient);
        searchRootLayout.setOnResizeListener(this);

        // 初始化dialog及dialog里面的控件
        dialog_wheelView = new Dialog(this, R.style.patient_detail_dialog);
        dialog_wheelView.setContentView(R.layout.dialog_wheel_view);

        // 设置dialog弹入弹出的动画
        Window window = dialog_wheelView.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT); // 填充满屏幕的宽度
        window.setWindowAnimations(R.style.action_sheet_animation); // 添加动画
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM; // 使dialog在底部显示
        window.setAttributes(wlp);

        iv_close = (ImageView) dialog_wheelView.findViewById(R.id.iv_close);

        wheelView1 = (WheelView) dialog_wheelView.findViewById(R.id.wheelview1);
    }

    @Override
    public void initView() {
        lv_search_result.setAdapter(searchDetailAdapter);
//        lv_search_result.setEmptyView(llt_search_prompt);
//        handleEmpty(false);
    }

    @Override
    public void initMemberData() {
        MedicalAppliction app = (MedicalAppliction) getApplication();
        this.loginEmployee = app.getLoginEmployee();
        // 请求症状列表
        searchDetailAdapter = new SearchDetailAdapter<Patient>(this, mAppiontmentCallBack);
        searchDetailAdapter.setDataList(patientsList);

        mSymptomDao = SymptomDao.getInstance(this);
        presenter = new SearchPatientPresenterImpl(this);

        mSexArray = new String[]{getString(R.string.male), getString(R.string.female)};
        wheelView1.setViewAdapter(new ArrayWheelAdapter(this, mSexArray, wheelView1));
    }

    @Override
    public void setListener() {
        lv_search_result.setOnItemClickListener(this);
        iv_close.setOnClickListener(this);
        et_phone.setOnEditorActionListener(this);

        tv_log_out.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        et_phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    mHasSearch = false;
                    lv_search_result.setVisibility(View.GONE);
                    btn_register.setVisibility(View.VISIBLE);
                } else {
                    searchPatient();
                }
            }
        });

        lv_search_result.setOnScrollListener(new AbsListView.OnScrollListener() {

            boolean isLastRow = false;

            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                if (isLastRow
                        && scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    mPageIndex++;
                    isLastRow = false;

                    String keyword = et_phone.getText().toString();
                    if (!StringUtils.isEmpty(keyword)) {
                        presenter.searchPatient(keyword, mPageIndex);
                    }
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                // 滑动到最下面一列数据项的时候,加载新的数据
                if ((firstVisibleItem + visibleItemCount == totalItemCount)
                        && (totalItemCount > 1)) {
                    isLastRow = true;
                }
            }
        });

        wheelView1.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                int currentSelectedIndex = wheel.getCurrentItem();
                String text = ((AbstractWheelTextAdapter) wheel.getViewAdapter()).getItemText(currentSelectedIndex)
                        .toString();

                tv_sex.setText(text);
            }
        });

    }

    private void logout() {
        final AlertDialog myDialog = new AlertDialog.Builder(this).setMessage("是否退出当前账号？")
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LogoutEmployee logoutEmployee = new LogoutEmployee(getApplicationContext());
                        logoutEmployee.logoutEmployee(new RequestCallBack() {

                            @Override
                            public void onStart() {
                                // mView.showProgress();
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
                                    PreferenceUtils.setPrefInt(SearchPatientActivity.this, MemberConstant.LOGIN_STATUS,
                                            MemberConstant.LOGIN_OUT);
                                    PreferenceUtils.setPrefString(SearchPatientActivity.this, MemberConstant.PASSWORD, "");
                                    Intent intent = new Intent();
                                    intent.setClass(SearchPatientActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
                    }
                }).setNeutralButton("取消", null).create();
        myDialog.show();
    }

    public void showDetail(boolean isDetail) {
        this.mIsDetail = isDetail;
        if (patientsList.size() == 0) {
//            handleEmpty(true);
        }

        int firstVisibleIndex = lv_search_result.getFirstVisiblePosition();

        if (isDetail) {
            lv_search_result.setAdapter(searchDetailAdapter);
        } else {
//            lv_search_result.setAdapter(searchSimpleAdapter);
        }

        lv_search_result.setSelection(firstVisibleIndex);

//		if (!isDestroyed()) {
        if (!isFinishing()) {
            searchDetailAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Patient patient = patientsList.get(position);
        if (parent == null) {
            return;
        }
        if (mIsDetail) {
//            Intent intent = new Intent(SearchPatientActivity.this, PatientDetailActivity.class);
//            intent.putExtra(MemberConstant.PATIENT_ID, patient.getPatientID());
//            startActivityForResult(intent, MemberConstant.APPIONTMENT_REQUEST_CODE);
        } else {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            et_phone.setText(patientsList.get(position).getPatientName());
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        KLog.e("onEditorAction执行了");
        // 表示按了键盘，使键盘消失，此时要显示详细的
//        if (actionId == EditorInfo.IME_ACTION_SEARCH || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
//            if (et_phone.getText().length() > 0) {
//                InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                im.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//
//                int firstVisibleIndex = lv_search_result.getFirstVisiblePosition();
//                lv_search_result.setAdapter(searchDetailAdapter);
//                lv_search_result.setSelection(firstVisibleIndex);
//            }
//            return true;
//        }
        KLog.e("actionId : " + actionId);
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            searchPatient();
        }

        return false;
    }

    private void searchPatient() {
        if (!mHasSearch) {
            mHasSearch = true;

            // 每次搜索都先清空数据再发起请求
            mPatient = new Patient();
            mPageIndex = 0;
            patientsList.clear();
            searchDetailAdapter.notifyDataSetChanged();

            String keyword = et_phone.getText().toString();
            if (!StringUtils.isEmpty(keyword)) {
                InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(et_phone.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                presenter.searchPatient(keyword, mPageIndex);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rlt_birthday:
                showDialog();
                break;
            case R.id.rlt_sex:
                dialog_wheelView.show();
                if (StringUtils.isEmpty(tv_sex.getText().toString())) {
                    tv_sex.setText(mSexArray[0]);
                    mPatient.setGender(1);
                }
                break;
            case R.id.iv_close:
                dialog_wheelView.dismiss();
                break;
            case R.id.btn_register:
                setPatientNewData();

                if (mPatient.getPatientID() != 0) {
                    new GetPatient(getApplicationContext()).getPatient(mPatient.getPatientID(), new RequestCallBack() {
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
                                        mPatient = response.getContent(Patient.class);

                                        setPatientNewData();
                                        savePatient();
                                    }
                                }
                            }
                    );
                } else {
                    savePatient();
                }

                break;
        }
    }

    private void setPatientNewData() {
        // 手机号码
        String phone = et_phone.getText().toString();

        if (StringUtils.isEmpty(phone)) {
            showToast("请输入手机号码");
            return;
        } else if (phone.length() != 11) {
            showToast("手机格式不支持");
            return;
        }
        mPatient.setPhone(phone);

        // 姓名
        if (et_name.getText() == null || et_name.getText().toString().equals("")) {
            showToast("请输入姓名");
            return;
        } else {
            mPatient.setPatientName(et_name.getText().toString());
        }

        // 生日
        if (tv_birthday.getText() == null || tv_birthday.getText().toString().equals("")) {
            showToast(R.string.choose_birthday);
            return;
        } else {
            mPatient.setDOB(DateUtils.toDate(tv_birthday.getText().toString(),
                    new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)));
        }

        // 性别
        int currentSelectedIndex = wheelView1.getCurrentItem();

        if (currentSelectedIndex == 0) {
            mPatient.setGender(1);
        } else {
            mPatient.setGender(2);
        }
    }

    private void savePatient() {
        new SavePatient(getApplicationContext()).savePatient(mPatient, new RequestCallBack() {
            @Override
            public void onStart() {
                showProgress();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                hideProgress();
            }

            @Override
            public void onFinish() {
                hideProgress();
            }

            @Override
            public void onSuccess(ResponseData response) {
                if (response.getCode() == ResponseCode.Normal.getValue()) {
                    createAppointment(mPatient);
                }
            }
        });

    }

    private void createAppointment(Patient patient) {

        List<Symptom> symptoms = mSymptomDao.getSymptoms();

        AppointmentInfo appointmentInfo = new AppointmentInfo();
        appointmentInfo.setOPDate(new Date());
        appointmentInfo.setPatientID(patient.getPatientID());

        lv_search_result.setVisibility(View.GONE);
        btn_register.setVisibility(View.VISIBLE);

        Intent intent = new Intent();
        intent.setClass(this, DoctorSelectListActivity.class);

//        if ((loginEmployee.getEmployeeRole() & Employee.DOCTOR) != 0) {
//            appointmentInfo.setDoctorID(loginEmployee.getEmployeeID());
//            appointmentInfo.setOPEMR(loginEmployee.getEMRType());
//            appointmentInfo.setDoctorName(loginEmployee.getEmployeeName());
//            appointmentInfo.setClinicID(loginEmployee.getClinicID());
//            if (symptoms != null && symptoms.size() != 0) {
////                intent.setClass(this, SymptomActivity.class);
//            } else {
//                presenter.saveAppointment(appointmentInfo);
//                return;
//            }
//        } else {
//            if (symptoms == null || symptoms.size() == 0) {
//                // 跳转到医生列表
//                intent.setClass(this, DoctorSelectListActivity.class);
//            } else {
////                intent.setClass(this, SymptomActivity.class);
//            }
//        }

        intent.putExtra(MemberConstant.APPOINTMENT, appointmentInfo);
        startActivityForResult(intent, MemberConstant.APPIONTMENT_REQUEST_CODE);
    }

    // 只传递结果，不处理结果值
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == MemberConstant.APPIONTMENT_REQUEST_CODE && resultCode == MemberConstant.APPIONTMENT_RESULT_CODE) {
//            setResult(resultCode, data);
//            finish();
//        }
        setResult(resultCode, data);
        et_phone.setText("");
        et_name.setText("");
        tv_birthday.setText("");
    }

    @Override
    public void updateResult(List<Patient> patients) {
//		this.patientsList.clear();
        if (patients == null || patients.size() == 0) {
//            handleEmpty(true);
//            tv_search_tips1.setText(R.string.no_match);
//            tv_search_tips2.setText(R.string.no_match_patient_value);
        } else {
            this.patientsList.addAll(patients);
            if (patientsList.size() > 1) {
                InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(et_phone.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                lv_search_result.setVisibility(View.VISIBLE);
                btn_register.setVisibility(View.GONE);

                searchDetailAdapter.notifyDataSetChanged();
            } else {
                lv_search_result.setVisibility(View.GONE);

                mPatient = patients.get(0);
                et_name.setText(mPatient.getPatientName());
                et_phone.setText(mPatient.getPhone());
                tv_birthday.setText(DateUtils.getYearMonthDayWithDash(mPatient.getDOB()));
                tv_sex.setText(mPatient.getGenderStr());
            }
        }
    }

    @Override
    public void finishResult(int appiontmentResultCode, AppointmentInfo appointment) {
        Intent intent = new Intent();
        intent.putExtra(MemberConstant.APPOINTMENT, appointment);
        setResult(appiontmentResultCode, intent);
        finish();
    }

    @Override
    public void OnResize(int w, final int h, int oldw, final int oldh) {
        int offset = oldh - h;
        if (offset > 0) {
            mIsDetail = false;
        } else {
            mIsDetail = true;
        }

        if (this.patientsList.size() == 0) {
            return;
        }

//		showDetail(mIsDetail);
        mHandler.sendEmptyMessage(0);
    }

    public void showDialog() {
        Calendar calendar = Calendar.getInstance();
        if (mPatient.getDOB() != null) {
            calendar.setTime(mPatient.getDOB());
        }

        if (datePickerDialog == null) {
            datePickerDialog = new BirthdayDatePickerDialog(this, this, calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        } else {
            datePickerDialog.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
        }
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());

        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));

        Calendar targetCalendar = Calendar.getInstance();
        targetCalendar.set(year, monthOfYear, dayOfMonth);

        long currentMillis = currentCalendar.getTimeInMillis();
        long targetMillis = targetCalendar.getTimeInMillis();

        long interval = targetMillis - currentMillis;

        long minimumInterval = 30L * 24 * 3600 * 1000;

        if (interval > 0) {
            Toast.makeText(getApplicationContext(), R.string.birthday_no_more_than_today, Toast.LENGTH_SHORT).show();
            return;
        } else {
            tv_birthday.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
        }
    }
}
