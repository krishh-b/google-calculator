@Regression
Feature: Google Calculator
  This feature is for verifying the functionalities of google calculator

  Background:
    Given I have opened the Google Calculator

  Scenario: Verify functionality of all calculator buttons
    When I press "12345"
    Then the result should be "12345" and the expression should be "Ans = 0"
    And I press operator "+"
    And I press "67"
    Then the result should be "12345 + 67" and the expression should be "Ans = 0"
    And I press operator "-"
    And I press "8"
    Then the result should be "12345 + 67 - 8" and the expression should be "Ans = 0"
    And I press operator "*"
    And I press "9"
    Then the result should be "12345 + 67 - 8 * 9" and the expression should be "Ans = 0"
    And I press operator "/"
    And I press "0.0"
    Then the result should be "12345 + 67 - 8 * 9 / 0.0" and the expression should be "Ans = 0"

  Scenario Outline: Verify basic arithmetic calculation is working as expected
    When I press "<operand1>" "<operator>" "<operand2>" "="
    Then the result should be "<result>" and the expression should be "<expression>"
    Examples:
      | operand1   | operator | operand2   | result        | expression                |
      | 2          | +        | 3          | 5             | 2 + 3 =                   |
      | 123456789  | -        | 123456789  | 0             | 123456789 - 123456789 =   |
      | 9999999999 | *        | 9999999999 | 1e+20         | 9999999999 * 9999999999 = |
      | 12345      | /        | 6789       | 1.81838267786 | 12345 / 6789 =            |
      | 0.25       | +        | 2.50       | 2.75          | 0.25 + 2.50 =             |
      | 5.8        | -        | 2.3        | 3.5           | 5.8 - 2.3 =               |
      | 2.5        | *        | 4.2        | 10.5          | 2.5 * 4.2 =               |
      | 7.5        | /        | 2.5        | 3             | 7.5 / 2.5 =               |
      | -5         | +        | 10         | 5             | -5 + 10 =                 |
      | 7.5        | /        | 2.5        | 3             | 7.5 / 2.5 =               |
      | 8          | /        | 0          | Infinity      | 8 / 0 =                   |
      | 5.5        | /        | 0          | Infinity      | 5.5 / 0 =                 |
      | 5544       | +        | .          | Error         | 5544 + . =                |

  Scenario: Verify complex decimal expression is working as expected
    When I press "5.2"
    And I press operator "+"
    And I press "3.1"
    And I press operator "*"
    And I press "2.0"
    And I press operator "/"
    And I press "2.5"
    And I press operator "-"
    And I press "1.2"
    And I press "="
    Then the result should be "6.48" and the expression should be "5.2 + 3.1 * 2.0 / 2.5 - 1.2 ="

  Scenario: Verify complex negative numbers expression is working as expected
    When I press operator "-"
    And I press "10"
    And I press operator "+"
    And I press "20"
    And I press operator "*"
    And I press operator "-"
    And I press "2"
    And I press "="
    Then the result should be "-50" and the expression should be "-10 + 20 * -2 ="

  Scenario: Verify AC button is clearing the recent result
    When I press "5"
    And I press operator "+"
    And I press operator "+"
    And I press operator "-"
    And I press "3"
    And I press "="
    Then the result should be "2" and the expression should be "5 - 3 ="
    And I press the AC button
    Then the result should be "0" and the expression should be "Ans = 2"

  Scenario: Verify CE button is clearing the last entered digit
    When I press "10000000"
    And I press the CE button
    Then the result should be "1000000" and the expression should be "Ans = 0"
    And I press the CE button
    Then the result should be "100000" and the expression should be "Ans = 0"
    And I press operator "*"
    And I press "10"
    And I press "="
    Then the result should be "1000000" and the expression should be "100000 * 10 ="

  Scenario: Verify multiplying two large digits
    When I press "100000000000000000000000000000000000000000000000000000000000000000"
    And I press operator "*"
    And I press "9999999999999999999999999999999999999999999999999999999"
    And I press "="
    Then the result should be "1e+120" and the expression should be "100000000000000000000000000000000000000000000000000000000000000000 * 9999999999999999999999999999999999999999999999999999999 ="

