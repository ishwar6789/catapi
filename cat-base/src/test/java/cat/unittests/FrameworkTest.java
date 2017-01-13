package cat.unittests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.catapi.core.FrameworkAssignment;

@Test
public class FrameworkTest {

	@Test(groups = { "functest1" })
	public void webdriverTest() {
		try {
			/*FrameworkAssignment fa = new FrameworkAssignment();
			fa.initializeSuite();
			
			Assert.assertNotNull(fa.getDriver());
			Assert.assertTrue(fa.getDriver() instanceof WebDriver);
			
			fa.getDriver().quit();*/
		} catch (Exception e) {
			Assert.fail("Test Failed ", e);
		}
	}
}
