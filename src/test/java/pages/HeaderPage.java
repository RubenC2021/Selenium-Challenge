package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HeaderPage extends BasePage{

    //*********Constructor*********
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    By customerServiceLbl = By.xpath("//a[text()='Customer Service']");
    By searchBox = By.id("twotabsearchtextbox");
    By searchIcon = By.cssSelector("#nav-search-submit-button");


    //*********Page Methods*********
  public void searchItem(String searchText)  {
        waitForElementVisible(customerServiceLbl);
        type(searchBox,searchText);
        click(searchIcon);
        searchItemByText("Results");

  }
}