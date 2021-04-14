package com.dropwizardAuth;

import com.dropwizardAuth.core.GreetAuthenticator;
import com.dropwizardAuth.core.User;
import com.dropwizardAuth.resources.EmployeeResource;
import com.dropwizardAuth.resources.UserResource;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DAuthApplication extends Application<DAuthConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DAuthApplication().run(args);
    }

    @Override
    public String getName() {
        return "DAuth";
    }

    @Override
    public void initialize(final Bootstrap<DAuthConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DAuthConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    	environment.jersey().register(new UserResource());
    	environment.jersey().register(new EmployeeResource());
    	environment.jersey().register
    			(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<User>()
                        .setAuthenticator(new GreetAuthenticator())
                        .setRealm("BASIC-AUTH-REALM")
                        .buildAuthFilter())
    			);
    }

}
