package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.tsz.afinal.annotation.sqlite.Id;
import net.tsz.afinal.annotation.sqlite.Table;
import net.tsz.afinal.annotation.sqlite.Transient;

@Table(name = "Fee")
public class Fee implements Parcelable {

	@Id
	private int id;
	
	@SerializedName("FTID")
	@Expose
	private int FTID;

	@SerializedName("FeeCode")
	@Expose
	private String FeeCode;

	@SerializedName("ClinicID")
	@Expose
	private int ClinicID;
	
	@SerializedName("DoctorID")
	@Expose
	private int DoctorID;

	@SerializedName("FeeType")
	@Expose
	private String FeeType;

	@SerializedName("Required")
	@Expose
	private boolean Required;

	@SerializedName("TotalFee")
	@Expose
	private int TotalFee;

	private boolean Displayed;

	private int PrintOrder;

	private boolean PrintShow;

	@Transient
	private Button bindButton;

	public Fee() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFTID() {
		return FTID;
	}

	public void setFTID(int fTID) {
		FTID = fTID;
	}

	public String getFeeCode() {
		return FeeCode;
	}

	public void setFeeCode(String feeCode) {
		FeeCode = feeCode;
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

	public String getFeeType() {
		return FeeType;
	}

	public void setFeeType(String feeType) {
		FeeType = feeType;
	}

	public boolean isRequired() {
		return Required;
	}

	public void setRequired(boolean required) {
		Required = required;
	}

	public int getTotalFee() {
		return TotalFee;
	}

	public void setTotalFee(int totalFee) {
		TotalFee = totalFee;
	}

	public boolean isDisplayed() {
		return Displayed;
	}

	public void setDisplayed(boolean displayed) {
		Displayed = displayed;
	}

	public int getPrintOrder() {
		return PrintOrder;
	}

	public void setPrintOrder(int printOrder) {
		PrintOrder = printOrder;
	}

	public boolean isPrintShow() {
		return PrintShow;
	}

	public void setPrintShow(boolean printShow) {
		PrintShow = printShow;
	}

	public Button getBindButton() {
		return bindButton;
	}

	public void setBindButton(Button bindButton) {
		this.bindButton = bindButton;
	}

	public Fee(Parcel source) {
		this.ClinicID = source.readInt();
		this.DoctorID = source.readInt();
		this.FeeType = source.readString();
		this.FTID = source.readInt();
		this.FeeCode = source.readString();
		this.Required = source.readInt() == 0 ? false : true;
		this.TotalFee = source.readInt();
		this.Displayed = source.readInt() == 1 ? true : false;
		this.PrintOrder = source.readInt();
		this.PrintShow = source.readInt() == 1 ? true : false;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(ClinicID);
		dest.writeInt(DoctorID);
		dest.writeString(FeeType);
		dest.writeInt(FTID);
		dest.writeString(FeeCode);
		dest.writeInt(Required ? 1 : 0);
		dest.writeInt(TotalFee);
		dest.writeInt(Displayed? 1 : 0);
		dest.writeInt(PrintOrder);
		dest.writeInt(PrintShow? 1 : 0);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Parcelable.Creator<Fee> CREATOR = new Parcelable.Creator<Fee>() {

		@Override
		public Fee createFromParcel(Parcel source) {
			return new Fee(source);
		}

		@Override
		public Fee[] newArray(int size) {
			return new Fee[size];
		}
	};
}
