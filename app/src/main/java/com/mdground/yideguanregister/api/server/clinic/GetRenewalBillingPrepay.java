package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author yoghourt
 */
public class GetRenewalBillingPrepay extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetRenewalBillingPrepay";

	public GetRenewalBillingPrepay(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getRenewalBillingPrepay(ArrayList<Integer> employeeIDList, int years, int totalFee, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			obj.put("EmployeeIDList", new JSONArray(employeeIDList));
			obj.put("Years", years);
			obj.put("TotalFee", totalFee);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());
		pocess();
	}
}
