package testRunnersForThreadLocal;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import browserSetup.BaseTest;
import pages.Login;

public class LoginTestRunner2 extends BaseTest {

    @Test
    public void loginWithInvalidEmailTest() throws IOException, ParseException {
        
        //Login login = new Login(getDriver());
    	Login login = new Login(driver);

        //invalid email and valid pass
        String lblInvalidEmail = login.loginWithInvalidEmail("viva", "123456");
        Assert.assertEquals(lblInvalidEmail, "Please enter a valid email address (Ex: johndoe@domain.com).");
    }
    
    @Test
    public void loginWithInvalidEmailTest1() throws IOException, ParseException {
        //Login login = new Login(getDriver());
    	Login login = new Login(driver);

        //invalid email and valid pass
        String lblInvalidEmail = login.loginWithInvalidEmail("vivadgd@agd", "123456");
        Assert.assertEquals(lblInvalidEmail, "Please enter a valid email address (Ex: johndoe@domain.com).");
    }
}
