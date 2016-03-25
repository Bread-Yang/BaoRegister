package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.enumobject.WarningTypeEnum;
import com.mdground.yideguanregister.util.DateUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * @author yoghourt
 */
public class GetDrugWarningList extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetDrugWarningList";

	public GetDrugWarningList(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getDrugWarningList(WarningTypeEnum warningType, Date warningDate, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			obj.put("WarningType", warningType.getValue());
			if (warningDate != null) {
				obj.put("WarningDate", DateUtils.getDateStringBySpecificDate(warningDate));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());
		pocess();
	}
}
