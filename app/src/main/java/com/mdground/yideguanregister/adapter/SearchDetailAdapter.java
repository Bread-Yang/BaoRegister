package com.mdground.yideguanregister.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.mdground.yideguanregister.R;
import com.mdground.yideguanregister.bean.Patient;
import com.mdground.yideguanregister.util.StringUtils;
import com.mdground.yideguanregister.view.CircleImageView;


public class SearchDetailAdapter<T> extends SimpleAdapter<T> {

	private AppiontmentCallBack mCallBack;

	protected static class ViewHolder extends BaseViewHolder {
		private CircleImageView headImg;
		private TextView name;
		private TextView age;
		private TextView notext;
		private TextView phone;
	}

	private View.OnClickListener mOnClickListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			if (mCallBack != null && v.getTag() instanceof Patient) {
				mCallBack.onAppiontment((Patient) v.getTag());
			}
		}
	};

	// 挂号
	public static interface AppiontmentCallBack {
		public void onAppiontment(Patient patient);
	}

	public SearchDetailAdapter(Context context, AppiontmentCallBack callBack) {
		super(context, ViewHolder.class);
		this.mCallBack = callBack;
	}

	@Override
	protected void bindData(SimpleAdapter.BaseViewHolder holder, int position, View convertView) {
		ViewHolder viewHolder = (ViewHolder) holder;

		Patient patient = (Patient) getItem(position);
		if (patient != null) {
			viewHolder.age.setText(StringUtils.getAge(patient.getDOB()) + "/" + patient.getGenderStr());
			viewHolder.name.setText(patient.getPatientName());
			viewHolder.phone.setText(patient.getPhone());
			viewHolder.notext.setTag(patient);
			if (patient.getGender() == 1) {// 1代表男
				viewHolder.headImg.setImageResource(R.drawable.head_man);
			} else {
				viewHolder.headImg.setImageResource(R.drawable.head_lady);
			}
			viewHolder.headImg.loadImage(patient.getPhotoUrl());
		}
	}

	@Override
	protected void initHolder(SimpleAdapter.BaseViewHolder holder, View convertView) {
		if (!(holder instanceof ViewHolder)) {
			return;
		}
		ViewHolder viewHolder = (ViewHolder) holder;
		
		viewHolder.headImg = (CircleImageView) convertView.findViewById(R.id.head);
		viewHolder.name = (TextView) convertView.findViewById(R.id.name);
		viewHolder.age = (TextView) convertView.findViewById(R.id.age);
		viewHolder.notext = (TextView) convertView.findViewById(R.id.notext);
		viewHolder.phone = (TextView) convertView.findViewById(R.id.phone);
		viewHolder.notext.setOnClickListener(mOnClickListener);

	}

	@Override
	protected int getViewResource() {
		return R.layout.item_search_detail; 
	}

}
