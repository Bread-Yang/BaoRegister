package com.mdground.yideguanregister;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.graphics.Bitmap;

import com.mdground.yideguanregister.api.MdgAppliction;
import com.mdground.yideguanregister.bean.Clinic;
import com.mdground.yideguanregister.bean.Employee;
import com.mdground.yideguanregister.util.MdgConfig;
import com.mdground.yideguanregister.util.YiDeGuanImageDownloader;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

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

        initImageLoader();
    }

    /**
     * 初始化Image缓存
     */
    public void initImageLoader() {
        DisplayImageOptions options = new DisplayImageOptions.Builder().delayBeforeLoading(150).bitmapConfig(Bitmap.Config.RGB_565).cacheInMemory(true).cacheOnDisk(true)
                .considerExifParams(true).build();

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .imageDownloader(new YiDeGuanImageDownloader(getApplicationContext())).defaultDisplayImageOptions(options).build();

        ImageLoader.getInstance().init(configuration);
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
