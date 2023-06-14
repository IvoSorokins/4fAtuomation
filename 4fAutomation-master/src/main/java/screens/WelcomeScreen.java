package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static utils.ElementAction.clickElement;

public class WelcomeScreen {

    @AndroidFindBy(
            id = "onboard_sign_up",
            xpath = "//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/onboard_sign_up\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/onboard_sign_up\")")
    private MobileElement start_SignUpButton;

    @AndroidFindBy(
            id="onboard_login",
            xpath="//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/onboard_login\"]",
            uiAutomator="new UiSelector().textStartsWith(\"LOG IN\")")
    private MobileElement loginButton;

    @AndroidFindBy(
            xpath = "//android.widget.TextView[@text=\"Continue as a guest\"]",
            uiAutomator = "new UiSelector().textStartsWith(\"Continue as a guest\")")
    private MobileElement guestButton;

    private final AndroidDriver driver;

    public WelcomeScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void clickSignUp(int testCaseNumber) {
        clickElement(
                start_SignUpButton,
                "'Sign up' button clicked!",
                "'Sign up' button not located: ",
                testCaseNumber);
    }

    public void clickLogIn(int testCaseNumber){
            clickElement(
                    loginButton,
                    "'Log in ' button clicked!",
                    "'Log in' button not located: ",
                    testCaseNumber);
        }

    public void clickQuest(int testCaseNumber) {
        clickElement(
                guestButton,
                "'Log in as a guest' button clicked!",
                "'Log in as a guest' button not located: ",
                testCaseNumber);
    }
}
