package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.listeners.TestListeners;

/**
 * This class contains the base configuration about the main browsers settings
 * that will be used for all tests
 */
@Listeners(TestListeners.class)

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        //Maximize Window
        driver.manage().window().maximize();

    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver () {
        driver.quit();
    }
}
