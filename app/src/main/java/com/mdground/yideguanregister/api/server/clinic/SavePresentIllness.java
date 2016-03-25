package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.google.gson.Gson;
import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.bean.PresentIllness;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 保存现病史
 * 
 * @author yoghourt
 *
 */
public class SavePresentIllness extends ClinicRequest {
	private static final String FUNCTION_NAME = "SavePresentIllness";

	public SavePresentIllness(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	/**
	 * 现病史的实体和主诉是一样的
	 * @param presentIllness
	 * @param callBack
	 */
	public void savePresentIllness(PresentIllness presentIllness, RequestCallBack callBack) {
		if (presentIllness == null) {
			return;
		}
		
		setRequestCallBack(callBack);
		
		JSONObject obj = new JSONObject();
		try {
			JSONObject presentIllnessJson = new JSONObject(new Gson().toJson(presentIllness));
			obj.put("PresentIllness",presentIllnessJson);  // 这是一个dict,不是一个string

		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());

		pocess();
	}
}

