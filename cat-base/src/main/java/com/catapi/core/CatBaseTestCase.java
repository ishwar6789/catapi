package com.catapi.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.util.Strings;

import com.catapi.reporting.ReportListen;
import com.catapi.reporting.ReportMethodListener;

import cat.unittests.FrameworkTest;

@Listeners({ReportListen.class,com.catapi.reporting.ReportMethodListener.class})
public abstract class CatBaseTestCase {
	
	protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public abstract DriverDetails createBrowser();
	
	@BeforeTest(alwaysRun = true)
	public void initDriver(Object[] args) {
		// run all the initial methods
		// tod0
		// set driver DriverDetails
		// start off listners
		BrowserFactory bf = new BrowserFactory();
		
		// check user wants to define the Driver details else use gecko driver as default or throw an exception
		DriverDetails dd= createBrowser();
		
		if(Strings.isNullOrEmpty(dd.getBrowser())){
			//call browser factory for gecko throw a warning message though
			bf.getDriver("firefox");
			
		}else{
			//call browser factory
			driver.set(bf.getDriver(dd.getBrowser()));
			FrameworkAssignment fT= new FrameworkAssignment();
			fT.setDriver (driver.get());
			//driver.get().get("http://127.0.0.1:8080/");
			System.out.println(driver.get());
			
			}
		}
	
	
	public WebDriver getDriver() {
		
        WebDriver driver = this.driver.get();
        if (driver == null) {
            throw new RuntimeException("The driver is not instantiated yet");
        }
        return driver;
    }

	@AfterTest(alwaysRun = true)
	public void quitDriver() {
		// clean up
		
		driver.get().quit();
		//driver.set(null);
	}
	
	@BeforeSuite(alwaysRun = true)
	public void setupSuite(){
		//setup reporting+-
		
		System.out.println("BEFORE SUITE");
		
	}
	
	
	@AfterSuite
	public void cleanSuite(){
		//write the reporting 
		
	}
	
	public void logandGrabscreenshot(String message){
		ReportMethodListener.testSteps.add(message);
	}
	

}
