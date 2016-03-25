package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.bean.SaleRecord;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * 购物车
 * 
 * @author yoghourt
 *
 */
public class SaleDrug extends ClinicRequest {
	private static final String FUNCTION_NAME = "SaleDrug";

	public SaleDrug(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void saleDrug(ArrayList<SaleRecord> salesList, RequestCallBack callBack) {
		if (salesList == null || salesList.size() == 0) {
			return;
		}

		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String jsonString = gson.toJson(salesList);
			JSONArray array = new JSONArray(jsonString);
			obj.put("SaleList", array); // 这是一个array,不是一个string

		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());

		pocess();
	}
}
