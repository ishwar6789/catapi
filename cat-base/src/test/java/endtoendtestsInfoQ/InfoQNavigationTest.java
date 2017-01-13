package endtoendtestsInfoQ;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.catapi.reporting.ReportMethodListener;
import com.catapi.uiextensions.ClickElement;
import com.catapi.uiextensions.SeleniumExtensions;

import cat.utilities.JqueryUtilites;


public class InfoQNavigationTest extends TestBase {
		
	@Test(groups={"infoq","infoq1"},description="navigatieon test class")
	public void navigatetoInfoQ(){		
		System.out.println("NavigationTests");
		InfoqNavigation.toLink(InfoqNavigation.CONTAINERS);
		
		//InfoqNavigation.toLink("failed");
		InfoqNavigation.toLink(InfoqNavigation.MICROSERVICES);
		InfoqNavigation.toLink(InfoqNavigation.REACTIVE);
		InfoqNavigation.toLink(InfoqNavigation.STREAMING);
	}
	@Test(groups={"infoq","infoq1"},description="navigatieon test class")
	public void repeatnavigatetoInfoQ(){		
		System.out.println("NavigationTests");	
		//InfoqNavigation.toLink(InfoqNavigation.CONTAINERS);
		
		//InfoqNavigation.toLink("failed");
		InfoqNavigation.toLink(InfoqNavigation.MICROSERVICES);
		InfoqNavigation.toLink(InfoqNavigation.REACTIVE);
		InfoqNavigation.toLink(InfoqNavigation.STREAMING);
	}
	@Test(groups={"infoq","infoq2"},description="search info test class")
	public void searchInfoQ(){		
		System.out.println("SearchInfoQ");	
		InfoqSearch.searchFor("Docker");
	}
	
	@Test(groups={"infoq","infoq2"},description="loginfo test class")
	public void loginInfoQ(){		
		System.out.println("SearchInfoQ");	
		InfoQLogin.login("username", "pass");
	}
	
	@Test(groups={"infoq","infoq3"})
	public void loginInfoQClickTest() throws InterruptedException{		
		System.out.println("InfoQQuickTest");
		
		JqueryUtilites.hideElement(By.cssSelector("#keyword"));
		//ClickElement.clickonElement(element, retryNum, fallback);
		ClickElement.onObject(By.cssSelector("#keyword"));
		
	}
	
	
	
}
