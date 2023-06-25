package core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePageDriver {


    private final Actions actions = new Actions(driver);
    protected static WebDriver driver;

    public void waitElementClickable(WebElement element) {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitElementInvisible(List<WebElement> elements) {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driverWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }
    public void driverSleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void setDriver(WebDriver driver_p) {
        driver = driver_p;
    }
    public void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }
    public void openSubNavMenu(WebElement element, List<WebElement> elList, String text){
        moveToElement(element);
        for (WebElement el : elList) {
            if (el.getText().equals(text)){
                moveToElement(el);
                actions.click().build().perform();
                break;
            }
        }
    }
}
