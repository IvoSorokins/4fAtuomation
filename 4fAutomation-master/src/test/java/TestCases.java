import DataProviders.InvalidEmailDP;
import DataProviders.InvalidLoginDP;
import DataProviders.InvalidPasswordDP;
import dataobjects.Email;
import dataobjects.Login;
import dataobjects.Password;
import installations.APKInstallation;
import installations.AppDeletion;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import screens.*;
import utils.TestProperties;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static utils.ColorFormatter.printTestResult;
import static utils.TestParameters.*;


/**
 * The TestCases class represents a collection of test TestCases and setups for a mobile application.
 * It includes methods for installing the app, setting up the test environment, and executing test cases.
 * Each test case is represented by a separate method.
 * <p>
 * The class uses various page objects to interact with different screens of the app.
 * It also initializes the necessary drivers and capabilities for test execution.
 * <p>
 * The TestCases class follows the TestNG framework conventions for test setup and teardown.
 * <p>
 * Usage:
 * 1. Creating an instance's of TestCases class.
 * 2. Call the setUp() method to set up the test environment before each test case.
 * 3. Implement separate methods for each test case, following the TestNG @Test annotation.
 * 4. Use the provided page objects to interact with the app screens during test execution.
 * 5. Use the provided installations and utility methods for app installation and setup.
 * 6. Add documentation and assertions within each test case to ensure test correctness.
 * 7. Optionally, use the TestNG framework annotations to group and configure test cases.
 * <p>
 * Note: This class assumes the usage of Appium and TestNG frameworks for mobile app testing.
 * It also relies on external data objects, page objects, and utility classes for interaction and assertions.
 *
 * @see WelcomeScreen
 * @see SignUpScreen
 * @see LogInScreen
 * @see ConfirmRegistrationScreen
 * @see NotificationScreen
 * @see ConsentScreen
 * @see GenderScreen
 * @see TransferScreen
 * @see GuestScreen
 * @see SearchScreen
 * @see MyAccountScreen
 * @see DashBoardScreen
 * @see ItemScreen
 * @see AddedToCartScreen
 * @see CartScreen
 * @see WishlistScreen
 * @see MessageScreen
 * @see APKInstallation
 * @see AppDeletion
 * @see TestProperties
 */



public class TestCases {

    // Create an instance of the AppDeletion class to handle app deletion operations
    private final AppDeletion appDeletion = new AppDeletion();

    // Create an instance of the APKInstallation class to handle APK installation operations
    private final APKInstallation apkInstallation = new APKInstallation();

    // Create an instance of AndroidDriver with the desired capabilities
    private AndroidDriver driver;

    // Page Objects
    public WelcomeScreen welcomeScreen;
    public SignUpScreen signUpScreen;
    public LogInScreen logInScreen;
    public ConfirmRegistrationScreen confirmRegistrationScreen;
    public NotificationScreen notificationScreen;
    public ConsentScreen consentScreen;
    public GenderScreen genderScreen;
    public TransferScreen transferScreen;
    public GuestScreen guestScreen;
    public SearchScreen searchScreen;
    public MyAccountScreen myAccountScreen;
    public DashBoardScreen dashBoardScreen;
    public ItemScreen itemScreen;
    public AddedToCartScreen addedToCartScreen;
    public CartScreen cartScreen;
    public WishlistScreen wishlistScreen;
    public MessageScreen messageScreen;

    // Holds the number of the test case being executed
    public int testCaseNumber = 0;

