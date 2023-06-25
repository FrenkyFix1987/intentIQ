package pages;

import core.BasePageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
public class MainPage extends BasePageDriver {

    @FindBy(xpath = "//nav[@class='navigation']/ul/li/a")
    private List<WebElement> navMenu;
    public MainPage() {
        PageFactory.initElements(driver, this);
    }
    public String getTitleTest(){
        return driver.getTitle();
    }

    public CategoryPage openRelevantCategory(String category, String subCategory) {
        for (WebElement el : navMenu) {
            if (el.getText().contentEquals(category)){
                openSubNavMenu(el, el.findElements(By.xpath("./../ul/li/a")), subCategory);
                break;
            }
        }
        return new CategoryPage();
    }
}
