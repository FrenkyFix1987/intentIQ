import core.BaseTestDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CategoryPage;
import pages.MainPage;
import pages.ThankYouPage;

public class MainPageTest extends BaseTestDriver {
    MainPage mainPage;
    CategoryPage categoryPage;
    ThankYouPage thankYouPage;

    @Test
    public void openTheTestSite(){
        mainPage = new MainPage();
        Assertions.assertEquals(mainPage.getTitleTest(),"Home Page", "The wrong page was opened");
    }

    @Test
    public void openTheBagsCategoryPage(){
        categoryPage = new MainPage().openRelevantCategory("Gear", "Bags");
        Assertions.assertEquals(categoryPage.getPageTitle(), "Bags", "The wrong category page was opened");
    }

    @Test
    public void writeOrderIdToFile() {
        openTheBagsCategoryPage();
        thankYouPage = categoryPage.addProductToCart().checkOut().fillingTheShippingFor();
        thankYouPage.writeToFile();
    }
}
