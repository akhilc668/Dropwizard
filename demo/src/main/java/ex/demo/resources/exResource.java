package ex.demo.resources;


import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import ex.demo.api.Employee;
import ex.demo.core.EmployeeService;

@Path("/")
@Produces("application/json")
public class exResource {
	private EmployeeService es =new EmployeeService();
	
	@GET
	public String welcome() {
		return "welcome employee";
	}

	@GET
	@Path("/employee")
	public List<Employee> getEmployees() {
		return es.getEmployees();
	}
	
	@GET
	@Path("/employee/{id}")
	public Employee getEmployee(@PathParam("id") int id) {
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
	public void deleteEmployee(@PathParam("id") int id) {
		es.deleteEmployee(id);
	}
}
