package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Reusable {
    public void selectFun(WebDriver driver, By selector, By index){
        driver.findElement(selector).click();
        driver.findElement(index).click();
    }
    public void isDisplayedWaitEvent(WebDriver wDriver, By elementLocator, int duration) {
        Wait wait = new WebDriverWait(wDriver, Duration.ofSeconds(duration));
        wait.until(d -> wDriver.findElement(elementLocator).isDisplayed());
    }
    public void clearAndType(WebDriver driver, By elementLocator, String typeWord){
        driver.findElement(elementLocator).clear();
        driver.findElement(elementLocator).sendKeys(typeWord);

    }
}
