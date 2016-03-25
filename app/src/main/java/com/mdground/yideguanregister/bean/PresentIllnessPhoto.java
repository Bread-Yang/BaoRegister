package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class PresentIllnessPhoto implements Parcelable {

	private int ClinicID;

	private int PPID;

	private int PhotoID;

	private int ThumbnailID;

	private int VisitID;

	public PresentIllnessPhoto() {
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

	public int getPPID() {
		return PPID;
	}

	public void setPPID(int PPID) {
		this.PPID = PPID;
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

	public PresentIllnessPhoto(Parcel source) {
		this.ClinicID = source.readInt();
		this.PPID = source.readInt();
		this.PhotoID = source.readInt();
		this.ThumbnailID = source.readInt();
		this.VisitID = source.readInt();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(ClinicID);
		dest.writeInt(PPID);
		dest.writeInt(PhotoID);
		dest.writeInt(ThumbnailID);
		dest.writeInt(VisitID);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<PresentIllnessPhoto> CREATOR = new Creator<PresentIllnessPhoto>() {

		@Override
		public PresentIllnessPhoto createFromParcel(Parcel source) {
			return new PresentIllnessPhoto(source);
		}

		@Override
		public PresentIllnessPhoto[] newArray(int size) {
			return new PresentIllnessPhoto[size];
		}
	};
}
