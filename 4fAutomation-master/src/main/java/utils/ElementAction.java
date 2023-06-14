package utils;

import exceptions.TestFailureException;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import static utils.ColorFormatter.*;

/**
 * This class contains mobile Element actions and log messages
 */
public class ElementAction {

    /**
     * Clicks on the specified mobile element and logs the success message if the element is displayed,
     * otherwise logs the failure message and throws a TestFailureException.
     *
     * @param element     The mobile element to click.
     * @param successMessage  The success message to be logged.
     * @param failMessage     The failure message to be logged in case of element not displayed.
     * @param testCaseNumber  The test case number for identification and error reporting.
     */

    public static void clickElement(MobileElement element, String successMessage, String failMessage, int testCaseNumber) {
        try {
            Thread.sleep(500);

            // Check if the element is displayed
            element.isDisplayed();

            Thread.sleep(500);


            // Click on the element
            element.click();

            Thread.sleep(500);

            // Log the success message
            colorize("\n" + successMessage, greenColor);
        } catch (NoSuchElementException | InterruptedException e) {
            // Log the failure message and throw TestFailureException
            colorize("\n" + failMessage + e.getMessage(), redColor);
            throw new TestFailureException(testCaseNumber);
        }
    }

    public static void checkElementDisplayed(MobileElement elementName, String successMessage, String failMessage, int testCaseNumber) {
        try {
            Thread.sleep(500);

            // Check if the element is displayed
            elementName.isDisplayed();

            // Log the success message
            colorize("\n" + successMessage, greenColor);
        } catch (NoSuchElementException | InterruptedException e) {
            // Log the failure message and throw TestFailureException
            colorize("\n" + failMessage + e.getMessage(), redColor);
            throw new TestFailureException(testCaseNumber);
        }
    }
    public static boolean compareElementText(MobileElement element,String removeUnnecessary, String actualText) throws InterruptedException {
        Thread.sleep(500);

        element.isDisplayed();

        String expectedText = element.getText().replace(removeUnnecessary, "").toLowerCase().trim();

        colorize("\nCOMPARE: \nElement text: " + expectedText + "\nExpected text: " + actualText , orangeColor);
        if (actualText.equals(expectedText)) {
            colorize("\nEQUAL!", greenColor);
            return true;
        }else{
            colorize("\nDIFFERENT!", redColor);
            return false;}

    }
    public static void compareElementTextTest(MobileElement element, String actualText,String removeUnnecessary, int testCaseNumber){
        try {
            Thread.sleep(500);

            element.isDisplayed();

            String expectedText = element.getText().replace(removeUnnecessary, "");

            colorize("\nCOMPARE: \nElement text: " + expectedText + "\nExpected text: " + actualText, orangeColor);
            Assert.assertEquals(actualText, expectedText);
            colorize("\nEQUAL!", boldGreenColor);

        } catch (NoSuchElementException | InterruptedException e) {
            colorize("\nDIFFERENT!\n" + e.getMessage(), redColor);
            throw new TestFailureException(testCaseNumber);

        }
    }
    public static void sendTextToElement(MobileElement element,String textToSend, String successMessage, String failMessage, int testCaseNumber) {
        try {
            Thread.sleep(500);

            // Check if the element is displayed
            element.isDisplayed();

            Thread.sleep(500);

            // Click on the element
            element.sendKeys(textToSend);

            Thread.sleep(500);

            // Log the success message
            colorize("\n" + successMessage, greenColor);
        } catch (NoSuchElementException | InterruptedException e) {
            // Log the failure message and throw TestFailureException
            colorize("\n" + failMessage + e.getMessage(), redColor);
            throw new TestFailureException(testCaseNumber);
        }
    }
    public static String getElementText(MobileElement element, String successMessage, String failMessage, String removeUnnecessary, int testCaseNumber){
        String elementName = "";
        try{
            Thread.sleep(500);

            element.isDisplayed();

            elementName = (element.getText()).replace(removeUnnecessary, "");

            colorize(successMessage + elementName , ColorFormatter.greenColor);
        }catch (NoSuchElementException e){
            ColorFormatter.colorize(failMessage + e.getMessage() ,ColorFormatter.redColor);
            throw new TestFailureException(testCaseNumber);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return elementName;
    }

    }

