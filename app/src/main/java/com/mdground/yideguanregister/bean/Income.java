package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by yoghourt on 1/20/16.
 */
public class Income implements Parcelable{

    private boolean Availability;

    private int ClinicID;

    private Date CreatedTime;

    private Date EffectiveTime;

    private int EmployeeID;

    private String FeeType;

    private int IncomeID;

    private int IncomeType;

    private String IncomeTypeName;

    private int TotalFee;

    private String TradeNo;

    protected Income(Parcel in) {
        Availability = in.readByte() != 0;
        ClinicID = in.readInt();
        {
            long tempCreateTime = in.readLong();
            this.CreatedTime = tempCreateTime == -1 ? null : new Date(tempCreateTime);
        }
        {
            long tempEffectiveTime = in.readLong();
            this.EffectiveTime = tempEffectiveTime == -1 ? null : new Date(tempEffectiveTime);
        }
        EmployeeID = in.readInt();
        FeeType = in.readString();
        IncomeID = in.readInt();
        IncomeType = in.readInt();
        IncomeTypeName = in.readString();
        TotalFee = in.readInt();
        TradeNo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (Availability ? 1 : 0));
        dest.writeInt(ClinicID);
        {
            if (CreatedTime == null) {
                dest.writeLong(-1);
            } else {
                dest.writeLong(CreatedTime.getTime());
            }
        }
        {
            if (EffectiveTime == null) {
                dest.writeLong(-1);
            } else {
                dest.writeLong(EffectiveTime.getTime());
            }
        }
        dest.writeInt(EmployeeID);
        dest.writeString(FeeType);
        dest.writeInt(IncomeID);
        dest.writeInt(IncomeType);
        dest.writeString(IncomeTypeName);
        dest.writeInt(TotalFee);
        dest.writeString(TradeNo);
    }

    public static final Creator<Income> CREATOR = new Creator<Income>() {
        @Override
        public Income createFromParcel(Parcel in) {
            return new Income(in);
        }

        @Override
        public Income[] newArray(int size) {
            return new Income[size];
        }
    };

    public boolean isAvailability() {
        return Availability;
    }

    public void setAvailability(boolean availability) {
        Availability = availability;
    }

    public int getClinicID() {
        return ClinicID;
    }

    public void setClinicID(int clinicID) {
        ClinicID = clinicID;
    }

    public Date getCreatedTime() {
        return CreatedTime;
    }

    public void setCreatedTime(Date createdTime) {
        CreatedTime = createdTime;
    }

    public Date getEffectiveTime() {
        return EffectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        EffectiveTime = effectiveTime;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getFeeType() {
        return FeeType;
    }

    public void setFeeType(String feeType) {
        FeeType = feeType;
    }

    public int getIncomeID() {
        return IncomeID;
    }

    public void setIncomeID(int incomeID) {
        IncomeID = incomeID;
    }

    public int getIncomeType() {
        return IncomeType;
    }

    public void setIncomeType(int incomeType) {
        IncomeType = incomeType;
    }

    public String getIncomeTypeName() {
        return IncomeTypeName;
    }

    public void setIncomeTypeName(String incomeTypeName) {
        IncomeTypeName = incomeTypeName;
    }

    public int getTotalFee() {
        return TotalFee;
    }

    public void setTotalFee(int totalFee) {
        TotalFee = totalFee;
    }

    public String getTradeNo() {
        return TradeNo;
    }

    public void setTradeNo(String tradeNo) {
        TradeNo = tradeNo;
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
