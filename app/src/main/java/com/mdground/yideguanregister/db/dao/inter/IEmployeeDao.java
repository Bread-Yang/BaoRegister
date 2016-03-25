package com.mdground.yideguanregister.db.dao.inter;

import java.util.List;

import com.mdground.yideguanregister.bean.Employee;

public interface IEmployeeDao {

	public void saveEmployeess(List<Employee> employees);

	public void deleteAll();
}
