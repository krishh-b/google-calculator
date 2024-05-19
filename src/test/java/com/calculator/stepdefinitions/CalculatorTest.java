package com.calculator.stepdefinitions;

import com.calculator.pageobjects.CalculatorPage;
import com.calculator.pageobjects.GooglePage;
import com.calculator.utils.CalculatorUtils;
import com.calculator.utils.DriverFactory;
import com.calculator.utils.SeleniumWrapper;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class CalculatorTest {
    private final SeleniumWrapper SELENIUM_UTIL;
    public CalculatorTest(DriverFactory driverFactory) {
        this.SELENIUM_UTIL = new SeleniumWrapper(driverFactory.getDriverInstance());
    }
    @Given("I have opened the Google Calculator")
    public void openGoogleCalculator() {
        SELENIUM_UTIL.sendKeys(By.xpath(GooglePage.getGoogleSearch()), "Calculator");
        SELENIUM_UTIL.sendKeys(By.xpath(GooglePage.getGoogleSearch()), Keys.RETURN);
        Assert.assertTrue(SELENIUM_UTIL.isElementDisplayed(By.xpath(CalculatorPage.getCalculator())), "Calculator is not displayed after google search.");
    }
    @When("I press {string}")
    public void pressCalculatorButton(String button) {
       enterDigits(button);
    }
    @When("I press operator {string}")
    public void pressOperatorButton(String button) {
        SELENIUM_UTIL.click(By.xpath(CalculatorPage.getOperatorButton(CalculatorUtils.getOperatorName(button))));
    }
    @When("^I (?:press|click) (?:the ) ?(AC|CE) button$")
    public void pressACorCEButton(String button) {
        SELENIUM_UTIL.click(By.xpath(CalculatorPage.getCalculatorButton(button)));
    }
    @When("I press {string} {string} {string} {string}")
    public void pressCalculatorButton(String operand1, String operator, String operand2, String equalSign) {
        enterDigits(operand1);
        pressOperatorButton(operator);
        enterDigits(operand2);
        SELENIUM_UTIL.click(By.xpath(CalculatorPage.getCalculatorButton(equalSign)));
    }
    @Then("the result should be {string} and the expression should be {string}")
    public void validateResult(String expectedResult, String expectedExpression) {
        String actualResult = SELENIUM_UTIL.getText(By.xpath(CalculatorPage.getCalculationResult()));
        String actualExpression = SELENIUM_UTIL.getText(By.xpath(CalculatorPage.getExpression()));
        Assert.assertEquals(actualResult, CalculatorUtils.convertOperatorToSymbol(expectedResult), "Calculator result validation failed.");
        Assert.assertEquals(actualExpression, CalculatorUtils.convertOperatorToSymbol(expectedExpression), "Calculator expression validation failed.");
    }
    // Method for entering multiple digits
    public void enterDigits(String number) {
        String[] digits = number.replaceAll("\\s", "").split("");
        for(String digit: digits){
            if (CalculatorUtils.isOperator(digit)) {
                SELENIUM_UTIL.click(By.xpath(CalculatorPage.getOperatorButton(CalculatorUtils.getOperatorName(digit))));
                continue;
            }
            SELENIUM_UTIL.click(By.xpath(CalculatorPage.getCalculatorButton(digit)));
        }

    }
}
