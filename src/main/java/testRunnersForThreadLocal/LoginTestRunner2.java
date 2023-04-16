package testRunnersForThreadLocal;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login;
import threadlocal.BaseTest;

public class LoginTestRunner2 extends BaseTest {

    @Test
    public void loginWithInvalidEmailTest() throws IOException, ParseException {
        
        //getDriver().get("https://magento.softwaretestingboard.com/");
        //Login login = new Login(getDriver());
    	Login login = new Login(driver);

        //invalid email and valid pass
        String lblInvalidEmail = login.loginWithInvalidEmail("viva", "123456");
        Assert.assertEquals(lblInvalidEmail, "Please enter a valid email address (Ex: johndoe@domain.com).");
    }
    
    @Test
    public void loginWithInvalidEmailTest1() throws IOException, ParseException {
        
        //getDriver().get("https://magento.softwaretestingboard.com/");
        //Login login = new Login(getDriver());
    	Login login = new Login(driver);

        //invalid email and valid pass
        String lblInvalidEmail = login.loginWithInvalidEmail("vivadgdagdshas", "123456");
        Assert.assertEquals(lblInvalidEmail, "Please enter a valid email address (Ex: johndoe@domain.com).");
    }
}
