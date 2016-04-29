package com.mdground.yideguanregister.api.server.global;

import android.content.Context;

import com.mdground.yideguanregister.api.base.GlobalRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

/**
 *
 * @author yoghourt
 *
 */
public class GetAndroidRegistersScreenVersion extends GlobalRequest {
	private static final String FUNCTION_NAME = "GetAndroidRegistersScreenVersion";

	public GetAndroidRegistersScreenVersion(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getAndroidVersion(String version, RequestCallBack callBack) {
		setRequestCallBack(callBack);

        RequestData data = getData();
		data.setQueryData(version);

		pocess();
	}
}
