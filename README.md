
# Project Overview

This project is an automated test suite designed to
read vehicle registration numbers from an input file **car_input.txt - v6.txt**.
Extract valid registration numbers using a pattern-matching approach.
perform vehicle details lookup on https://car-checking.com/ and
compare fetched details with expected data from **car_output.txt -v6.txt**.
Highlight discrepancies and fail tests if mismatches are found.
This framework is scalable, maintainable and modular allowing easy code re-usability and future capability to scale more input data sources using testng.

## Key Framework features:
* Cross browser testing
* POM (Page Object Modal) pattern
  
## Pre-requisite setup:

* Intellij IDEA

* Maven

* Java

* Testng

* Selenium Webdriver

* Chrome browser

* Firefox browser

* Logging: Log4j

## Getting Started:
Git clone project or download and open with Intellij IDE or any appropriate IDE of choice

### Executing tests:
**Via IDE**:
* You can  right-click on the fullregression suite xml and run all tests

* **Command line**:
  `mvn clean test -DsuitXmlFile=SmokeTestSuite.xml`

## Reporting:

Navigate to the `target folder -> surefire-reports -> index.html` and right click to open in browser
See sample report screenshot:

Simulated failed Test:

<img width="1276" alt="Screenshot 2025-03-07 at 03 05 52" src="https://github.com/user-attachments/assets/7034150e-1a25-492a-8e71-436705535c86" />

Simulated Passed Test:

<img width="1306" alt="Screenshot 2025-03-07 at 03 04 40" src="https://github.com/user-attachments/assets/3988f1c0-7db1-404e-8536-5ba46c5f71e9" />



### **Future improvements**:

* Scale to include more input files to run the vehicleDetailsTest against multiple data sources (Data providers)
* Extend to run in Ci and cloud platforms
* Expand  to run on more browsers to ensure compatibility
* Improve on the error handling and mismatched data
