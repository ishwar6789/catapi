package com.catapi.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.catapi.uiextensions.CatSeleniumUtilities;

public class FrameworkAssignment {
	
	private static WebDriver driver;
     static	EventFiringWebDriver e_driver;

	public static WebDriver getDriver() {
		return driver;
	}
	
	public static WebDriver getEventFiringDriver(){
		return e_driver;
	}

	public void setDriver(WebDriver _driver) {	
		driver=_driver;
		e_driver = new EventFiringWebDriver(_driver);
		CatSeleniumUtilities eventListener = new CatSeleniumUtilities();
		e_driver.register(eventListener);		
		//driver = e_driver;
	}
	
	

}
