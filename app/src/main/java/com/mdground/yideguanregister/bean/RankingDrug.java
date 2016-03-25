package com.mdground.yideguanregister.bean;

public class RankingDrug implements Comparable<RankingDrug> {

    private String ApprovalNo;

    private int ClinicID;

    private int DrugID;

    private String DrugName;

    private String Manufacturer;

    private int TotalFee;

    private int TotalProfit;

    public String getApprovalNo() {
        return ApprovalNo;
    }

    public void setApprovalNo(String approvalNo) {
        ApprovalNo = approvalNo;
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

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
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

    @Override
    public int compareTo(RankingDrug another) {
        return (another.TotalFee - this.TotalFee);
    }

}
