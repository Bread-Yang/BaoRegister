package com.mdground.yideguanregister.enumobject;

public enum BillingStatusEnum {

    // 部分取消
    CANCEL_PARTIAL(-2),

    // 取消
    CANCEL(-1),

    NONE(0),

    // 预付款
    PREPAY(1),

    // 已付款
    PAID(2);

    private int value;

    private BillingStatusEnum(int value) {
        this.setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static BillingStatusEnum valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case -2:
                return CANCEL_PARTIAL;
            case -1:
                return CANCEL;
            case 0:
                return NONE;
            case 1:
                return PREPAY;
            case 2:
                return PAID;
            default:
                return null;
        }
    }
}
