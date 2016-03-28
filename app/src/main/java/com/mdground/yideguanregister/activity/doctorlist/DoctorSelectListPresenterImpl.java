package com.mdground.yideguanregister.activity.doctorlist;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.mdground.yideguanregister.R;
import com.mdground.yideguanregister.api.base.DoctorWaittingCount;
import com.mdground.yideguanregister.api.base.RequestCallBack;
import com.mdground.yideguanregister.api.base.ResponseCode;
import com.mdground.yideguanregister.api.base.ResponseData;
import com.mdground.yideguanregister.api.server.clinic.GetAppointmentCountForWaiting;
import com.mdground.yideguanregister.api.server.clinic.SaveAppointment;
import com.mdground.yideguanregister.api.server.clinic.UpdateAppointmentByAssign;
import com.mdground.yideguanregister.api.server.global.GetDoctorList;
import com.mdground.yideguanregister.bean.AppointmentInfo;
import com.mdground.yideguanregister.bean.Doctor;
import com.mdground.yideguanregister.constant.MemberConstant;

import org.apache.http.Header;

import java.util.List;

public class DoctorSelectListPresenterImpl implements DoctorSelectListPresenter {
	DoctorSelectListView mView;

	public DoctorSelectListPresenterImpl(DoctorSelectListView view) {
		this.mView = view;
	}

	@Override
	public void saveAppointment(final AppointmentInfo appointment) {
		SaveAppointment saveAppointment = new SaveAppointment((Context) mView);
		saveAppointment.saveAppointment(appointment, new RequestCallBack() {

			@Override
			public void onSuccess(ResponseData response) {
				if (response.getCode() == ResponseCode.Normal.getValue()) {
					AppointmentInfo appointmentInfo = response.getContent(AppointmentInfo.class);
					appointmentInfo.setOPEMR(appointment.getOPEMR());
					mView.finishResult(MemberConstant.APPIONTMENT_RESULT_CODE, appointmentInfo);
				} else {
					mView.requestError(response.getCode(), response.getMessage());
				}
			}

			@Override
			public void onStart() {
				mView.showProgress();
			}

			@Override
			public void onFinish() {
				mView.hideProgress();
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
				mView.showToast(R.string.request_error);
			}
		});
	}

	@Override
	public void getDoctorList() {
		GetDoctorList getDoctorList = new GetDoctorList((Context) mView);
		getDoctorList.getDoctorList(new RequestCallBack() {

			@Override
			public void onStart() {
				mView.showProgress();
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
				// TODO Auto-generated method stub
				mView.showToast(R.string.request_error);
			}

			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				mView.hideProgress();
			}

			@Override
			public void onSuccess(ResponseData response) {
				if (response.getCode() == ResponseCode.Normal.getValue()) {
					List<Doctor> doctorsList = response.getContent(new TypeToken<List<Doctor>>() {
					});
					mView.updateDoctorList(doctorsList);
				} else {
					mView.requestError(response.getCode(), response.getMessage());
				}
			}
		});

	}

	@Override
	public void assignAppointment(final AppointmentInfo appointmentInfo, int doctorId) {
		// TODO Auto-generated method stub
		UpdateAppointmentByAssign updateAppointmentByAssign = new UpdateAppointmentByAssign((Context) mView);
		updateAppointmentByAssign.updateAppointmentByAssign(appointmentInfo.getOPID(), doctorId, new RequestCallBack() {

			@Override
			public void onStart() {
				mView.showProgress();
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
				// TODO Auto-generated method stub
				mView.showToast(R.string.request_error);
			}

			@Override
			public void onFinish() {
				mView.hideProgress();
			}

			@Override
			public void onSuccess(ResponseData response) {
				// TODO Auto-generated method stub
				if (response.getCode() == ResponseCode.Normal.getValue()) {
					mView.finishResult(MemberConstant.APPIONTMENT_RESULT_ASSIGN, appointmentInfo);
				} else {
					mView.requestError(response.getCode(), response.getMessage());
				}
			}
		});
	}

	@Override
	public void getWaitingCountForDoctorList(List<Doctor> doctors) {
		GetAppointmentCountForWaiting getWaiting = new GetAppointmentCountForWaiting((Context) mView);
		getWaiting.getAppointmentCountForWaiting(doctors, new RequestCallBack() {

			@Override
			public void onSuccess(ResponseData response) {
				if (response.getCode() == ResponseCode.Normal.getValue()) {
					List<DoctorWaittingCount> waittingCount = response.getContent(new TypeToken<List<DoctorWaittingCount>>() {
					});
					mView.updateWaitingCount(waittingCount);
				} else {
					mView.requestError(response.getCode(), response.getMessage());
				}
			}

			@Override
			public void onStart() {

			}

			@Override
			public void onFinish() {
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
				mView.showToast(R.string.request_error);
			}
		});
	}
}
