package com.mdground.yideguanregister;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;

import com.mdground.yideguanregister.api.MdgAppliction;
import com.mdground.yideguanregister.bean.Clinic;
import com.mdground.yideguanregister.bean.Employee;
import com.mdground.yideguanregister.util.MdgConfig;

import java.util.List;

public class MedicalAppliction extends MdgAppliction {

    public static Employee mLoginEmployee;// 登陆用户

    public static Clinic mClinic; // 诊所信息

    public MedicalAppliction() {
    }

    public Employee getLoginEmployee() {
        return mLoginEmployee;
    }

    public void setLoginEmployee(Employee employee) {
        mLoginEmployee = employee;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public boolean isMainProcess() {
        ActivityManager am = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE));
        List<RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
        String mainProcessName = getPackageName();
        int myPid = android.os.Process.myPid();
        for (RunningAppProcessInfo info : processInfos) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getDeviceId() {
        int deviceId = MdgConfig.getDeviceId();
        return deviceId;
    }

    @Override
    public String getDeviceToken() {
        return "";
    }

}
