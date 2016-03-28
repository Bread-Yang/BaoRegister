package com.mdground.yideguanregister.activity.base;

public interface BaseView {
	void showProgress();

	void hideProgress();
	
	void showToast(String text);
	void showToast(int resId);
	
	void requestError(int errorCode, String message);
}
