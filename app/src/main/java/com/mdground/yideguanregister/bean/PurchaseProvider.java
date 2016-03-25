package com.mdground.yideguanregister.bean;

public class PurchaseProvider {

    private int ClinicID;

    private int Count;

    private int DrugFee;

    private int FeeAvg;

    private int OVFee;

    private int TotalFee;

    private int TotalProfit;

    private int ProviderID;

    private String ProviderName;

    public int getFeeAvg() {
        return FeeAvg;
    }

    public void setFeeAvg(int feeAvg) {
        FeeAvg = feeAvg;
    }

    public int getClinicID() {
        return ClinicID;
    }

    public void setClinicID(int clinicID) {
        ClinicID = clinicID;
    }

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

    public int getProviderID() {
        return ProviderID;
    }

    public void setProviderID(int providerID) {
        ProviderID = providerID;
    }

    public String getProviderName() {
        return ProviderName;
    }

    public void setProviderName(String providerName) {
        ProviderName = providerName;
    }
}
