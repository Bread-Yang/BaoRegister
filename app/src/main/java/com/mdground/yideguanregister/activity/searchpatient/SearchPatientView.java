package com.mdground.yideguanregister.activity.searchpatient;

import com.mdground.yideguanregister.activity.base.BaseView;
import com.mdground.yideguanregister.bean.AppointmentInfo;
import com.mdground.yideguanregister.bean.Patient;

import java.util.List;

public interface SearchPatientView extends BaseView {

	void updateResult(List<Patient> patients);

	void finishResult(int appiontmentResultCode, AppointmentInfo appointment);

}
