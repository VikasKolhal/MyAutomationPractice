package webpages_script_actitime;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;
import webpages_actitime.ActitimeHomepage;
import webpages_actitime.ActitimeLoginPage;

public class TestActitimeFunctionallity extends SeleniumUtility {

	ActitimeHomepage getActitimeHomepage;
	ActitimeLoginPage getActitimeLoginPage;
	
	@BeforeTest
	public void startUp() {
		WebDriver driver=setUp("chrome", "https://demo.actitime.com/login.do");
		getActitimeHomepage=new ActitimeHomepage(driver);
		getActitimeLoginPage =new ActitimeLoginPage(driver);
	}
	@Test
	public void loginActitime() {
		getActitimeLoginPage.logiActitime("admin", "manager");
		
		Assert.assertTrue(getActitimeHomepage.checkLogo());
		
	}
	@Test
	
	public void logoutActitime() {
		getActitimeHomepage.ClicklogOut();
		String expTitle="actiTIME - Login";
		String actTitle=getCurrentTitleOfApplication();
		Assert.assertEquals(actTitle, expTitle);
	}
	@AfterTest
	public void ends() {
		cleanUp();
	}
	
	
	
	
	
}
