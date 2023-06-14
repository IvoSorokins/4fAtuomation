package installations;

import exceptions.TestFailureException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static utils.ColorFormatter.*;

/**
 * This class provides a method to uninstall a specified APK package using adb.
 */
public class AppDeletion {

    /**
     * Checks if the specified package is installed on the device.
     *
     * @param testCaseNumber represents test case number for identification and error reporting
     */
    public void isPackageInstalled(int testCaseNumber) {

        try {
            // Executes the command in adb using Runtime
            Process p = Runtime.getRuntime().exec("adb shell pm list packages pl.com.fourf.ecommerce");

            // Retrieves the input stream of the process to read the command output
            InputStream in = p.getInputStream();

            // Creates a scanner to read the input stream, using the delimiter "\\A" to read the entire stream
            Scanner s = new Scanner(in).useDelimiter("\\A");

            // Reads the output of the command from the scanner and stores it in the 'result' string variable
            String result = s.hasNext() ? s.next() : "";

            // Waits for the process to finish and retrieves the exit value
            int exitValue = p.waitFor();

            // Checks if the exit value is 0, indicating a successful execution of the command
            if (exitValue == 0) {
                // Checks if the result contains the specified package name, indicating that it is installed
                if (result.contains("com.fourf.ecommerce")) {
                    colorize("\nPackage installed successfully.", greenColor);
                } else {
                    colorize("\nPackage installation failed!.", redColor);
                }
            } else {
                // Throws an IOException if the process did not execute successfully, providing the result as an error message
                throw new IOException("Failed to list packages:\n" + result);
            }
        } catch (IOException | InterruptedException e) {
            // Handles any IOException or InterruptedException that may occur and provides an error message
            colorize("\nFailed to check package installation:\n" + e.getMessage(), redColor);
            throw new TestFailureException(testCaseNumber);
        }
    }

    /**
     * Uninstalls the specified package from the device.
     *
     * @param testCaseNumber represents test case number for identification and error reporting
     */
        public void uninstallation(int testCaseNumber) {
        try {
            // Uninstall the specified package using adb
            Runtime.getRuntime().exec("adb uninstall pl.com.fourf.ecommerce");

            // If the app is successfully uninstalled, print a success message
            colorize("\nApp uninstalled successfully!", greenColor);

        } catch (IOException e) {
            // Handles IOException and provides an error message with specific details
            colorize("\nApp is not uninstalled!\n" + e.getMessage() , redColor);
            throw new TestFailureException(testCaseNumber);
        }
    }
}

