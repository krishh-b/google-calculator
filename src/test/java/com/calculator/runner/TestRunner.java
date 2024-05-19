package com.calculator.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = { "pretty", "html:results/test-result.html" },
        glue = {"com.calculator.stepdefinitions", "com.calculator.hooks"},
        features = {"src/test/resources/features/"},
        monochrome = true,
        tags="@Regression"
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
