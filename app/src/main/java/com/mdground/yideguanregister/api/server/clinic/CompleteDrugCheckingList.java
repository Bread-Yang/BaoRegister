package com.mdground.yideguanregister.api.base;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

/**
 *
 * @author yoghourt
 *
 */
public class CompleteDrugCheckingList extends ClinicRequest {
	private static final String FUNCTION_NAME = "CompleteDrugCheckingList";

	public CompleteDrugCheckingList(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void completeDrugCheckingList(RequestCallBack callBack) {
		setRequestCallBack(callBack);

		RequestData data = getData();

		pocess();
	}
}
