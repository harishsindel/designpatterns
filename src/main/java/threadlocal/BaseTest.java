package threadlocal;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import singleton.SingletonBaseClass;
import utils.ConfigFileReader;

public class BaseTest {
	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	ConfigFileReader configReader = new ConfigFileReader();
	String parallel = configReader.getParallel();
	protected WebDriver driver;


    @BeforeTest
    public void Setup(){
    	if(parallel.equalsIgnoreCase("true")) {
    		driver = BrowserManager.doBrowserSetup();
            //set driver
            threadLocalDriver.set(driver);
            driver = getDriver();
            System.out.println("Before Test Thread ID: "+Thread.currentThread().getId());
            getDriver().get(configReader.getApplicationUrl());
    	} else {
    		SingletonBaseClass.init();
    		driver = SingletonBaseClass.getDriver();
    		driver.get(configReader.getApplicationUrl());
    	}
        //driver = BrowserManager.doBrowserSetup();
        //set driver
        //threadLocalDriver.set(driver);

        //System.out.println("Before Test Thread ID: "+Thread.currentThread().getId());

        //get URL
        ///getDriver().get(configReader.getApplicationUrl());
    }

    //get thread-safe driver
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }


    @AfterTest
    public void tearDown(){
    	if(parallel.equalsIgnoreCase("true")) {
        	driver.quit();
            System.out.println("After Test Thread ID: "+Thread.currentThread().getId());
            threadLocalDriver.remove();
    	}
        //getDriver().quit();

        //System.out.println("After Test Thread ID: "+Thread.currentThread().getId());

        //threadLocalDriver.remove();
    }
    @AfterSuite
	public void tearDownAfterClass() {
    	if(parallel.equalsIgnoreCase("true")) {
        	driver.quit();
            System.out.println("After Test Thread ID: "+Thread.currentThread().getId());
            threadLocalDriver.remove();
    	} else {
		SingletonBaseClass.quit();
    	}
	}
}
