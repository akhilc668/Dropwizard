package com.dropwizardAuth.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dropwizardAuth.core.User;

import io.dropwizard.auth.Auth;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	@GET
	public String getName(@Auth User user) {
		System.out.println(user.getName());
		return "Hello Welcome "+user.getName();
	}
}
