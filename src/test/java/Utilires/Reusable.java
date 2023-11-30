package Utilires;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Reusable {
    WebDriver driver;
    public void search(WebDriver driver, String searchKey, By locator){
        driver.findElement(locator).sendKeys(searchKey, Keys.ENTER);
    }
}
