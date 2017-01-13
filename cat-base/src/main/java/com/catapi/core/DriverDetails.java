package com.catapi.core;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverDetails {

	private String browser;
	private DesiredCapabilities desiredcap;
	private URL driverLocation;

	public DriverDetails(String browser) {

		this.browser = browser;
		this.desiredcap = null;
		this.driverLocation = null;
	}

	public DriverDetails(String browser, DesiredCapabilities desiredcap) {

		this.browser = browser;
		this.desiredcap = desiredcap;
		this.driverLocation = null;
	}

	public DriverDetails(String browser, DesiredCapabilities desiredcap, URL driverLocation) {

		this.browser = browser;
		this.desiredcap = desiredcap;
		this.driverLocation = driverLocation;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public DesiredCapabilities getDesiredcap() {
		return desiredcap;
	}

	public void setDesiredcap(DesiredCapabilities desiredcap) {
		this.desiredcap = desiredcap;
	}

	public URL getDriverLocation() {
		return driverLocation;
	}

	public void setDriverLocation(URL driverLocation) {
		this.driverLocation = driverLocation;
	}

	@Override
	public String toString() {
		return "DriverDetails [browser=" + browser + ", desiredcap=" + desiredcap.toString() + ", driverLocation=" + driverLocation.getPath()
				+ "]";
	}
	
	
	
	

}
