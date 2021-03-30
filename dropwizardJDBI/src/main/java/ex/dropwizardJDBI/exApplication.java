package ex.dropwizardJDBI;

import javax.sql.DataSource;

import org.skife.jdbi.v2.DBI;

import ex.dropwizardJDBI.core.EmployeeService;
import ex.dropwizardJDBI.resources.EmployeeResource;
import io.dropwizard.Application;

import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class exApplication extends Application<exConfiguration> {

	public static void main(final String[] args) throws Exception {
		new exApplication().run(args);
	}

	@Override
	public String getName() {
		return "ex";
	}

	@Override
	public void initialize(final Bootstrap<exConfiguration> bootstrap) {
		// TODO: application initialization
	}

	@Override
	public void run(final exConfiguration configuration, final Environment environment) {
		DataSource dataSource=configuration.getDataSourceFactory().build(environment.metrics(), "sql");
		DBI dbi=new DBI(dataSource);
		environment.jersey().register(new EmployeeResource(dbi.onDemand(EmployeeService.class)));
	}

}
