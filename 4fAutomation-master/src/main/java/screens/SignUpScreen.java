package screens;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.ColorFormatter;
import utils.TestParameters;

import static utils.ColorFormatter.colorize;
import static utils.ElementAction.*;


public class SignUpScreen {
    public String tempEmail = TestParameters.unTempEmail; //For creating manual account

    public String tempPassword = TestParameters.unTempPassword;//For creating manual account


    @AndroidFindBy(
            id = "registration_regulations_check",
            xpath = "//android.widget.CheckBox[@resource-id=\"pl.com.fourf.ecommerce:id/registration_regulations_check\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/registration_regulations_check\")")
    private MobileElement Terms;
    @AndroidFindBy(
            xpath = "//android.widget.EditText[@focusable='true' and @long-clickable='true' and not(@password='true')]")
    private static MobileElement Email;

    @AndroidFindBy(
            id = "registration_sign_up",
            xpath = "//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/registration_sign_up\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/registration_sign_up\")")
    private MobileElement createAccountButton;
    @AndroidFindBy(
            xpath = "//android.widget.EditText[@text=\"Password\"]",
            uiAutomator = "new UiSelector().textStartsWith(\"Password\")")
    private static MobileElement Password;

    @AndroidFindBy(
            xpath = "//android.widget.TextView[@text=\"Enter a valid e-mail address\"]",
            uiAutomator = "new UiSelector().textStartsWith(\"Enter a valid e-mail address\")")
    private static MobileElement invalidEmail;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/registration_title",
            xpath = "//android.widget.TextView[@text=\"Create account\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/registration_title\")")
    private MobileElement verifyCreateAccountScreen;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/textinput_error",
            xpath = "//android.widget.TextView[@text=\"This password does not meet the minimum requirements\"]",
            uiAutomator = "new UiSelector().textStartsWith(\"This password does not meet the minimum requirements\")")
    private MobileElement invalidPassword;

    @AndroidFindBy(
            xpath = "//android.widget.TextView[@text=\"Log in\"]",
            uiAutomator = "new UiSelector().textStartsWith(\"Log in\")")
    private MobileElement logInButton;


    private final AndroidDriver driver;

    public SignUpScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void enterCredentials(int testCaseNumber) {
        sendTextToElement(
                Email,
                tempEmail,
                "Email entered successfully!",
                "Failed to enter email: ",
                testCaseNumber);
        sendTextToElement(
                Password,
                tempPassword,
                "Password entered successfully!",
                "Failed to enter email: ",
                testCaseNumber);

        colorize("\nSuccessfully entered TestParameters!", ColorFormatter.greenColor);
    }

    public void AcceptTerms(int testCaseNumber) {
            clickElement(
                    Terms,
                    "'Accept terms' checked!",
                    "'Accept terms' check not located: ",
                    testCaseNumber);
    }

    public void clickCreateAccount(int testCaseNumber) {
        clickElement(
                createAccountButton,
                "'Create account' button clicked!",
                "'Create account' button not located: ",
                testCaseNumber);
    }


    public void verifySignUpScreen(int testCaseNumber) {
            checkElementDisplayed(
                    verifyCreateAccountScreen,
                    "User is navigated to 'Sign up' page!",
                    "User was not navigated to 'Sign up' page: ",
                    testCaseNumber );
    }

    public void navigateToLogIn(int testCaseNumber) {
            clickElement(
                    logInButton,
                    "'Log In' successfully located, clicked!",
                    "Problem locating, clicking on 'Log in': ",
                    testCaseNumber);
    }


    /**
     * For testing invalid TestParameters
     */
    public void fillInvalidEmail(String email, int testCaseNumber) {
            sendTextToElement(
                    Email,
                    email,
                    "",
                    "",
                    testCaseNumber);
            sendTextToElement(
                    Password,
                    tempPassword,
                    "",
                    "",
                    testCaseNumber);

            clickCreateAccount(testCaseNumber);

            checkElementDisplayed(
                    invalidEmail,
                    "No accounts can be created with invalid email!",
                    "Something went wrong when trying to enter invalid email: ",
                    testCaseNumber);
    }


    public void enterInvalidPassword(String password, int testCaseNumber) {
            sendTextToElement(
                    Email,
                    tempEmail,
                    "",
                    "",
                    testCaseNumber);
            sendTextToElement(
                    Password,
                    password,
                    "",
                    "",
                    testCaseNumber);

            clickCreateAccount(testCaseNumber);

            checkElementDisplayed(
                    invalidPassword,
                    "No accounts can be created with invalid Password!",
                    "Something went wrong when trying to create invalid email account: ",
                    testCaseNumber);
    }
}




