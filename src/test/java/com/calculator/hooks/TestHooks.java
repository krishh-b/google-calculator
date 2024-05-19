package com.calculator.hooks;

import com.calculator.utils.DriverFactory;
import com.calculator.utils.Utility;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class TestHooks {
    private final DriverFactory DRIVER_FACTORY;
    public TestHooks(DriverFactory driverFactory) {
        this.DRIVER_FACTORY = driverFactory;
    }
    @Before
    public void setup() {
        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : Utility.getConfigProperty("defaultBrowser");
        DRIVER_FACTORY.getDriver(browserName);
    }
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DRIVER_FACTORY.getDriverInstance()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "FailedStepScreenshot");
        }
        DRIVER_FACTORY.quitDriver();
    }
}
