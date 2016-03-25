package com.mdground.yideguanregister.bean;

import java.util.Date;

public class Finance implements Comparable<Finance> {

    private int BillingAttached;

    private int BillingID;

    private int BillingType;

    private int Cashier;

    private int ClinicID;

    private String FeeType;

    private int PayID;

    private int PayStatus;

    private int TotalFee;

    private String TradeNo;

    private String TradePlatform;

    private Date TradeTime;

    private String TradeType;

    private String BillingTypeName;

    private String CashierName;

    public int getBillingAttached() {
        return BillingAttached;
    }

    public void setBillingAttached(int billingAttached) {
        BillingAttached = billingAttached;
    }

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

    public int getCashier() {
        return Cashier;
    }

    public void setCashier(int cashier) {
        Cashier = cashier;
    }

    public int getClinicID() {
        return ClinicID;
    }

    public void setClinicID(int clinicID) {
        ClinicID = clinicID;
    }

    public String getFeeType() {
        return FeeType;
    }

    public void setFeeType(String feeType) {
        FeeType = feeType;
    }

    public int getPayID() {
        return PayID;
    }

    public void setPayID(int payID) {
        PayID = payID;
    }

    public int getPayStatus() {
        return PayStatus;
    }

    public void setPayStatus(int payStatus) {
        PayStatus = payStatus;
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

    public String getTradePlatform() {
        return TradePlatform;
    }

    public void setTradePlatform(String tradePlatform) {
        TradePlatform = tradePlatform;
    }

    public Date getTradeTime() {
        return TradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        TradeTime = tradeTime;
    }

    public String getTradeType() {
        return TradeType;
    }

    public void setTradeType(String tradeType) {
        TradeType = tradeType;
    }

    public String getBillingTypeName() {
        return BillingTypeName;
    }

    public void setBillingTypeName(String billingTypeName) {
        BillingTypeName = billingTypeName;
    }

    public String getCashierName() {
        return CashierName;
    }

    public void setCashierName(String cashierName) {
        CashierName = cashierName;
    }

    @Override
    public int compareTo(Finance another) {
        return (another.TotalFee - this.TotalFee);
    }
}
