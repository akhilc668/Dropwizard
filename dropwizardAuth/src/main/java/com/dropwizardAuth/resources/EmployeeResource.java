package com.dropwizardAuth.resources;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dropwizardAuth.api.Employee;
import com.dropwizardAuth.core.EmployeeService;
import com.dropwizardAuth.core.User;

import io.dropwizard.auth.Auth;

@Path("/")
@Produces("application/json")
public class EmployeeResource {
	private EmployeeService es =new EmployeeService();
	
	/*
	 * @GET public String welcome(@Auth User user) { return "welcome employee"; }
	 */

	@GET
	@Path("/employee")
	public List<Employee> getEmployees(@Auth User user) {
		return es.getEmployees();
	}
	
	@GET
	@Path("/employee/{id}")
	public Employee getEmployee(@PathParam("id") int id,@Auth User user) {
		Employee e=es.getEmployee(id);
		return e;
	}
	
	@POST
	@Path("/add")
	public void setEmployee(Employee e) {
		es.addEmployee(e);
	}
	
	@PUT
	@Path("/update/{id}")
	public void updateEmployee(Employee e,@PathParam("id") int id) {
		 es.updateEmployee(e,id);
		
	}
	
	@DELETE
	@Path("/delete/{id}")
	public void deleteEmployee(@PathParam("id") int id,@Auth User user) {
		es.deleteEmployee(id);
	}
}
