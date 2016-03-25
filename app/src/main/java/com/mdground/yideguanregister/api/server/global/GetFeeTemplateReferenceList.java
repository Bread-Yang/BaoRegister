package com.mdground.yideguanregister.api.server.global;

import android.content.Context;

import com.mdground.yideguanregister.api.base.GlobalRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;

public class GetFeeTemplateReferenceList extends GlobalRequest {

	private static final String FUNCTION_NAME = "GetFeeTemplateReferenceList";

	public GetFeeTemplateReferenceList(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getFeeTemplateReferenceList(RequestCallBack requestCallBack) {
		setRequestCallBack(requestCallBack);
		pocess();
	}

}
