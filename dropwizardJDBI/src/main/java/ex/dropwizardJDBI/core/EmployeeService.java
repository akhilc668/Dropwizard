package ex.dropwizardJDBI.core;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import ex.dropwizardJDBI.api.Employee;
import ex.dropwizardJDBI.db.EmployeeDao;

public abstract class EmployeeService {
	@CreateSqlObject
	abstract EmployeeDao employeeDao();

	public List<Employee> getEmployees() {
		return employeeDao().getEmployees();
	}

	public Employee getEmployee(int id) {
		Employee employee = employeeDao().getEmployee(id);
		return employee;
	}

	public void createEmployee(Employee employee) {
		employeeDao().createEmployee(employee);
	}

	public Employee editEmployee(Employee employee) {

		employeeDao().editEmployee(employee);
		return employeeDao().getEmployee(employee.getId());
	}

	public String deleteEmployee(final int id) {
		int result = employeeDao().deleteEmployee(id);
		if (result != 0) {
			return "success";
		}
		return "failed";
	}
}
