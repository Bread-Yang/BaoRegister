package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.enumobject.DrugOperateTypeEnum;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author yoghourt
 *
 */
public class GetDrugOperateInfo extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetDrugOperateInfo";

	public GetDrugOperateInfo(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getDrugOperateInfo(int logID, DrugOperateTypeEnum operateTypeEnum, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			obj.put("LogID", String.valueOf(logID));
			obj.put("OperateType", String.valueOf(operateTypeEnum.getValue()));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());

		pocess();
	}
}
