package com.catapi.uiextensions;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.catapi.core.FrameworkAssignment;
import com.catapi.reporting.ReportMethodListener;

public class SeleniumExtensions {
	
	
	public static void logandgrabScreenshot(String message){
		try{
		logMessages(message,true);}
		catch(IOException e){}
	}
	public static void log(String message){
			try {
				logMessages(message,false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	static void logMessages(String message, boolean takescreenshot) throws IOException{
		HashMap<String, String> teststeps = new HashMap<>();
		teststeps.put("message", message);
		if(takescreenshot){
			
			WebDriver driver =FrameworkAssignment.getDriver();
			Random random = new Random();
			
			int first = random.ints(1000, 10000000).findAny().getAsInt();
			
			String fileName ="report//resultestCase"+first+".jpg";
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
            FileUtils.copyFile(scrFile, new File(fileName));
            teststeps.put("link", "./resultestCase"+first+".jpg");
            ReportMethodListener.testSteps.add(teststeps);
            return;
		}
		ReportMethodListener.testSteps.add(teststeps);		
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
