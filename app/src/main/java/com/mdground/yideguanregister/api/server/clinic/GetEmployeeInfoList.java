package com.mdground.yideguanregister.api.server.clinic;

import android.content.Context;

import com.mdground.yideguanregister.api.base.ClinicRequest;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.RequestData;

/**
 * @author yoghourt
 */
public class GetEmployeeInfoList extends ClinicRequest {
    private static final String FUNCTION_NAME = "GetEmployeeInfoList";

    public GetEmployeeInfoList(Context context) {
        super(context);
    }

    @Override
    protected String getFunctionName() {
        return FUNCTION_NAME;
    }

    public void getEmployeeInfoList(RequestCallBack callBack) {
        setRequestCallBack(callBack);

        RequestData data = getData();
        pocess();
    }
}
