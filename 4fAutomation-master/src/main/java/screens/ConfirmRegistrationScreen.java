package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static utils.ElementAction.*;
import static utils.TestParameters.unTempEmail;


public class ConfirmRegistrationScreen {

    private final AndroidDriver driver;


    @AndroidFindBy(
            id = "confirm_title",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/confirm_title\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/confirm_title\")")
    private MobileElement registrationScreen;

    @AndroidFindBy(
            xpath = "//android.widget.Button[@text=\"CONTINUE\"]",
            uiAutomator = "new UiSelector().textStartsWith(\"CONTINUE\")")
    private MobileElement continueButton;

    @AndroidFindBy(
            id = "confirm_description",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/confirm_description\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/confirm_description\")")
    private MobileElement validateEmail;





    public ConfirmRegistrationScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void confirmRegistrationPage(int testCaseNumber) {
        checkElementDisplayed(
                registrationScreen,
                "'Confirm Registration' screen appeared!",
                "'Confirm Registration' screen did not appear: ",
                testCaseNumber);
    }

    public void visibleContinueButton(int testCaseNumber) {
        checkElementDisplayed(
                continueButton,
                "'Continue' Button located!",
                "'Continue' Button was not located: ",
                testCaseNumber);
    }

    public void clickContinueButton(int testCaseNumber) {
        clickElement(
                continueButton,
                "'Continue' Button clicked!",
                "'Failed to click 'Continue' button: ",
                testCaseNumber);
    }


    public void validateProfileEmail(int testCaseNumber){
        compareElementTextTest(
                validateEmail,
                unTempEmail,
                "click the link sent to your e-mail address: ",
                testCaseNumber);
    }
}




