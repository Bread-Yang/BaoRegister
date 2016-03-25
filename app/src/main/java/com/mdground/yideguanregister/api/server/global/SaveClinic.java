package com.mdground.yideguanregister.api.server.global;

import android.content.Context;

import com.mdground.yideguanregister.api.base.GlobalRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.bean.Clinic;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author yoghourt
 */
public class SaveClinic extends GlobalRequest {
	private static final String FUNCTION_NAME = "SaveClinic";

	public SaveClinic(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void saveClinic(Clinic clinic, RequestCallBack callBack) {
		if (clinic == null) {
			return;
		}
		
		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			obj.put("PricePolicy", clinic.getPricePolicy());
			obj.put("ModuleDisplay", clinic.getModuleDisplay());
			obj.put("NavigationType", clinic.getNavigationType());
			obj.put("ModuleRequired", clinic.getModuleRequired());
			obj.put("DrugAudit", clinic.isDrugAudit());
			obj.put("TradePlatform", clinic.getTradePlatform());

		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		RequestData data = getData();

//		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//		data.setQueryData(gson.toJson(clinic));
		data.setQueryData(obj.toString());

		pocess();
	}
}

