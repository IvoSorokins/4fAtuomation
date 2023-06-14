package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import utils.ColorFormatter;
import exceptions.TestFailureException;
import utils.TestParameters;

import static utils.ElementAction.*;

public class LogInScreen {
    private final AndroidDriver driver;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/login_title",
            xpath = "//android.widget.TextView[@text=\"Let’s start!\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/login_title\")")
    private MobileElement verifyLogInWidget;

    @AndroidFindBy(
            xpath = "//android.widget.TextView[@text=\"Join now\"]",
            uiAutomator = "new UiSelector().textStartsWith(\"Join now\")")
    private MobileElement joinNowButton;

    @AndroidFindBy(
            xpath = "//android.widget.EditText[@text=\"E-mail address\"]",
            uiAutomator = "new UiSelector().textStartsWith(\"E-mail address\")")
    private MobileElement emailBox;

    @AndroidFindBy(
            xpath = "//android.widget.EditText[@text=\"Password\"]",
            uiAutomator = "new UiSelector().textStartsWith(\"Password\")")
    private MobileElement passwordBox;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/login_sign_in",
            xpath = "//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/login_sign_in\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/login_sign_in\")")
    private MobileElement nextButton;



    public LogInScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
    public void verifyLogInScreen(int testCaseNumber){
        checkElementDisplayed(
                verifyLogInWidget,
                "'Log in' screen appeared!",
                "'Log in' screen did not appear: ",
                testCaseNumber);
    }
    public void clickJoinNow(int testCaseNumber) {
            clickElement(
                    joinNowButton,
                    "'Join now' button clicked!",
                    "'Join now' button cannot be located: ",
                    testCaseNumber);
    }
    public void enterEmail(int testCaseNumber) {
            sendTextToElement(
                    emailBox,
                    TestParameters.TempEmail,
                    "Successfully entered email!",
                    "Failed to enter email: ",
                    testCaseNumber);

    }
    public void enterPassword(int testCaseNumber) {
            sendTextToElement(
                    passwordBox,
                    TestParameters.TempPassword,
                    "Password entered successfully!",
                    "Failed to enter password: ",
                    testCaseNumber );
    }
    public void clickNextButton(int testCaseNumber) {
        clickElement(
                nextButton,
                "'Next' button successfully clicked!",
                "Failed to click 'Next' button: ",
                testCaseNumber);
    }


    public void enterInvalidCredentials(String email, String password, int testCaseNumber) {
        try{
            sendTextToElement(
                    emailBox,
                    email,
                    "",
                    "",
                    testCaseNumber);
            sendTextToElement(
                    passwordBox,
                    password,
                    "",
                    "",
                    testCaseNumber);

            clickNextButton(testCaseNumber);

            verifyLogInScreen(testCaseNumber);

            ColorFormatter.colorize("\nCan't login with invalid TestParameters!", ColorFormatter.orangeColor);
            }catch(NoSuchElementException e){
                ColorFormatter.colorize("\nFailed to enter invalid TestParameters: " + e.getMessage(), ColorFormatter.redColor);
                throw new TestFailureException(testCaseNumber);
            }
    }
}
