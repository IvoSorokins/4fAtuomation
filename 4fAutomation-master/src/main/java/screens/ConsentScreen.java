package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static utils.ElementAction.checkElementDisplayed;
import static utils.ElementAction.clickElement;
public class ConsentScreen {

    private final AndroidDriver driver;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/agreement_title",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/agreement_title\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/agreement_title\")")
    private MobileElement consentVerification;

    @AndroidFindBy(
            xpath = "//android.widget.Button[@text=\"NEXT\"]",
            uiAutomator = "new UiSelector().textStartsWith(\"NEXT\")")
    private MobileElement nextButton;

    public ConsentScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void verifyConsentScreen(int testCaseNumber){
        checkElementDisplayed(
                consentVerification,
                "'Consent' screen appeared!",
                "'Consent' screen did not appear: ",
                testCaseNumber);
    }
    public void clickNextButton(int testCaseNumber) {
        clickElement(
                nextButton,
                "'Consent' screen 'Next' button clicked!",
                "Failed to click 'Consent' screen 'Next' button: ",
                testCaseNumber);
    }
}
