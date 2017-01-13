package cat.unittests;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.catapi.core.CatBaseTestCase;
import com.catapi.core.DriverDetails;
import com.catapi.uiextensions.SeleniumExtensions;

@Test
public class BrowserFactoryTest extends CatBaseTestCase {

	@Override
	public DriverDetails createBrowser() {
		// 
		return new DriverDetails("chrome");
	}
	
	@Test(groups = { "functest1","factory123" })
	public void factory() throws InterruptedException{
		
		System.out.println("Testing I am not going to battery plant");
		SeleniumExtensions.navigatetoUrl("https://www.facebook.com/");
		
		SeleniumExtensions.enterText(By.cssSelector("input[name='firstname']"), "harika");
		//name="lastname"
		SeleniumExtensions.enterText(By.cssSelector("input[name='lastname']"), "casimkot");
		
		SeleniumExtensions.enterText(By.cssSelector("input[name='reg_email__']"), "casimkot"+new Random().nextInt()+"@mailinator.com");
		//name="reg_email__"
		//name="websubmit"
		
		SeleniumExtensions.clickAction(By.cssSelector("button[name='websubmit']"));
		Thread.sleep(100);
		
		//reg_email_confirmation__ 	
		SeleniumExtensions.getProperties(By.cssSelector("input[name='reg_email_confirmation__']"));
		
		Thread.sleep(1000);
		
		
		
	}
	
	

}
