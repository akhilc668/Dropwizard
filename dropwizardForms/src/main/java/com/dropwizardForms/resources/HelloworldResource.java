package com.dropwizardForms.resources;

import com.codahale.metrics.annotation.Timed;
import com.dropwizardForms.TemplateConfigurationContext;

import freemarker.template.Template;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Path("/")
public class HelloworldResource {
	

	@GET
	@Timed
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/getName")
	public String getName() {
		return "Akhil";
	}

	@POST
	@Timed
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/postName")
	public String postName(String name) {
		System.out.println("Name given by : " + name);
		return "Ok";
	}

	@GET
	@Timed
	@Produces({ MediaType.TEXT_HTML })
	@Path("/helloWorld")
	public Response getHelloWorld() {
		try {
			Template temp = TemplateConfigurationContext.getConfiguration().getTemplate("home.html");
			Map root = new HashMap();
			root.put("user", "Akhil");
			Writer writer = new StringWriter();
			temp.process(root, writer);
			return Response.status(Response.Status.ACCEPTED).entity((writer.toString())).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(("Oops! Try again later")).build();
	}
}