package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

public class RefreshEmployee extends ClinicRequest {
	private static final String FUNCTION_NAME = "RefreshEmployee";

	public RefreshEmployee(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void refreshEmployee(int employeeRole, BigDecimal updatedTicks, String appVersion, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			obj.put("EmployeeRole", employeeRole);
			obj.put("UpdatedTicks", updatedTicks);
			obj.put("AppVersion", appVersion);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());

		pocess();
	}
}
