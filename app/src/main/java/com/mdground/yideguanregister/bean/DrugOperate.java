package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by yoghourt on 12/30/15.
 */
public class DrugOperate implements Parcelable {

    private int Auditor;

    private String AuditorName;

    private Date AuditTime;

    private int CheckStatus;

    private int ClinicID;

    private int DrugID;

    private String DrugName;

    private boolean HasAudit;

    private boolean HasRead;

    private int InventoryID;

    private int InventoryQuantity;

    private int InventoryQuantity0;

    private int LogID;

    private String Manufacturer;

    private int OperateGroup;

    private Date OperateTime;

    private int OperateType;

    private int Operator;

    private String OperatorName;

    private int OVPrice;

    private int OVPrice0;

    private int OVUnitType;

    private int OVUnitType0;

    private String Remark;

    private int SalePrice;

    private int SalePrice0;

    private int SaleUnitType;

    private int SaleUnitType0;

    private String Specification;

    private int UnitConvert;

    private String UnitGeneric;

    private String UnitSmall;

    // 只是界面用到的字段
    private transient boolean isChecked;

    public DrugOperate() {
        Remark = "";
    }

    protected DrugOperate(Parcel in) {
        Auditor = in.readInt();
        AuditorName = in.readString();
        long auditTimeTemp = in.readLong();
        if (auditTimeTemp != -1) {
            AuditTime = new Date(auditTimeTemp);
        }
        CheckStatus = in.readInt();
        ClinicID = in.readInt();
        DrugID = in.readInt();
        DrugName = in.readString();
        HasAudit = in.readByte() != 0;
        HasRead = in.readByte() != 0;
        InventoryID = in.readInt();
        InventoryQuantity = in.readInt();
        InventoryQuantity0 = in.readInt();
        LogID = in.readInt();
        Manufacturer = in.readString();
        OperateGroup = in.readInt();
        long operateTimeTemp = in.readLong();
        if (operateTimeTemp != -1) {
            OperateTime = new Date(operateTimeTemp);
        }
        OperateType = in.readInt();
        Operator = in.readInt();
        OperatorName = in.readString();
        OVPrice = in.readInt();
        OVPrice0 = in.readInt();
        OVUnitType = in.readInt();
        OVUnitType0 = in.readInt();
        Remark = in.readString();
        SalePrice = in.readInt();
        SalePrice0 = in.readInt();
        SaleUnitType = in.readInt();
        SaleUnitType0 = in.readInt();
        Specification = in.readString();
        UnitConvert = in.readInt();
        UnitGeneric = in.readString();
        UnitSmall = in.readString();
    }

    public static final Creator<DrugOperate> CREATOR = new Creator<DrugOperate>() {
        @Override
        public DrugOperate createFromParcel(Parcel in) {
            return new DrugOperate(in);
        }

        @Override
        public DrugOperate[] newArray(int size) {
            return new DrugOperate[size];
        }
    };

    public int getAuditor() {
        return Auditor;
    }

    public void setAuditor(int auditor) {
        Auditor = auditor;
    }

    public String getAuditorName() {
        return AuditorName;
    }

    public void setAuditorName(String auditorName) {
        AuditorName = auditorName;
    }

    public Date getAuditTime() {
        return AuditTime;
    }

    public void setAuditTime(Date auditTime) {
        AuditTime = auditTime;
    }

    public int getCheckStatus() {
        return CheckStatus;
    }

    public void setCheckStatus(int checkStatus) {
        CheckStatus = checkStatus;
    }

    public int getClinicID() {
        return ClinicID;
    }

    public void setClinicID(int clinicID) {
        ClinicID = clinicID;
    }

    public int getDrugID() {
        return DrugID;
    }

    public void setDrugID(int drugID) {
        DrugID = drugID;
    }

    public String getDrugName() {
        return DrugName;
    }

    public void setDrugName(String drugName) {
        DrugName = drugName;
    }

    public boolean isHasAudit() {
        return HasAudit;
    }

    public void setHasAudit(boolean hasAudit) {
        HasAudit = hasAudit;
    }

    public boolean isHasRead() {
        return HasRead;
    }

    public void setHasRead(boolean hasRead) {
        HasRead = hasRead;
    }

    public int getInventoryID() {
        return InventoryID;
    }

    public void setInventoryID(int inventoryID) {
        InventoryID = inventoryID;
    }

    public int getInventoryQuantity() {
        return InventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        InventoryQuantity = inventoryQuantity;
    }

    public int getInventoryQuantity0() {
        return InventoryQuantity0;
    }

    public void setInventoryQuantity0(int inventoryQuantity0) {
        InventoryQuantity0 = inventoryQuantity0;
    }

