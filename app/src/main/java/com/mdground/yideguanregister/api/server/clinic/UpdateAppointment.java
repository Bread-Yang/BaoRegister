package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;

public class UpdateAppointment extends ClinicRequest {
	private static final String FUNCTION_NAME = "UpdateAppointment";

	public UpdateAppointment(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void updateAppointment(int oPid, int statusFinish, RequestCallBack requestCallBack) {

		setRequestCallBack(requestCallBack);

		String query = new QueryDataBuilder().putData("OPID", String.valueOf(oPid)).putData("OPStatus", String.valueOf(statusFinish)).create();
		getData().setQueryData(query);
		pocess();
	}

}
