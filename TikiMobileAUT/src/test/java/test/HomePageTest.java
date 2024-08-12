package test;

import core.BaseTest;
import core.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

import java.time.Duration;

public class HomePageTest extends BaseTest {

    @Test(dataProviderClass = DataProviderUtils.class, dataProvider = "TestData")
    public void Ex1(String text) throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        ProductPage productPage = new ProductPage(getDriver());
        Thread.sleep(5000);
        homePage.tapAllowButton();
        Thread.sleep(1000);
        homePage.tapByCoordinates(180, 1522); //Tap Danh Muc
        //homePage.tapDanhMuc();
        homePage.tapThoiTrangNam();
        homePage.swipeMobileUp(Duration.ofSeconds(2));
        Thread.sleep(5000);
        productPage.tapProduct(5);
        productPage.tapThemVaoGioHang();
        Thread.sleep(5000);
        productPage.tapChon();
        Assert.assertTrue(productPage.verifyLoginPageDisplay(text));
    }
}
