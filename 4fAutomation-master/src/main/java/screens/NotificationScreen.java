package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static utils.ElementAction.checkElementDisplayed;
import static utils.ElementAction.clickElement;

/**
 * This class represents the notification screen.
 */
public class NotificationScreen {


    @AndroidFindBy(
            id = "notification_next",
            xpath = "//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/notification_next\"]",
            uiAutomator = "new UiSelector().text(\"NEXT\")")
    private MobileElement nextButton;


    private final AndroidDriver driver;

    /**
     * Constructs a new instance of the NotificationScreen.
     *
     * @param driver the AndroidDriver instance used for interacting with the screen.
     */
    public NotificationScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    /**
     * Clicks the notification button.
     *
     */

    public void validatedNotificationButton(int testCaseNumber) {
            //Verifying button is on screen
            checkElementDisplayed(
                    nextButton,
                    "Notification button located!",
                    "Notification cannot be located: ",
                    testCaseNumber);
    }

    public void clickNotificationButton(int testCaseNumber) {
            clickElement(
                    nextButton,
                    "Successfully clicked passed Notification Screen!",
                    "Notification screen button 'Next' cannot be located: ",
                    testCaseNumber);

    }

}
