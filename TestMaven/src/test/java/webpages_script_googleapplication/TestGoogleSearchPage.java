package webpages_script_googleapplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;
import webpages_googleaplication.GoogleSearchPage;
import webpages_googleaplication.GoogleSerchResultPage;

public class TestGoogleSearchPage extends SeleniumUtility {
    GoogleSearchPage getGoogleSearchPage;
    GoogleSerchResultPage getGoogleSearchResultPage;
    
    @BeforeTest
    public void startUp() {
    	WebDriver driver=setUp("chrome", "https://www.google.com");
    	getGoogleSearchPage=new GoogleSearchPage(driver);
    	getGoogleSearchResultPage =new GoogleSerchResultPage(driver);
    }
    @Test
    public void testGoogleSearchFunctionality() {
    	getGoogleSearchPage.searchText("SQL");
    	String expTitle="SQL - Google Search";
    	String actTitle=getGoogleSearchResultPage.getSearchPageTitle();
    	Assert.assertEquals(actTitle, expTitle);
    	
    }
    
    @Test
    public void testGoogleSearchSuggestionsCount() {
    	getGoogleSearchPage.searchTextSugg("SQL");
    	
    int actCountOfSuggList=	getGoogleSearchPage.getSugg().size();
    Assert.assertTrue(actCountOfSuggList==10);
    }
	
	
	 @AfterTest 
	 public void ends() {
		 cleanUp();
		 }
	 
	 
}
