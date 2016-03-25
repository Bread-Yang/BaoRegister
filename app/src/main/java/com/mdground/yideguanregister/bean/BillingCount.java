package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class BillingCount implements Comparable<BillingCount>, Parcelable {

    private int Count;

    private int DrugFee;

    private int FeeAvg;

    private int OVFee;

    private int TotalFee;

    private int TotalProfit;

    private int CountReturn;

    private int CountLocal;

    private int CountOnline;

    private int DoctorID;

    private String DoctorName;

    private int FeeMax;

    private int PhotoID;

    private int PhotoSID;

    private int WaitingAvg;

    private int WaitingMax;

    private int WorkingAvg;

    private int WorkingMin;

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public int getDrugFee() {
        return DrugFee;
    }

    public void setDrugFee(int drugFee) {
        DrugFee = drugFee;
    }

    public int getFeeAvg() {
        return FeeAvg;
    }

    public void setFeeAvg(int feeAvg) {
        FeeAvg = feeAvg;
    }

    public int getOVFee() {
        return OVFee;
    }

    public void setOVFee(int OVFee) {
        this.OVFee = OVFee;
    }

    public int getTotalFee() {
        return TotalFee;
    }

    public void setTotalFee(int totalFee) {
        TotalFee = totalFee;
    }

    public int getTotalProfit() {
        return TotalProfit;
    }

    public void setTotalProfit(int totalProfit) {
        TotalProfit = totalProfit;
    }

    public int getCountReturn() {
        return CountReturn;
    }

    public void setCountReturn(int countReturn) {
        CountReturn = countReturn;
    }

    public int getCountLocal() {
        return CountLocal;
    }

    public void setCountLocal(int countLocal) {
        CountLocal = countLocal;
    }

    public int getCountOnline() {
        return CountOnline;
    }

    public void setCountOnline(int countOnline) {
        CountOnline = countOnline;
    }

    public int getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(int doctorID) {
        DoctorID = doctorID;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public int getFeeMax() {
        return FeeMax;
    }

    public void setFeeMax(int feeMax) {
        FeeMax = feeMax;
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

    public int getWaitingAvg() {
        return WaitingAvg;
    }

    public void setWaitingAvg(int waitingAvg) {
        WaitingAvg = waitingAvg;
    }

    public int getWaitingMax() {
        return WaitingMax;
    }

    public void setWaitingMax(int waitingMax) {
        WaitingMax = waitingMax;
    }

    public int getWorkingAvg() {
        return WorkingAvg;
    }

    public void setWorkingAvg(int workingAvg) {
        WorkingAvg = workingAvg;
    }

    public int getWorkingMin() {
        return WorkingMin;
    }

    public void setWorkingMin(int workingMin) {
        WorkingMin = workingMin;
    }

    @Override
    public int compareTo(BillingCount another) {
        if (another.TotalFee == this.TotalFee) {
            return (another.Count - this.Count);
        } else {
            return (another.TotalFee - this.TotalFee);
        }
    }

    protected BillingCount(Parcel in) {
        Count = in.readInt();
        DrugFee = in.readInt();
        FeeAvg = in.readInt();
        OVFee = in.readInt();
        TotalFee = in.readInt();
        TotalProfit = in.readInt();
        CountReturn = in.readInt();
        CountLocal = in.readInt();
        CountOnline = in.readInt();
        DoctorID = in.readInt();
        DoctorName = in.readString();
        FeeMax = in.readInt();
        PhotoID = in.readInt();
        PhotoSID = in.readInt();
        WaitingAvg = in.readInt();
        WaitingMax = in.readInt();
        WorkingAvg = in.readInt();
        WorkingMin = in.readInt();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Count);
        dest.writeInt(DrugFee);
        dest.writeInt(FeeAvg);
        dest.writeInt(OVFee);
        dest.writeInt(TotalFee);
        dest.writeInt(TotalProfit);
        dest.writeInt(CountReturn);
        dest.writeInt(CountLocal);
        dest.writeInt(CountOnline);
        dest.writeInt(DoctorID);
        dest.writeString(DoctorName);
        dest.writeInt(FeeMax);
        dest.writeInt(PhotoID);
        dest.writeInt(PhotoSID);
        dest.writeInt(WaitingAvg);
        dest.writeInt(WaitingMax);
        dest.writeInt(WorkingAvg);
        dest.writeInt(WorkingMin);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BillingCount> CREATOR = new Creator<BillingCount>() {
        @Override
        public BillingCount createFromParcel(Parcel in) {
            return new BillingCount(in);
        }

        @Override
        public BillingCount[] newArray(int size) {
            return new BillingCount[size];
        }
    };
}
