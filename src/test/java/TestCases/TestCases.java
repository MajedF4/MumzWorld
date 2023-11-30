package TestCases;

import Pages.SearchPage;
import Pages.ShoppingBagPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestCases{

    public WebDriver driver;
    SearchPage searchPage;
    ShoppingBagPage shoppingBagPage;
    public static String url = "https://www.mumzworld.com/";

    @BeforeTest
    public void setup(){
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get(url);
    }

    @Test(priority = 1)
    public void SearchOperation(){
        searchPage = new SearchPage(driver);
        searchPage.search("Aery");
    }

    @Test(priority = 2)
    public void clickOnSearchedProduct(){
        searchPage = new SearchPage(driver);
        String productAssert = searchPage.clickOnProduct();
        Assert.assertEquals(productAssert,"Aery - Indian Sandalwood Candle - Black");
    }

    @Test(priority = 3)
    public void addItemToBagTest(){
        searchPage = new SearchPage(driver);
        String addItemAssert = searchPage.addItemToBag();
        Assert.assertEquals(addItemAssert,"Successfully added to bag");
    }

    @Test(priority = 4)
    public void increaseItemQtyTest(){
        shoppingBagPage = searchPage.goToViewBagPage();
        boolean increaseAssert = shoppingBagPage.isShoppingPage();
        Assert.assertTrue(increaseAssert);
        shoppingBagPage.increaseItemQty();

    }
    @AfterTest
    public void teardown(){
        driver.close();
    }

}
