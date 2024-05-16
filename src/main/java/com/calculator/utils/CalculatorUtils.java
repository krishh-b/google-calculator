package com.calculator.utils;

import java.util.List;
import java.util.regex.Pattern;

public class CalculatorUtils {
    private static final List<String> calculatorSymbols = List.of("plus", "minus", "multiply", "divide");
    private static final String operatorRegex = ".*[\\+\\-\\*\\/].*";
    public static String getOperatorSymbol(String operator) {
        switch(operator) {
            case "+":
                return calculatorSymbols.get(0);
            case "-":
                return calculatorSymbols.get(1);
            case "*":
                return calculatorSymbols.get(2);
            case "/":
                return calculatorSymbols.get(3);
            default:
                return operator;
        }
    }
    public static boolean isOperator(String input) {
        Pattern pattern = Pattern.compile(operatorRegex);
        return pattern.matcher(input).matches();

    }
}
