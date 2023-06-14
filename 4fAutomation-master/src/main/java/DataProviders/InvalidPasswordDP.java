package DataProviders;


import dataobjects.Password;
import org.testng.annotations.DataProvider;

public class InvalidPasswordDP {

    @DataProvider(name = "invalid-password")
    public static Object[][] createInvalidPassword() {
        return new Object[][]{
                // Test 20 scenarios for invalid password
                {new Password("abcd")},         //< 8 characters, no upper case letters, no digits, no special characters
                {new Password("QWERT")},        //< 8 characters, no lower case letters, no digits, no special characters
                {new Password("QWERxc")},       //< 8 characters, no digits, no special characters
                {new Password("QWsd12")},       //< 8 characters,no special characters
                {new Password("QWsd12!")},      //< 8 characters
                {new Password("qwertyui")},     //No upper case letters, no digits, no special characters
                {new Password("qwerty123")},    //No upper case letters,no special characters
                {new Password("qwerty!@#")},    ///No upper case letters,no digits
                {new Password("ASDFGHJK")},     //No lower case letters, no digits, no special characters
                {new Password("ZXCVBX986")},    //No lower case letters,no special characters
                {new Password("QWERasdfg")},    //No digits, no special characters
                {new Password("FDWkwe!?")},     //No numbers
                {new Password("qwekwei1932")},  //No special characters
                {new Password("qwekwei1932!")}, //No upper case
                {new Password("ZXCAS1932!")},   //No lower case
                {new Password("!@£$%^&*")},     //No upper,lower case letters, no digits
                {new Password("123456789")},    //No upper,lower case letters, no special characters
                {new Password("@£%^1932!")},    //No upper,lower case letters
                {new Password("")},             //No letters, no numbers, no characters
                {new Password("A1!aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaa")}           //More than 256 characters
        };
    }
}
