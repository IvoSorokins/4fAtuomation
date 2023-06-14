package screens;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static utils.ElementAction.*;
import static utils.TestParameters.*;


public class SearchScreen {
    private final AndroidDriver driver;


    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/taxonomy_search",
            xpath = "//android.widget.EditText[@resource-id=\"pl.com.fourf.ecommerce:id/taxonomy_search\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/taxonomy_search\")")
    private MobileElement searchBar;

    @AndroidFindBy(
            uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"" + searchText + "\")")
    private MobileElement findElementByName;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/taxonomy_close_icon",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/taxonomy_close_icon\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/taxonomy_close_icon\")")
    private MobileElement clearButton;

    @AndroidFindBy(
            id = "pl.com.fourf.ecommerce:id/taxonomy_close",
            xpath = "//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/taxonomy_close\"]",
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/taxonomy_close\")")
    private MobileElement clearWidget;

    @AndroidFindBy(
            xpath = "//android.widget.TextView[@text=\"" + itemCategory + "\"]",
            uiAutomator = "new UiSelector().textContains(\"" + itemCategory + "\")")
    private MobileElement chosenCategoryElement;

    @AndroidFindBy(
            xpath = "//android.widget.TextView[@text=\"" + itemsSubCategory + "\"]",
            uiAutomator = "new UiSelector().textContains(\"" + itemsSubCategory + "\")")
    private MobileElement subCatButton;

    @AndroidFindBy(
            xpath = "//android.widget.TextView[@text=\"" + itemsType + "\"]",
            uiAutomator = "new UiSelector().textContains(\"" + itemsType + "\")")
    private MobileElement verifySubCat;

    @AndroidFindBy(
            uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/product_category_small_item_title\").textContains(\"" + itemsTitle + "\")")
    private MobileElement clickOnItem;


    public SearchScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void enterTextSearchBar(int testCaseNumber) {
        sendTextToElement(
                searchBar,
                searchText,
                "Successfully enter text into search bar!\n Search...............",
                "No Elements found using keyword: " + searchText + " ",
                testCaseNumber);
    }

    public void verifyElementFoundByName(int testCaseNumber) {
        checkElementDisplayed(
                findElementByName,
                "Items found by keyword: " + searchText + " clicked!",
                "",
                testCaseNumber);
    }

    public void clearSearchBarByButton(int testCaseNumber) {
        clickElement(
                clearButton,
                "Successfully 'Clear' button clicked!",
                "Failed to click 'Clear' button: ",
                testCaseNumber);

        compareElementTextTest(
                searchBar,
                "",
                "What are you looking for?",
                testCaseNumber);

    }

    public void clearSearchBarByWidget(int testCaseNumber) {
            clickElement(
                    clearWidget,
                    "Successfully clicked 'Clear' widget ",
                    "",
                    testCaseNumber
            );
            compareElementTextTest(
                    searchBar,
                    "What are you looking for?",
                    "",
                    testCaseNumber);
    }
    public void clickOnCategory(int testCaseNumber){
            clickElement(
                    chosenCategoryElement,
                    "Successfully clicked on category!",
                    "Failed to click on chosen category: ",
                    testCaseNumber);
    }
    public void clickSubCategoryButton(int testCaseNumber){
            clickElement(
                    subCatButton,
                    "Clicked on sub-category button successfully!",
                    "Failed to click on chosen sub-category button: ",
                    testCaseNumber);
    }
    public void verifySubCategory(int testCaseNumber){
            checkElementDisplayed(
                    verifySubCat,
                    "Clothing category contains expected sub-category!",
                    "Clothing category doesn't contain expected sub-category: ",
                    testCaseNumber);
    }
    public void clickTypeOfItem(int testCaseNumber){
            clickElement(
                    verifySubCat,
                    "Successfully clicked on type of item!",
                    "Error accord when clicking on SubCategory: ",
                    testCaseNumber);
    }

    public void clickOnItem(int testCaseNumber){
            clickElement(
                    clickOnItem,
                    "Successfully clicked on item!",
                    "Error accord when clicking on Item: ",
                    testCaseNumber);
    }
}


