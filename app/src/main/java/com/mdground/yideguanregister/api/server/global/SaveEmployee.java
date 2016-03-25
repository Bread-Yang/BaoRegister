package com.mdground.yideguanregister.api.server.global;

import android.content.Context;

import com.mdground.yideguanregister.api.base.GlobalRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;
import com.mdground.yideguanregister.bean.Employee;
import com.mdground.yideguanregister.util.DateUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class SaveEmployee extends GlobalRequest {
    private static final String FUNCTION_NAME = "SaveEmployee";

    public SaveEmployee(Context context) {
        super(context);
    }

    @Override
    protected String getFunctionName() {
        return FUNCTION_NAME;
    }

    public void saveEmployee(Employee employee, RequestCallBack listener) {
        if (employee == null) {
            return;
        }

        setRequestCallBack(listener);
        JSONObject obj = new JSONObject();
        try {
            obj.put("Address", employee.getAddress());
            obj.put("CityID", employee.getCityID());
            obj.put("CountryID", employee.getCountryID());
            obj.put("DistrictID", employee.getDistrictID());
            obj.put("DOB", DateUtils.getDateStringBySpecificDate(employee.getDOB()));
            obj.put("EmployeeID", employee.getEmployeeID());
            obj.put("EmployeeName", employee.getEmployeeName());
            obj.put("EmployeeRole", employee.getEmployeeRole());
            obj.put("EMRType", employee.getEMRType());
            obj.put("Gender", String.valueOf(employee.getGender()));
            obj.put("GraduateSchool", employee.getGraduateSchool());
            obj.put("OpenID", employee.getOpenID());
            obj.put("PhotoID", employee.getPhotoID());
            obj.put("PhotoSID", employee.getPhotoSID());
            obj.put("ProvinceID", String.valueOf(employee.getProvinceID()));
            obj.put("SpecialtyName", employee.getSpecialtyName());
            obj.put("Street", employee.getStreet());
            obj.put("UnionID", employee.getUnionID());
            obj.put("WorkWX", employee.getWorkWX());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestData data = getData();
        data.setQueryData(obj.toString());

        pocess();
    }

}
