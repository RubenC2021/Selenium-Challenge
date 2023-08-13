package utils;


import com.codeborne.selenide.Selenide;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class TestUtilities extends BasePage {

    public TestUtilities (WebDriver driver){
        super(driver);
    }

    public  WebElement highlightElement(WebElement element) {
        String script = "arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script,element);
        return element;
    }
}
