package com.mdground.yideguanregister.api.server.global;

import android.content.Context;
import android.util.Log;

import com.mdground.yideguanregister.api.base.GlobalRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

public class CheckEmployeePassword extends GlobalRequest {

	private static final String FUNCTION_NAME = "CheckEmployeePassword";

	public CheckEmployeePassword(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void checkEmployeePwd(String password, RequestCallBack listener) {
		if (password == null || password.equals("")) {
			Log.e(TAG, "password is null");
			return;
		}
		setRequestCallBack(listener);

		RequestData data = getData();
		data.setQueryData(password);

		pocess();
	}

}
