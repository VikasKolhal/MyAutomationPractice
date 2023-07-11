package webpages_googleaplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class GoogleSerchResultPage extends SeleniumUtility{
    
	public GoogleSerchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public String getSearchPageTitle() {
		return getCurrentTitleOfApplication();
	}
	
	
}
