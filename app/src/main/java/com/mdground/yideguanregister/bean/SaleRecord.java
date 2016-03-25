package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by yoghourt on 1/13/16.
 */
public class SaleRecord implements Parcelable {

    private int BillingID;

    private int BillingType;

    private int ClinicID;

    private int DrugID;

    private String DrugName;

    private int EmployeeUpdater;

    private int InventoryID;

    private int PatientID;

    private String ProductionBatch;

    private int PurchasePrice;

    private int SaleID;

    private int SalePrice;

    private int SaleQuantity;

    private int SaleStatus;

    private String SaleUnit;

    private int SaleUnitType;

    private String Specification;

    // 必须传到服务器
    private Date UpdatedTime;

    // 只是界面用到的字段
    private transient boolean isChecked;
    private transient boolean isEdit;

    public SaleRecord() {
        UpdatedTime = new Date();
    }

    protected SaleRecord(Parcel in) {
        BillingID = in.readInt();
        BillingType = in.readInt();
        ClinicID = in.readInt();
        DrugID = in.readInt();
        DrugName = in.readString();
        EmployeeUpdater = in.readInt();
        InventoryID = in.readInt();
        PatientID = in.readInt();
        ProductionBatch = in.readString();
        PurchasePrice = in.readInt();
        SaleID = in.readInt();
        SalePrice = in.readInt();
        SaleQuantity = in.readInt();
        SaleStatus = in.readInt();
        SaleUnit = in.readString();
        SaleUnitType = in.readInt();
        Specification = in.readString();
        {
            long tempUpdatedTime = in.readLong();
            this.UpdatedTime = tempUpdatedTime == -1 ? null : new Date(tempUpdatedTime);
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(BillingID);
        dest.writeInt(BillingType);
        dest.writeInt(ClinicID);
        dest.writeInt(DrugID);
        dest.writeString(DrugName);
        dest.writeInt(EmployeeUpdater);
        dest.writeInt(InventoryID);
        dest.writeInt(PatientID);
        dest.writeString(ProductionBatch);
        dest.writeInt(PurchasePrice);
        dest.writeInt(SaleID);
        dest.writeInt(SalePrice);
        dest.writeInt(SaleQuantity);
        dest.writeInt(SaleStatus);
        dest.writeString(SaleUnit);
        dest.writeInt(SaleUnitType);
        dest.writeString(Specification);
        {
            if (UpdatedTime == null) {
                dest.writeLong(-1);
            } else {
                dest.writeLong(UpdatedTime.getTime());
            }
        }
    }

    public static final Creator<SaleRecord> CREATOR = new Creator<SaleRecord>() {
        @Override
        public SaleRecord createFromParcel(Parcel in) {
            return new SaleRecord(in);
        }

        @Override
        public SaleRecord[] newArray(int size) {
            return new SaleRecord[size];
        }
    };

    public int getBillingID() {
        return BillingID;
    }

    public void setBillingID(int billingID) {
        BillingID = billingID;
    }

    public int getBillingType() {
        return BillingType;
    }

    public void setBillingType(int billingType) {
        BillingType = billingType;
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

    public int getEmployeeUpdater() {
        return EmployeeUpdater;
    }

    public void setEmployeeUpdater(int employeeUpdater) {
        EmployeeUpdater = employeeUpdater;
    }

    public int getInventoryID() {
        return InventoryID;
    }

    public void setInventoryID(int inventoryID) {
        InventoryID = inventoryID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int patientID) {
        PatientID = patientID;
    }

    public String getProductionBatch() {
        return ProductionBatch;
    }

    public void setProductionBatch(String productionBatch) {
        ProductionBatch = productionBatch;
    }

    public int getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public int getSaleID() {
        return SaleID;
    }

    public void setSaleID(int saleID) {
        SaleID = saleID;
    }

    public int getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(int salePrice) {
        SalePrice = salePrice;
    }

    public int getSaleQuantity() {
        return SaleQuantity;
    }

    public void setSaleQuantity(int saleQuantity) {
        SaleQuantity = saleQuantity;
    }

    public int getSaleStatus() {
        return SaleStatus;
    }

    public void setSaleStatus(int saleStatus) {
        SaleStatus = saleStatus;
    }

    public String getSaleUnit() {
        return SaleUnit;
    }

    public void setSaleUnit(String saleUnit) {
        SaleUnit = saleUnit;
    }

    public int getSaleUnitType() {
        return SaleUnitType;
    }

    public void setSaleUnitType(int saleUnitType) {
        SaleUnitType = saleUnitType;
    }

    public String getSpecification() {
        return Specification;
    }

    public void setSpecification(String specification) {
        Specification = specification;
    }

    public Date getUpdatedTime() {
        return UpdatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        UpdatedTime = updatedTime;
    }

    public boolean isEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
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
}
