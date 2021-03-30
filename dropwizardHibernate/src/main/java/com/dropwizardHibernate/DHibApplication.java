package com.dropwizardHibernate;

import com.dropwizardHibernate.core.Employee;
import com.dropwizardHibernate.db.EmployeeDao;
import com.dropwizardHibernate.resources.EmployeeResource;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DHibApplication extends Application<DHibConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DHibApplication().run(args);
    }

    @Override
    public String getName() {
        return "DHib";
    }
    
    private final HibernateBundle<DHibConfiguration> hibernate=new HibernateBundle<DHibConfiguration>(Employee.class) {
		
		@Override
		public DataSourceFactory getDataSourceFactory(DHibConfiguration configuration) {
			// TODO Auto-generated method stub
			return configuration.getDataSourceFactory();
		}
	};

    @Override
    public void initialize(final Bootstrap<DHibConfiguration> bootstrap) {
    	bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(final DHibConfiguration configuration,
                    final Environment environment) {
    	EmployeeDao empdao=new EmployeeDao(hibernate.getSessionFactory());
    	EmployeeResource er=new EmployeeResource(empdao);
    	environment.jersey().register(er);    	
    }

}
