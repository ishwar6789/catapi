package endtoendtestsInfoQ;

import org.testng.annotations.BeforeTest;

import com.catapi.core.CatBaseTestCase;
import com.catapi.core.DriverDetails;
import com.catapi.uiextensions.SeleniumExtensions;

public class TestBase extends CatBaseTestCase {

	@Override
	public DriverDetails createBrowser() {
		return new DriverDetails("chrome");
	}
	
	@BeforeTest(alwaysRun=true)
	public void setupTests(){
		System.out.println("ERROR FINDOUT WHY");
		SeleniumExtensions.navigatetoUrl("https://www.infoq.com/");
	}
	
	
	

}
