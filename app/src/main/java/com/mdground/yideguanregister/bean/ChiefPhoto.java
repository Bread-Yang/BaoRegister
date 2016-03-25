package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ChiefPhoto implements Parcelable {

	private int ClinicID;

	private int CPID;

	private int PhotoID;

	private int ThumbnailID;

	private int VisitID;

	public ChiefPhoto() {
	}

	public int getClinicID() {
		return ClinicID;
	}

	public void setClinicID(int clinicID) {
		ClinicID = clinicID;
	}

	public int getPhotoID() {
		return PhotoID;
	}

	public void setPhotoID(int photoID) {
		PhotoID = photoID;
	}

	public int getCPID() {
		return CPID;
	}

	public void setCPID(int CPID) {
		this.CPID = CPID;
	}

	public int getThumbnailID() {
		return ThumbnailID;
	}

	public void setThumbnailID(int thumbnailID) {
		ThumbnailID = thumbnailID;
	}

	public int getVisitID() {
		return VisitID;
	}

	public void setVisitID(int visitID) {
		VisitID = visitID;
	}

	public String getImageURL() {
		return "image://" + ClinicID + "." + PhotoID;
	}

	public ChiefPhoto(Parcel source) {
		this.ClinicID = source.readInt();
		this.CPID = source.readInt();
		this.PhotoID = source.readInt();
		this.ThumbnailID = source.readInt();
		this.VisitID = source.readInt();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(ClinicID);
		dest.writeInt(CPID);
		dest.writeInt(PhotoID);
		dest.writeInt(ThumbnailID);
		dest.writeInt(VisitID);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<ChiefPhoto> CREATOR = new Creator<ChiefPhoto>() {

		@Override
		public ChiefPhoto createFromParcel(Parcel source) {
			return new ChiefPhoto(source);
		}

		@Override
		public ChiefPhoto[] newArray(int size) {
			return new ChiefPhoto[size];
		}
	};
}
