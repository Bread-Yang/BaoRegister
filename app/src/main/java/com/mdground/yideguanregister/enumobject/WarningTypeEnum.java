package com.mdground.yideguanregister.enumobject;

public enum WarningTypeEnum {

    // 库存预警
    Quantity(1),

    // 期限预警
    ExpiredDate(2);

    private int value;

    private WarningTypeEnum(int value) {
        this.setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
