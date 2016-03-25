package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.tsz.afinal.annotation.sqlite.Id;
import net.tsz.afinal.annotation.sqlite.Table;

public class DrugPhoto implements Parcelable {

	private int ClinicID;

	private int DPID;

	private int DrugID;

	private int PhotoID;

	private int PhotoSID;

	public DrugPhoto() {
	}

	public int getClinicID() {
		return ClinicID;
	}

	public void setClinicID(int clinicID) {
		ClinicID = clinicID;
	}

	public int getDPID() {
		return DPID;
	}

	public void setDPID(int DPID) {
		this.DPID = DPID;
	}

	public int getDrugID() {
		return DrugID;
	}

	public void setDrugID(int drugID) {
		DrugID = drugID;
	}

	public int getPhotoID() {
		return PhotoID;
	}

	public void setPhotoID(int photoID) {
		PhotoID = photoID;
	}

	public int getPhotoSID() {
		return PhotoSID;
	}

	public void setPhotoSID(int photoSID) {
		PhotoSID = photoSID;
	}

	public DrugPhoto(Parcel source) {
		this.ClinicID = source.readInt();
		this.DPID = source.readInt();
		this.DrugID = source.readInt();
		this.PhotoID = source.readInt();
		this.PhotoSID = source.readInt();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(ClinicID);
		dest.writeInt(DPID);
		dest.writeInt(DrugID);
		dest.writeInt(PhotoID);
		dest.writeInt(PhotoSID);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<DrugPhoto> CREATOR = new Creator<DrugPhoto>() {

		@Override
		public DrugPhoto createFromParcel(Parcel source) {
			return new DrugPhoto(source);
		}

		@Override
		public DrugPhoto[] newArray(int size) {
			return new DrugPhoto[size];
		}
	};
}
