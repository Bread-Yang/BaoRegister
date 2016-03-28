package com.mdground.yideguanregister.activity.searchpatient;


import com.mdground.yideguanregister.bean.AppointmentInfo;

public interface SearchPatientPresenter {
	void searchPatient(String keyword, int pageIndex);

	void saveAppointment(AppointmentInfo appointmentInfo);
}
