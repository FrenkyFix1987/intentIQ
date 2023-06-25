package core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public abstract class BaseTestDriver{
    protected WebDriver driver;

    @BeforeEach
    public void setup(){
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("general.useragent.override","Mozilla/5.0 (iPhone; CPU iPhone OS 16_3_1 like Mac OS X) " +
                "AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.3 Mobile/15E148 Safari/604.1");
        options.addPreference("profile.default_content_setting_values.cookies", 2);
        driver = new FirefoxDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        BasePageDriver.setDriver(driver);
        driver.get("https://magento.softwaretestingboard.com/");
    }
    public void setupChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("profile.default_content_setting_values.cookies", 2);
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        BasePageDriver.setDriver(driver);
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
