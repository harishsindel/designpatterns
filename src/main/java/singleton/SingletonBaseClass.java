package singleton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingletonBaseClass {
	private static WebDriver driver = null;
	private static String browserName = "chrome";
	
	public static void init() {
		if(driver == null) {
			if(browserName.equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if(browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
        //maximize window
        driver.manage().window().maximize();

        //add implicit timeout
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static void quit() {
		driver.quit();
		driver = null;
	}
}