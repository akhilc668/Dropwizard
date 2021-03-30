package ex.demo;

import ex.demo.resources.exResource;
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
    public void run(final exConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new exResource());
    }

}
