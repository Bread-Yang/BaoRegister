package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class PresentIllness implements Parcelable {

	private int VisitID;
	private int ClinicID;
	private int DoctorID;
	private int PatientID;
	private String Description;
	private ArrayList<PresentIllnessPhoto> PhotoList;

	public PresentIllness() {
	}

	public int getVisitID() {
		return VisitID;
	}

	public void setVisitID(int visitID) {
		VisitID = visitID;
	}

	public int getClinicID() {
		return ClinicID;
	}

	public void setClinicID(int clinicID) {
		ClinicID = clinicID;
	}

	public int getDoctorID() {
		return DoctorID;
	}

	public void setDoctorID(int doctorID) {
		DoctorID = doctorID;
	}

	public int getPatientID() {
		return PatientID;
	}

	public void setPatientID(int patientID) {
		PatientID = patientID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public ArrayList<PresentIllnessPhoto> getPhotoList() {
		return PhotoList;
	}

	public void setPhotoList(ArrayList<PresentIllnessPhoto> photoList) {
		PhotoList = photoList;
	}

	public PresentIllness(Parcel source) {
		this.VisitID = source.readInt();
		this.ClinicID = source.readInt();
		this.DoctorID = source.readInt();
		this.PatientID = source.readInt();
		this.Description = source.readString();
		this.PhotoList = source.createTypedArrayList(PresentIllnessPhoto.CREATOR);
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(VisitID);
		dest.writeInt(ClinicID);
		dest.writeInt(DoctorID);
		dest.writeInt(PatientID);
		dest.writeString(Description);
		dest.writeTypedList(PhotoList);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<PresentIllness> CREATOR = new Creator<PresentIllness>() {

		@Override
		public PresentIllness createFromParcel(Parcel source) {
			return new PresentIllness(source);
		}

		@Override
		public PresentIllness[] newArray(int size) {
			return new PresentIllness[size];
		}
	};
}
