package Helpers;

import config.ConfigFileReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {
    public static WebElement ExplicitWait(WebElement element, WebDriverWait wait, ConfigFileReader configFileReader){
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        return element;
    }
}
