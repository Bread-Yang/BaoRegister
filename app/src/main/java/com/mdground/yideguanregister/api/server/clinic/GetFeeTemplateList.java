package com.mdground.yideguanregister.api.server.clinic;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

/**
 * 费用类型列表
 * 
 * @author yoghourt
 *
 */
public class GetFeeTemplateList extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetFeeTemplateList";

	public GetFeeTemplateList(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getFeeTemplateList(RequestCallBack callBack) {
		setRequestCallBack(callBack);

		pocess();
	}
}
