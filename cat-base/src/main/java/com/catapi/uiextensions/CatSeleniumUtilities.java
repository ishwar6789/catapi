package com.catapi.uiextensions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class CatSeleniumUtilities extends AbstractWebDriverEventListener {

	
	
	
	
	  	  public void beforeNavigateTo(String url, WebDriver driver) {
		     System.out.println("we are navigating to : " +url);
		  }

		  public void afterNavigateTo(String url, WebDriver driver) {
		    // Do nothing.
		  }

		  public void beforeNavigateBack(WebDriver driver) {
		    // Do nothing.
		  }

		  public void afterNavigateBack(WebDriver driver) {
		    // Do nothing.
		  }

		  public void beforeNavigateForward(WebDriver driver) {
		    // Do nothing.
		  }

		  public void afterNavigateForward(WebDriver driver) {
		    // Do nothing.
		  }

		  public void beforeNavigateRefresh(WebDriver driver) {
		    // Do nothing.
		  }

		  public void afterNavigateRefresh(WebDriver driver) {
		    // Do nothing.
		  }

		  public void beforeFindBy(By by, WebElement element, WebDriver driver) {
			  String ele;
			  if(by == null){ 
				  ele = element.toString();
			  }else{ele = by.toString();}
		   //  System.out.println("we are trying to find "+ele);
		  }

		  public void afterFindBy(By by, WebElement element, WebDriver driver) {
		    // Do nothing.
		  }

		  public void beforeClickOn(WebElement element, WebDriver driver) {
		    // Do nothing.
		  }

		  public void afterClickOn(WebElement element, WebDriver driver) {
		    // Do nothing.
		  }

		  public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		    // Do nothing.
		  }

		  public void afterChangeValueOf(WebElement element, WebDriver driver) {
		    // Do nothing.
		  }

		  public void beforeScript(String script, WebDriver driver) {
		    System.out.println("Script Executed :"+script);
		  }

		  public void afterScript(String script, WebDriver driver) {
		    // Do nothing
		  }

		  public void onException(Throwable throwable, WebDriver driver) {
		    // Do nothing
		  }
	
/*		  private static void growlNotification(WebDriver driver, String msg, String header) throws InterruptedException 
	        {
	            
	            js.executeScript("if (!window.jQuery) {var jquery = document.createElement('script'); jquery.type = 'text/javascript';jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';document.getElementsByTagName('head')[0].appendChild(jquery)}");
	            //TODO Add check for existing jQuery on page
	            js.executeScript( "var jq = document.createElement('script'); jq.type = 'text/javascript'; jq.src = '" +
	             "'; document.getElementsByTagName('head')[0].appendChild(jq);" );

	            js.executeScript( "$.getScript(\"" + JGROWL_SCRIPT + "\");" );

	            js.executeScript( "var lnk = document.createElement('link'); lnk.rel = 'stylesheet'; lnk.href = '" +
	            JGROWL_STYLE + "'; lnk.type = 'text/css'; document.getElementsByTagName('head')[0].appendChild(lnk);" );
	            js.executeScript( "$.jGrowl('" + msg + "', { header: '" + header + "' });" );
	        }*/

}
