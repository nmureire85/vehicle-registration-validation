package com.nelsonproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportPage extends BasePage {
    private By registrationNumberLocator = By.xpath("//input[@id='subForm' and @type='text' and @name='i']");
    private By vehicleTableLocator = By.cssSelector(".table.table-responsive tbody");

    public ReportPage(WebDriver driver) {
        super(driver);
    }

    public Map<String, String> getVehicleDetails() {
        Map<String, String> vehicleDetails = new HashMap<>();
        WebElement vehicleTable = driver.findElement(vehicleTableLocator);
        List<WebElement> rows = vehicleTable.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columns.size() == 2) {
                String key = columns.get(0).getText().trim();
                String value = columns.get(1).getText().trim();

                if ("Make".equalsIgnoreCase(key)) {
                    vehicleDetails.put("Make", value);
                } else if ("Model".equalsIgnoreCase(key)) {
                    vehicleDetails.put("Model", value);
                } else if ("Year of manufacture".equalsIgnoreCase(key)) {
                    vehicleDetails.put("Year of manufacture", value);
                }
            }
        }
        return vehicleDetails;
    }


    public String resultRegNumber() {
        return waitForElement(registrationNumberLocator).getAttribute("value").trim();
    }

    public String getResultRegNumber() {
        return resultRegNumber();
    }

    public String getMake() {
        return getVehicleDetails().getOrDefault("Make", "Not Found");
    }

    public String getModel() {
        return getVehicleDetails().getOrDefault("Model", "Not Found");
    }

    public String getYear() {
        return getVehicleDetails().getOrDefault("Year of manufacture", "Not Found");
    }
}