    @BeforeClass(description = "Starts the session", groups = "StartUp")
    public void setUpClass() throws IOException {
        // Close System.err to prevent any error messages from being printed to the console
        System.err.close();

        // Set System.err to the default output stream to allow any error messages to be printed to the console again
        System.setErr(System.out);

        // Installs application
        apkInstallation.installAPK();

        // Set the desired capabilities for the test
        DesiredCapabilities desiredCapabilities = TestProperties.setDesiredCapabilities();
        desiredCapabilities.setCapability("appium:udid", deviceId);

        // Add the app capability with the app path or package name
        desiredCapabilities.setCapability("app",  APK_FILE_PATH );

        // Set the remote URL for Appium
        URL remoteUrl = new URL(TestProperties.getProperty("appiumURL"));

        // Create a new AndroidDriver instance with the desired capabilities and remote URL
        //noinspection rawtypes
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        // Set the implicit wait timeout to 15 seconds
        driver.manage().timeouts().implicitlyWait(simplicityWaitForElement, TimeUnit.SECONDS);

        // Initialize the page objects for the different screens of the app
        welcomeScreen = new WelcomeScreen(driver);
        signUpScreen = new SignUpScreen(driver);
        logInScreen = new LogInScreen(driver);
        confirmRegistrationScreen = new ConfirmRegistrationScreen(driver);
        notificationScreen = new NotificationScreen(driver);
        consentScreen = new ConsentScreen(driver);
        genderScreen = new GenderScreen(driver);
        guestScreen = new GuestScreen(driver);
        dashBoardScreen = new DashBoardScreen(driver);
        searchScreen = new SearchScreen(driver);
        myAccountScreen = new MyAccountScreen(driver);
        itemScreen = new ItemScreen(driver);
        transferScreen = new TransferScreen(driver);
        addedToCartScreen = new AddedToCartScreen(driver);
        cartScreen = new CartScreen(driver);
        wishlistScreen = new WishlistScreen(driver);
        messageScreen = new MessageScreen(driver);
    }

    @BeforeGroups(description = "Resets the app before each test group", alwaysRun = true)
    public void setUpMethodGroups(){
        // Reset the app to the initial state before each test
        driver.resetApp();
    }
    @BeforeMethod(description = "Resets the app before each test", alwaysRun = true)
    public void setUpMethod() {
        // Reset the app to the initial state before each test
        driver.resetApp();
    }

    @Test(description = "User installs app from the APK file",
            groups = {"App_Download", "TC1"},
            priority = 1)
    public void appDownload_1() {
        testCaseNumber++;

        apkInstallation.testAppDownload(testCaseNumber);

        printTestResult(testCaseNumber);
    }

    @Test(description = "App works correctly after installation",
            groups = {"App_Download", "TC2"},
            priority = 2)
    public void appDownload_2() {
        testCaseNumber++;

        notificationScreen.validatedNotificationButton(testCaseNumber);
        notificationScreen.clickNotificationButton(testCaseNumber);

        printTestResult(testCaseNumber);
    }

    @Test(description = "App can be uninstalled from the device",
            groups = {"App Uninstallation", "TC3"},
            priority = 3)
    public void appUninstallation_3(){
        testCaseNumber++;

        appDeletion.isPackageInstalled(testCaseNumber);
        appDeletion.uninstallation(testCaseNumber);

        printTestResult(testCaseNumber);

    }

    @Test(description = "User navigates to Registration page through Welcome page",
            groups = {"Account Registration", "TC4"},
            priority = 4)
    public void accountRegistration_4() {
        testCaseNumber++;


        notificationScreen.validatedNotificationButton(testCaseNumber);
        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickSignUp(testCaseNumber);

        signUpScreen.verifySignUpScreen(testCaseNumber);

        printTestResult(testCaseNumber);

    }

    @Test(description = "User navigates to Registration page through Login in page",
            groups = {"Account Registration", "TC5"},
            priority = 5)
    public void accountRegistration_5(){
        testCaseNumber++;

        notificationScreen.validatedNotificationButton(testCaseNumber);
        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.clickJoinNow(testCaseNumber);

        signUpScreen.verifySignUpScreen(testCaseNumber);

        printTestResult(testCaseNumber);
    }

    @Test(description = "User is not able to register Account with invalid Email",
            groups = {"Account Registration", "TC6"},
            dataProviderClass = InvalidEmailDP.class,
            dataProvider = "invalid-email",
            priority = 6)
    public void accountRegistration_6(Email email) {
        testCaseNumber++;

        notificationScreen.validatedNotificationButton(testCaseNumber);
        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickSignUp(testCaseNumber);

        signUpScreen.AcceptTerms(testCaseNumber);
        signUpScreen.fillInvalidEmail(email.getEmail(),testCaseNumber); //Using @DataProvider


        printTestResult(testCaseNumber);
    }


