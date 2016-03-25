package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Billing implements Parcelable {

    private int BillingID;

    private String BillingNo;

    private int BillingStatus;

    private int BillingType;

    private int Cashier;

    private String CashierName;

    private int ClinicID;

    private Date CreatedTime;

    private String DoctorName;

    private String FeeType;

    private int OPID;

    private int OPNo;

    private int PatientID;

    private Date PatientDOB;

    private int PatientGender;

    private String PatientName;

    private int TotalCost;

    private int TotalFee;

    private int TotalFeeAdjust;

    private int TotalFeeDebt;

    private int TotalFeeOnSale;

    private int TotalFeeReal;

    private int TotalProfit;

    private String TradePlatform;

    private Date TradeExpriedTime;

    private String TradeNo;

    private Date TradeTime;

    private int VisitID;

    private boolean Confirmed;

    public Billing() {
    }

    protected Billing(Parcel in) {
        BillingID = in.readInt();
        BillingNo = in.readString();
        BillingStatus = in.readInt();
        BillingType = in.readInt();
        Cashier = in.readInt();
        CashierName = in.readString();
        ClinicID = in.readInt();
        {
            long tempCreateTime = in.readLong();
            this.CreatedTime = tempCreateTime == -1 ? null : new Date(tempCreateTime);
        }
        DoctorName = in.readString();
        FeeType = in.readString();
        OPID = in.readInt();
        OPNo = in.readInt();
        PatientID = in.readInt();
        {
            long tempPatientDOB = in.readLong();
            this.PatientDOB = tempPatientDOB == -1 ? null : new Date(tempPatientDOB);
        }
        PatientGender = in.readInt();
        PatientName = in.readString();
        TotalCost = in.readInt();
        TotalFee = in.readInt();
        TotalFeeAdjust = in.readInt();
        TotalFeeDebt = in.readInt();
        TotalFeeOnSale = in.readInt();
        TotalFeeReal = in.readInt();
        TotalProfit = in.readInt();
        TradePlatform = in.readString();
        {
            long tempTradeExpriedTime = in.readLong();
            this.TradeExpriedTime = tempTradeExpriedTime == -1 ? null : new Date(tempTradeExpriedTime);
        }
        TradeNo = in.readString();
        {
            long tempTradeTime = in.readLong();
            this.TradeTime = tempTradeTime == -1 ? null : new Date(tempTradeTime);
        }
        VisitID = in.readInt();
        Confirmed = (in.readInt() == 0) ? false : true;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(BillingID);
        dest.writeString(BillingNo);
        dest.writeInt(BillingStatus);
        dest.writeInt(BillingType);
        dest.writeInt(Cashier);
        dest.writeString(CashierName);
        dest.writeInt(ClinicID);
        {
            if (CreatedTime == null) {
                dest.writeLong(-1);
            } else {
                dest.writeLong(CreatedTime.getTime());
            }
        }
        dest.writeString(DoctorName);
        dest.writeString(FeeType);
        dest.writeInt(OPID);
        dest.writeInt(OPNo);
        dest.writeInt(PatientID);
        {
            if (PatientDOB == null) {
                dest.writeLong(-1);
            } else {
                dest.writeLong(PatientDOB.getTime());
            }
        }
        dest.writeInt(PatientGender);
        dest.writeString(PatientName);
        dest.writeInt(TotalCost);
        dest.writeInt(TotalFee);
        dest.writeInt(TotalFeeAdjust);
        dest.writeInt(TotalFeeDebt);
        dest.writeInt(TotalFeeOnSale);
        dest.writeInt(TotalFeeReal);
        dest.writeInt(TotalProfit);
        dest.writeString(TradePlatform);
        {
            if (TradeExpriedTime == null) {
                dest.writeLong(-1);
            } else {
                dest.writeLong(TradeExpriedTime.getTime());
            }
        }
        dest.writeString(TradeNo);
        {
            if (TradeTime == null) {
                dest.writeLong(-1);
            } else {
                dest.writeLong(TradeTime.getTime());
            }
        }
        dest.writeInt(VisitID);
        dest.writeInt(Confirmed ? 1 : 0);
    }

    public static final Creator<Billing> CREATOR = new Creator<Billing>() {
        @Override
        public Billing createFromParcel(Parcel in) {
            return new Billing(in);
        }

        @Override
        public Billing[] newArray(int size) {
            return new Billing[size];
        }
    };

    public int getClinicID() {
        return ClinicID;
    }

    public void setClinicID(int clinicID) {
        ClinicID = clinicID;
    }

    public int getBillingID() {
        return BillingID;
    }

    public void setBillingID(int billingID) {
        BillingID = billingID;
    }

    public String getBillingNo() {
        return BillingNo;
    }

    public void setBillingNo(String billingNo) {
        BillingNo = billingNo;
    }

    public int getBillingStatus() {
        return BillingStatus;
    }

    public void setBillingStatus(int billingStatus) {
        BillingStatus = billingStatus;
    }

    public int getBillingType() {
        return BillingType;
    }

    public void setBillingType(int billingType) {
        BillingType = billingType;
    }

    public int getCashier() {
        return Cashier;
    }

    public void setCashier(int cashier) {
        Cashier = cashier;
    }

    public String getCashierName() {
        return CashierName;
    }

    public void setCashierName(String cashierName) {
        CashierName = cashierName;
    }

    public Date getCreatedTime() {
        return CreatedTime;
    }

    public void setCreatedTime(Date createdTime) {
        CreatedTime = createdTime;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getFeeType() {
        return FeeType;
    }

    public void setFeeType(String feeType) {
        FeeType = feeType;
    }

    public int getOPID() {
        return OPID;
    }

    public void setOPID(int OPID) {
        this.OPID = OPID;
    }

    public int getOPNo() {
        return OPNo;
    }

    public void setOPNo(int OPNo) {
        this.OPNo = OPNo;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int patientID) {
        PatientID = patientID;
    }

    public Date getPatientDOB() {
        return PatientDOB;
    }

    public void setPatientDOB(Date patientDOB) {
        PatientDOB = patientDOB;
    }

    public int getPatientGender() {
        return PatientGender;
    }

    public void setPatientGender(int patientGender) {
        PatientGender = patientGender;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public int getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(int totalCost) {
        TotalCost = totalCost;
    }

    public int getTotalFee() {
        return TotalFee;
    }

    public void setTotalFee(int totalFee) {
        TotalFee = totalFee;
    }

    public int getTotalFeeAdjust() {
        return TotalFeeAdjust;
    }

    public void setTotalFeeAdjust(int totalFeeAdjust) {
        TotalFeeAdjust = totalFeeAdjust;
    }

    public int getTotalFeeDebt() {
        return TotalFeeDebt;
    }

    public void setTotalFeeDebt(int totalFeeDebt) {
        TotalFeeDebt = totalFeeDebt;
    }

    public int getTotalFeeOnSale() {
        return TotalFeeOnSale;
    }

    public void setTotalFeeOnSale(int totalFeeOnSale) {
        TotalFeeOnSale = totalFeeOnSale;
    }

    public int getTotalFeeReal() {
        return TotalFeeReal;
    }

    public void setTotalFeeReal(int totalFeeReal) {
        TotalFeeReal = totalFeeReal;
    }

    public int getTotalProfit() {
        return TotalProfit;
    }

    public void setTotalProfit(int totalProfit) {
        TotalProfit = totalProfit;
    }

    public String getTradePlatform() {
        return TradePlatform;
    }

    public void setTradePlatform(String tradePlatform) {
        TradePlatform = tradePlatform;
    }

    public Date getTradeExpriedTime() {
        return TradeExpriedTime;
    }

    public void setTradeExpriedTime(Date tradeExpriedTime) {
        TradeExpriedTime = tradeExpriedTime;
    }

    public String getTradeNo() {
        return TradeNo;
    }

    public void setTradeNo(String tradeNo) {
        TradeNo = tradeNo;
    }

    public Date getTradeTime() {
        return TradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        TradeTime = tradeTime;
    }

    public int getVisitID() {
        return VisitID;
    }

    public void setVisitID(int visitID) {
        VisitID = visitID;
    }

    public boolean isConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        Confirmed = confirmed;
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