    public int getLogID() {
        return LogID;
    }

    public void setLogID(int logID) {
        LogID = logID;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public int getOperateGroup() {
        return OperateGroup;
    }

    public void setOperateGroup(int operateGroup) {
        OperateGroup = operateGroup;
    }

    public Date getOperateTime() {
        return OperateTime;
    }

    public void setOperateTime(Date operateTime) {
        OperateTime = operateTime;
    }

    public int getOperateType() {
        return OperateType;
    }

    public void setOperateType(int operateType) {
        OperateType = operateType;
    }

    public int getOperator() {
        return Operator;
    }

    public void setOperator(int operator) {
        Operator = operator;
    }

    public String getOperatorName() {
        return OperatorName;
    }

    public void setOperatorName(String operatorName) {
        OperatorName = operatorName;
    }

    public int getOVPrice() {
        return OVPrice;
    }

    public void setOVPrice(int OVPrice) {
        this.OVPrice = OVPrice;
    }

    public int getOVPrice0() {
        return OVPrice0;
    }

    public void setOVPrice0(int OVPrice0) {
        this.OVPrice0 = OVPrice0;
    }

    public int getOVUnitType() {
        return OVUnitType;
    }

    public void setOVUnitType(int OVUnitType) {
        this.OVUnitType = OVUnitType;
    }

    public int getOVUnitType0() {
        return OVUnitType0;
    }

    public void setOVUnitType0(int OVUnitType0) {
        this.OVUnitType0 = OVUnitType0;
    }

    public String getOVUnit() {
        if (OVUnitType == 1) {
            return UnitGeneric;
        } else {
            return UnitSmall;
        }
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public int getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(int salePrice) {
        SalePrice = salePrice;
    }

    public int getSalePrice0() {
        return SalePrice0;
    }

    public void setSalePrice0(int salePrice0) {
        SalePrice0 = salePrice0;
    }

    public int getSaleUnitType() {
        return SaleUnitType;
    }

    public void setSaleUnitType(int saleUnitType) {
        SaleUnitType = saleUnitType;
    }

    public String getSaleUnit() {
        if (SaleUnitType == 1) {
            return UnitGeneric;
        } else {
            return UnitSmall;
        }
    }

    public int getSaleUnitType0() {
        return SaleUnitType0;
    }

    public void setSaleUnitType0(int saleUnitType0) {
        SaleUnitType0 = saleUnitType0;
    }

    public String getSpecification() {
        return Specification;
    }

    public void setSpecification(String specification) {
        Specification = specification;
    }

    public int getUnitConvert() {
        return UnitConvert;
    }

    public void setUnitConvert(int unitConvert) {
        UnitConvert = unitConvert;
    }

    public String getUnitGeneric() {
        return UnitGeneric;
    }

    public void setUnitGeneric(String unitGeneric) {
        UnitGeneric = unitGeneric;
    }

    public String getUnitSmall() {
        return UnitSmall;
    }

    public void setUnitSmall(String unitSmall) {
        UnitSmall = unitSmall;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Auditor);
        dest.writeString(AuditorName);
        if (AuditTime != null) {
            dest.writeLong(AuditTime.getTime());
        } else {
            dest.writeLong(-1);
        }
        dest.writeInt(CheckStatus);
        dest.writeInt(ClinicID);
        dest.writeInt(DrugID);
        dest.writeString(DrugName);
        dest.writeByte((byte) (HasAudit ? 1 : 0));
        dest.writeByte((byte) (HasRead ? 1 : 0));
        dest.writeInt(InventoryID);
        dest.writeInt(InventoryQuantity);
        dest.writeInt(InventoryQuantity0);
        dest.writeInt(LogID);
        dest.writeString(Manufacturer);
        dest.writeInt(OperateGroup);
        if (OperateTime != null) {
            dest.writeLong(OperateTime.getTime());
        } else {
            dest.writeLong(-1);
        }
        dest.writeInt(OperateType);
        dest.writeInt(Operator);
        dest.writeString(OperatorName);
        dest.writeInt(OVPrice);
        dest.writeInt(OVPrice0);
        dest.writeInt(OVUnitType);
        dest.writeInt(OVUnitType0);
        dest.writeString(Remark);
        dest.writeInt(SalePrice);
        dest.writeInt(SalePrice0);
        dest.writeInt(SaleUnitType);
        dest.writeInt(SaleUnitType0);
        dest.writeString(Specification);
        dest.writeInt(UnitConvert);
        dest.writeString(UnitGeneric);
        dest.writeString(UnitSmall);
    }
}
