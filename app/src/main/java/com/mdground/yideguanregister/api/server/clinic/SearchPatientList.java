package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

import org.json.JSONException;
import org.json.JSONObject;

public class SearchPatientList extends ClinicRequest {
	private static final String FUNCTION_NAME = "SearchPatientList";

	public SearchPatientList(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void searchPatient(String keyword, int pageIndex, RequestCallBack requestCallBack) {
		if (keyword == null) {
			return;
		}
		setRequestCallBack(requestCallBack);

        JSONObject obj = new JSONObject();
        try {
            obj.put("Keyword", keyword);
            obj.put("PageIndex", String.valueOf(pageIndex));
            obj.put("PageSize", "10");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestData data = getData();
        data.setQueryData(obj.toString());
        pocess();
	}

}
