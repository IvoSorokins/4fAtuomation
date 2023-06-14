package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static utils.ElementAction.clickElement;

public class MyAccountScreen {

    private final AndroidDriver driver;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/account_log_out",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/account_log_out\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/account_log_out\")")
    private MobileElement logOutButton;

    public MyAccountScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
    public void clickLogOutButton(int testCaseNumber) {
        clickElement(
                logOutButton,
                "'Log out' on Account Screen successfully clicked!",
                "Failed to click 'Log out' button on Account Screen: ",
                testCaseNumber);
    }
}
