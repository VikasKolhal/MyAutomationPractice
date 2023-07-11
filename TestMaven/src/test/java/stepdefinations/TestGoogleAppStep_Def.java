package stepdefinations;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumUtility;
import webpages_googleaplication.GoogleSearchPage;
import webpages_googleaplication.GoogleSerchResultPage;

public class TestGoogleAppStep_Def extends SeleniumUtility {
	GoogleSearchPage getGoogleSearchPage;
	GoogleSerchResultPage getGoogleSerchResultPage;

	@Given("^user is alredy in google serch page$")
	public void user_is_alredy_in_google_serch_page() {
     driver=setUp("chrome", "https://www.google.com");
      getGoogleSearchPage =new GoogleSearchPage(driver);
 	 getGoogleSerchResultPage =new GoogleSerchResultPage(driver);
	}

	@When("user types 'SQL'in in search input field and click on search button")
	public void user_types_sql_in_in_search_input_field_and_click_on_search_button() {
		getGoogleSearchPage.searchText("SQL");

	}

	@Then("user gets search result page with the title {string}")
	public void user_gets_search_result_page_with_the_title(String string) {
		Assert.assertEquals(getGoogleSerchResultPage.getSearchPageTitle(), "SQL - Google Search");

	}

	@Then("close the browser")
	public void close_the_browser() {
		cleanUp();

	}
	
	@Given("^user is alredy in google search page$")
	public void user_is_alredy_in_google_search_page() {
		driver=setUp("chrome", "https://www.google.com");
	      getGoogleSearchPage =new GoogleSearchPage(driver);
	 	 getGoogleSerchResultPage =new GoogleSerchResultPage(driver);
	    
	    
	}

	@When("^user types (.+) in search input filed and click on search button$")
	public void user_types_in_search_input_filed_and_click_on_search_button(String textToBeSearched) {
		getGoogleSearchPage.searchText(textToBeSearched);
	    
	}

	@Then("^user gate search result page with the title (.+)$")
	public void user_gate_search_result_page_with_the_title(String expectedTitle) {
		Assert.assertEquals(getGoogleSerchResultPage.getSearchPageTitle(), expectedTitle);
	    
	}

	

}
