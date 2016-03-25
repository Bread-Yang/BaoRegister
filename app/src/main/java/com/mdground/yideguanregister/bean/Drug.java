package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.tsz.afinal.annotation.sqlite.Id;
import net.tsz.afinal.annotation.sqlite.Table;

import java.util.Date;

@Table(name = "Drug")
public class Drug implements Parcelable {

    @Id
    private int id;

    @SerializedName("DrugID")
    @Expose
    private int DrugID;

    @SerializedName("ClinicID")
    @Expose
    private int ClinicID;

    public Date ApprovalDate;

    @SerializedName("ApprovalNo")
    @Expose
    private String ApprovalNo;

    @SerializedName("Barcode")
    @Expose
    private String Barcode;

    @SerializedName("EssentialDrug")
    @Expose
    private int EssentialDrug;

    @SerializedName("DrugName")
    @Expose
    private String DrugName;

    @SerializedName("Dosage")
    @Expose
    private float Dosage;

    @SerializedName("DosageFrom")
    @Expose
    private String DosageFrom;    // GetDrugInfoByBarcode

    @SerializedName("DosageForm")
    @Expose
    private String DosageForm;   //  GetDrugByID

    @SerializedName("DosageSingle")
    @Expose
    private float DosageSingle;

    @SerializedName("DosageUnit")
    @Expose
    private String DosageUnit;

    @SerializedName("Frequency")
    @Expose
    private String Frequency;

    @SerializedName("Specification")
    @Expose
    private String Specification;

    @SerializedName("InventoryQuantity")
    @Expose
    private int InventoryQuantity;

    @SerializedName("InventoryUnit")
    @Expose
    private String InventoryUnit;

    @SerializedName("InvoiceItem")
    @Expose
    private String InvoiceItem;

    @SerializedName("Manufacturer")
    @Expose
    private String Manufacturer;

    @SerializedName("OVPrice")
    @Expose
    private int OVPrice;

    @SerializedName("OVUnitType")
    @Expose
    private int OVUnitType;

    @SerializedName("SalePrice")
    @Expose
    private int SalePrice;

    @SerializedName("SaleUnitType")
    @Expose
    private int SaleUnitType;

    @SerializedName("PurchasePrice")
    @Expose
    private int PurchasePrice;

    @SerializedName("PurchaseUnitType")
    @Expose
    private int PurchaseUnitType;

    @SerializedName("TakeType")
    @Expose
    private String TakeType;

    @SerializedName("DrugCategory")
    @Expose
    private String DrugCategory;

    @SerializedName("TypeID")
    @Expose
    private int TypeID;

    @SerializedName("UnitConvert")
    @Expose
    private int UnitConvert;

    @SerializedName("UnitGeneric")
    @Expose
    private String UnitGeneric;

    @SerializedName("UnitSmall")
    @Expose
    private String UnitSmall;

    @SerializedName("PinyinCode")
    @Expose
    private String PinyinCode;

    @SerializedName("WubiCode")
    @Expose
    private String WubiCode;

//    @SerializedName("PhotoListString")
//    @Expose
//    private String PhotoListString;

//    private ArrayList<DrugPhoto> PhotoList;

    private String CompanyLocation;

    private String CompanyLocation2;

    private String CompanyName;

    private String CompanyName2;

    private String DrugName2;

    private String DrugReaction;

    private int ExpiryMonths;

    private boolean ImportDrug;

    private String Manufacturer2;

    private String ManufacturerAddress;

    private String ManufacturerAddress2;

    private String ManufacturerLocation;

    private String ManufacturerLocation2;

    private int UpdatedBy;

    private String StandardCode;

    private String NotSuitable;

    private String StorageCondition;

    private int ProviderID;

    private int AlertLimit;

    private int AlertLimitUnitType;

    public int PhotoID;

    public int PhotoSID;

    public int TypeIDSmall;


