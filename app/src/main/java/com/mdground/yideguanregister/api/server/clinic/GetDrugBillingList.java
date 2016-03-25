package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.util.DateUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * @author yoghourt
 */
public class GetDrugBillingList extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetDrugBillingList";

	public GetDrugBillingList(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getDrugBillingList(String keyword, Date queryDate, int pageIndex, int pageSize, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			obj.put("Keyword", keyword);
			obj.put("PageIndex", pageIndex);
			obj.put("PageSize", pageSize);
			if (queryDate != null) {
				obj.put("Date", DateUtils.getDateStringBySpecificDate(queryDate));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());
		pocess();
	}
}
