package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 获取药品
 * 
 * @author yoghourt
 *
 */
public class GetDrugListBySearch extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetDrugListBySearch";

	public GetDrugListBySearch(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getDrugListBySearch(String keyword, int pageIndex, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			obj.put("Keyword", keyword);
			obj.put("PageIndex", String.valueOf(pageIndex));
			obj.put("PageSize", "10");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());
		pocess();
	}
}
