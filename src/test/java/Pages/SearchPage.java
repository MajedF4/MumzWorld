package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    By keyworldField = By.xpath("//input[@placeholder='What are you looking for?']");
    By searchedPRoduct = By.xpath("(//span[text()='Aery - Indian Sandalwood Candle - Black'])[1]");
    By ProductSearchAccual = By.xpath("//h1[text()='Aery - Indian Sandalwood Candle - Black']");
    By bagBtn = By.xpath("//button[@title='Add to bag']");
    By addItemAssert = By.xpath("//span[text()='Successfully added to bag']");
    By veiwBag = By.xpath("//a[@href='/en/cart']");
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    public void search(String searchKey){
        driver.findElement(keyworldField).sendKeys(searchKey, Keys.ENTER);
    }
    public String clickOnProduct(){
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(searchedPRoduct).isDisplayed());
        driver.findElement(searchedPRoduct).click();
        wait.until(d -> driver.findElement(ProductSearchAccual).isDisplayed());
        return driver.findElement(ProductSearchAccual).getText();
    }
     public String addItemToBag(){
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(bagBtn).click();
        wait.until(d -> driver.findElement(addItemAssert).isDisplayed());
        return driver.findElement(addItemAssert).getText();

     }
    public ShoppingBagPage goToViewBagPage(){
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(veiwBag).isDisplayed());
        driver.findElement(veiwBag).click();
        return new ShoppingBagPage(driver);
    }
}
