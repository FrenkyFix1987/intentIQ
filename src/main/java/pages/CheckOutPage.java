package pages;

import core.BasePageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePageDriver {
//
//    @FindBy(xpath = "//div[@class='loader']")
//    private WebElement loader;
    @FindBy(id = "customer-email")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@name='street[0]']")
    private WebElement streetFirstInput;
    @FindBy(xpath = "//input[@name='city']")
    private WebElement cityInput;
    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement postcodeInput;
    @FindBy(xpath = "//select[@name='country_id']")
    private WebElement countries;
    @FindBy(xpath = "//input[@name='telephone']")
    private WebElement telephoneInput;
    @FindBy(xpath = "//button[contains(@class,'continue')]")
    private WebElement nextBtn;

    @FindBy(xpath = "//button[contains(@class,'checkout')]")
    private WebElement placeOrderBtn;

    public CheckOutPage(){
        PageFactory.initElements(driver, this);
    }

    public ThankYouPage fillingTheShippingFor(){
        waitElementIsNotPresent(By.xpath("//div[@class='loader']"));
//        waitElementInvisible(driver.findElements());
        Select select = new Select(countries);
        select.selectByVisibleText("Israel");
        emailInput.sendKeys("alexandersivrikov@gmail.com");
        firstNameInput.sendKeys("Alexander");
        lastNameInput.sendKeys("Sivrikov");
        streetFirstInput.sendKeys("Ha-Rav Nisim Street 1");
        cityInput.sendKeys("Hadera");
        postcodeInput.sendKeys("383064");
        telephoneInput.sendKeys("+972559486022");
//        waitElementInvisible(driver.findElements(By.xpath("//div[@class='loader']")));
        waitElementIsNotPresent(By.xpath("//div[@class='loader']"));
        //        driverSleep(5000);
        nextBtn.click();
//        waitElementInvisible(driver.findElements(By.xpath("//div[@class='loader']")));
        waitElementIsNotPresent(By.xpath("//div[@class='loader']"));
        placeOrderBtn.click();
        return new ThankYouPage();
    }

}
