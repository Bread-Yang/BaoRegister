package com.mdground.yideguanregister.activity.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.mdground.yideguanregister.MedicalAppliction;
import com.mdground.yideguanregister.R;
import com.mdground.yideguanregister.api.base.ResponseCode;
import com.mdground.yideguanregister.util.AppManager;
import com.mdground.yideguanregister.dialog.LoadingDialog;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public abstract class BaseActivity extends Activity implements BaseView {

    private LoadingDialog mLoadingDialog;

    /**
     * 用户获取控件方法
     */
    public abstract void findView();

    /**
     * 初始化成员变量
     */
    public abstract void initMemberData();

    /**
     * 初始化控件数据
     */
    public abstract void initView();

    /**
     * 设置监听方法
     */
    public abstract void setListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void showToast(int resId) {
        String text = getResources().getString(resId);
        showToast(text);
    }

    public MedicalAppliction getMedicalAppliction() {
        Application app = getApplication();
        if (app instanceof MedicalAppliction) {
            return (MedicalAppliction) app;
        }

        return null;
    }

    @Override
    public void showProgress() {
        getLoadingDialog().show();
    }

    @Override
    public void hideProgress() {
        getLoadingDialog().dismiss();
    }

    protected LoadingDialog getLoadingDialog() {
        if (mLoadingDialog == null) {
            mLoadingDialog = new LoadingDialog(this);
        }

        return mLoadingDialog;
    }

    @Override
    public void requestError(int errorCode, String message) {
        if (errorCode >= ResponseCode.AppCustom0.getValue()) {
            showToast(message);
        } else {
            showToast(R.string.request_error);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(new CalligraphyContextWrapper(newBase));
    }

    @Override
    public void onBackPressed() {
    }
}
