package com.mdground.yideguanregister.api.server.clinic;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

/**
 * 获取每次诊断的详细信息，包含了主诉、诊断、体征、处方等信息
 * 
 * @author yoghourt
 *
 */
public class GetOfficeVisitInfo extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetOfficeVisitInfo";

	public GetOfficeVisitInfo(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getOfficeVisitInfo(int opID, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		RequestData data = getData();
		data.setQueryData(String.valueOf(opID));

		pocess();
	}
}
