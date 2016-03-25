package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.google.gson.Gson;
import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.bean.Fee;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * 保存诊断
 *
 * @author yoghourt
 */
public class SaveFeeTemplateList extends ClinicRequest {
    private static final String FUNCTION_NAME = "SaveFeeTemplateList";

    public SaveFeeTemplateList(Context context) {
        super(context);
    }

    @Override
    protected String getFunctionName() {
        return FUNCTION_NAME;
    }

    public void saveFeeTemplateList(ArrayList<Fee> fees, RequestCallBack callBack) {
        if (fees == null) {
            return;
        }

        setRequestCallBack(callBack);

        JSONObject obj = new JSONObject();
        try {
            String jsonString = new Gson().toJson(fees);
            JSONArray array = new JSONArray(jsonString);
            obj.put("TemplateList", array); // 这是一个array,不是一个string

        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestData data = getData();
        data.setQueryData(obj.toString());

        pocess();
    }
}
