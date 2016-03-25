package com.mdground.yideguanregister.api.base;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 叫号
 * 
 * @author yoghourt
 *
 */
public class CallAppointment extends ClinicRequest {
	private static final String FUNCTION_NAME = "CallAppointment";

	public CallAppointment(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void callAppointment(int opNO, int doctorID, String doctorName, String patientName, RequestCallBack callBack) {

		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			obj.put("OPNo", opNO);
			obj.put("DoctorID", doctorID);
			obj.put("DoctorName", doctorName);
			obj.put("PatientName", patientName);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());

		pocess();
	}
}
