package com.catapi.uiextensions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.catapi.core.FrameworkAssignment;
import com.catapi.reporting.ReportMethodListener;

public class SeleniumExtensions {
	
	
	public static void logandgrabScreenshot(String message){logMessages(message,true);}
	public static void log(String message){logMessages(message,false);}
	
	static void logMessages(String message, boolean takescreenshot){
		if(takescreenshot){}
		ReportMethodListener.testSteps.add(message);		
	}
		
	/**
	 * 
	 * @param selector
	 * @param timeoutSeconds
	 * @param expectedCondition (@optional)
	 * @return
	 */
	public static WebElement getElement(By selector, int timeoutSeconds, ExpectedCondition<WebElement> expectedCondition){
		if(expectedCondition == null){
			return FrameworkAssignment.getDriver().findElement(selector);
		}else{
			return (WebElement)waitforCondition(expectedCondition,timeoutSeconds);
		}
	}
	
	
	

	public static void navigatetoUrl(String url) {
		log("Navigating to the "+url );
		FrameworkAssignment.getDriver().get(url);
		
	}

	public static void enterText(By by, String value){
		log("Entering value = "+value +" " +" in Locator "+by.toString() );
		FrameworkAssignment.getDriver().findElement(by).sendKeys(value);
	}

	public static void clickAction(By by) {
		log(" Trying to Click on locator "+ by.toString());
		FrameworkAssignment.getDriver().findElement(by).click();
	}

	public static Object waitforCondition(ExpectedCondition<WebElement> ec, int timeoutSeconds) {
		log(" Waiting for "+timeoutSeconds+" sec for the condition "+ ec.toString());
		
		WebDriverWait wD = new WebDriverWait(FrameworkAssignment.getDriver(), timeoutSeconds);
		return wD.until(ec);
	}	
	

	public static void getProperties(By cssSelector) {
		WebElement element=FrameworkAssignment.getDriver().findElement(cssSelector);
		Object results = ((JavascriptExecutor) FrameworkAssignment.getDriver()).executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", element);
		System.out.println("Results: "+results);
		String script = "var s = '';" +
                "var o = getComputedStyle(arguments[0]);" +
                "for(var i = 0; i < o.length; i++){" +
                "s+=o[i] + ':' + o.getPropertyValue(o[i])+';';}" + 
                "return s;";
		
		Object results1 = ((JavascriptExecutor) FrameworkAssignment.getDriver()).executeScript(script, element);
		System.out.println("Results: "+results1);
	}
	
	public static void scrollintoView(By byselector){
		JSExtensions.scrollintoView(byselector);
		
		
	}
	
		
}
