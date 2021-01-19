package org.rjlearn.testsuite;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java8.En;
import org.rjlearn.driver.DriverController;

public class TestHooks implements En {

    public TestHooks() {
        Before(scenario -> {
            System.out.println("----START: " + scenario.getName());
            DriverController.initialize();
        });

//        BeforeStep(1, (scenario) -> {
//            System.out.println("BEFORE STEP: " + scenario.getName());
//        });

        After(scenario -> {
            System.out.println("----END: " + scenario.getName() + "---Status: " + scenario.getStatus());
            DriverController.quitDriver();
        });
    }


}
