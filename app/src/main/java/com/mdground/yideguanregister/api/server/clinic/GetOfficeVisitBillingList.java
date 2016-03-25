package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.MedicalAppliction;
import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.bean.Employee;
import com.mdground.yideguanregister.util.DateUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 *
 * @author yoghourt
 *
 */
public class GetOfficeVisitBillingList extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetOfficeVisitBillingList";

	public enum SettlementStats {
		PENDING_SETTLEMENT, CLOSED_SETTLEMENT
	}

	public GetOfficeVisitBillingList(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getOfficeVisitBillingList(Date ovDate, SettlementStats settlementStats, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		int billingStatus = 0;
		switch (settlementStats) {
			case PENDING_SETTLEMENT:
				billingStatus = 1;
				break;
			case CLOSED_SETTLEMENT:
				billingStatus = 2;
				break;
		}

		Employee employee = ((MedicalAppliction) mContext.getApplicationContext()).getLoginEmployee();

		int employeeID = employee.getEmployeeID();

		// 如果权限有管理者,则传0过去,如果不是,则传employeeID过去
		if ((employee.getEmployeeRole() & Employee.CLINIC_MANAGER) != 0) {
			employeeID = 0;
		}

		JSONObject obj = new JSONObject();
		try {
			obj.put("OVDate", DateUtils.getDateStringBySpecificDate(ovDate));
			obj.put("BillingStatus", String.valueOf(billingStatus));
			obj.put("Cashier", String.valueOf(employeeID));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());

		pocess();
	}
}
