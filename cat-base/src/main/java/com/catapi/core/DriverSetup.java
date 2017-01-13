package com.catapi.core;

import org.apache.commons.lang3.NotImplementedException;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class DriverSetup {

	public void setChromeWebDriver() {
		ChromeDriverManager.getInstance().setup();
		// new ChromeDriver();
	}

	public void setChromeWebDriver(String verorArch) {
		ChromeDriverManager.getInstance().setup(verorArch);
	}

	public void setfirefoxWebDriver() {
		FirefoxDriverManager.getInstance().setup();
	}

	public void setfirefoxWebDriver(String verorArch) {
		FirefoxDriverManager.getInstance().setup(verorArch);
	}

	public void setieWebDriver() {
		InternetExplorerDriverManager.getInstance().setup();
	}

	public void setieWedDriver(String verorArch) {
		InternetExplorerDriverManager.getInstance().setup(verorArch);
	}

	public void setedgeWebDriver() {
		EdgeDriverManager.getInstance().setup();
	}

	public void setedgeWedDriver(String verorArch) {
		EdgeDriverManager.getInstance().setup(verorArch);
	}

	public void setinternetExplorerWebBrowser() {
		// TODO Auto-generated method stub
		throw new NotImplementedException("IE Driver not implemented");
		
	}

	
	
	////To do ///
	// we need to refactor this class one or two methods should be able to do this job
	//need to implement all the browsers 
	
	
	
}
