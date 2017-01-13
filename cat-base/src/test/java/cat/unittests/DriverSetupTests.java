package cat.unittests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.catapi.core.DriverSetup;

@Test
public class DriverSetupTests {
	DriverSetup driversetup;
	
	@BeforeTest
	public void setup(){
		driversetup=new DriverSetup();
	}	
	
	@AfterTest
	public void cleanup(){
		driversetup=null;
	}
	
	@Test(groups={"functest"})
	public void testChromeDriver(){		
		try{			
			driversetup.setChromeWebDriver();			
			WebDriver driver=new ChromeDriver();
			driver.quit();
			
			Assert.assertNotNull(driver);
			System.out.println("Chrome Driver Started");
		}catch(Exception e){
			System.out.println("Error received now"+e.toString());
			Assert.fail(e.toString());		
		}
	}
	
	@Test(groups={"functest"})
	public void testChromeDriverversion(){		
		try{			
			driversetup.setChromeWebDriver("2.27");			
			WebDriver driver=new ChromeDriver();
			driver.quit();
			
			Assert.assertNotNull(driver);					
		}catch(Exception e){
			System.out.println("Error received now"+e.toString());
			Assert.fail(e.toString());		
		}
	}
	
	
	@Test(groups={"functest"})
	public void testfirefoxDriver(){		
		try{			
			driversetup.setfirefoxWebDriver();		
			WebDriver driver=new FirefoxDriver();
			driver.quit();
			
			Assert.assertNotNull(driver);					
		}catch(Exception e){
			System.out.println("Error received now"+e.toString());
			Assert.fail(e.toString());		
		}
	}
	
	@Test(groups={"functest"})
	public void testfirefoxDriverversion(){		
		try{			
			driversetup.setfirefoxWebDriver("0.11.1");		
			WebDriver driver=new FirefoxDriver();
			driver.quit();
			
			Assert.assertNotNull(driver);					
		}catch(Exception e){
			System.out.println("Error received now"+e.toString());
			Assert.fail(e.toString());		
		}
	}
	
	
	
	
	
	
}
