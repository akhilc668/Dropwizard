package com.dropwizardForms.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.dropwizard.views.View;

@Path("/")
public class FormResource {
	@GET
	public View display() {
		View v=new View("index") {
			
		};
		return v;
	}

}
