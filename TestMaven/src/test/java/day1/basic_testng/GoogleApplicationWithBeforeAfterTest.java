package day1.basic_testng;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class GoogleApplicationWithBeforeAfterTest extends SeleniumUtility {
 WebDriver driver;
	@BeforeMethod
	public void startUp() {
		driver= setUp("chrome", "https://www.google.com");
		System.out.println("before method ");
	}
	@Test
	public void testGoogleLanding() {
		String expTitle="Google";
		String actTitlle=getCurrentTitleOfApplication();
		Assert.assertEquals(actTitlle, expTitle);
		
	}
	@Test
	public void testsearch() {
		getActiveElementFromUi().sendKeys("SQL",Keys.ENTER);
		Assert.assertTrue(getCurrentTitleOfApplication().contains("SQL"), "SQL search is failed");
	}
	
	@AfterMethod
	public void tearUp() {
		System.out.println("after method");
		cleanUp();
		
	}
	
}
