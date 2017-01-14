package endtoendtestsInfoQ;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.catapi.core.FrameworkAssignment;
import com.catapi.uiextensions.ClickElement;
import com.catapi.uiextensions.JSExtensions;
import com.catapi.uiextensions.SeleniumExtensions;

public class InfoqNavigation {
	

	static final String STREAMING=".submenuf a[title^='Streaming']";
	static final String MACHINNELEARNING=".submenu a[title^='Machine Learning']";
	static final String REACTIVE=".submenu a[title^='Reactive']";
	static final String MICROSERVICES=".submenu a[title^='Microservices']";
	static final String CONTAINERS=".submenu a[title^='Containers']";	
	static final By FOOTER = By.cssSelector("div.footer");

	
	public static void toLink(String link){
		//SeleniumExtensions.clickAction(By.cssSelector(link));
		//ClickElement.link_btn(By.cssSelector(link));
		
		ClickElement.onObject(By.cssSelector(link));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	ClickElement.link_btn( FrameworkAssignment.getDriver().findElement(By.cssSelector(link)) );
		
		
	}


	public static boolean scrollTo(By eleLocation) {
		JSExtensions.scrollintoView(eleLocation);		
		return SeleniumExtensions.getElement(eleLocation, 30, null).isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