    public Drug() {
        ApprovalDate = new Date();
//        PhotoList = new ArrayList<>();
        CompanyLocation = "";
        CompanyLocation2 = "";
        CompanyName = "";
        CompanyName2 = "";
        DrugName2 = "";
        DrugReaction = "";
        Manufacturer = "";   // 一定要传供应商过去
        Manufacturer2 = "";
        ManufacturerAddress = "";
        ManufacturerAddress2 = "";
        ManufacturerLocation = "";
        ManufacturerLocation2 = "";
        NotSuitable = "";
        StandardCode = "";
        StorageCondition = "";
        DrugCategory = "";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDrugID() {
        return DrugID;
    }

    public void setDrugID(int drugID) {
        DrugID = drugID;
    }

    public int getClinicID() {
        return ClinicID;
    }

    public void setClinicID(int clinicID) {
        ClinicID = clinicID;
    }

    public Date getApprovalDate() {
        return ApprovalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        ApprovalDate = approvalDate;
    }

    public String getApprovalNo() {
        return ApprovalNo;
    }

    public void setApprovalNo(String approvalNo) {
        ApprovalNo = approvalNo;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }

    public int getEssentialDrug() {
        return EssentialDrug;
    }

    public void setEssentialDrug(int essentialDrug) {
        EssentialDrug = essentialDrug;
    }

    public String getDrugName() {
        return DrugName;
    }

    public void setDrugName(String drugName) {
        DrugName = drugName;
    }

    public float getDosage() {
        return Dosage;
    }

    public void setDosage(float dosage) {
        Dosage = dosage;
    }

    public String getDosageFrom() {
        return DosageFrom;
    }

    public void setDosageFrom(String dosageForm) {
        DosageFrom = dosageForm;
    }

    public String getDosageForm() {
        return DosageForm;
    }

    public void setDosageForm(String dosageForm) {
        DosageForm = dosageForm;
    }

    public float getDosageSingle() {
        return DosageSingle;
    }

    public void setDosageSingle(float dosageSingle) {
        DosageSingle = dosageSingle;
    }

    public String getDosageUnit() {
        return DosageUnit;
    }

    public void setDosageUnit(String dosageUnit) {
        DosageUnit = dosageUnit;
    }

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String frequency) {
        Frequency = frequency;
    }

    public String getSpecification() {
        return Specification;
    }

    public void setSpecification(String specification) {
        Specification = specification;
    }

    public int getInventoryQuantity() {
        return InventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        InventoryQuantity = inventoryQuantity;
    }

    public String getInventoryUnit() {
        return InventoryUnit;
    }

    public void setInventoryUnit(String inventoryUnit) {
        InventoryUnit = inventoryUnit;
    }

    public String getInvoiceItem() {
        return InvoiceItem;
    }

