package com.mdground.yideguanregister.db.dao.inter;

import java.util.List;

import com.mdground.yideguanregister.bean.Symptom;

public interface ISymptom {
	// 根据日期和员工获取对应的排班表数据
	public void saveSymptoms(List<Symptom> symptoms);

	public List<Symptom> getSymptoms();

	public void deleteAll();
}
