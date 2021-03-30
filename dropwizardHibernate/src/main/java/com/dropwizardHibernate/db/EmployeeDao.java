package com.dropwizardHibernate.db;

import java.util.List;

import org.hibernate.SessionFactory;

import com.dropwizardHibernate.core.Employee;

import io.dropwizard.hibernate.AbstractDAO;

public class EmployeeDao extends AbstractDAO<Employee>{

	public EmployeeDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		return (List<Employee>) currentSession().createQuery("from Employee e").list();
	}

	public Employee getEmployee(int id) {
		return currentSession().get(Employee.class, id);
	}

	public void addEmployee(Employee employee) {
		currentSession().save(employee);
	}

	public void updateEmployee(Employee employee) {
		currentSession().update(employee);
	}

	public void deleteEmployee(Employee employee) {
		currentSession().delete(employee);
	}

}
