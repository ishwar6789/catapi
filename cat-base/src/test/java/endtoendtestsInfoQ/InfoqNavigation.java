package endtoendtestsInfoQ;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.catapi.core.FrameworkAssignment;
import com.catapi.uiextensions.ClickElement;
import com.catapi.uiextensions.SeleniumExtensions;

public class InfoqNavigation {
	

	static final String STREAMING=".submenu a[title^='Streaming']";
	static final String MACHINNELEARNING=".submenu a[title^='Machine Learning']";
	static final String REACTIVE=".submenu a[title^='Reactive']";
	static final String MICROSERVICES=".submenu a[title^='Microservices']";
	static final String CONTAINERS=".submenu a[title^='Containers']";	

	
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
	
	
	
	
	
	
	
	
	
	
	
	

}
