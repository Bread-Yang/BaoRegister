package com.mdground.yideguanregister.activity.doctorlist;


import com.mdground.yideguanregister.activity.base.BaseView;
import com.mdground.yideguanregister.api.base.DoctorWaittingCount;
import com.mdground.yideguanregister.bean.AppointmentInfo;
import com.mdground.yideguanregister.bean.Doctor;

import java.util.List;

public interface DoctorSelectListView extends BaseView {

	public void finishResult(int resultCode, AppointmentInfo appointmentInfo);

	public void updateDoctorList(List<Doctor> doctorsList);

	public void updateWaitingCount(List<DoctorWaittingCount> waittingCount);
}
