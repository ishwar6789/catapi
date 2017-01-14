package com.catapi.uiextensions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.catapi.core.FrameworkAssignment;

public class JSExtensions {
	
	private static final String JSSCROLLHOME = "scrollTo(0,0)";
	
	private static final String newJS="var element = arguments[0] , rect = element.getBoundingClientRect();" + 
			"var winHeight =document.documentElement.clientHeight;" + 
			"var winWidth =document.documentElement.clientWidth;" + 
			"var scrolltoXaxis;" + 
			"var scrolltoYaxis;" + 
			"	if(rect.right >= winWidth ){scrolltoXaxis = rect.right;}" + 
			"	else if(rect.left >0 ){scrolltoXaxis=0;}" + 
			"	else {scrolltoXaxis = rect.left;}" + 
			"	if(rect.bottom >= winHeight ){scrolltoYaxis = rect.bottom;}" + 
			"	else if(rect.top>0){scrolltoYaxis=0;}" + 
			"	else{scrolltoYaxis = rect.top;}	" + 
			"	if(scrolltoXaxis ==0 && scrolltoYaxis == 0){return;}window.scrollTo(scrolltoXaxis, scrolltoYaxis);";
			     
	
	
	
	
	
	
	public static Object jsExecuter(String script, Object... args){
		String forLogging = args.length>=0? "first argument"+ args[0].toString() : "no argument";
		SeleniumExtensions.log(" Executing javascript : " + script+ " parameters : "+ (args.length>=0?args[0].toString():"noarguments"));
		WebDriver driver = FrameworkAssignment.getDriver();
		return ((JavascriptExecutor)driver).executeScript(script, args);
	}
	/*
	driver.execute_script('return document.documentElement.clientHeight')
	driver.execute_script('return document.documentElement.clientWidth')*/
	//element.getBoundingClientRect()
	//window.scrollTo(300, 500);
	
	public static void scrollintoView(By locator){
		
		WebDriver driver = FrameworkAssignment.getDriver();		
		try{
			WebElement ele = driver.findElement(locator);
			jsExecuter(newJS,ele);	
		}
		catch(Exception e){			
			System.out.println(e.toString());
		}
	}
	
	public static void scrolltoHome(){
		WebDriver driver = FrameworkAssignment.getDriver();		
		try{
			jsExecuter(JSSCROLLHOME);	
		}
		catch(Exception e){			
			System.out.println(e.toString());
		}
	}
	
	
	
	
	

}
