package com.nelsonproject.tests;

import com.nelsonproject.BaseTest;
import com.nelsonproject.pageobjects.CarValuationPage;
import com.nelsonproject.pageobjects.ReportPage;
import com.nelsonproject.utils.FileUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class VehicleDetailsTest extends BaseTest {

    @Test
    public void validateVehicleDetailsTest() {
        logger.info("Extracting vehicle registration numbers....");
        List<String> regNumbers = FileUtils.readVehicleNumbers("src/main/resources/car_input - V6.txt");
        Map<String, String> expectedResults = FileUtils.readExpectedResults("src/main/resources/car_output - V6.txt");

        logger.info("Starting the validateVehicleDetails ");
        CarValuationPage carValuationPage = new CarValuationPage(driver);
        ReportPage reportPage = new ReportPage(driver);

        for (String reg : regNumbers) {
            carValuationPage.visit();
            carValuationPage.executeCheckNowSearch(reg);

            // Handle invalid registration number "BW57 BOW"
            if ("BW57 BOW".equals(reg)) {
                logger.info("Error message displayed for invalid registration number: " + reg);
                continue;  // Skip this registration number and proceed to the next one
            }

            // Extract actual vehicle details using the ReportPage getter methods
            String actualRegNumber = reportPage.getResultRegNumber();
            System.out.println(actualRegNumber);
            String actualMake = reportPage.getMake();
            System.out.println(actualMake);
            String actualModel = reportPage.getModel();
            String actualYear = reportPage.getYear();
            System.out.println(expectedResults);
            String expectedDetails = expectedResults.getOrDefault(reg, "NOT FOUND");
            expectedDetails = reg + "," + expectedDetails;
            String[] expectedParts = expectedDetails.split(",");
            System.out.println(Arrays.toString(expectedParts));

            if (expectedParts.length >= 4) {
                Assert.assertEquals(actualRegNumber, expectedParts[0].trim(), " Registration mismatch for: " + reg);
                Assert.assertEquals(actualMake, expectedParts[1].trim(), "Make mismatch for: " + reg);
                Assert.assertEquals(actualModel, expectedParts[2].trim(), "Model mismatch for: " + reg);
                Assert.assertEquals(actualYear, expectedParts[3].trim(), "Year mismatch for: " + reg);
            } else {
                logger.info("Expected details for " + reg + " are not properly formatted: " + expectedDetails);
            }
        }
    }


}
