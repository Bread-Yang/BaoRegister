package com.mdground.yideguanregister.activity.doctorlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mdground.yideguanregister.R;
import com.mdground.yideguanregister.activity.base.BaseActivity;
import com.mdground.yideguanregister.adapter.SelectDoctorRoomListAdapter;
import com.mdground.yideguanregister.api.base.DoctorWaittingCount;
import com.mdground.yideguanregister.bean.AppointmentInfo;
import com.mdground.yideguanregister.bean.Doctor;
import com.mdground.yideguanregister.constant.MemberConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择医生界面
 * 
 * @author Administrator
 * 
 */

public class DoctorSelectListActivity extends BaseActivity implements OnClickListener, OnItemClickListener, DoctorSelectListView {
	private ImageView iv_back;
	private Button btn_register;
	private TextView BtConfirm;
	private ListView doctorRoomListView;
	private SelectDoctorRoomListAdapter roomListAdpater;
	private List<Doctor> doctors = new ArrayList<Doctor>();
	private AppointmentInfo appointmentInfo;
	
	private DoctorSelectListPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doctor_select_list);
		findView();
		initView();
		setListener();
		initMemberData();
	}

	@Override
	public void findView() {
		btn_register = (Button) this.findViewById(R.id.btn_register);
		BtConfirm = (TextView) this.findViewById(R.id.comfirm);
		iv_back = (ImageView) this.findViewById(R.id.iv_back);
		doctorRoomListView = (ListView) this.findViewById(R.id.doctor_list);
	}

	@Override
	public void initView() {
		roomListAdpater = new SelectDoctorRoomListAdapter(this);
		roomListAdpater.setDataList(doctors);
		doctorRoomListView.setAdapter(roomListAdpater);
	}

	@Override
	public void initMemberData() {
		Intent intent = getIntent();
		if (intent != null) {
			appointmentInfo = intent.getParcelableExtra(MemberConstant.APPOINTMENT);
		}

		presenter = new DoctorSelectListPresenterImpl(this);
		presenter.getDoctorList();
	}

	@Override
	public void setListener() {
		btn_register.setOnClickListener(this);
		iv_back.setOnClickListener(this);
		doctorRoomListView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		for (int i = 0; i < doctors.size(); i++) {
			Doctor doctor = doctors.get(i);
			if (i == position) {
				doctor.setSelected(true);
			} else {
				doctor.setSelected(false);
			}
		}
		roomListAdpater.notifyDataSetChanged();
	}

	private Doctor getSelectDoctor() {
		Doctor doctor = null;
		for (int i = 0; i < doctors.size(); i++) {
			if (doctors.get(i).isSelected()) {
				doctor = doctors.get(i);
				break;
			}
		}
		return doctor;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_register: {
			// 设置选择的医生
			Doctor doctor = getSelectDoctor();
			if (doctor == null) {
				Toast.makeText(this, "请先选择医生", Toast.LENGTH_SHORT).show();
				return;
			}

			if (appointmentInfo.getOPID() == 0) {
				// 挂号save
				appointmentInfo.setDoctorID(doctor.getDoctorID());
				appointmentInfo.setDoctorName(doctor.getDoctorName());
				appointmentInfo.setOPEMR(doctor.getEMRType());
				presenter.saveAppointment(appointmentInfo);
			} else {
				// 分配
				presenter.assignAppointment(appointmentInfo, doctor.getDoctorID());
			}
			break;
		}
		case R.id.iv_back: {
			finish();
			break;
		}

		}
	}

	@Override
	public void finishResult(int resultCode, AppointmentInfo appointment) {
		Intent intent = new Intent();
		intent.putExtra(MemberConstant.APPOINTMENT, appointment);
		setResult(resultCode, intent);
		finish();
	}

	@Override
	public void updateDoctorList(List<Doctor> doctorsList) {
		if (doctorsList != null) {
			doctors.addAll(doctorsList);
		}

		if (appointmentInfo != null && appointmentInfo.getDoctorID() != 0) {
			for (int i = 0; i < doctors.size(); i++) {
				if (doctors.get(i).getDoctorID() == appointmentInfo.getDoctorID()) {
					doctors.remove(i);
					break;
				}
			}
		}
		// 请求医生候诊人数
		presenter.getWaitingCountForDoctorList(doctors);
		roomListAdpater.notifyDataSetChanged();
	}

	@Override
	public void updateWaitingCount(List<DoctorWaittingCount> waittingCount) {
		if (waittingCount == null || waittingCount.size() == 0) {
			return;
		}
		for (int i = 0; i < waittingCount.size(); i++) {
			DoctorWaittingCount count = waittingCount.get(i);
			for (int j = 0; j < doctors.size(); j++) {
				Doctor doctor = doctors.get(j);
				if (doctor.getDoctorID() == count.getKey()) {
					doctor.setWaittingCount(count.getValue());
				}
			}
		}
		roomListAdpater.notifyDataSetChanged();

	}

}
