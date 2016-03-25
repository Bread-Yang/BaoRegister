package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.google.gson.Gson;
import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.bean.DrugUse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 保存处方
 *
 * @author yoghourt
 */
public class SaveDrugUseChineseForOV extends ClinicRequest {
    private static final String FUNCTION_NAME = "SaveDrugUseChineseForOV";

    public SaveDrugUseChineseForOV(Context context) {
        super(context);
    }

    @Override
    protected String getFunctionName() {
        return FUNCTION_NAME;
    }

    public void saveDrugUseChineseForOV(int clinicID, int visitID, DrugUse drugUse, RequestCallBack callBack) {

        setRequestCallBack(callBack);

        JSONObject obj = new JSONObject();
        try {
            JSONObject chiefCoomplaintJson = new JSONObject(new Gson().toJson(drugUse));
            obj.put("DrugChinese", chiefCoomplaintJson);
            obj.put("ClinicID", clinicID);
            obj.put("VisitID", visitID);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestData data = getData();
        data.setQueryData(obj.toString());

        pocess();
    }
}
