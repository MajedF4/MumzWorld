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
    By saveAndContinue = By.className("addressForm-buttons-1-h");
    By selectedOp = By.xpath("//div[text()='United Kingdom']");
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registrationStepOne(String fName, String lName, String email, String password){
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(registerBtn).isDisplayed());
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(emial).sendKeys(email);
        driver.findElement(pass).sendKeys(password);
        driver.findElement(termConditionBox).isSelected();
        driver.findElement(registerBtn).click();
        wait.until(d -> driver.findElement(stepTwoLanding).isDisplayed());
    }

    public void registrationStepTwo(String userCity, String userStreet, String userBuilding, String userPhone){
        reusable.selectFun(driver,selectCountry, selectedOp);
        driver.findElement(city).sendKeys(userCity);
        driver.findElement(street).sendKeys(userStreet);
        driver.findElement(building).sendKeys(userBuilding);
        driver.findElement(phoneNumber).sendKeys(userPhone);
        if (driver.findElement(saveAndContinue).isEnabled()) {
            driver.findElement(saveAndContinue).click();
        }
    }

}
