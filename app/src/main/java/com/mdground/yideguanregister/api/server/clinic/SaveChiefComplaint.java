package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.google.gson.Gson;
import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.bean.ChiefComplaint;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 保存体征
 * 
 * @author yoghourt
 *
 */
public class SaveChiefComplaint extends ClinicRequest {
	private static final String FUNCTION_NAME = "SaveChiefComplaint";

	public SaveChiefComplaint(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void saveChiefComplaint(ChiefComplaint chiefComplaint, RequestCallBack callBack) {
		if (chiefComplaint == null) {
			return;
		}
		
		setRequestCallBack(callBack);
		
		JSONObject obj = new JSONObject();
		try {
			JSONObject chiefCoomplaintJson = new JSONObject(new Gson().toJson(chiefComplaint));
			obj.put("ChiefComplaint",chiefCoomplaintJson);  // 这是一个dict,不是一个string

		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());

		pocess();
	}
}

