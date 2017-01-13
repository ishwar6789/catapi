package endtoendtestsInfoQ;

import org.openqa.selenium.By;

import com.catapi.uiextensions.SeleniumExtensions;

public class InfoQLogin {
	private static final String LOGINLINK ="a.login_btn";
	private static final String LOGIN_BTN ="input.submit-login";
	private static final String LOGINUSERNAME ="input#login_username.login_text";
	private static final String LOGINPASSWORD="#login_password";
	
	
	public static void login(final String loginName, final String pass){
		SeleniumExtensions.clickAction(By.cssSelector(LOGINLINK));
		SeleniumExtensions.enterText(By.cssSelector(LOGINUSERNAME), loginName);	
		SeleniumExtensions.enterText(By.cssSelector(LOGINPASSWORD), pass);	
		//SeleniumExtensions.clickAction(By.cssSelector(LOGIN_BTN));
		
	}
	
	
	
	
	

}
