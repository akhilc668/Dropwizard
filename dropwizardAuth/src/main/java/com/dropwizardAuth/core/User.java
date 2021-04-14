package com.dropwizardAuth.core;

import java.security.Principal;

public class User implements Principal {
	
	private static String name;
	

	public User(String name) {
		super();
		User.name = name;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public void setName(String name) {
		User.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return User.name;
	}

}
