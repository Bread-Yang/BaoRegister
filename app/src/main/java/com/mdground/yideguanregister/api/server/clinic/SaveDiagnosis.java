package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.google.gson.Gson;
import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.bean.Diagnosis;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * 保存诊断
 * 
 * @author yoghourt
 *
 */
public class SaveDiagnosis extends ClinicRequest {
	private static final String FUNCTION_NAME = "SaveDiagnosis";

	public SaveDiagnosis(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void saveDiagnosis(int visitID, ArrayList<Diagnosis> diagnosisList, RequestCallBack callBack) {
		if (diagnosisList == null) {
			return;
		}

		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			String jsonString = new Gson().toJson(diagnosisList);
			JSONArray array = new JSONArray(jsonString);
			obj.put("VisitID", visitID);
			obj.put("DiagnosisList", array); // 这是一个array,不是一个string

		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());

		pocess();
	}
}
