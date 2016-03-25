package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.bean.DrugUse;
import com.mdground.yideguanregister.bean.Inventory;
import com.mdground.yideguanregister.bean.OfficeVisitFee;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 入库
 *
 * @author yoghourt
 */
public class WarehouseDrug extends ClinicRequest {
    private static final String FUNCTION_NAME = "WarehouseDrug";

    public WarehouseDrug(Context context) {
        super(context);
    }

    @Override
    protected String getFunctionName() {
        return FUNCTION_NAME;
    }

    public void WarehouseDrug(List<Inventory> inventoryList, RequestCallBack callBack) {
        if (inventoryList == null) {
            return;
        }

        setRequestCallBack(callBack);

        JSONObject obj = new JSONObject();
        try {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            JSONArray sendInventoryList = new JSONArray(gson.toJson(inventoryList));
            obj.put("InventoryList", sendInventoryList);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestData data = getData();
        data.setQueryData(obj.toString());

        pocess();
    }
}
