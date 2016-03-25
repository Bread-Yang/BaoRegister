package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.bean.DrugOperate;
import com.mdground.yideguanregister.enumobject.DrugOperateTypeEnum;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author yoghourt
 *
 */
public class SaveDrugOperateList extends ClinicRequest {
	private static final String FUNCTION_NAME = "SaveDrugOperateList";

	public SaveDrugOperateList(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void saveDrugOperateList(DrugOperateTypeEnum operateType, ArrayList<DrugOperate> operateList, RequestCallBack callBack) {
		if (operateList == null) {
			return;
		}

		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

			String jsonString = gson.toJson(operateList);
			JSONArray array = new JSONArray(jsonString);
			obj.put("OperateType", operateType.getValue());
			obj.put("OperateList", array); // 这是一个array,不是一个string
		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());

		pocess();
	}

}
