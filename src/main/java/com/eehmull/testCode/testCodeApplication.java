package com.eehmull.testCode;

import com.eehmull.testCode.resources.ChuckNorrisResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class testCodeApplication extends Application<testCodeConfiguration> {

    public static void main(final String[] args) throws Exception {
        new testCodeApplication().run(args);
    }

    @Override
    public String getName() {
        return "testCode";
    }

    @Override
    public void initialize(final Bootstrap<testCodeConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final testCodeConfiguration configuration,
            final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new ChuckNorrisResource());
    }

}
