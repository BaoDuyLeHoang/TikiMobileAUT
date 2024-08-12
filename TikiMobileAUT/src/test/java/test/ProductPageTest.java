package test;

import core.BaseTest;
import core.DataProviderUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

import java.time.Duration;

public class ProductPageTest  extends BaseTest {
    @Test(dataProviderClass = DataProviderUtils.class, dataProvider = "TestData")
    public void Ex2(String search) throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        ProductPage productPage = new ProductPage(getDriver());
        Thread.sleep(5000);
        homePage.tapAllowButton();
        Thread.sleep(1000);
        //homePage.tapSearchBar();
        homePage.tapByCoordinates(36, 262); //Tap Search Bar
        homePage.inputSearch(search);
        homePage.Enter();
        productPage.tapLoc();
        productPage.tapFilter();
        productPage.tapApDung();

        Assert.assertTrue(productPage.verifyPrice(productPage.getFirstProductPrice()), "First Price incorrect");
        Assert.assertTrue(productPage.verifyPrice(productPage.getSecondProductPrice()), "Second Price incorrect");
    }
}
