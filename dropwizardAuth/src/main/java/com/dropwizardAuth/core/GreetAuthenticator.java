package com.dropwizardAuth.core;

import java.util.Optional;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class GreetAuthenticator implements Authenticator<BasicCredentials, User>{

	@Override
	public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
		// TODO Auto-generated method stub
		if("admin".equals(credentials.getPassword()) && "admin".equals(credentials.getUsername())) {
			
			return Optional.of(new User(credentials.getUsername()));
		}
		return Optional.empty();
	}

}
