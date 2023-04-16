package testRunnersForThreadLocal;


import threadlocal.BaseTest;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login;

import java.io.IOException;

public class LoginTestRunner1 extends BaseTest {

    @Test
    public void loginTest() throws IOException, ParseException {
        //Login login = new Login(getDriver());
    	Login login = new Login(driver);

        //valid email and valid password
        String pageTitle = login.createAnAccount();
        Assert.assertEquals(pageTitle, "Create New Customer Account");

    }

}