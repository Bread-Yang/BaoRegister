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
public class GetDrugToptenList extends ClinicRequest {
	private static final String FUNCTION_NAME = "GetDrugToptenList";

	// 综合
	public static final int All = 1;
	// 处方
	public static final int OV = 2;
	// 售药
	public static final int Sale = 3;
	// 利润
	public static final int Profit = 4;
	// 损耗
	public static final int Loss = 5;

	public GetDrugToptenList(Context context) {
		super(context);
	}

	@Override
	protected String getFunctionName() {
		return FUNCTION_NAME;
	}

	public void getDrugToptenList(int topTenType, Date beginDate, Date endDate, RequestCallBack callBack) {
		setRequestCallBack(callBack);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

		JSONObject obj = new JSONObject();
		try {
			obj.put("BeginDate", sdf.format(beginDate));
			obj.put("EndDate", sdf.format(endDate));
			obj.put("ToptenType", String.valueOf(topTenType));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		RequestData data = getData();
		data.setQueryData(obj.toString());
		pocess();
	}
}
