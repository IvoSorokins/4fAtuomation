package exceptions;

import utils.ColorFormatter;

/**
 * Custom exception class to indicate test case failure
 */
public class TestFailureException extends RuntimeException {

    /**
     * Constructs a TestFailureException with the specified test case number.
     *
     * @param testCaseNumber The number of the test case that failed.
     */
    public TestFailureException(int testCaseNumber) {
        // Calling the superclass constructor with a formatted error message
        super(ColorFormatter.boldRedColor + "Test Case " + testCaseNumber + " FAILED!"  + ColorFormatter.resetColor);
    }
}

