package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.List;


public class ShopPage extends BasePage {

    //*********Constructor*********
    public ShopPage (WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    By sortDropdown = By.cssSelector(".a-button-text.a-declarative");
    By optsDropdown = By.xpath("//a[@class='a-dropdown-link']");
    By itemsCard = By.cssSelector(".s-product-image-container");
    By sizeDropdown = By.xpath("(//span[@class='a-button-text a-declarative']/span)[1]");
    By addToCartBtn = By.id("add-to-cart-button");
    By sizeOpt = By.cssSelector(".a-dropdown-item.dropdownAvailable");
    By buyNowBtn = By.id("buy-now-button");

    By cartIcon = By.id("nav-cart");

    By shoppingLbl = By.cssSelector(".a-row.sc-cart-header");

    By deleteBtn = By.xpath("//input[@value='Delete']");




    //*********Page Methods*********

    public void sortItemsByText(String triggerItemText){
        click(sortDropdown);
        searchItemByText("Results");
        clickAnyItemFromDropdown(triggerItemText,optsDropdown);
    }

    public void selectItem(){
        searchItemByText("Results");
        List<WebElement> itemsList = findElements(itemsCard);
        for (int i=0; i<itemsList.size();i++){
            if(i==2){
                itemsList.get(i).click();
                break;
            }
        }
    }

    public void addItemToCart(){
        waitForElementVisible(addToCartBtn);
        click(sizeDropdown);
        waitForElementVisible(sizeOpt);
        click(sizeOpt);
        waitForElementVisible(buyNowBtn);
        click(addToCartBtn);
    }

    public void removeItemFromCart(){
        click(cartIcon);
        waitForElementVisible(shoppingLbl);

        click(deleteBtn);

    }









    public void addItemToCart(int itemPosition){

    }


}
