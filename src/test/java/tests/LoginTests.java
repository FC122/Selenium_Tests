package tests;

import Helpers.Helpers;
import config.ConfigFileReader;
import jdk.jfr.Timespan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageLocators.LoginPageLocators;
import pages.LoginPageActions;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

public class LoginTests {
    public WebDriver driver;
    public LoginPageLocators locators;
    public LoginPageActions actions;
    public ConfigFileReader configs = new ConfigFileReader();
    public WebDriverWait wait;
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver",configs.getDriverPath());
        driver = new ChromeDriver();
        locators = new LoginPageLocators(driver);
        actions = new LoginPageActions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(configs.getExplicitWaitTime()));
        driver.navigate().to(configs.getApplicationUrl());
    }
    @Test
    public void checkIfRegisteredUserCanLogIn() throws InterruptedException {
        actions.logIn(configs.getStandardUsername(),configs.getPassword(),wait);
    }
    @Test
    public void checkIfRegisteredUserCanLogInWithUpercaseUsername() throws InterruptedException {
        actions.logIn(configs.getStandardUsername().toUpperCase(), configs.getPassword(),wait);
    }
    @Test
    public void checkValidationForLoggingInWithEmptyInputs() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElements(locators.btnLogIn));
        locators.btnLogIn.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(locators.txtError));
        Assert.assertEquals(locators.txtError.getText(),configs.getUsernameRequiredErrorTxt());
    }
    @Test
    public void checkValidationForLoggingInWithJustUsername() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElements(locators.inputUsername));
        locators.inputUsername.sendKeys(configs.getStandardUsername());
        wait.until(ExpectedConditions.visibilityOfAllElements(locators.btnLogIn));
        locators.btnLogIn.click();
        Assert.assertEquals(locators.txtError.getText(),configs.getPasswordRequiredErrorTxt());
    }
    @Test
    public void checkValidationForLoggingInWithJustPassword() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElements(locators.inputPassword));
        locators.inputPassword.sendKeys(configs.getPassword());
        wait.until(ExpectedConditions.visibilityOfAllElements(locators.btnLogIn));
        locators.btnLogIn.click();
        Assert.assertEquals(locators.txtError.getText(),configs.getUsernameRequiredErrorTxt());
    }
    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }

}