    @Test(description = "User is not able to register Account with invalid password",
            groups ={"Account Registration", "TC7"},
            dataProviderClass = InvalidPasswordDP.class,
            dataProvider = "invalid-password",
            priority = 7)
    public void accountRegistration_7(Password password) {
        testCaseNumber++;

        notificationScreen.validatedNotificationButton(testCaseNumber);
        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickSignUp(testCaseNumber);

        signUpScreen.AcceptTerms(testCaseNumber);
        signUpScreen.enterInvalidPassword(password.getPassword(), testCaseNumber); //Using @DataProvider

        printTestResult(testCaseNumber);
        }


    @Test(description = "User registers new Account",
            groups = {"Account Registration", "TC8"},
            priority = 8)
    public void accountRegistration_8(){
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);
        welcomeScreen.clickSignUp(testCaseNumber);


        signUpScreen.AcceptTerms(testCaseNumber);
        signUpScreen.enterCredentials(testCaseNumber);
        signUpScreen.clickCreateAccount(testCaseNumber);

        //Confirm user is located on Registration page
        confirmRegistrationScreen.confirmRegistrationPage(testCaseNumber);

        //Verify that email was validated
        confirmRegistrationScreen.validateProfileEmail(testCaseNumber);

        //Continue Button
        confirmRegistrationScreen.visibleContinueButton(testCaseNumber);
        confirmRegistrationScreen.clickContinueButton(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @Test(description = "User navigates to Login page through Registration page",
            groups = {"Log in","TC9"},
            priority = 9)
    public void logIn_9(){
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickSignUp(testCaseNumber);

        signUpScreen.navigateToLogIn(testCaseNumber);

        logInScreen.verifyLogInScreen(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @Test(description = "User Logs in with valid TestParameters",
            groups = {"Log in","TC10"},
            priority = 10)
    public void LogIn_10(){
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.enterEmail(testCaseNumber);
        logInScreen.enterPassword(testCaseNumber);
        logInScreen.clickNextButton(testCaseNumber);

        consentScreen.verifyConsentScreen(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @Test(description = "Users can't Log in with Invalid TestParameters",
            groups = {"Log in","TC11"},
            dataProviderClass = InvalidLoginDP.class,
            dataProvider = "invalid-login",
            priority = 11)
    public void LogIn_11(Login login){
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);
        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.enterInvalidCredentials(login.getEmail(),login.getPassword(),testCaseNumber);


        printTestResult(testCaseNumber);
    }

    @Test(description = "User Logs in as quest",
            groups = {"Guest mode","TC12"},
            priority = 12)
    public void questMode_12() {
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickQuest(testCaseNumber);

        dashBoardScreen.clickAccountButton(testCaseNumber);

        guestScreen.verifyGuestAccount(testCaseNumber);

        printTestResult(testCaseNumber);
    }

    @Test(description = "User navigates to sign up page in guest mode",
            groups = {"Guest mode","TC13"},
            priority = 13)
    public void questMode_13(){
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickQuest(testCaseNumber);

        dashBoardScreen.clickAccountButton(testCaseNumber);

        guestScreen.clickGuestSignUpButton(testCaseNumber);

        signUpScreen.verifySignUpScreen(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @Test(description = "User navigates to Login page in guest mode",
            groups = {"Guest mode","TC14"},
            priority = 14)
    public void guestMode_14(){
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickQuest(testCaseNumber);

        dashBoardScreen.clickAccountButton(testCaseNumber);

        guestScreen.clickGuestLogInButton(testCaseNumber);

        logInScreen.verifyLogInScreen(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @Test(description = "User logs out of profile",
            groups = {"Logging out","TC15"},
            priority = 15)
    public void loggingOut_15(){
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);
        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.enterEmail(testCaseNumber);
        logInScreen.enterPassword(testCaseNumber);
        logInScreen.clickNextButton(testCaseNumber);

        consentScreen.clickNextButton(testCaseNumber);

        genderScreen.clickSkipButton(testCaseNumber);

        dashBoardScreen.clickAccountButton(testCaseNumber);

        myAccountScreen.clickLogOutButton(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @Test(description = "User searches for item using search bar",
            groups = {"Search functionality","TC16"},
            priority = 16)
    public void searchFunctionality_16(){// Search item by name
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.enterEmail(testCaseNumber);
        logInScreen.enterPassword(testCaseNumber);
        logInScreen.clickNextButton(testCaseNumber);

        consentScreen.clickNextButton(testCaseNumber);

        genderScreen.clickSkipButton(testCaseNumber);

        dashBoardScreen.clickSearchButton(testCaseNumber);

        transferScreen.clickSkipButton(testCaseNumber);

        searchScreen.enterTextSearchBar(testCaseNumber);
        searchScreen.verifyElementFoundByName(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @Test(description = "User clears search bar by button",
            groups = {"Search functionality","TC17"},
            priority = 17)
    public void searchFunctionality_17() {
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);
        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.enterEmail(testCaseNumber);
        logInScreen.enterPassword(testCaseNumber);
        logInScreen.clickNextButton(testCaseNumber);

        consentScreen.clickNextButton(testCaseNumber);

        genderScreen.clickSkipButton(testCaseNumber);

        dashBoardScreen.clickSearchButton(testCaseNumber);

        transferScreen.clickSkipButton(testCaseNumber);

        searchScreen.enterTextSearchBar(testCaseNumber);
        searchScreen.clearSearchBarByButton(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @Test(description = "User clears search bar by clear",
            groups = {"Search functionality","TC18"},
            priority = 18)
    public void searchFunctionality_18(){
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);
        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.enterEmail(testCaseNumber);
        logInScreen.enterPassword(testCaseNumber);
        logInScreen.clickNextButton(testCaseNumber);

        consentScreen.clickNextButton(testCaseNumber);

        genderScreen.clickSkipButton(testCaseNumber);

        dashBoardScreen.clickSearchButton(testCaseNumber);

        transferScreen.clickSkipButton(testCaseNumber);

        searchScreen.enterTextSearchBar(testCaseNumber);
        searchScreen.clearSearchBarByWidget(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @Test(description = "User navigates to item sub-category",
            groups = {"Item functionality","TC19"},
            priority = 19)
    public void itemFunctionality_19(){
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.enterEmail(testCaseNumber);
        logInScreen.enterPassword(testCaseNumber);

        logInScreen.clickNextButton(testCaseNumber);

        consentScreen.clickNextButton(testCaseNumber);

        genderScreen.clickSkipButton(testCaseNumber);

        dashBoardScreen.clickSearchButton(testCaseNumber);
        transferScreen.clickSkipButton(testCaseNumber);   //!!!!!!!!! Transfers screens

        searchScreen.clickOnCategory(testCaseNumber);
        searchScreen.clickTypeOfItem(testCaseNumber);
        searchScreen.verifySubCategory(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @Test(description = "User navigates to item page from sub-category page",
            groups = {"Item functionality","TC20"},
            priority = 20)
    public void itemFunctionality_20() throws InterruptedException {
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);
        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.enterEmail(testCaseNumber);
        logInScreen.enterPassword(testCaseNumber);

        logInScreen.clickNextButton(testCaseNumber);

        consentScreen.clickNextButton(testCaseNumber);

        genderScreen.clickSkipButton(testCaseNumber);

        dashBoardScreen.clickSearchButton(testCaseNumber);
        transferScreen.clickSkipButton(testCaseNumber);

        searchScreen.clickOnCategory(testCaseNumber);
        searchScreen.clickSubCategoryButton(testCaseNumber);
        searchScreen.clickTypeOfItem(testCaseNumber);
        searchScreen.clickOnItem(testCaseNumber);

        itemScreen.verifyItemAppeared(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @Test(description = "User puts item into cart",
            groups = {"Cart functionality","TC21"},
            priority = 21)
    public void cartFunctionality_21(){
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.enterEmail(testCaseNumber);
        logInScreen.enterPassword(testCaseNumber);
        logInScreen.clickNextButton(testCaseNumber);

        consentScreen.clickNextButton(testCaseNumber);

        genderScreen.clickSkipButton(testCaseNumber);

        dashBoardScreen.clickSearchButton(testCaseNumber);
        transferScreen.clickSkipButton(testCaseNumber);   //!!!!!!!!! Transfers screens

        searchScreen.clickOnCategory(testCaseNumber);
        searchScreen.clickSubCategoryButton(testCaseNumber);
        searchScreen.clickTypeOfItem(testCaseNumber);
        searchScreen.clickOnItem(testCaseNumber);

        itemScreen.clickAddToYourCartButton(testCaseNumber);
        itemScreen.clickFirstSize(testCaseNumber);

        addedToCartScreen.verifyAddedItemScreen(testCaseNumber);
        addedToCartScreen.clickCheckYourCartButton(testCaseNumber);

        cartScreen.verifyItemInCart(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @Test(description = "User removes item from cart",
            groups = {"Cart functionality","TC22"},
            priority = 22)
    public void cartFunctionality_22() {
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);
        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.enterEmail(testCaseNumber);
        logInScreen.enterPassword(testCaseNumber);
        logInScreen.clickNextButton(testCaseNumber);

        consentScreen.clickNextButton(testCaseNumber);

        genderScreen.clickSkipButton(testCaseNumber);

        dashBoardScreen.clickCartButton(testCaseNumber);

        cartScreen.clickMoreOptionsButton(testCaseNumber);
        cartScreen.clickDeleteButton(testCaseNumber);
        cartScreen.verifyCartEmpty(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @Test(description = "User removes item from cart to wishlist",
            groups = {"Cart functionality","TC23"},
            priority = 23)
    public void cartFunctionality_23() {
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.enterEmail(testCaseNumber);
        logInScreen.enterPassword(testCaseNumber);
        logInScreen.clickNextButton(testCaseNumber);

        consentScreen.clickNextButton(testCaseNumber);

        genderScreen.clickSkipButton(testCaseNumber);

        dashBoardScreen.clickSearchButton(testCaseNumber);

        transferScreen.clickSkipButton(testCaseNumber);

        searchScreen.clickOnCategory(testCaseNumber);
        searchScreen.clickSubCategoryButton(testCaseNumber);
        searchScreen.clickTypeOfItem(testCaseNumber);
        searchScreen.clickOnItem(testCaseNumber);

        itemScreen.clickAddToYourCartButton(testCaseNumber);
        itemScreen.clickFirstSize(testCaseNumber);

        addedToCartScreen.verifyAddedItemScreen(testCaseNumber);
        addedToCartScreen.clickCheckYourCartButton(testCaseNumber);

        cartScreen.verifyItemInCart(testCaseNumber);

        //Added item now test case can be automated

        cartScreen.clickMoreOptionsButton(testCaseNumber);
        cartScreen.moveToWishList(testCaseNumber);
        cartScreen.verifyCartEmpty(testCaseNumber);

        dashBoardScreen.clickWishButton(testCaseNumber);

        wishlistScreen.verifyWishlistNotEmpty(testCaseNumber);
        // Verify cart is empty
        dashBoardScreen.clickCartButton(testCaseNumber);

        cartScreen.verifyCartEmpty(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @Test(description = "User removes item from wishlist",
            groups = {"User removes item from wishlist","TC24"},
            priority = 24)
    public void wishListFunctionality_24(){
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.enterEmail(testCaseNumber);
        logInScreen.enterPassword(testCaseNumber);

        logInScreen.clickNextButton(testCaseNumber);

        consentScreen.clickNextButton(testCaseNumber);

        genderScreen.clickSkipButton(testCaseNumber);

        dashBoardScreen.clickWishButton(testCaseNumber);

        wishlistScreen.clickMoreOptionsButton(testCaseNumber);
        wishlistScreen.clickRemoveButton(testCaseNumber);
        wishlistScreen.verifyWishListEmpty(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @Test(description = "User adds item to wishlist from items page by button",
            groups = {"Wish functionality","TC25"},
            priority = 25)
    public void wishListFunctionality_25() {
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.enterEmail(testCaseNumber);
        logInScreen.enterPassword(testCaseNumber);
        logInScreen.clickNextButton(testCaseNumber);

        consentScreen.clickNextButton(testCaseNumber);

        genderScreen.clickSkipButton(testCaseNumber);

        dashBoardScreen.clickSearchButton(testCaseNumber);

        transferScreen.clickSkipButton(testCaseNumber);

        searchScreen.clickOnCategory(testCaseNumber);
        searchScreen.clickSubCategoryButton(testCaseNumber);
        searchScreen.clickTypeOfItem(testCaseNumber);
        searchScreen.clickOnItem(testCaseNumber);

        itemScreen.clickHeartButton(testCaseNumber);
        itemScreen.clickReturnButton(testCaseNumber);

        dashBoardScreen.clickWishButton(testCaseNumber);

        wishlistScreen.verifyWishlistNotEmpty(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @Test(description = "User navigates to item from 'Chosen for you'",
            groups = {"Wishlist functionality","TC26"},
            priority = 26)
    public void wishListFunctionality_26() {
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);
        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.enterEmail(testCaseNumber);
        logInScreen.enterPassword(testCaseNumber);
        logInScreen.clickNextButton(testCaseNumber);

        consentScreen.clickNextButton(testCaseNumber);

        genderScreen.clickSkipButton(testCaseNumber);

        dashBoardScreen.clickWishButton(testCaseNumber);

        String title = WishlistScreen.getItemsName(testCaseNumber); // Stores name of the title from WishList screen
        wishlistScreen.clickChosenForYouItem(testCaseNumber);

        itemScreen.verifyTitleName(testCaseNumber,title); // Verifies stored title with item screen title

        printTestResult(testCaseNumber);
    }
    @Test(description = "User shares item via messages",
            groups = {"Share functionality","TC27"},
            priority = 27)
    public void shareFunctionality_27() {
        String previewLink;

        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.enterEmail(testCaseNumber);
        logInScreen.enterPassword(testCaseNumber);
        logInScreen.clickNextButton(testCaseNumber);

        consentScreen.clickNextButton(testCaseNumber);

        genderScreen.clickSkipButton(testCaseNumber);

        dashBoardScreen.clickSearchButton(testCaseNumber);

        transferScreen.clickSkipButton(testCaseNumber);

        searchScreen.clickOnCategory(testCaseNumber);
        searchScreen.clickSubCategoryButton(testCaseNumber);
        searchScreen.clickTypeOfItem(testCaseNumber);
        searchScreen.clickOnItem(testCaseNumber);

        itemScreen.clickShareButton(testCaseNumber);
        previewLink = itemScreen.getPreviewLink(testCaseNumber);
        itemScreen.clickShareMessage(testCaseNumber);

        messageScreen.clickContact(testCaseNumber);
        messageScreen.compareTextMessage(testCaseNumber,previewLink);

        printTestResult(testCaseNumber);
    }
    @Test(description = "User shares item via copied link",
            groups = {"Share functionality","TC28"},
            priority = 28)
    public void shareFunctionality_28() {
        testCaseNumber++;

        notificationScreen.clickNotificationButton(testCaseNumber);

        welcomeScreen.clickLogIn(testCaseNumber);

        logInScreen.enterEmail(testCaseNumber);
        logInScreen.enterPassword(testCaseNumber);

        logInScreen.clickNextButton(testCaseNumber);

        consentScreen.clickNextButton(testCaseNumber);

        genderScreen.clickSkipButton(testCaseNumber);

        dashBoardScreen.clickSearchButton(testCaseNumber);
        transferScreen.clickSkipButton(testCaseNumber);

        searchScreen.clickOnCategory(testCaseNumber);
        searchScreen.clickSubCategoryButton(testCaseNumber);

        searchScreen.clickTypeOfItem(testCaseNumber);
        searchScreen.clickOnItem(testCaseNumber);

        itemScreen.clickShareButton(testCaseNumber);
        itemScreen.clickCopyButton(testCaseNumber);
        itemScreen.clickShareButton(testCaseNumber);
        itemScreen.getPreviewLink(testCaseNumber);
        itemScreen.verifyLink(testCaseNumber);

        printTestResult(testCaseNumber);
    }
    @AfterClass(description="Runs after each test",
            groups=("CleanUp"),
            alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }

}
