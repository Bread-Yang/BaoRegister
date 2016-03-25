package com.mdground.yideguanregister.api.server.global;

import android.content.Context;

import com.mdground.yideguanregister.api.base.GlobalRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.bean.Employee;
import com.mdground.yideguanregister.util.DateUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class SaveEmployeeStatus extends GlobalRequest {
	private static final String FUNCTION_NAME = "SaveEmployeeStatus";

	public SaveEmployeeStatus(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void saveEmployeeStatus(Employee employee, RequestCallBack listener) {
		if (employee == null) {
			return;
		}

		setRequestCallBack(listener);

		JSONObject obj = new JSONObject();
		try {
			obj.put("EmployeeID", employee.getEmployeeID());
            if (employee.getExpiredTime() != null) {
                obj.put("ExpiredTime", DateUtils.getDateStringBySpecificDate(employee.getExpiredTime()));
            }
			obj.put("Status", employee.getStatus());
		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());

		pocess();
	}

}
