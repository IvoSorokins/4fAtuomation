package utils;

import org.testng.Reporter;

/**
 * This class provides ANSI color codes for use in formatting console output in Java.
 */
public class ColorFormatter {

    // ANSI color codes for formatting
    public static final String

            resetColor = "\033[0m", // Used for resting color

            /**
            * Regular color formatting
            */
            orangeColor = "\033[38;2;255;165;0m", // Used to set up orange color
            greenColor = "\u001B[32m", // Used to set up green color
            redColor = "\u001B[31m", // Used to set up red color
            yellowColor = "\u001B[33m", // Used to set up yellow color

            /**
            * Bold color formatting
            */
            boldGreenColor = "\033[1;32m",
            boldRedColor = "\033[1;31m",
            boldYellowColor = "\033[1;33m";

    /**
     * Colorizes the given message with the specified color and logs the formatted message to the test report and
     * prints it to the console.
     *
     * @param message The message to be colorized.
     * @param color   The color to be used for formatting the message.
     */
    public static void colorize(String message, String color) {
        // Take message ,color it, reset color so text that comes after is not colored
        String formattedMessage = color + message + resetColor;

        // Log the formatted message to the TestNG report
        Reporter.log(formattedMessage);

        // Print out message to console
        System.out.println(formattedMessage);
    }
    public static void printTestResult(int testCaseNumber) {
        colorize("\nTest " + testCaseNumber + " Passed!", boldGreenColor);
    }
}


