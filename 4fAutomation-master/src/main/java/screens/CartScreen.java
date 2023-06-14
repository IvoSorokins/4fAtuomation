package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static utils.ElementAction.checkElementDisplayed;
import static utils.ElementAction.clickElement;

import static utils.TestParameters.itemsTitle;

public class CartScreen {
    private final AndroidDriver driver;

    @AndroidFindBy(
            uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"" + itemsTitle + "\")")
    private MobileElement findItemInCartByName;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/cart_product_item_more_options",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/cart_product_item_more_options\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/cart_product_item_more_options\")")
    private MobileElement moreOptionsButton;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/cart_product_item_remove",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/cart_product_item_remove\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/cart_product_item_remove\")")
    private MobileElement deleteButton;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/cart_empty_item_title",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/cart_empty_item_title\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/cart_empty_item_title\")")
    private MobileElement cartEmpty;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/cart_product_item_add_wish_list",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/cart_product_item_add_wish_list\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/cart_product_item_add_wish_list\")")
    private MobileElement moveButton;

    public CartScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void verifyItemInCart(int testCaseNumber) {
            checkElementDisplayed(
                    findItemInCartByName,
                    "Item by name of " + itemsTitle + " found in cart!",
                    "Item by name of " + itemsTitle + " not found in cart:" ,
                    testCaseNumber);
    }

    public void clickMoreOptionsButton(int testCaseNumber) {
            clickElement(
                    moreOptionsButton,
                    "Successfully clicked on 'More options' button!",
                    "Failed to click on 'More options' button: ",
                    testCaseNumber);
    }

    public void clickDeleteButton(int testCaseNumber) {
        clickElement(
                deleteButton,
                "Successfully clicked on 'Delete' button",
                "Failed to click on 'Delete' button: ",
                testCaseNumber);
    }

    public void verifyCartEmpty(int testCaseNumber) {
            checkElementDisplayed(
                    cartEmpty,
                    "Cart is empty!",
                    "Cart is not empty: ",
                    testCaseNumber);
    }

    public void moveToWishList(int testCaseNumber) {
        clickElement(
                moveButton,
                "Successfully clicked on 'Move' button!",
                "Failed to click on 'Move' button: ",
                testCaseNumber);
    }
}


