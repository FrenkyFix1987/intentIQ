package pages;

import core.BasePageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoryPage extends BasePageDriver {
    @FindBy(id = "top-cart-btn-checkout")
    private WebElement checkOutBtn;
    @FindBy(xpath = "//a[contains(@class,'showcart')]/span[contains(@class, 'counter')]")
    private WebElement itemCounter;
    @FindBy(xpath = "//h1[@id='page-title-heading']/span")
    private WebElement pageTitle;
    @FindBy(xpath = "//li[contains(@class, 'product-item')]")
    private List<WebElement> productsItems;
    @FindBy(xpath = "//div[@class='minicart-wrapper']/a[contains(@class, 'showcart')]")
    private WebElement showCartBtn;
    @FindBy(xpath = "//div[@class='items-total']/span[@class='count']")
    private WebElement itemsInCart;
    public CategoryPage(){
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public CategoryPage addProductToCart(){
        moveToElement(productsItems.get(0));
        WebElement addToCartBtn = driver.findElement(By.xpath("//button[contains(@class, 'tocart')]"));
        waitElementClickable(addToCartBtn);
        driverSleep(2000);
        addToCartBtn.click();
        return this;
    }
    public CheckOutPage checkOut(){
        driverSleep(2000);
        showCartBtn.click();
        checkOutBtn.click();
        driverSleep(2000);
        return new CheckOutPage();
    }

}
