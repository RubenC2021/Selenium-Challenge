package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestUtilities;

import java.util.List;


@Slf4j
public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);

    }



    protected WebElement find(By locator) {
        log.info("The WebElement with the locator " + "'" + locator + "'" + " was found");
        return waitForElementVisible(locator);
    }

    protected  List<WebElement> findElements(By locator){
        return  visibilityOfAllElementsLocatedBy(locator);
    }

    void clickAnyItemFromDropdown(String triggerItemText, By listElementsLocator){
        List<WebElement> itemList = findElements(listElementsLocator);
        for (WebElement item :itemList) {
            System.out.println(item.getText());
            if(item.getText().contains(triggerItemText)){
                item.click();
                break;
            }
        }
    }

    //find element using given webElement
    protected WebElement find(WebElement webElement) {
        log.info("The WebElement with the locator " + "'" + webElement + "'" + " was found");
        return waitVisibilityOfElement(webElement);
    }

    //click any item using given locator
    public void click(By locator) {
        TestUtilities testUtilities = new TestUtilities(driver);
        testUtilities.highlightElement(waitElementToBeClickable(locator)).click();
        log.info("The WebElement with the locator " + "'" + locator + "'" + " was clicked");
    }

    //click any item using given webElement
    public void click(WebElement webElement) {
        TestUtilities testUtilities = new TestUtilities(driver);
        testUtilities.highlightElement(waitElementToBeClickable(webElement)).click();
        log.info("The WebElement was clicked");
    }

    //Type given text into element with given locator
    public void type(By locator, String text) {
        TestUtilities testUtilities = new TestUtilities(driver);
        testUtilities.highlightElement(find(locator)).sendKeys(text);
        log.info("The text " + "'" + text + "'" + " was typed on the " + "'" + locator + "'" + " TextBox");
    }

    //Get Text
    public String getText(By locator) {
        TestUtilities testUtilities = new TestUtilities(driver);
        String text = testUtilities.highlightElement(find(locator)).getText();
        log.info("The text '" + text + "' was found");
        return text;
    }

    //This method get the current url
    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        log.info("The " + currentUrl + " URL was found");
        return currentUrl;
    }

    //this method clear the text on text boxes
    protected void clearText(By locator) {
        log.info("The WebElement with the locator " + "'" + locator + "'" + " was found and clear");
        find(locator).clear();
    }

    public void searchItemByText(String text){
        find(By.xpath("//*[contains(text()," + "'" + text + "')]"));
    }

    //waits methods for wrappers
    public WebElement waitForElementVisible(By Locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
    }

    public WebElement waitElementToBeClickable(By Locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(Locator));
    }

    public WebElement waitElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void invisibilityOfElementLocated(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public WebElement waitVisibilityOfElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> visibilityOfAllElementsLocatedBy(By locator){
        return  wait.until((ExpectedConditions.presenceOfAllElementsLocatedBy(locator)));
    }



}
