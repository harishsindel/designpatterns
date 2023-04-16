package threadlocal;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigFileReader;

public class BrowserManager {
	public static WebDriver doBrowserSetup(){
		ConfigFileReader configReader = new ConfigFileReader();

        WebDriver driver = null;
        String browserName = configReader.getBrowser();
        if (browserName.equalsIgnoreCase("chrome")){
            //steup chrome browser
            WebDriverManager.chromedriver().setup();


            //Add options for --headed or --headless browser launch
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headed");
            
            //initialize driver for chrome
            driver = new ChromeDriver(chromeOptions);

            //maximize window
            driver.manage().window().maximize();

            //add implicit timeout
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }
        return driver;
	}
}
