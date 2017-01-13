package cat.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.catapi.uiextensions.JSExtensions;
import com.catapi.uiextensions.SeleniumExtensions;

public class JqueryUtilites {	
	// hide an element
	public static void hideElement(By by){
		WebElement ele=SeleniumExtensions.getElement(by, 3, null);
		JSExtensions.jsExecuter("var k=arguments[0]; $(k).hide();", ele);			
	} 

}
