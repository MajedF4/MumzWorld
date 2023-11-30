package TestCases;

import Utilires.Reusable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseClass {
    WebDriver driver;
    public static String url = "https://www.mumzworld.com/";

    @BeforeMethod
    public void setup(){
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        driver = new FirefoxDriver(options);
        driver.get(url);
    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
