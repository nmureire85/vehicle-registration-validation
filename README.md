
### Project Overview

This project is an automated test suite designed to:
Read vehicle registration numbers from an input file **car_input.txt - v6.txt**.
Extract valid registration numbers using a pattern-matching approach.
Perform vehicle details lookup on https://car-checking.com/.
Compare fetched details with expected data from **car_output.txt -v6.txt**.
Highlight discrepancies and fail tests if mismatches are found.
This framework is scalable, allowing easy addition of more input files and test cases in the future.

#### Key Framework features:
* Cross browser support

* POM (Page Object Modal) pattern
### Pre-requisite setup:

Intellij IDEA

Maven

Java

Testng

Selenium Webdriver

Chrome browser

Firefox browser

Logging: Log4j

### Getting Started:
Git clone project or download and open with Intellij IDE or any appropriate IDE of choice

#### Executing tests:
**Via IDE**:
1. You can  right-click on the fullregression suite xml and run all tests

**Command line**:
`mvn clean test -DsuitXmlFile=SmokeTestSuite.xml`

### Reporting:

Navigate to the `target folder -> surefire-reports -> index.html` and right click to open in browser
See sample report screenshot:

![Screenshot 2025-03-06 at 21.26.54.png](../../Desktop/Screenshot%202025-03-06%20at%2021.26.54.png)

### **Future improvements**:

* Scale to include more input files to run the vehicleDetailsTest against multiple data sources (Data providers)
* Extend to run in Ci and cloud platforms
* Expand  to run on more browsers to ensure compatibility
* Improve on the error handling and mismatched data
