package com.dropwizardJDBI3;

import org.jdbi.v3.core.Jdbi;

import com.dropwizardJDBI3.core.EmployeeService;
import com.dropwizardJDBI3.health.DatabaseHealthCheck;
import com.dropwizardJDBI3.resources.EmployeeResource;

import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DJDBI3Application extends Application<DJDBI3Configuration> {

	public static void main(final String[] args) throws Exception {
		new DJDBI3Application().run(args);
	}

	@Override
	public String getName() {
		return "DJDBI3";
	}

	@Override
	public void initialize(final Bootstrap<DJDBI3Configuration> bootstrap) {
		// TODO: application initialization
	}

	@Override
	public void run(final DJDBI3Configuration configuration, final Environment environment) {
		// TODO: implement application
		JdbiFactory jf = new JdbiFactory();
		Jdbi j = jf.build(environment, configuration.getDataSourceFactory(), "sql");
		EmployeeService es=j.onDemand(EmployeeService.class);
		environment.healthChecks().register("database", new DatabaseHealthCheck(configuration.getDataSourceFactory()));
		environment.jersey().register(new EmployeeResource(es));
	}

}
