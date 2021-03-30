package com.dropwizardJDBI3.core;

import java.util.List;

import org.jdbi.v3.sqlobject.CreateSqlObject;

import com.dropwizardJDBI3.api.Employee;
import com.dropwizardJDBI3.db.EmployeeDao;

public interface EmployeeService {
	
	@CreateSqlObject
	EmployeeDao employeeDao();

	public default List<Employee> getEmployees() {
		return employeeDao().getEmployees();
	}

	public default Employee getEmployee(int id) {
		Employee employee = employeeDao().getEmployee(id);
		return employee;
	}

	public default void createEmployee(Employee employee) {
		employeeDao().createEmployee(employee);
	}

	public default Employee editEmployee(Employee employee) {

		employeeDao().editEmployee(employee);
		return employeeDao().getEmployee(employee.getId());
	}

	public default String deleteEmployee(final int id) {
		int result = employeeDao().deleteEmployee(id);
		if (result != 0) {
			return "success";
		}
		return "failed";
	}
}
