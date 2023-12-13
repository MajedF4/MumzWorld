package Pages;

import Utilities.Reusable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;
    Reusable reusable = new Reusable();
    By registerBtn = By.xpath("(//span[text()='Register'])[1]");
    By firstName = By.id("create_account_page_firstname");
    By lastName = By.id("create_account_page_lastname");
    By emial = By.id("create_account_page_email");
    By pass = By.id("create_account_page_password");
    By termConditionBox = By.id("terms_and_conditions");
    By stepTwoLanding = By.className("basicHeader-headerTeaser-P2F");
    By city = By.id("customer_city");
    By street = By.id("customer_street[0]");
    By building = By.id("customer_street[1]");
    By phoneNumber = By.id("customer_telephone");
    By selectCountry = By.xpath("(//div[contains(@class,'searchSelect-input-D63 observableSelect-input-2nD')])[1]");
    By saveAndContinue = By.xpath("//span[text()='Save & Continue']");
    By selectedOp = By.xpath("//div[text()='United Kingdom']");
    By getPhoneNumber = By.className("shippingInformation-cardPersonalTelephone-S9w");
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registrationStepOne(String fName, String lName, String email, String password){
        reusable.isDisplayedWaitEvent(driver,registerBtn,5);
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(emial).sendKeys(email);
        driver.findElement(pass).sendKeys(password);
        driver.findElement(termConditionBox).isSelected();
        driver.findElement(registerBtn).click();
        reusable.isDisplayedWaitEvent(driver,stepTwoLanding,5);
    }

    public String registrationStepTwo(String userCity, String userStreet, String userBuilding, String userPhone){
        reusable.isDisplayedWaitEvent(driver,selectCountry,10);
        reusable.selectFun(driver,selectCountry, selectedOp);
        driver.findElement(city).sendKeys(userCity);
        driver.findElement(street).sendKeys(userStreet);
        driver.findElement(building).sendKeys(userBuilding);
        driver.findElement(phoneNumber).sendKeys(userPhone);
        if (driver.findElement(saveAndContinue).isEnabled()) {
            driver.findElement(saveAndContinue).click();
            reusable.isDisplayedWaitEvent(driver,getPhoneNumber,15);
        }

        return driver.findElement(getPhoneNumber).getText();
    }

}
