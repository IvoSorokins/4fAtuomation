package DataProviders;

import dataobjects.Login;

import org.testng.annotations.DataProvider;

public class InvalidLoginDP {

    @DataProvider(name = "invalid-login")
    public static Object[][] createInvalidLogin(){
        // Test 20 scenarios for invalid email and password
        return new Object[][]{
                {new Login("xoheto3034@ngopycom","Xoheto3034")},    //Email Missing dot
                {new Login("xoheto3034ngopy.com","Xoheto3034!")},   //Email Missing @
                {new Login("xoheto3034@.com","Xoheto3034!")},       //Email Missing domain
                {new Login("xoheto3034@ngopy.","Xoheto3034!")},     //Email Missing top domain
                {new Login("","Xoheto3034!")},                      //Email is Missing
                {new Login("xoheto3034@ngopy.com","Xoheto3034")},   //Password Missing special character
                {new Login("xoheto3034@ngopy.com","Xoheto!")},      //Password Missing numbers
                {new Login("xoheto3034@ngopy.com","")},             //Password Missing
                {new Login("xoheto3034@ngopy.com","xoheto3034!")},  //Password Missing Upper Case letters
                {new Login("xoheto3034@ngopy.com","XOHETO3034!")},  //Password Missing Lower Case Letters
                {new Login("xoheto3034","Xo3034!")},                //Password < 8 characters / Email have only username
                {new Login("xoheto3034@ngopy,com","Xoheto3034")},   //Password Missing special character / Email have Comma instead of dot
                {new Login("xoheto3034@ngopy.can","Xoheto")},       //Password Missing digits, special characters  / Email have Incorrect top domain
                {new Login("3034@ngopy.com","XOHETO!@#$")},         //Password Missing Lower Case letters, numbers / Email Username without letters
                {new Login("xoheto3034@!@#$%^.com","xoheto3034")},  //Password Missing Upper Case letters, special characters / Email have Domain name with special characters only
                {new Login("xoheto3034@ng4opy.com","#$%^&!@#!")},   //Password Missing letters, numbers / Email have Invalid character at middle of domain name
                {new Login("xoheto3034@ngpy.com","XOHETOTBN")},     //Password Missing special characters, numbers, lowercase letters / Email have Domain misses one letter
                {new Login("xoheto3034@ngopy!.com","XOhet")},       //Password < 8 characters, no digits, no special characters / Email have Invalid character at the end of domain name
                {new Login("xoheto3034@ngopy..com","Xo3034!")},      //Password < 8 characters / Email has double dots in domain name
                {new Login("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaa@ngopy.com",
                        "A1!aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                                "aaaaaaaaaaaa")},  // Password/Email more than 256 characters
        };
    }
}

