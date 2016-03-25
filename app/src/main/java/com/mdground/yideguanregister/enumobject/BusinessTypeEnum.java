package com.mdground.yideguanregister.enumobject;

public enum BusinessTypeEnum {

	//收入
	Statistics_Income(1),

	//提现
	Statistics_Withdrawal(2);

	private int value;

	private BusinessTypeEnum(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
