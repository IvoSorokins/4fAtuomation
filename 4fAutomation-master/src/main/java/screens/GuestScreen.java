package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static utils.ElementAction.checkElementDisplayed;
import static utils.ElementAction.clickElement;

public class GuestScreen {
    private final AndroidDriver driver;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/account_guest_benefits",
            xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"pl.com.fourf.ecommerce:id/account_guest_benefits\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/account_guest_benefits\")")
    private MobileElement guestVerification;

    @AndroidFindBy(id = "pl.com.fourf.ecommerce:id/account_guest_sign_in", xpath = "//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/account_guest_sign_in\"]", uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/account_guest_sign_in\")" )
    private MobileElement guestLogInButton;

    public GuestScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void verifyGuestAccount(int testCaseNumber){
        checkElementDisplayed(
                guestVerification,
                "Account is in guest mode!",
                "Can't verify that account is in guest mode: ",
                testCaseNumber);
    }
    public void clickGuestSignUpButton(int testCaseNumber){
            clickElement(
                    guestLogInButton,
                    "'Sign up' button in guest mode clicked!",
                    "'Sign up' button in guest mode not located: ",
                    testCaseNumber);
    }
    public void clickGuestLogInButton(int testCaseNumber){
            checkElementDisplayed(
                    guestLogInButton,
                    "'Log In' button in guest mode clicked!",
                    "'Log In' button in guest mode not located: ",
                    testCaseNumber);
    }
}
