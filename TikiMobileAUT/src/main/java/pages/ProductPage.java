package pages;

import core.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ProductPage extends BasePage {
    public ProductPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/" +
            "android.view.ViewGroup")
    List<WebElement> productsList;

    @FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid.productDetail2:id/button_add_to_cart")
    private WebElement btnThemVaoGioHang;
    @FindBy(how = How.ID, using = "vn.tiki.app.tikiandroid:id/button")
    private WebElement btnChon;
    @FindBy(how = How.XPATH, using = "//*[@text='Đăng nhập / Đăng ký']")
    private WebElement textCheck;
    @FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.recyclerview.widget.RecyclerView[4]/android.view.ViewGroup[4]/android.view.ViewGroup")
    private WebElement filter;
    @FindBy(how = How.ID, using =
            "vn.tiki.app.tikiandroid.productList2:id/filter_text")
    private WebElement btnLoc;
    @FindBy(how = How.ID, using =
            "vn.tiki.app.tikiandroid.productList2:id/btn_apply")
    private WebElement btnApDung;

    public void tapChon() {
        this.tapByElement(btnChon);
    }

    public void tapLoc() {
        this.tapByElement(btnLoc);
    }

    public void tapFilter() {
        this.tapByElement(filter);
    }

    public void tapApDung() {
        this.tapByElement(btnApDung);
    }


    public void tapThemVaoGioHang() {
        this.tapByElement(btnThemVaoGioHang);
    }

    public void tapProduct(int index) throws InterruptedException {
        this.isElementsVisibility(productsList);
        WebElement firstContact = productsList.get(index).findElement(By.xpath(".//*[@class='android.view.ViewGroup'][last()]"));
        this.tapByElement(firstContact);
    }

    public String getFirstProductPrice() {
        String nameCon;
        this.isElementsVisibility(productsList);
        WebElement firstContact = productsList.get(2).findElement(By.xpath(".//*[@class='android.view.ViewGroup'][last()]//android.widget.TextView[1]"));
        return nameCon = firstContact.getAttribute("Text");
    }

    public String getSecondProductPrice() {
        String nameCon;
        this.isElementsVisibility(productsList);
        WebElement firstContact = productsList.get(3).findElement(By.xpath(".//*[@class='android.view.ViewGroup'][last()]//android.widget.TextView[1]"));
        return nameCon = firstContact.getAttribute("Text");
    }

    public Boolean verifyPrice(String price) {
        String _price = price.replace(".", "").replace("₫", "");
        int priceInt = Integer.parseInt(_price);
        if (priceInt > 230000) {
            return true;
        }
        return false;
    }

    public Boolean verifyLoginPageDisplay(String text) {
        String check = textCheck.getAttribute("text");
        if (check.equals(text)) {
            return true;
        }
        return false;
    }
}
