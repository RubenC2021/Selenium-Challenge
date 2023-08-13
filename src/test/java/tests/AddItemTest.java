package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.ShopPage;
import utils.CommonMethods;

public class AddItemTest extends BaseTest {


    @Test ()
    public void AddRemoveItemFromCart() {
        HeaderPage headerPage = new HeaderPage(driver);
        ShopPage shopPage = new ShopPage(driver);
        CommonMethods commonMethods = new CommonMethods(driver);
        headerPage.searchItem("Shoes");
        shopPage.sortItemsByText("Price: High to Low");
        shopPage.selectItem();
        shopPage.addItemToCart();
        Assert.assertTrue(commonMethods.isTextPresent("Added to Cart"));
        shopPage.removeItemFromCart();
        Assert.assertTrue(commonMethods.isTextPresent("Your Amazon Cart is empty."));
    }



}