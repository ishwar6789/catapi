package endtoendtestsInfoQ;

import org.openqa.selenium.By;

import com.catapi.uiextensions.SeleniumExtensions;

public class InfoqSearch {
	private static final String SEARCH="input.searchInput";
	private static final String SEARCHBUTTON="input#search";
	
	
	public static void searchFor(String value){
		SeleniumExtensions.enterText(By.cssSelector(SEARCH), value);
		SeleniumExtensions.clickAction(By.cssSelector(SEARCHBUTTON));
	}
	
	
	

}
