package com.dropwizardForms;

import com.dropwizardForms.resources.FormResource;
import com.dropwizardForms.resources.HelloworldResource;

import io.dropwizard.Application;
//import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
//import io.federecio.dropwizard.swagger.SwaggerBundle;
//import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class DFormApplication extends Application<DFormConfiguration> {

	public static void main(final String[] args) throws Exception {
		new DFormApplication().run(args);
	}

	@Override
	public String getName() {
		return "DForm";
	}

	@Override
	public void initialize(final Bootstrap<DFormConfiguration> bootstrap) {
		// TODO: application initialization
		/*
		 * bootstrap.addBundle(new SwaggerBundle<DFormConfiguration>() {
		 * 
		 * @Override protected SwaggerBundleConfiguration
		 * getSwaggerBundleConfiguration(DFormConfiguration configuration) { // TODO
		 * Auto-generated method stub return configuration.getSwagger(); } });
		 * bootstrap.addBundle(new AssetsBundle("/assets/", "/", "index.html",
		 * "assets"));
		 */
	}

	@Override
	public void run(final DFormConfiguration configuration, final Environment environment) {
		// TODO: implement application

		/* environment.jersey().register(new FormResource()); */
		environment.jersey().register(new HelloworldResource());
	}

}
