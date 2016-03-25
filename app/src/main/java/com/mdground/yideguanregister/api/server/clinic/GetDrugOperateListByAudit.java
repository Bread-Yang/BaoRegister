package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.MedicalAppliction;
import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.bean.Employee;
import com.mdground.yideguanregister.enumobject.CheckStatusEnum;
import com.mdground.yideguanregister.enumobject.DrugOperateTypeEnum;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author yoghourt
 *
 */
public class GetDrugOperateListByAudit extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetDrugOperateListByAudit";

	public GetDrugOperateListByAudit(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getDrugOperateListByAudit(int pageIndex, DrugOperateTypeEnum operateType, CheckStatusEnum checkType, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			obj.put("PageIndex", String.valueOf(pageIndex));
			obj.put("PageSize", 10);
			obj.put("OperateType", String.valueOf(operateType.getValue()));
			obj.put("CheckStatus", String.valueOf(checkType.getValue()));
			if ((MedicalAppliction.mLoginEmployee.getEmployeeRole() & Employee.AUDIT_MANAGER) == 0) {
				obj.put("OperatorID", MedicalAppliction.mLoginEmployee.getEmployeeID());
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());

		pocess();
	}
}
