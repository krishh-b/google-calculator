package com.calculator.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = { "pretty", "html:results/test-result.html" },
        glue = {"com.calculator.stepdefinitions", "com.calculator.hooks"},
        features = {"src/test/resources/features/"},
        monochrome = true,
        tags="@Regression"
)

public class ParallelRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
