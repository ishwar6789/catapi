package com.catapi.core;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.util.Strings;

public class BrowserFactory {
	private WebDriver driver;
	
	public WebDriver getDriver(String browser){		
		return callDrivers(browser);		
	}
	
	private WebDriver callDrivers(String browser){	
		
		switch (browser.toLowerCase())
		{		
			case "firefox":  new DriverSetup().setfirefoxWebDriver();
							 return new FirefoxDriver(getcapabilites(browser));							
					
			case "chrome":	if(ischromedriverpathSet()){
								return new ChromeDriver(getcapabilites(browser));
							}else{
								new DriverSetup().setChromeWebDriver();
								return new ChromeDriver(getcapabilites(browser));
							}
				
			case "ie":		 new DriverSetup().setinternetExplorerWebBrowser() ;
							 return null;
		
			case "default":  new DriverSetup().setChromeWebDriver();
					         return null;			
		}
		
		return null;		
	}

	private boolean ischromedriverpathSet() {
		if(Strings.isNullOrEmpty(System.getProperty("webdriver.chrome.driver"))){
			return false;
		}		
			return true;
	}

	private DesiredCapabilities getcapabilites(String driverParameter) {
		DesiredCapabilities capabilities = null;
        if (driverParameter.equalsIgnoreCase("FIREFOX")) {
            capabilities = DesiredCapabilities.firefox();
        }
        if (driverParameter.equalsIgnoreCase("IE")) {
            capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        }
        if (driverParameter.equalsIgnoreCase("CHROME")) {
        	capabilities = DesiredCapabilities.chrome();
        	String chromeProfile = "C:\\Users\\HarikaAkshay\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        	ArrayList<String> switches = new ArrayList<String>();
        	switches.add("--user-data-dir=" + chromeProfile);
        	capabilities.setCapability("chrome.switches", switches);
            
        }
        return capabilities;
	}
	
}
