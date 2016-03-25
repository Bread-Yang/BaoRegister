package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;

public class UpdateAppointmentByAssign extends ClinicRequest {
	private static final String FUNCTION_NAME = "UpdateAppointmentByAssign";

	public UpdateAppointmentByAssign(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void updateAppointmentByAssign(int opid, int doctorId, RequestCallBack requestCallBack) {
		setRequestCallBack(requestCallBack);

		String query = new QueryDataBuilder().putData("OPID", String.valueOf(opid)).putData("DoctorID", String.valueOf(doctorId)).create();
		getData().setQueryData(query);
		pocess();
	}

}
