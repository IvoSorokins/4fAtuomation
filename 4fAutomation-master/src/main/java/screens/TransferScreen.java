package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static utils.ElementAction.clickElement;

public class TransferScreen {
    private final AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Skip\"]")
    private MobileElement skipButton;
    public TransferScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
    public void clickSkipButton(int testCaseNumber){
        clickElement(
                skipButton,
                "'Transfer' screen 'Skip' button clicked successfully!",
                "Failed to click on 'Transfer' screen 'Skip' button: ",
                testCaseNumber );
    }
}
