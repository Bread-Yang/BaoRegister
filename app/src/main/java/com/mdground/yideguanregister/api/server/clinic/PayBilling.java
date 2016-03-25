package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author yoghourt
 *
 */
public class PayBilling extends ClinicRequest {
	private static final String FUNCTION_NAME = "PayBilling";

	public PayBilling(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void payBilling(int tradePlatform, int totalFeeReal, int billingID, int billingType, RequestCallBack callBack) {

		setRequestCallBack(callBack);

		JSONObject obj = new JSONObject();
		try {
			obj.put("TradeType", "2");
			obj.put("TradePlatform", Integer.valueOf(tradePlatform));
			obj.put("TotalFeeReal", Integer.valueOf(totalFeeReal));
			obj.put("BillingID", Integer.valueOf(billingID));
			obj.put("BillingType", Integer.valueOf(billingType));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());

		pocess();
	}
}
