package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static utils.ElementAction.*;

public class MessageScreen {
    private final AndroidDriver driver;

    @AndroidFindBy(
            id = "com.google.android.apps.messaging:id/compose_message_text",
            xpath = "//android.widget.EditText[@resource-id=\"com.google.android.apps.messaging:id/compose_message_text\"]",
            uiAutomator = "new UiSelector().resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")
    private MobileElement messageText;

    @AndroidFindBy(
            id = "com.google.android.apps.messaging:id/details_container",
            xpath = "//android.widget.LinearLayout[@resource-id=\"com.google.android.apps.messaging:id/details_container\"]",
            uiAutomator = "new UiSelector().resourceId(\"com.google.android.apps.messaging:id/details_container\")")
    private MobileElement contact;

    public MessageScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void clickContact(int testCaseNumber){
        clickElement(
                contact,
                "Successfully clicked on contact",
                "Failed to click on contact: ",
                testCaseNumber);
    }
    public void compareTextMessage(int testCaseNumber,String actualText){
         compareElementTextTest(
                messageText,
                actualText,
                "",
                testCaseNumber);
    }


}
