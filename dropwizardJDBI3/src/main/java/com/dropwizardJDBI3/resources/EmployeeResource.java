package com.dropwizardJDBI3.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dropwizardJDBI3.api.Employee;
import com.dropwizardJDBI3.core.EmployeeService;

@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
	private final EmployeeService employeeService;

	/*
	 * public EmployeeResource() { super(); this.employeeService = new
	 * EmployeeService(); }
	 */

	public EmployeeResource(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GET
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@GET
	@Path("{id}")
	public Employee geEmployee(@PathParam("id") int id) {
		return employeeService.getEmployee(id);
	}

	@POST
	public void createEmployee(Employee e) {
		employeeService.createEmployee(e);
	}

	@PUT
	@Path("{id}")
	public Employee editEmployee(Employee employee, @PathParam("id") int id) {
		return employeeService.editEmployee(employee);
	}

	@DELETE
	@Path("{id}")
	public String deleteEmployee(@PathParam("id") final int id) {
		return employeeService.deleteEmployee(id);
	}

}
