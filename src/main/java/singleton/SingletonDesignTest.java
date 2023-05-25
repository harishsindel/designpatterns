package singleton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import browserSetup.SingletonBrowserManager;
import utils.ConfigFileReader;

public class SingletonDesignTest {
	WebDriver driver1, driver2;
	ConfigFileReader configReader = new ConfigFileReader();
    String browserName = configReader.getBrowser();
	@BeforeClass
	public void setUp() {
		SingletonBrowserManager.getDriver(browserName);
	}
	
	@Test(priority=1)
	public void testOne() {
		driver1 = SingletonBrowserManager.getDriver(browserName);
		driver1.get("https://bstackdemo.com/");
		Assert.assertEquals(driver1.getTitle(), "StackDemo");
	}
	
	@Test(priority=2)
	public void testTwo() {
		driver2 = SingletonBrowserManager.getDriver(browserName);
		driver2.get("https://bstackdemo.com/");
		WebElement logo = driver2.findElement(By.cssSelector(" a.Navbar_logo__26S5Y"));
		driver2.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(logo.isDisplayed());
	}
	
	@AfterClass
	public void tearDown() {
		SingletonBrowserManager.quit();
	}
}
