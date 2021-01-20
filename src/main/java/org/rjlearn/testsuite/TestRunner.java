package org.rjlearn.testsuite;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/"},
        glue = {"org/rjlearn/stepdefinitions", "org/rjlearn/testsuite"},
        plugin = {"pretty", "json:cucumber-output.json"}
)
public class TestRunner {
}
