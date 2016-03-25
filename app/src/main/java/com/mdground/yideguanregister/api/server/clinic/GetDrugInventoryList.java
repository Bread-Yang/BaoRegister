package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 获取药品详情
 * 
 * @author yoghourt
 *
 */
public class GetDrugInventoryList extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetDrugInventoryList";

	public GetDrugInventoryList(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getDrugInventoryList(int drugID, int pageIndex, int pageSize, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			obj.put("DrugID", String.valueOf(drugID));
//			obj.put("PageIndex", String.valueOf(pageIndex));
//			obj.put("PageSize", String.valueOf(pageSize));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());

		pocess();
	}
}
