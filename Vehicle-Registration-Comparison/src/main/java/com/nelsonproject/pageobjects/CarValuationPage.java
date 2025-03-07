package com.nelsonproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarValuationPage extends BasePage {
    private By vehicleRegistrationInputLocator = By.id("subForm1");
    private By checkNowButtonLocator = By.className("check-now-button");

    public CarValuationPage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit("https://car-checking.com/");
    }

    public void enterRegistrationNumber(String registrationNumber) {
        driver.findElement(vehicleRegistrationInputLocator).sendKeys(registrationNumber);
    }

    public void clearRegistrationNumber() {
        driver.findElement(vehicleRegistrationInputLocator).clear();
    }

    public void clickCheckNowButton() {
        driver.findElement(checkNowButtonLocator).click();
    }

    public void executeCheckNowSearch(String registrationNumber) {
        clearRegistrationNumber();
        enterRegistrationNumber(registrationNumber);
        clickCheckNowButton();
    }
}
