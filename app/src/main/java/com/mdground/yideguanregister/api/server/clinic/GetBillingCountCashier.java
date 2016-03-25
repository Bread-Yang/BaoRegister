package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author yoghourt
 *
 */
public class GetBillingCountCashier extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetBillingCountCashier";

	public GetBillingCountCashier(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getBillingCountCashier(Date beginDate, Date endDate, int DoctorID, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

		JSONObject obj = new JSONObject();
		try {
			obj.put("BeginDate", sdf.format(beginDate));
			obj.put("EndDate", sdf.format(endDate));
			obj.put("DoctorID", DoctorID);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());
		pocess();
	}
}
