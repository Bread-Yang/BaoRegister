package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Inventory implements Parcelable {

    private int InventoryID;
    private int ClinicID;
    private int DrugID;
    private String ProductionBatch;
    private Date ProductionDate;
    private Date ExpiredDate;
    private String Provider;
    private int ProviderID;
    private String WarehouseNo;
    private int WarehouseUnitType;
    private int QuantityWarehouse;
    private String UnitSmall;
    private int QuantitySmall;  // 单价
    private int UnitConvert;
    private int QuantityUse;
    private int PurchasePrice;
    private int OVPrice;
    private int OVUnitType;
    private int PurchaseUnitType;
    private int SaleUnitType;
    private int SalePrice;
    private int WarehouseStatus;
    private Date WarehouseDate;
    private int WarehouseUpdater;
    private Date WarehouseUpdatedTime;

    // 只是界面用到的字段
    private boolean isChecked;
    private boolean isEdit;

    public Inventory() {

    }

    public int getInventoryID() {
        return InventoryID;
    }

    public void setInventoryID(int inventoryID) {
        InventoryID = inventoryID;
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

    public Date getExpiredDate() {
        return ExpiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        ExpiredDate = expiredDate;
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

    public String getWarehouseNo() {
        return WarehouseNo;
    }

    public void setWarehouseNo(String warehouseNo) {
        WarehouseNo = warehouseNo;
    }

    public int getWarehouseUnitType() {
        return WarehouseUnitType;
    }

    public void setWarehouseUnitType(int warehouseUnitType) {
        WarehouseUnitType = warehouseUnitType;
    }

    public int getQuantityWarehouse() {
        return QuantityWarehouse;
    }

    public void setQuantityWarehouse(int quantityWarehouse) {
        QuantityWarehouse = quantityWarehouse;
    }

    public String getUnitSmall() {
        return UnitSmall;
    }

    public void setUnitSmall(String unitSmall) {
        UnitSmall = unitSmall;
    }

    public int getQuantitySmall() {
        return QuantitySmall;
    }

    public void setQuantitySmall(int quantitySmall) {
        QuantitySmall = quantitySmall;
    }

    public int getUnitConvert() {
        return UnitConvert;
    }

    public void setUnitConvert(int unitConvert) {
        UnitConvert = unitConvert;
    }

    public int getQuantityUse() {
        return QuantityUse;
    }

    public void setQuantityUse(int quantityUse) {
        QuantityUse = quantityUse;
    }

    public int getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        PurchasePrice = purchasePrice;
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

    public int getPurchaseUnitType() {
        return PurchaseUnitType;
    }

    public void setPurchaseUnitType(int purchaseUnitType) {
        PurchaseUnitType = purchaseUnitType;
    }

    public int getSaleUnitType() {
        return SaleUnitType;
    }

    public void setSaleUnitType(int saleUnitType) {
        SaleUnitType = saleUnitType;
    }

    public int getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(int salePrice) {
        SalePrice = salePrice;
    }

    public int getWarehouseStatus() {
        return WarehouseStatus;
    }

    public void setWarehouseStatus(int warehouseStatus) {
        WarehouseStatus = warehouseStatus;
    }

    public Date getWarehouseDate() {
        return WarehouseDate;
    }

    public void setWarehouseDate(Date warehouseDate) {
        WarehouseDate = warehouseDate;
    }

    public int getWarehouseUpdater() {
        return WarehouseUpdater;
    }

    public void setWarehouseUpdater(int warehouseUpdater) {
        WarehouseUpdater = warehouseUpdater;
    }

    public Date getWarehouseUpdatedTime() {
        return WarehouseUpdatedTime;
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

    public void setWarehouseUpdatedTime(Date warehouseUpdatedTime) {
        WarehouseUpdatedTime = warehouseUpdatedTime;
    }

    public Inventory(Parcel source) {
        InventoryID = source.readInt();
        ClinicID = source.readInt();
        DrugID = source.readInt();
        ProductionBatch = source.readString();
        long tmpProductionTime = source.readLong();
        ProductionDate = tmpProductionTime == -1 ? null : new Date(tmpProductionTime);
        long tmpExpireDateTime = source.readLong();
        ExpiredDate = tmpExpireDateTime == -1 ? null : new Date(tmpExpireDateTime);
        Provider = source.readString();
        ProviderID = source.readInt();
        WarehouseNo = source.readString();
        WarehouseUnitType = source.readInt();
        QuantityWarehouse = source.readInt();
        UnitSmall = source.readString();
        QuantitySmall = source.readInt();
        UnitConvert = source.readInt();
        QuantityUse = source.readInt();
        PurchasePrice = source.readInt();
        OVPrice = source.readInt();
        OVUnitType = source.readInt();
        PurchaseUnitType = source.readInt();
        SaleUnitType = source.readInt();
        SalePrice = source.readInt();
        WarehouseStatus = source.readInt();
        long tmpWareHouseDate = source.readLong();
        WarehouseDate = tmpWareHouseDate == -1 ? null : new Date(tmpWareHouseDate);
        WarehouseUpdater = source.readInt();
        long tmpWarehouseUpdatedTime = source.readLong();
        WarehouseUpdatedTime = tmpWarehouseUpdatedTime == -1 ? null : new Date(tmpWarehouseUpdatedTime);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getInventoryID());
        dest.writeInt(getClinicID());
        dest.writeInt(getDrugID());
        dest.writeString(getProductionBatch());
        if (getProductionDate() == null) {
            dest.writeLong(-1);
        } else {
            dest.writeLong(getProductionDate().getTime());
        }
        if (getExpiredDate() == null) {
            dest.writeLong(-1);
        } else {
            dest.writeLong(getExpiredDate().getTime());
        }
        dest.writeString(getProvider());
        dest.writeInt(ProviderID);
        dest.writeString(getWarehouseNo());
        dest.writeInt(getWarehouseUnitType());
        dest.writeInt(getQuantityWarehouse());
        dest.writeString(getUnitSmall());
        dest.writeInt(getQuantitySmall());
        dest.writeInt(getUnitConvert());
        dest.writeInt(getQuantityUse());
        dest.writeInt(getPurchasePrice());
        dest.writeInt(getOVPrice());
        dest.writeInt(getOVUnitType());
        dest.writeInt(getPurchaseUnitType());
        dest.writeInt(getSaleUnitType());
        dest.writeInt(getSalePrice());
        dest.writeInt(getWarehouseStatus());
        if (getWarehouseDate() == null) {
            dest.writeLong(-1);
        } else {
            dest.writeLong(getWarehouseDate().getTime());
        }
        dest.writeInt(getWarehouseUpdater());
        if (getWarehouseUpdatedTime() == null) {
            dest.writeLong(-1);
        } else {
            dest.writeLong(getWarehouseUpdatedTime().getTime());
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Inventory> CREATOR = new Parcelable.Creator<Inventory>() {

        @Override
        public Inventory createFromParcel(Parcel source) {
            return new Inventory(source);
        }

        @Override
        public Inventory[] newArray(int size) {
            return new Inventory[size];
        }
    };
}
