package com.dropwizardlogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DLogApplication extends Application<DLogConfiguration> {
	
	private static final Logger log=LoggerFactory.getLogger(DLogApplication.class);

    public static void main(final String[] args) throws Exception {
        new DLogApplication().run(args);
    }

    @Override
    public String getName() {
        return "DLog";
    }

    @Override
    public void initialize(final Bootstrap<DLogConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DLogConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    	System.out.println("Start.....");
    	log.debug("debugging");
    	log.info("information");
    	log.error("no error");
    	System.out.println("end.......");
    	
    }

}
