package com.calculator.utils;

import java.util.List;
import java.util.regex.Pattern;

public class CalculatorUtils {
    private static final List<String> calculatorOperators = List.of("plus", "minus", "multiply", "divide");
    private static final String[] calculatorSymbols = {"×", "÷"};
    private static final String operatorRegex = ".*[+\\-*/].*";
    public static String getOperatorName(String operator) {
        switch(operator) {
            case "+":
                return calculatorOperators.get(0);
            case "-":
                return calculatorOperators.get(1);
            case "*":
                return calculatorOperators.get(2);
            case "/":
                return calculatorOperators.get(3);
            default:
                return operator;
        }
    }
    public static String convertOperatorToSymbol(String input) {
       input = input.replaceAll("\\*", calculatorSymbols[0]).replaceAll("/", calculatorSymbols[1]);
       return input;
    }
    public static boolean isOperator(String input) {
        Pattern pattern = Pattern.compile(operatorRegex);
        return pattern.matcher(input).matches();

    }
}
