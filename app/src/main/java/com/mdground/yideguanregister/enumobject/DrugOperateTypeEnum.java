package com.mdground.yideguanregister.enumobject;

public enum DrugOperateTypeEnum {

	// 入库
	Warehouse(1),

	// 盘点
	Check(2),

	// 报损
	Loss(3),

	// 调价
	Discount(4),

	// 采购
	Purchase(5),

    // 库存退货
    InventoryReturn(6);

	private int value;

	private DrugOperateTypeEnum(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
