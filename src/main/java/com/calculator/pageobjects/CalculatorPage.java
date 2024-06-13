package com.calculator.pageobjects;

public class CalculatorPage {
    private static final String CALCULATOR = "//div[@class = 'card-section']";
    private static final String BUTTON = "//div[@class = 'card-section']//div[@role='button' and text() = '%s']";
    private static final String OPERATOR_BUTTON = "//div[@class = 'card-section']//div[@role='button' and @aria-label = '%s']";
    private static final String RESULT = "//div[@class = 'card-section']//span[@id = 'cwos']";
    private static final String EXPRESSION = "//div[@class = 'card-section']//span[@class= 'vUGUtc']";

    public static String getCalculatorButton(String buttonName) {
        return String.format(BUTTON, buttonName);
    }
    public static String getCalculationResult() { return RESULT; }
    public static String getCalculator() { return CALCULATOR; }
    public static String getOperatorButton(String operator) { return String.format(OPERATOR_BUTTON, operator); }
    public static String getExpression() { return EXPRESSION; }
}