    public void setInvoiceItem(String invoiceItem) {
        InvoiceItem = invoiceItem;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public int getOVPrice() {
        return OVPrice;
    }

    public void setOVPrice(int oVPrice) {
        OVPrice = oVPrice;
    }

    public int getOVUnitType() {
        return OVUnitType;
    }

    public void setOVUnitType(int oVUnit) {
        OVUnitType = oVUnit;
    }

    public String getOVUnit() {
        if (OVUnitType == 1) {
            return UnitGeneric;
        } else {
            return UnitSmall;
        }
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

    public String getSaleUnit() {
        if (SaleUnitType == 1) {
            return UnitGeneric;
        } else {
            return UnitSmall;
        }
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

    public String getTakeType() {
        return TakeType;
    }

    public void setTakeType(String takeType) {
        TakeType = takeType;
    }

    public String getDrugCategory() {
        return DrugCategory;
    }

    public void setDrugCategory(String drugCategory) {
        DrugCategory = drugCategory;
    }

    public int getTypeID() {
        return TypeID;
    }

    public void setTypeID(int typeID) {
        TypeID = typeID;
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

    public String getPinyinCode() {
        return PinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        PinyinCode = pinyinCode;
    }

    public String getWubiCode() {
        return WubiCode;
    }

    public void setWubiCode(String wubiCode) {
        WubiCode = wubiCode;
    }

//    public String getPhotoListString() {
//        return PhotoListString;
//    }

//    public void setPhotoListString(String photoListString) {
//        PhotoListString = photoListString;
//    }

//    public ArrayList<DrugPhoto> getPhotoList() {
//        return PhotoList;
//    }
//
//    public void setPhotoList(ArrayList<DrugPhoto> photoList) {
//        PhotoList = photoList;
//    }

    public String getCompanyLocation() {
        return CompanyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        CompanyLocation = companyLocation;
    }

    public String getCompanyLocation2() {
        return CompanyLocation2;
    }

    public void setCompanyLocation2(String companyLocation2) {
        CompanyLocation2 = companyLocation2;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getCompanyName2() {
        return CompanyName2;
    }

    public void setCompanyName2(String companyName2) {
        CompanyName2 = companyName2;
    }

    public String getDrugName2() {
        return DrugName2;
    }

    public void setDrugName2(String drugName2) {
        DrugName2 = drugName2;
    }

    public String getDrugReaction() {
        return DrugReaction;
    }

    public void setDrugReaction(String drugReaction) {
        DrugReaction = drugReaction;
    }

    public int getExpiryMonths() {
        return ExpiryMonths;
    }

    public void setExpiryMonths(int expiryMonths) {
        ExpiryMonths = expiryMonths;
    }

    public boolean isImportDrug() {
        return ImportDrug;
    }

    public void setImportDrug(boolean importDrug) {
        ImportDrug = importDrug;
    }

    public String getManufacturer2() {
        return Manufacturer2;
    }

    public void setManufacturer2(String manufacturer2) {
        Manufacturer2 = manufacturer2;
    }

    public String getManufacturerAddress() {
        return ManufacturerAddress;
    }

    public void setManufacturerAddress(String manufacturerAddress) {
        ManufacturerAddress = manufacturerAddress;
    }

    public String getManufacturerAddress2() {
        return ManufacturerAddress2;
    }

    public void setManufacturerAddress2(String manufacturerAddress2) {
        ManufacturerAddress2 = manufacturerAddress2;
    }

    public String getManufacturerLocation() {
        return ManufacturerLocation;
    }

    public void setManufacturerLocation(String manufacturerLocation) {
        ManufacturerLocation = manufacturerLocation;
    }

    public String getManufacturerLocation2() {
        return ManufacturerLocation2;
    }

    public void setManufacturerLocation2(String manufacturerLocation2) {
        ManufacturerLocation2 = manufacturerLocation2;
    }

    public int getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        UpdatedBy = updatedBy;
    }

    public String getStandardCode() {
        return StandardCode;
    }

    public void setStandardCode(String standardCode) {
        StandardCode = standardCode;
    }

    public String getNotSuitable() {
        return NotSuitable;
    }

    public void setNotSuitable(String notSuitable) {
        NotSuitable = notSuitable;
    }

    public String getStorageCondition() {
        return StorageCondition;
    }

    public void setStorageCondition(String storageCondition) {
        StorageCondition = storageCondition;
    }

    public int getProviderID() {
        return ProviderID;
    }

    public void setProviderID(int providerID) {
        ProviderID = providerID;
    }

    public int getAlertLimit() {
        return AlertLimit;
    }

    public void setAlertLimit(int alertLimit) {
        AlertLimit = alertLimit;
    }

    public int getAlertLimitUnitType() {
        return AlertLimitUnitType;
    }

    public void setAlertLimitUnitType(int alertLimitUnitType) {
        AlertLimitUnitType = alertLimitUnitType;
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

    public int getTypeIDSmall() {
        return TypeIDSmall;
    }

    public void setTypeIDSmall(int typeIDSmall) {
        TypeIDSmall = typeIDSmall;
    }

    public Drug(Parcel source) {
        this.DrugID = source.readInt();
        this.ClinicID = source.readInt();
        long tmpApprovalDateTime = source.readLong();
        this.ApprovalDate = tmpApprovalDateTime == -1 ? null : new Date(tmpApprovalDateTime);
        this.ApprovalNo = source.readString();
        this.Barcode = source.readString();
        this.EssentialDrug = source.readInt();
        this.DrugName = source.readString();
        this.Dosage = source.readFloat();
        this.DosageFrom = source.readString();
        this.DosageForm = source.readString();
        this.DosageSingle = source.readFloat();
        this.DosageUnit = source.readString();
        this.Frequency = source.readString();
        this.InventoryQuantity = source.readInt();
        this.InventoryUnit = source.readString();
        this.InvoiceItem = source.readString();
        this.Manufacturer = source.readString();
        this.OVPrice = source.readInt();
        this.OVUnitType = source.readInt();
        this.SalePrice = source.readInt();
        this.SaleUnitType = source.readInt();
        this.PurchasePrice = source.readInt();
        this.PurchaseUnitType = source.readInt();
        this.Specification = source.readString();
        this.TakeType = source.readString();
        this.DrugCategory = source.readString();
        this.TypeID = source.readInt();
        this.UnitConvert = source.readInt();
        this.UnitGeneric = source.readString();
        this.UnitSmall = source.readString();
        this.PinyinCode = source.readString();
        this.WubiCode = source.readString();
//        this.PhotoList = source.readArrayList(DrugPhoto.class.getClassLoader());
        this.CompanyLocation = source.readString();
        this.CompanyLocation2 = source.readString();
        this.CompanyName = source.readString();
        this.CompanyName2 = source.readString();
        this.DrugName2 = source.readString();
        this.DrugReaction = source.readString();
        this.ExpiryMonths = source.readInt();
        this.ImportDrug = source.readInt() == -1 ? false : true;
        this.Manufacturer2 = source.readString();
        this.ManufacturerAddress = source.readString();
        this.ManufacturerAddress2 = source.readString();
        this.ManufacturerLocation = source.readString();
        this.ManufacturerLocation2 = source.readString();
        this.UpdatedBy = source.readInt();
        this.StandardCode = source.readString();
        this.NotSuitable = source.readString();
        this.StorageCondition = source.readString();
        this.ProviderID = source.readInt();
        this.AlertLimit = source.readInt();
        this.AlertLimitUnitType = source.readInt();
        this.PhotoID = source.readInt();
        this.PhotoSID = source.readInt();
        this.TypeIDSmall = source.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(DrugID);
        dest.writeInt(ClinicID);
        if (ApprovalDate == null) {
            dest.writeLong(-1);
        } else {
            dest.writeLong(ApprovalDate.getTime());
        }
        dest.writeString(getApprovalNo());
        dest.writeString(getBarcode());
        dest.writeInt(getEssentialDrug());
        dest.writeString(DrugName);
        dest.writeFloat(Dosage);
        dest.writeString(DosageFrom);
        dest.writeString(DosageForm);
        dest.writeFloat(DosageSingle);
        dest.writeString(DosageUnit);
        dest.writeString(Frequency);
        dest.writeInt(InventoryQuantity);
        dest.writeString(InventoryUnit);
        dest.writeString(InvoiceItem);
        dest.writeString(Manufacturer);
        dest.writeInt(OVPrice);
        dest.writeInt(OVUnitType);
        dest.writeInt(getSalePrice());
        dest.writeInt(SaleUnitType);
        dest.writeInt(PurchasePrice);
        dest.writeInt(PurchaseUnitType);
        dest.writeString(Specification);
        dest.writeString(TakeType);
        dest.writeString(DrugCategory);
        dest.writeInt(TypeID);
        dest.writeInt(UnitConvert);
        dest.writeString(UnitGeneric);
        dest.writeString(UnitSmall);
        dest.writeString(PinyinCode);
        dest.writeString(WubiCode);
//        dest.writeList(PhotoList);
        dest.writeString(CompanyLocation);
        dest.writeString(CompanyLocation2);
        dest.writeString(CompanyName);
        dest.writeString(CompanyName2);
        dest.writeString(DrugName2);
        dest.writeString(DrugReaction);
        dest.writeInt(ExpiryMonths);
        dest.writeInt(ImportDrug ? 0 : -1);
        dest.writeString(Manufacturer2);
        dest.writeString(ManufacturerAddress);
        dest.writeString(ManufacturerAddress2);
        dest.writeString(ManufacturerLocation);
        dest.writeString(ManufacturerLocation2);
        dest.writeInt(UpdatedBy);
        dest.writeString(StandardCode);
        dest.writeString(NotSuitable);
        dest.writeString(StorageCondition);
        dest.writeInt(ProviderID);
        dest.writeInt(AlertLimit);
        dest.writeInt(AlertLimitUnitType);
        dest.writeInt(PhotoID);
        dest.writeInt(PhotoSID);
        dest.writeInt(TypeIDSmall);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Drug> CREATOR = new Parcelable.Creator<Drug>() {

        @Override
        public Drug createFromParcel(Parcel source) {
            return new Drug(source);
        }

        @Override
        public Drug[] newArray(int size) {
            return new Drug[size];
        }
    };
}
