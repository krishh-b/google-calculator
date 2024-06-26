# Google Calculator UI Test Automation Framework

## Overview

This project is a test automation framework designed to perform UI testing for the Google Calculator application. The framework is built using Java, Selenium, Cucumber, and TestNG, and it supports parallel test execution. The framework also integrates with CircleCI for continuous integration and uses WebDriverManager to manage browser drivers automatically. Git is used for version control, and the code is hosted on GitHub.

## Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven 3.6.0 or higher
- Google Chrome browser
- Git (Optional)
- IDE (Optional - IntelliJ IDEA recommended)

## Project Structure
	│   .gitignore
	│   pom.xml
	│   README.md
	│   RegressionTest.xml
    │   RegressionTest_Parallel.xml
	│   runTest.bat
	│
	├───.circleci
	│       config.yml
	│
	│
	├───documentation
	│       Test Automation Solution Document.pdf
	│
	├───results
	│       Sample_Failed_Test_Result.html
	│       Sample_Passed_Test_Result.html
	│       test-result.html
	│
	└───src
	    ├───main
	    │   └───java
	    │       └───com
	    │           └───calculator
	    │               ├───pageobjects
	    │               │       CalculatorPage.java
	    │               │       GooglePage.java
	    │               │
	    │               └───utils
	    │                       CalculatorUtils.java
	    │                       DriverFactory.java
	    │                       SeleniumWrapper.java
	    │                       Utility.java
	    │
	    └───test
	        ├───java
        	│   └───com
	        │       └───calculator
        	│           ├───hooks
	        │           │       TestHooks.java
        	│           │
        	│           ├───runner
        	│           │       TestRunner.java
                        │       ParallelRunner.java
	        │           │
        	│           └───stepdefinitions
        	│                   CalculatorTest.java
        	│
        	└───resources
        	    ├───config
        	    │       config.properties
        	    │
        	    └───features
                	    Calculator.feature
    
            

## Setup Instructions

   ### Clone the repository or download as zip from Github
       git clone https://github.com/krishh-b/google-calculator.git
       cd google-calculator-automation

   ### Build the project
       mvn clean install

   ### Run the tests
       mvn test -Dcucumber.filter.tags="@Regression" -DthreadCount="4" -Dbrowser="chrome"

### Run Tests from the IDE
  Open the project in IntelliJ IDEA.
  #### Running from TESTNG.xml file
  Navigate to the RegressionTest.xml file.
  Right-click on the file and select Run 'RegressionTest.xml'.
  #### Running from Test Runner class
  Navigate to the TestRunner.java file.
  Right-click on the file and select Run 'TestRunner.java'.
  #### Running tests parallel
  Navigate to the ParallelRunner.java file.
  Right-click on the file and select Run 'ParallelRunner.java'.<br>
  **Note: The default thread count (10) will be applied when running from this class.**

## Configuration
  #### Maven Dependencies
  The pom.xml file includes dependencies for Selenium, WebDriverManager, Cucumber, TestNG, and other necessary libraries.
  
  #### WebDriver Management
  WebDriverManager is used to manage browser drivers automatically. This eliminates the need for manual download and configuration of WebDriver binaries.

  #### Parallel Execution
  Parallel execution is configured in the pom.xml file. The default count is set as 4. However, the count can be overridden by passing "threadCount" as a parameter.<br>
  **Note: The thread count can only be controlled when the tests are ran using mvn test command.**

## Reporting
  Test results are saved in the HTML format:<br>
  You can find the reports in the results directory after running the tests. To view the HTML report, open the **test-result.html** file in a web browser.

## Continuous Integration
  The project is configured with CircleCI for continuous integration. You can find the configuration file in the .circleci/config.yml.

## GitHub Repository
  The source code is managed using Git and hosted on GitHub.


   


