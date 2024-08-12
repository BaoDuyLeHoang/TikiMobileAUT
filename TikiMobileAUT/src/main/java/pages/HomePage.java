package pages;

import core.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "com.android.packageinstaller:id/permission_allow_button")
    private WebElement btnAllow;

    @FindBy(how = How.XPATH, using = "//*[@text='Danh mục']")
    // @FindBy(how = How.XPATH, using = "//android.widget.FrameLayout[@content-desc='Danh mục']/android.view.ViewGroup/android.widget.TextView")
    private WebElement btnDanhMuc;
    @FindBy(how = How.XPATH, using = "//*[@text='Thời trang nam']")
    private WebElement btnThoiTrangNam;



    @FindBy(how = How.ID, using = "com.google.android.contacts:id/large_title")
    private WebElement titleName;
    @FindBy(how = How.ID, using = "com.google.android.contacts:id/header")
    private WebElement titlePhone;


    @FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid.homeV3:id/searchBar")
    private WebElement searchBar;
    @FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid:id/etQuery")
    private WebElement search;


    public void tapDanhMuc() {

        //    this.tapByElement(btnDanhMuc);
        //   WebElement element=driver.findElement(By.xpath("//*[@text='Danh mục']"));
        WebElement element = driver.findElement(By.id("vn.tiki.app.tikiandroid:id/navCategories"));
        this.tapByElement(element);
    }

    public void tapThoiTrangNam() {
        this.tapByElement(btnThoiTrangNam);
    }

    public void tapSearchBar() {
        this.tapByElement(searchBar);
    }

    public void inputSearch(String _search) {
        this.enterText(search, _search);
    }


    public void tapAllowButton() {
        this.tapByElement(btnAllow);
    }

    public void Enter(){
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public Boolean verifyContactCreated(String fn, String ln, String phone) {
        String nameAttribute = titleName.getAttribute("Text");
        String phoneAttribute = titlePhone.getAttribute("Text");
        String output = phoneAttribute.replaceAll("\\s", "");
        if (nameAttribute.contains(fn) && nameAttribute.contains(ln)) {
            if (phone.contains(output)) {
                return true;
            }
        }
        return false;
    }

}
