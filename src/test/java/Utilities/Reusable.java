package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Reusable {
    public void selectFun(WebDriver driver, By selector, By index){
        driver.findElement(selector).click();
        driver.findElement(index).click();
    }
}
