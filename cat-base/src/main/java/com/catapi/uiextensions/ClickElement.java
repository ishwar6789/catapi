package com.catapi.uiextensions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClickElement {

	final static String CLICKJS = "arguments[0].click();";

	public static void onObject(Object link) {
		if (link instanceof By) {
			WebElement element =SeleniumExtensions.getElement(null,30 ,ExpectedConditions.elementToBeClickable((By)link));
			clickonElement(element, 3,true);

		} else if (link instanceof WebElement) {
			clickonElement((WebElement)link, 0,true);	
		}
	}

	public static void clickonElement(WebElement element, int retryNum, boolean fallback) {
		try {	
				element.click();
		}catch(UnhandledAlertException | StaleElementReferenceException  e){
			throw e;			
		} catch (Exception e) {
			if (retryNum > 0) {
				retryNum--;
				System.out.println("retry :"+retryNum);
				clickonElement(element, retryNum, fallback);

			} else if (fallback) {
				System.out.println("fallback triggered:"+fallback);
				jsclick(element, retryNum, false);
			}
		}

	}

	private static Object jsclick(WebElement element, int retryNum, boolean b) {
		try {
			return JSExtensions.jsExecuter(CLICKJS, element);
		} catch (Exception e) {
			if (retryNum > 0) {
				retryNum--;
				clickonElement(element, retryNum, false);
			}
		}
		return null;
	}
}
