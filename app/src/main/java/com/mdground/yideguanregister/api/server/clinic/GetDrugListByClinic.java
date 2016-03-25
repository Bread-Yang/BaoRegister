package com.mdground.yideguanregister.api.server.clinic;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

/**
 * 获取药品列表
 * 
 * @author yoghourt
 *
 */
public class GetDrugListByClinic extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetDrugListByClinic";

	public GetDrugListByClinic(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getDrugListByClinic(RequestCallBack callBack) {
		setRequestCallBack(callBack);

//		RequestData data = getData();
//		data.setQueryData(String.valueOf(patientId));

		pocess();
	}
}
