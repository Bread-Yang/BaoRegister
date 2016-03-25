package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

/**
 * 获取拼字简码
 * 
 * @author yoghourt
 *
 */
public class GetWubiCode extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetWubiCode";

	public GetWubiCode(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getWubiCode(String drugName, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		RequestData data = getData();
		data.setQueryData(String.valueOf(drugName));

		pocess();
	}
}
