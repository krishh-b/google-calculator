package com.calculator.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumWrapper {
    private final WebDriver DRIVER;
    private final WebDriverWait WAIT;
    public SeleniumWrapper(WebDriver driver) {
        this.DRIVER = driver;
        this.WAIT = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(Utility.getConfigProperty("defaultWait"))));
    }
    public WebElement findElement(By locator) {
        WebElement element = WAIT.until(ExpectedConditions.visibilityOfElementLocated(locator));
        highlightElement(element);
        return element;
    }
    public WebElement waitUntilClickable(WebElement element) {
        return WAIT.until(ExpectedConditions.elementToBeClickable(element));
    }
    public WebElement click(By locator) {
        WebElement element = findElement(locator);
        waitUntilClickable(element).click();
        return element;
    }
    public WebElement sendKeys(By locator, String text) {
        WebElement element = findElement(locator);
        element.sendKeys(text);
        return element;
    }
    public WebElement sendKeys(By locator, Keys key) {
        WebElement element = findElement(locator);
        element.sendKeys(key);
        return element;
    }
    public boolean isElementDisplayed(By locator) {
        try {
           return findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void highlightElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor)DRIVER;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
                    "color: Red; border: 3px solid Red;");
            hardWait(500L);
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "");
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void hardWait(long milliSeconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getText(By locator) {
        WebElement element = findElement(locator);
        return element.getText();
    }
}
