package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by yoghourt on 12/17/15.
 */
public class OperateInventory implements Parcelable {

    private boolean Availability;

    private int ClinicID;

    private int DrugID;

    private Date ExpiredDate;

    private int InventoryID;

    private int OVPrice;

    private int OVUnitType;

    private String ProductionBatch;

    private Date ProductionDate;

    private String Provider;

    private int ProviderID;

    private int PurchasePrice;

    private int PurchaseUnitType;

    private int QuantityReturn;

    private int QuantitySmall;

    private int QuantityUse;

    private int QuantityWarehouse;

    private Date ReturnAuditedTime;

    private int ReturnAuditor;

    private String ReturnNo;

    private Date ReturnUpdatedTime;

    private int ReturnUpdater;

    private int SalePrice;

    private int SaleUnitType;

    private int UnitConvert;

    private Date UpdatedTime;

    private Date WarehouseAuditedTime;

    private int WarehouseAuditor;

    private Date WarehouseDate;

    private String WarehouseNo;

    private int WarehouseStatus;

    private int WarehouseUnitType;

    private int WarehouseUpdater;

    private transient int InventoryQuantity;

    // 只是界面用到的字段
    private transient boolean isChecked;
    private transient boolean isEdit;

    protected OperateInventory(Parcel in) {
        Availability = in.readByte() != 0;
        ClinicID = in.readInt();
        DrugID = in.readInt();
        long temp = in.readLong();
        if (temp != -1) {
            ExpiredDate = new Date(temp);
        }
        InventoryID = in.readInt();
        OVPrice = in.readInt();
        OVUnitType = in.readInt();
        ProductionBatch = in.readString();
        Provider = in.readString();
        ProviderID = in.readInt();
        PurchasePrice = in.readInt();
        PurchaseUnitType = in.readInt();
        QuantityReturn = in.readInt();
        QuantitySmall = in.readInt();
        QuantityUse = in.readInt();
        QuantityWarehouse = in.readInt();
        ReturnAuditor = in.readInt();
        ReturnNo = in.readString();
        ReturnUpdater = in.readInt();
        SalePrice = in.readInt();
        SaleUnitType = in.readInt();
        UnitConvert = in.readInt();
        WarehouseAuditor = in.readInt();
        WarehouseNo = in.readString();
        WarehouseStatus = in.readInt();
        WarehouseUnitType = in.readInt();
        WarehouseUpdater = in.readInt();
        InventoryQuantity = in.readInt();
        isChecked = in.readByte() != 0;
        isEdit = in.readByte() != 0;
    }

    public static final Creator<OperateInventory> CREATOR = new Creator<OperateInventory>() {
        @Override
        public OperateInventory createFromParcel(Parcel in) {
            return new OperateInventory(in);
        }

        @Override
        public OperateInventory[] newArray(int size) {
            return new OperateInventory[size];
        }
    };

    public Date getWarehouseDate() {
        return WarehouseDate;
    }

    public void setWarehouseDate(Date warehouseDate) {
        WarehouseDate = warehouseDate;
    }

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

    public int getDrugID() {
        return DrugID;
    }

    public void setDrugID(int drugID) {
        DrugID = drugID;
    }

    public Date getExpiredDate() {
        return ExpiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        ExpiredDate = expiredDate;
    }

    public int getInventoryID() {
        return InventoryID;
    }

    public void setInventoryID(int inventoryID) {
        InventoryID = inventoryID;
    }

    public int getOVPrice() {
        return OVPrice;
    }

    public void setOVPrice(int OVPrice) {
        this.OVPrice = OVPrice;
    }

    public int getOVUnitType() {
        return OVUnitType;
    }

    public void setOVUnitType(int OVUnitType) {
        this.OVUnitType = OVUnitType;
    }

    public String getProductionBatch() {
        return ProductionBatch;
    }

    public void setProductionBatch(String productionBatch) {
        ProductionBatch = productionBatch;
    }

    public Date getProductionDate() {
        return ProductionDate;
    }

    public void setProductionDate(Date productionDate) {
        ProductionDate = productionDate;
    }

    public String getProvider() {
        return Provider;
    }

    public void setProvider(String provider) {
        Provider = provider;
    }

    public int getProviderID() {
        return ProviderID;
    }

    public void setProviderID(int providerID) {
        ProviderID = providerID;
    }

    public int getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public int getPurchaseUnitType() {
        return PurchaseUnitType;
    }

    public void setPurchaseUnitType(int purchaseUnitType) {
        PurchaseUnitType = purchaseUnitType;
    }

    public int getQuantityReturn() {
        return QuantityReturn;
    }

    public void setQuantityReturn(int quantityReturn) {
        QuantityReturn = quantityReturn;
    }

    public int getQuantitySmall() {
        return QuantitySmall;
    }

