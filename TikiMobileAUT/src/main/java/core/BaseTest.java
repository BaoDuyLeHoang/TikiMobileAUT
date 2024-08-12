package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    private AndroidDriver driver;
    private UiAutomator2Options options;

    @BeforeSuite
    public void beforeSuite() {
        options = new UiAutomator2Options()
                .setDeviceName("samsung SM-S908E")
                .setPlatformName("Android")
                .setPlatformVersion("9")
                .setAppPackage("vn.tiki.app.tikiandroid")
                .setAppActivity("vn.tiki.android.shopping.homeV3.HomeActivity")
                .setAutomationName("UiAutomator2");
    }
    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
         driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
    }

    @AfterMethod
    public void afterMethod() {
        //Đóng driver sau khi test kết thúc
        if (driver != null) {
            driver.quit();
        }
    }

    public AndroidDriver getDriver() {
        return driver;
    }
}
