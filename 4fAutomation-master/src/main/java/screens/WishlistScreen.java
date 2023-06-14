package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.ColorFormatter;

import static utils.ColorFormatter.colorize;
import static utils.ElementAction.*;

public class WishlistScreen {

    private final AndroidDriver driver;

    private static String itemWishlistTitle ;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/wish_list_product_item_container",
            xpath = "//android.view.ViewGroup[@resource-id=\"pl.com.fourf.ecommerce:id/wish_list_product_item_container\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/wish_list_product_item_container\")")
    private MobileElement itemInCart;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/wish_list_product_item_more_options",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/wish_list_product_item_more_options\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/wish_list_product_item_more_options\")")
    private MobileElement moreOptionsButton;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/wish_list_product_item_remove",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/wish_list_product_item_remove\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/wish_list_product_item_remove\")")
    private MobileElement removeButton;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/wish_list_empty_item_title",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/wish_list_empty_item_title\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/wish_list_empty_item_title\")")
    private MobileElement emptyWishlist;

    @AndroidFindBy(
            xpath = "//android.widget.ImageView[@resource-id=\"pl.com.fourf.ecommerce:id/taxonomy_product_subitem_image\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/taxonomy_product_subitem_image\")")
    private MobileElement chosenForYouItem;

    @AndroidFindBy(
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/taxonomy_product_subitem_title\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/taxonomy_product_subitem_title\")")
    private static MobileElement itemsName;


    public WishlistScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void verifyWishlistNotEmpty(int testCaseNumber) {
        checkElementDisplayed(
                itemInCart,
                "Item in Wishlist located!",
                "No items were located in Wishlist: ",
                testCaseNumber);
    }

    public void verifyWishListEmpty(int testCaseNumber) {
            checkElementDisplayed(
                    emptyWishlist,
                    "Wishlist is empty!",
                    "Failed to empty WishList: ",
                    testCaseNumber);
    }

    public void clickMoreOptionsButton(int testCaseNumber) {
        clickElement(
                moreOptionsButton,
                "Successfully clicked on 'More options' button!",
                "Failed to click 'More options' button: ",
                testCaseNumber);
    }

    public void clickRemoveButton(int testCaseNumber) {
            clickElement(
                    removeButton,
                    "Successfully clicked on 'remove' button!",
                    "Failed to click 'remove' button: ",
                    testCaseNumber);
    }
    public static String getItemsName(int testCaseNumber) {
        itemWishlistTitle = getElementText(
                itemsName,
                "",
                "Failed to get items Title: ",
                "",
                testCaseNumber);

        colorize("\nsuccessfully saved items Title: " +itemWishlistTitle + "!" , ColorFormatter.greenColor);
        return itemWishlistTitle;
    }

    public void clickChosenForYouItem(int testCaseNumber) {
        clickElement(
                chosenForYouItem,
                "Successfully clicked on item from 'Chosen for you section'!",
                "Failed to clicked on item from 'Chosen for you section': ",
                testCaseNumber);

    }
}