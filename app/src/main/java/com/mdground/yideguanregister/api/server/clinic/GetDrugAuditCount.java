package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.MedicalAppliction;
import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.bean.Employee;

/**
 * @author yoghourt
 *
 */
public class GetDrugAuditCount extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetDrugAuditCount";

	public GetDrugAuditCount(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getDrugAuditCount(RequestCallBack callBack) {
		setRequestCallBack(callBack);

		Employee loginEmployee = MedicalAppliction.mLoginEmployee;
		int employeeID = 0;

		// 没有审核员权限,则传employeeID过去
		if ((loginEmployee.getEmployeeRole() & Employee.AUDIT_MANAGER) == 0) {
			employeeID = loginEmployee.getEmployeeID();
		}

		RequestData data = getData();
		if (employeeID != 0) {
			data.setQueryData(String.valueOf(employeeID));
		} else {
			data.setQueryData("");
		}

		pocess();
	}
}
