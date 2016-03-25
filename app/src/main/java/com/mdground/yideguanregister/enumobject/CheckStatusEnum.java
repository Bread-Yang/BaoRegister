package com.mdground.yideguanregister.enumobject;

public enum CheckStatusEnum {

	// 被驳回
	Reject(-1),

	NULL(0),

	// 准备开始
	Prepare(1),

	// 已执行（盘点/报损/调价）
	Done(2),

	// 已提交
	Submitted(4),

	// 已完成（审核）
	Finished(8);

	private int value;

	private CheckStatusEnum(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
