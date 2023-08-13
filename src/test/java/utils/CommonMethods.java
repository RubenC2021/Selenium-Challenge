package utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.BasePage;
@Slf4j
public class CommonMethods extends BasePage {


    public CommonMethods(WebDriver driver) {
        super(driver);
    }

    public boolean isTextPresent(String text) {
        boolean textAppears = false;
        String checkText = getText(By.xpath("//*[contains(text()," + "'" + text + "')]"));
        if (checkText.contains(text.trim())) {
            textAppears = true;
            log.info("The text '" + checkText + "' was found");
        } else {
            log.info("The text '" + checkText + "' was not found");
        }
        return textAppears;
    }

    public void assertFieldTexts(String...textFieldName){
        for(String textField:textFieldName){
            Assert.assertTrue(isTextPresent(textField), "The text "+ textField +" was not found");
        }
    }






}
