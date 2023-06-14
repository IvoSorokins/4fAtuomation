package DataProviders;

import dataobjects.Email;
import org.testng.annotations.DataProvider;

public class InvalidEmailDP {
    @DataProvider(name = "invalid-email")
    public static Object[][] createInvalidEmail() { // xoheto3034@ngopy.com
        return new Object[][]{
                // Test 20 scenarios for invalid email addresses
                {new Email("xoheto3034ngopy.com")},      // Missing "@" symbol
                {new Email("xoheto3034@.com")},          // Missing domain name
                {new Email("xoheto3034@ngopycom")},      // Missing dot in domain name
                {new Email("")},                         // Missing Email
                {new Email("xoheto3034@ngopy.")},        // Empty top domain
                {new Email("xoheto3034@-ngopy.com")},    // Invalid character at the beginning of domain name
                {new Email("@ngopy.com")},               // Missing username
                {new Email("xoheto3034@ngopy-.com")},    // Invalid character at the end of domain name
                {new Email("xoheto3034@ngopy,com")},     // Comma instead of dot
                {new Email("xoheto3034@ngo1py.com")},    // Invalid character at middle of domain name
                {new Email("xoheto3034@ngopy..com")},    // Double dot in domain name
                {new Email("xoheto3034@ngopy.c")},       // Domain name with only one character
                {new Email("xoheto3034@12345.com")},     // Numeric domain name with numbers only
                {new Email("xoheto3034@ngopy.com.")},    // Trailing dot in domain name
                {new Email("xoheto3034@!@#$.com")},      // Domain name with special characters only
                {new Email("xoheto3034@ngop.com")},      // Domain misses one letter
                {new Email("xoheto3034@ngopy.car")},     // Incorrect top domain
                {new Email("xoheto@ngopy.com")},         // Username without numbers
                {new Email("3034@ngopy.com")},           // Username without letters
                {new Email("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaa@ngopy.com")},               // More than 256 characters
        };
    }
}
