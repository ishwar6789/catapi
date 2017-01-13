package com.catapi.uiextensions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.catapi.core.FrameworkAssignment;

public class JSExtensions {
	
	public static Object jsExecuter(String script, Object... args){
		String forLogging = args.length>=0? "first argument"+ args[0].toString() : "no argument";
		SeleniumExtensions.log(" Executing javascript : " + script+ " parameters : "+ (args.length>=0?args[0].toString():"noarguments"));
		WebDriver driver = FrameworkAssignment.getDriver();
		return ((JavascriptExecutor)driver).executeScript(script, args);
	}

}
