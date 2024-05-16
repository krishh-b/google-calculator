package com.calculator.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    private  WebDriver DRIVER;
    public void getDriver(String browserName) {
        if(DRIVER == null) {
            switch(browserName) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    DRIVER = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    DRIVER = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    DRIVER = new ChromeDriver();
                    break;
            }
            String baseUrl = Utility.getConfigProperty("baseUrl");
            DRIVER.get(baseUrl);
            DRIVER.manage().window().maximize();
            DRIVER.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            DRIVER.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
        }
    }
    public WebDriver getDriverInstance() {
        return DRIVER;
    }
    public void quitDriver() {
        if(DRIVER != null) {
            DRIVER.quit();
        }
    }
}
