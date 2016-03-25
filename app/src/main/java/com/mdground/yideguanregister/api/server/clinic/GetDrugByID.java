package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

/**
 * 获取药品
 * 
 * @author yoghourt
 *
 */
public class GetDrugByID extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetDrugByID";

	public GetDrugByID(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getDrugByID(int drugID, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		RequestData data = getData();
		data.setQueryData(String.valueOf(drugID));

		pocess();
	}
}
