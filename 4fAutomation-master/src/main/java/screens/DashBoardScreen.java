package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static utils.ElementAction.clickElement;

public class DashBoardScreen {

    private final AndroidDriver driver;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/action_to_account",
            xpath = "//android.widget.FrameLayout[@resource-id=\"pl.com.fourf.ecommerce:id/action_to_account\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/action_to_account\")")
    private MobileElement accountButton;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/action_to_cart",
            xpath = "//android.widget.FrameLayout[@resource-id=\"pl.com.fourf.ecommerce:id/action_to_cart\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/action_to_cart\")")
    private MobileElement cartButton;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/action_to_wish_list",
            xpath = "//android.widget.FrameLayout[@resource-id=\"pl.com.fourf.ecommerce:id/action_to_wish_list\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/action_to_wish_list\")")
    private MobileElement wishButton;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/action_to_taxonomy",
            xpath = "//android.widget.FrameLayout[@resource-id=\"pl.com.fourf.ecommerce:id/action_to_taxonomy\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/action_to_taxonomy\")")
    private MobileElement searchButton;


    public DashBoardScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
    public void clickAccountButton(int testCaseNumber){
        clickElement(
                accountButton,
                "Successfully clicked on account button!",
                "Account button cannot be located: ",
                testCaseNumber);
    }

    public void clickCartButton(int testCaseNumber) {
        clickElement(
                cartButton,
                "",
                "",
                testCaseNumber);
    }

    public void clickWishButton(int testCaseNumber){
        clickElement(
                wishButton,
                "",
                "",
                testCaseNumber);
    }

    public void clickSearchButton(int testCaseNumber){
        clickElement(
                searchButton,
                "",
                "",
                testCaseNumber);
    }
}
