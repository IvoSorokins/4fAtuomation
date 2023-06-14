package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static utils.ElementAction.clickElement;

public class GenderScreen {
    private final AndroidDriver driver;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/gender_skip",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/gender_skip\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/gender_skip\")")
    private MobileElement skipButton;

    public GenderScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
    public void clickSkipButton(int testCaseNumber){
        clickElement(
                skipButton,
                "'Skip' button successfully clicked!",
                "Failed to click 'Skip' button: ",
                testCaseNumber
        );
    }
}
