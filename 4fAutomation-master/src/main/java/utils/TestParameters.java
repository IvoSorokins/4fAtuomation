package utils;

/**
 * This class provides TestParameters and file paths used in the test cases.
 */
public class TestParameters {
        public static final int simplicityWaitForElement = 15;
     public static final String

             //Device ID
             deviceId = "emulator-5554",

             // Path of 4F-1.52.apk on your computer
             APK_FILE_PATH = "/Users/ivosorokins/Downloads/files/4F-1.52.apk",


             /*
             !!BEFORE TESTING!!

             For creating Temporary Email for creating test accounts : https://temp-mail.org/en/

              Unregistered Email and password used for registering test cases
              Used for test case 8
              Must contain uppercase, lowercase, number, special character,
              length at least 8
              */
             unTempEmail = "yayol18516@soremap.com",
             unTempPassword = "Hyayol18516!",

             // Used in most test cases where user must be logged in !!Do not change!!
             TempEmail = "xoheto3034@ngopy.com",
             TempPassword = "Xoheto3034!",

             // Used for elements by their name Test Case 16 !!Do not change!!
             searchText = "Dress",

             // Used in test case 20 !!Do not change!!
             itemCategory = "CLOTHING",
             itemsSubCategory = "Pants",
             itemsType = "Lifestyle pants",

             // Used in items title comparison !!Do not change!!
             itemsTitle = "joggers";

}
