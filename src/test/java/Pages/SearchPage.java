package Pages;

import Utilities.Reusable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    WebDriver driver;
    Reusable reusable = new Reusable();

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    By keyworldField = By.xpath("//input[@placeholder='What are you looking for?']");
    By searchedPRoduct = By.xpath("(//span[text()='Aery - Indian Sandalwood Candle - Black'])[1]");
    By ProductSearchAccual = By.xpath("//h1[text()='Aery - Indian Sandalwood Candle - Black']");
    By bagBtn = By.xpath("//button[@title='Add to bag']");
    By addItemAssert = By.xpath("//span[text()='Successfully added to bag']");
    By veiwBag = By.xpath("//a[@href='/en/cart']");
    public void search(String searchKey){
        reusable.isDisplayedWaitEvent(driver,keyworldField,10);
        reusable.clearAndType(driver,keyworldField,searchKey);
        driver.findElement(keyworldField).click();
    }
    public String clickOnProduct(){
        reusable.isDisplayedWaitEvent(driver,searchedPRoduct,15);
        driver.findElement(searchedPRoduct).click();
        reusable.isDisplayedWaitEvent(driver,ProductSearchAccual,10);
        return driver.findElement(ProductSearchAccual).getText();
    }
     public String addItemToBag(){
        driver.findElement(bagBtn).click();
        reusable.isDisplayedWaitEvent(driver,addItemAssert,10);
        return driver.findElement(addItemAssert).getText();

     }
    public ShoppingBagPage goToViewBagPage(){
        reusable.isDisplayedWaitEvent(driver,veiwBag,10);
        driver.findElement(veiwBag).click();
        return new ShoppingBagPage(driver);
    }

}
