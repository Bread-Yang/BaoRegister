package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.enumobject.CheckStatusEnum;

/**
 *
 * @author yoghourt
 *
 */
public class GetDrugInfoListByCheck extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetDrugInfoListByCheck";

	public GetDrugInfoListByCheck(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getDrugInfoListByCheck(CheckStatusEnum status, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		RequestData data = getData();
		data.setQueryData(String.valueOf(status.getValue()));

		pocess();
	}
}
