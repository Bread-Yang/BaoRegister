package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

/**
 * 获取药品详情
 * 
 * @author yoghourt
 *
 */
public class GetDrugInfoForCheck extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetDrugInfoForCheck";

	public GetDrugInfoForCheck(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getDrugInfoForCheck(int drugID, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		RequestData data = getData();
		data.setQueryData(String.valueOf(drugID));

		pocess();
	}
}
