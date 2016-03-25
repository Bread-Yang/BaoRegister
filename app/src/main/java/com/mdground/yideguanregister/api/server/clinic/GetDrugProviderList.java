package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;

/**
 * 获取供应商
 * 
 * @author yoghourt
 *
 */
public class GetDrugProviderList extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetDrugProviderList";

	public GetDrugProviderList(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getDrugProviderList(RequestCallBack callBack) {
		setRequestCallBack(callBack);

		pocess();
	}
}
