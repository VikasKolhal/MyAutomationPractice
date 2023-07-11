package stepdefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumUtility;
import webpages_actitime.ActitimeHomepage;
import webpages_actitime.ActitimeLoginPage;

public class ActitimeStep_Def extends SeleniumUtility {
	WebDriver driver;
	String username,password;
	ActitimeLoginPage getActitimeLoginPage;
	ActitimeHomepage getActitimeHomepage;
	@Given("^user is alredy having URl as (.+)$")
	public void user_is_alredy_having_url_as(String url) {
		  driver=setUp("chrome", url);
		 getActitimeLoginPage=new ActitimeLoginPage(driver);
		 getActitimeHomepage= new ActitimeHomepage(driver);
	}

	@Given("^also having usename as (.+) and password as (.+) for the application$")
	public void also_having_usename_as_and_password_as_for_the_application(String username,String password) {
		this.username=username;
		this.password=password;
		
	}

	@When("^user enter the username and password And clicks on login button$")
	public void user_enter_the_username_and_password_And_clicks_on_login_button() {
		getActitimeLoginPage.logiActitime(username, password);
		
	}

	

	@Then("^Actitime home page will be displayed with application title as (.+)$")
	public void actitime_home_page_will_be_displayed_with_application_title_as(String title) {
		String actTilte=getActitimeHomepage.titleOfActiTime(title);
		Assert.assertEquals(actTilte, title);
	}

	


}
