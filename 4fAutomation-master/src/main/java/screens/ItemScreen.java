package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.clipboard.ClipboardContentType;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import utils.ColorFormatter;
import utils.ElementAction;
import exceptions.TestFailureException;

import static utils.ElementAction.compareElementText;
import static utils.TestParameters.itemsTitle;





public class ItemScreen {
    private final AndroidDriver driver;





    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/product_header_item_name",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/product_header_item_name\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/product_header_item_name\")")
    private MobileElement itemsName;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/product_header_item_buy",
            xpath = "//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/product_header_item_buy\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/product_header_item_buy\")")
    private MobileElement addToCartButton;

    @AndroidFindBy(
            xpath = "//android.view.ViewGroup[@index=\"0\"and @clickable=\"true\"]",
            uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").index(0).clickable(true);")
    private MobileElement chooseFirstSize;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/product_header_item_wish_list",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/product_header_item_wish_list\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/product_header_item_wish_list\")")
    private MobileElement heartButton;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/product_header_item_back",
            xpath = "//android.view.View[@resource-id=\"pl.com.fourf.ecommerce:id/product_header_item_back\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/product_header_item_back\")")
    private MobileElement returnButton;

    @AndroidFindBy(
            xpath = "//android.widget.TextView[@text=\"\uF1E0\"]",
            uiAutomator = "new UiSelector().textContains(\"\uF1E0\")")
    private MobileElement shareButton;

    @AndroidFindBy(
            id = "android:id/chooser_copy_button",
            xpath =  "//android.widget.Button[@resource-id=\"android:id/chooser_copy_button\"]",
            uiAutomator = "new UiSelector().resourceId(\"android:id/chooser_copy_button\")")
    private MobileElement copyButton;

    @AndroidFindBy(
            id = "android:id/content_preview_text",
            xpath = "//android.widget.TextView[@resource-id=\"android:id/content_preview_text\"]",
            uiAutomator = "new UiSelector().resourceId(\"android:id/content_preview_text\")")
    private MobileElement previewShareText;

    @AndroidFindBy(
            xpath = "//android.widget.TextView[@resource-id='android:id/text1' and contains(@text, 'Messages')]",
            uiAutomator = "new UiSelector().textContains(\"Messages\").resourceId(\"android:id/text1\")")
    private MobileElement messageShareWidget;


    public ItemScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void verifyItemAppeared(int testCaseNumber) throws InterruptedException {
        try {
            ElementAction.checkElementDisplayed(
                    itemsName,
                    "Items name located!",
                    "Failed to located items name: ",
                    testCaseNumber);
            if (compareElementText(itemsName,"WOMEN'S CASUAL", itemsTitle)) {
                ColorFormatter.colorize("\nVerified items name! ", ColorFormatter.greenColor);
            } else {
                ColorFormatter.colorize("\nItems name is not what it's supposed to be", ColorFormatter.redColor);
                throw new TestFailureException(testCaseNumber);
            }
        } catch (NoSuchElementException | InterruptedException e) {
            ColorFormatter.colorize("\nItems name not found: " + e.getMessage(), ColorFormatter.redColor);
            throw new TestFailureException(testCaseNumber);
        }
    }

    public void clickAddToYourCartButton(int testCaseNumber) {
        try {
            addToCartButton.isDisplayed();
            addToCartButton.click();
            ColorFormatter.colorize("\nSuccessfully clicked on 'Add to cart' button!", ColorFormatter.greenColor);
        } catch (NoSuchElementException e) {
            ColorFormatter.colorize("\nFailed to click on 'Add to cart' button: " + e.getMessage(), ColorFormatter.redColor);
            throw new TestFailureException(testCaseNumber);
        }
    }

    public void clickFirstSize(int testCaseNumber) {
        try {
            chooseFirstSize.isDisplayed();
            chooseFirstSize.click();
            ColorFormatter.colorize("\nSuccessfully clicked on 'Check your cart' button!", ColorFormatter.greenColor);
        } catch (NoSuchElementException e) {
            ColorFormatter.colorize("\nFailed to click on 'Check your cart' button: " + e.getMessage(), ColorFormatter.redColor);
            throw new TestFailureException(testCaseNumber);
        }
    }

    public void clickHeartButton(int testCaseNumber) {
        try {
            heartButton.isDisplayed();
            heartButton.click();
            ColorFormatter.colorize("\nSuccessfully clicked on heart button!",ColorFormatter.greenColor);
        } catch (NoSuchElementException e) {
            ColorFormatter.colorize("\nFailed to click on heart button: " +e.getMessage(),ColorFormatter.redColor);
            throw new TestFailureException(testCaseNumber);
        }
    }
    public void clickReturnButton(int testCaseNumber){
        try{
            returnButton.isDisplayed();
            returnButton.click();
            ColorFormatter.colorize("\nSuccessfully clicked on 'return' button!",ColorFormatter.greenColor);
        }catch (NoSuchElementException e){
            ColorFormatter.colorize("\nFailed to click on 'return' button: " + e.getMessage(),ColorFormatter.redColor);
            throw new TestFailureException(testCaseNumber);
        }
    }
    public void verifyTitleName(int testCaseNumber, String itemWishListTitle) {
        String actualTitle = itemsName.getText();

        if ((itemWishListTitle.toUpperCase()).equals(actualTitle)) {
            ColorFormatter.colorize("\nTitle matches the expected value: " + actualTitle , ColorFormatter.greenColor);
        } else {
            ColorFormatter.colorize("\nTitle does not match the expected value. Actual title: " + actualTitle + "  Wishlist title: " + itemWishListTitle.toUpperCase() , ColorFormatter.redColor);
            throw new TestFailureException(testCaseNumber);
        }
    }
    public void clickShareButton(int testCaseNumber){
        try{
            shareButton.isDisplayed();
            shareButton.click();
            ColorFormatter.colorize("\nSuccessfully clicked on 'Share' button!",ColorFormatter.greenColor);
        }catch (NoSuchElementException e){
            ColorFormatter.colorize("\nFailed to click on 'Share' button: " + e.getMessage() , ColorFormatter.redColor);
            throw new TestFailureException(testCaseNumber);
        }
    }
    public void clickCopyButton(int testCaseNumber){
        try{
            copyButton.isDisplayed();
            copyButton.click();
            ColorFormatter.colorize("\nSuccessfully clicked on 'Copy' button!", ColorFormatter.greenColor);
        }catch (NoSuchElementException e){
            ColorFormatter.colorize("\nFailed to click on 'Copy' button: " + e.getMessage() ,ColorFormatter.redColor);
            throw new TestFailureException(testCaseNumber);
        }
    }
    public void verifyLink(int testCaseNumber){
        try{
            String copiedLink = driver.getClipboard(ClipboardContentType.PLAINTEXT);
            String previewLink = (previewShareText.getText()).replace("See it on 4F: ", "");
            ColorFormatter.colorize("\nComparing links!", ColorFormatter.orangeColor);
            if(copiedLink.equals(previewLink)){
                    ColorFormatter.colorize("\nLink copied successfully!", ColorFormatter.greenColor);
            }else{
                ColorFormatter.colorize("\nCopied link doesn't match! \nCopy: " + copiedLink + "\nShould look like this: " + previewLink, ColorFormatter.redColor);
                throw new TestFailureException(testCaseNumber);
            }

        }catch (NoSuchElementException e){
            ColorFormatter.colorize("\nFailed to locate compare links: " + e.getMessage(), ColorFormatter.redColor);
            throw new TestFailureException(testCaseNumber);
        }
    }
    public String getPreviewLink(int testCaseNumber){
        String previewLink = "";
        try{
           previewLink =  (previewShareText.getText()).replace("See it on 4F: ", "");
           ColorFormatter.colorize("\nSuccessfully saved preview link: " + previewLink + " !", ColorFormatter.greenColor);
        }catch (NoSuchElementException e) {
            ColorFormatter.colorize("\nFailed to save preview link: " +e.getMessage() ,ColorFormatter.redColor);
        }
        return previewLink;
    }
    public void clickShareMessage(int testCaseNumber){
        try{
            messageShareWidget.isDisplayed();
            messageShareWidget.click();
            ColorFormatter.colorize("\nSuccessfully clicked on 'Messages' button!" , ColorFormatter.greenColor);
        }catch (NoSuchElementException e){
            ColorFormatter.colorize("\nFailed to click on 'Messages' button: " + e.getMessage() , ColorFormatter.redColor);
            throw new TestFailureException(testCaseNumber);
        }
    }

}
