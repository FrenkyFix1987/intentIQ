package pages;

import core.BasePageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ThankYouPage extends BasePageDriver {
    private final String FILE_NAME = "src/test/resources/test_data.txt";
    @FindBy(xpath = "//main[@id='maincontent']/div[@class='columns']/div/div[@class='checkout-success']/p[1]/span")
    private WebElement orderId;
    public ThankYouPage(){
        PageFactory.initElements(driver, this);
    }

    private void createFileWithOrder(){
        File targetFile = new File(FILE_NAME);
        targetFile.delete();
        File newFile = new File(FILE_NAME);
        boolean success = false;
        try {
            success = newFile.createNewFile();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertTrue(success);
    }

    public void writeToFile(){
        createFileWithOrder();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(orderId.getText());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
