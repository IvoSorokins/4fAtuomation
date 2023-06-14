package installations;

import exceptions.TestFailureException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static utils.ColorFormatter.*;
import static utils.TestParameters.APK_FILE_PATH;


/**
 * This class provides methods for installing and checking the installation of an APK package
 */
public class APKInstallation {

    /**
     * Installs the APK if it is not already installed.
     * If the app is already installed, it prints a message indicating that.
     * If the installation fails, it prints an error message.
     */
    public void installAPK() {
        try {
            // Check if the app is already installed
            if (isPackageInstalled("com.fourf.ecommerce")) {
                colorize("App already installed!\n", orangeColor );
                return;
            }
            // If the app is not installed, install it
            Process p = Runtime.getRuntime().exec("adb install " + APK_FILE_PATH);
            try (Scanner ignored = new Scanner(p.getInputStream()).useDelimiter("\\A")) {
                int exitValue = p.waitFor();
                if (exitValue == 0) {
                    colorize("\nApp installed successfully!\n", greenColor);
                } else {
                    colorize("\nApp is not installed successfully!\n", redColor);

                }
            } catch (InterruptedException e) {
                colorize("\nFailed to install APK: " + e.getMessage(), redColor);
            }
        } catch (IOException | InterruptedException e) {
            colorize("\nFailed to check if package is installed: " + e.getMessage(), redColor);
        }
    }

    /**
     * Checks if a package is installed on the device/emulator.
     *
     * @param packageName the name of the package to check
     * @return true if the package is installed, false otherwise
     * @throws IOException          if an I/O error occurs
     * @throws InterruptedException if the current thread is interrupted while waiting for the process to complete
     */
    public static boolean isPackageInstalled(String packageName) throws IOException, InterruptedException {
        // Executes the command in adb using the Runtime class
        Process p = Runtime.getRuntime().exec("adb shell pm list packages");
        try (InputStream in = p.getInputStream(); Scanner s = new Scanner(in).useDelimiter("\\A")) {
            // Reads the output of the command from the scanner and stores it in the 'result' string variable
            String result = s.hasNext() ? s.next() : "";
            // Waits for the process to finish and retrieves the exit value
            int exitValue = p.waitFor();
            if (exitValue == 0) {
                // Checks if the result contains the specified package name, indicating that it is installed
                return result.contains(packageName);
            } else {
                // Throws an IOException if the process did not execute successfully, providing the result as an error message
                throw new IOException(redColor + "Failed to list packages: " + resetColor + result);
            }
        }
    }

    /**
     * Tests if the app has been downloaded for the test case.
     * If the app is located in the correct directory and on the home screen, it prints a success message.
     * If the app is not located in the correct directory, it prints an error message and throws a TestFailureException.
     *
     * @param testCaseNumber the test case number
     * @throws TestFailureException if the app is not located in the correct directory
     */
    public void testAppDownload(int testCaseNumber) {
        try{
            // Check if the app is installed and located in the correct directory
            isPackageInstalled("com.fourf.ecommerce");
            colorize("\nApp is located in the correct directory!" +
                    "\nApp is located on home screen!\n", greenColor);
        } catch (IOException e) {
            // Handle IOException
            colorize("\nApp is not located in correct directory: " + e.getMessage(), redColor);
            throw new TestFailureException(testCaseNumber);
        } catch (InterruptedException e) {
            // Handle InterruptedException
            colorize("\nInterruptedException occurred: " + e.getMessage(), redColor);
            throw new TestFailureException(testCaseNumber);
        }
    }
}