    public void setQuantitySmall(int quantitySmall) {
        QuantitySmall = quantitySmall;
    }

    public int getQuantityUse() {
        return QuantityUse;
    }

    public void setQuantityUse(int quantityUse) {
        QuantityUse = quantityUse;
    }

    public int getQuantityWarehouse() {
        return QuantityWarehouse;
    }

    public void setQuantityWarehouse(int quantityWarehouse) {
        QuantityWarehouse = quantityWarehouse;
    }

    public Date getReturnAuditedTime() {
        return ReturnAuditedTime;
    }

    public void setReturnAuditedTime(Date returnAuditedTime) {
        ReturnAuditedTime = returnAuditedTime;
    }

    public int getReturnAuditor() {
        return ReturnAuditor;
    }

    public void setReturnAuditor(int returnAuditor) {
        ReturnAuditor = returnAuditor;
    }

    public String getReturnNo() {
        return ReturnNo;
    }

    public void setReturnNo(String returnNo) {
        ReturnNo = returnNo;
    }

    public Date getReturnUpdatedTime() {
        return ReturnUpdatedTime;
    }

    public void setReturnUpdatedTime(Date returnUpdatedTime) {
        ReturnUpdatedTime = returnUpdatedTime;
    }

    public int getReturnUpdater() {
        return ReturnUpdater;
    }

    public void setReturnUpdater(int returnUpdater) {
        ReturnUpdater = returnUpdater;
    }

    public int getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(int salePrice) {
        SalePrice = salePrice;
    }

    public int getSaleUnitType() {
        return SaleUnitType;
    }

    public void setSaleUnitType(int saleUnitType) {
        SaleUnitType = saleUnitType;
    }

    public int getUnitConvert() {
        return UnitConvert;
    }

    public void setUnitConvert(int unitConvert) {
        UnitConvert = unitConvert;
    }

    public Date getUpdatedTime() {
        return UpdatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        UpdatedTime = updatedTime;
    }

    public Date getWarehouseAuditedTime() {
        return WarehouseAuditedTime;
    }

    public void setWarehouseAuditedTime(Date warehouseAuditedTime) {
        WarehouseAuditedTime = warehouseAuditedTime;
    }

    public int getWarehouseAuditor() {
        return WarehouseAuditor;
    }

    public void setWarehouseAuditor(int warehouseAuditor) {
        WarehouseAuditor = warehouseAuditor;
    }

    public String getWarehouseNo() {
        return WarehouseNo;
    }

    public void setWarehouseNo(String warehouseNo) {
        WarehouseNo = warehouseNo;
    }

    public int getWarehouseStatus() {
        return WarehouseStatus;
    }

    public void setWarehouseStatus(int warehouseStatus) {
        WarehouseStatus = warehouseStatus;
    }

    public int getWarehouseUnitType() {
        return WarehouseUnitType;
    }

    public void setWarehouseUnitType(int warehouseUnitType) {
        WarehouseUnitType = warehouseUnitType;
    }

    public int getWarehouseUpdater() {
        return WarehouseUpdater;
    }

    public void setWarehouseUpdater(int warehouseUpdater) {
        WarehouseUpdater = warehouseUpdater;
    }

    public int getInventoryQuantity() {
        return InventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        InventoryQuantity = inventoryQuantity;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public boolean isEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (Availability ? 1 : 0));
        dest.writeInt(ClinicID);
        dest.writeInt(DrugID);
        if (ExpiredDate == null)  {
            dest.writeLong(-1);
        } else {
            dest.writeLong(ExpiredDate.getTime());
        }
        dest.writeInt(InventoryID);
        dest.writeInt(OVPrice);
        dest.writeInt(OVUnitType);
        dest.writeString(ProductionBatch);
        dest.writeString(Provider);
        dest.writeInt(ProviderID);
        dest.writeInt(PurchasePrice);
        dest.writeInt(PurchaseUnitType);
        dest.writeInt(QuantityReturn);
        dest.writeInt(QuantitySmall);
        dest.writeInt(QuantityUse);
        dest.writeInt(QuantityWarehouse);
        dest.writeInt(ReturnAuditor);
        dest.writeString(ReturnNo);
        dest.writeInt(ReturnUpdater);
        dest.writeInt(SalePrice);
        dest.writeInt(SaleUnitType);
        dest.writeInt(UnitConvert);
        dest.writeInt(WarehouseAuditor);
        dest.writeString(WarehouseNo);
        dest.writeInt(WarehouseStatus);
        dest.writeInt(WarehouseUnitType);
        dest.writeInt(WarehouseUpdater);
        dest.writeInt(InventoryQuantity);
        dest.writeByte((byte) (isChecked ? 1 : 0));
        dest.writeByte((byte) (isEdit ? 1 : 0));
    }
}
