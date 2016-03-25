package com.mdground.yideguanregister.api.server.global;

import android.content.Context;

import com.mdground.yideguanregister.api.base.GlobalRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;

public class LogoutEmployee extends GlobalRequest {
	private static final String FUNCTION_NAME = "LogoutEmployee";

	public LogoutEmployee(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void logoutEmployee(RequestCallBack requestCallBack) {
		setRequestCallBack(requestCallBack);
		getData().setQueryData("");
		pocess();
	}

}
