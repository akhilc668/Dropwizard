package com.dropwizardHibernate.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dropwizardHibernate.core.Employee;
import com.dropwizardHibernate.db.EmployeeDao;

import io.dropwizard.hibernate.UnitOfWork;



@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
	private EmployeeDao employeeDao;

	public EmployeeResource(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@GET
	@UnitOfWork
	public List<Employee> getEmployees() {
		return employeeDao.getAllEmployees();
	}

	@GET
	@Path("{id}")
	@UnitOfWork
	public Employee geEmployee(@PathParam("id") int id) {
		return employeeDao.getEmployee(id);
	}

	@POST
	@UnitOfWork
	public void createEmployee(Employee e) {
		employeeDao.addEmployee(e);
	}

	@PUT
	@Path("{id}")
	@UnitOfWork
	public void editEmployee(Employee employee, @PathParam("id") int id) {
		 employeeDao.updateEmployee(employee);
	}

	@DELETE
	@Path("{id}")
	@UnitOfWork
	public void deleteEmployee(@PathParam("id") final int id) {
		employeeDao.deleteEmployee(employeeDao.getEmployee(id));
	}

}
