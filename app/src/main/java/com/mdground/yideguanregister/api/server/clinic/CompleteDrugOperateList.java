package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.enumobject.DrugOperateTypeEnum;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author yoghourt
 *
 */
public class CompleteDrugOperateList extends ClinicRequest {
	private static final String FUNCTION_NAME = "CompleteDrugOperateList";

	public CompleteDrugOperateList(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void completeDrugOperateList(String logIDList, String remark, DrugOperateTypeEnum operateType, boolean passAudit, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			obj.put("LogIDList", logIDList);
			obj.put("Remark", remark);
			obj.put("OperateType", Integer.valueOf(operateType.getValue()));
			obj.put("PassAudit", passAudit);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());

		pocess();
	}
}
