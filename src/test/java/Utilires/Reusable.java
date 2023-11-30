package Utilires;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Reusable {
    public void selectFun(WebDriver driver, By selector, By index){
        driver.findElement(selector).click();
        driver.findElement(index).click();
    }
}
