package com.calculator.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverFactory {
    private  WebDriver DRIVER;
    public void getDriver(String browserName, boolean isHeadlessBrowser) {
        if(DRIVER == null) {
            switch(browserName) {
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if(isHeadlessBrowser) {
                        firefoxOptions.addArguments("--headless=new");
                    }
                    DRIVER = new FirefoxDriver(firefoxOptions);
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if(isHeadlessBrowser) {
                        edgeOptions.addArguments("--headless=new");
                    }
                    DRIVER = new EdgeDriver(edgeOptions);
                    break;
                default:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if(isHeadlessBrowser) {
                        chromeOptions.addArguments("--headless=new");
                    }
                    DRIVER = new ChromeDriver(chromeOptions);
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
