package core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseTestDriver{
    protected WebDriver driver;

    @BeforeEach
    public void setup(){
        FirefoxProfile profile = new ProfilesIni().getProfile("default");
        profile.setPreference("network.cookie.cookieBehavior", 1);
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("general.useragent.override","Mozilla/5.0 (iPhone; CPU iPhone OS 16_3_1 like Mac OS X) " +
                "AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.3 Mobile/15E148 Safari/604.1");
        options.setProfile(profile);
        driver = new FirefoxDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        BasePageDriver.setDriver(driver);
        driver.get("https://magento.softwaretestingboard.com/");
    }

//    @BeforeEach
    public void setupChromeDriver(){
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.cookies", 1);
        prefs.put("profile.cookie_controls_mode", 1);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--remote-allow-origins=*");
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
