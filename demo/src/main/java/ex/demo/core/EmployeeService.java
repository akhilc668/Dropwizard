package ex.demo.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ex.demo.api.Employee;

public class EmployeeService {
	private List<Employee> eli = new ArrayList<Employee>(Arrays.asList(new Employee(101, "Vishal", 50000),
			new Employee(102, "Prashanth", 10000)));
	
	public List<Employee> getEmployees(){
		return eli;
	}
	
	public Employee getEmployee(int id) {
		Employee e =null;
		for(Employee e1:eli) {
			if(e1.getId() == id) {
				e=e1;
			}
		}
		return e;
	}
	
	public void addEmployee(Employee e) {
		eli.add(e);
	}
	
	public void updateEmployee(Employee e,int id) {
		int i=0;
		for(Employee e1:eli) {
			if(e1.getId() == id) {
				eli.set(i, e);
				break;
			}
			i++;
		}
	}
	
	public void deleteEmployee(int id) {
		for(Employee e1:eli) {
			if(e1.getId() == id) {
				eli.remove(e1);
				break;
			}
		}
	}
}
