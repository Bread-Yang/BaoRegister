package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ChiefComplaint implements Parcelable {

	private int VisitID;
	private int ClinicID;
	private int DoctorID;
	private int PatientID;
	private String Description;
	private ArrayList<ChiefPhoto> PhotoList;
	
	public ChiefComplaint() {
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

	public ArrayList<ChiefPhoto> getPhotoList() {
		return PhotoList;
	}

	public void setPhotoList(ArrayList<ChiefPhoto> photoList) {
		PhotoList = photoList;
	}

	public ChiefComplaint(Parcel source) {
		this.VisitID = source.readInt();
		this.ClinicID = source.readInt();
		this.DoctorID = source.readInt();
		this.PatientID = source.readInt();
		this.Description = source.readString();
		this.PhotoList = source.createTypedArrayList(ChiefPhoto.CREATOR);
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

	public static final Parcelable.Creator<ChiefComplaint> CREATOR = new Parcelable.Creator<ChiefComplaint>() {

		@Override
		public ChiefComplaint createFromParcel(Parcel source) {
			return new ChiefComplaint(source);
		}

		@Override
		public ChiefComplaint[] newArray(int size) {
			return new ChiefComplaint[size];
		}
	};
}
