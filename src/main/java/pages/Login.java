package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;

    @FindBy(xpath = "//a[@class='action skip contentarea']/following-sibling::ul//a[contains(text(),'Sign In')]")
    WebElement linkLogin;
    
    @FindBy(xpath = "//a[@class='action skip contentarea']/following-sibling::ul//a[contains(text(),'Create an Account')]")
    WebElement linkCreateAnAccount;

    @FindBy(id = "email")
    WebElement txtEmail;

    @FindBy(id = "pass")
    WebElement txtPassword;

    @FindBy(id = "send2")
    WebElement btnSignIn;
    
    @FindBy(id = "email-error")
    WebElement invalidEmailErrorMessage;
    
    @FindBy(xpath = "//h1[@class='page-title']/span")
    WebElement pageTitle;

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    
  //Click on Create an Account link and validate title
    public String createAnAccount(){
    	linkCreateAnAccount.click();

        return pageTitle.getText();
    }
    
    //Invalid email
    public String loginWithInvalidEmail(String email, String password){
        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSignIn.click();

        return invalidEmailErrorMessage.getText();
    }
}
