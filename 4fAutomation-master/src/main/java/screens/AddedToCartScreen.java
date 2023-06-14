package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static utils.ElementAction.*;

/**
 * Represents the AddedToCartScreen class.
 * Contains methods to interact with elements on the screen.
 */
public class AddedToCartScreen {

    private final AndroidDriver driver;
    /**
     * Initializes a new instance of the AddedToCartScreen class.
     * @param driver The AndroidDriver instance.
     */
    public AddedToCartScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    // Locators to used find elements on screen
    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/product_add_to_cart_confirm_title",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/product_add_to_cart_confirm_title\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/product_add_to_cart_confirm_title\")"
    ) private MobileElement addedItemScreen;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/product_add_to_cart_confirm_cart",
            xpath = "//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/product_add_to_cart_confirm_cart\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/product_add_to_cart_confirm_cart\")"
    ) private MobileElement checkYourCartButton;

    /**
     * Verifies if the 'Item added to cart' screen is displayed.
     * @param testCaseNumber represents test case number for identification and error reporting.
     */
    public void verifyAddedItemScreen(int testCaseNumber) {
        checkElementDisplayed(
                addedItemScreen,
                "'Item added to cart' screen appeared!",
                "Added item screen did not appear: ",
                testCaseNumber
                );
    }

    /**
     * Verifies that 'Check your cart' button is displayed.
     * Clicks on the 'Check your cart' button.
     * @param testCaseNumber represents test case number for identification and error reporting.
     */
    public void clickCheckYourCartButton(int testCaseNumber) {
        clickElement(
                checkYourCartButton,
                "Successfully clicked on 'Check your cart' button!)",
                "Failed to click on 'Check your cart' button: ",
                testCaseNumber
        );
    }
}
