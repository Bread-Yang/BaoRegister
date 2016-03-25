package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 是否是初诊
 * 
 * @author yoghourt
 *
 */
public class SaveFirstVisit extends ClinicRequest {
	private static final String FUNCTION_NAME = "SaveFirstVisit";

	public SaveFirstVisit(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void saveFirstVisit(int visitID, boolean isFirstVisit, RequestCallBack callBack) {

		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			obj.put("VisitID", visitID);
			obj.put("FirstVisit", isFirstVisit);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());

		pocess();
	}

	public void saveFirstVisit(int visitID, boolean isFirstVisit, int firstVisitID, RequestCallBack callBack) {

		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			obj.put("VisitID", visitID);
			obj.put("FirstVisit", isFirstVisit);
			obj.put("FirstVisitID", firstVisitID);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());

		pocess();
	}
}
