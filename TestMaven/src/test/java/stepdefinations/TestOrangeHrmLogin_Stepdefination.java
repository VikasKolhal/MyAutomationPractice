package stepdefinations;

//import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

//import com.aventstack.extentreports.util.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumUtility;
import webpages_orangehrm.LoginPageOrangeHrm;

public class TestOrangeHrmLogin_Stepdefination extends SeleniumUtility{
	String appUrl;
	LoginPageOrangeHrm getLoginPageOrangeHrm;
	@Given("user has entered a valid url")
	public void user_has_entered_a_valid_url() {
	    appUrl="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	   
	}

	@When("user has opened chrome browser and entered the URL")
	public void user_has_opened_chrome_browser_and_entered_the_url() {
	   WebDriver driver= setUp("chrome", appUrl);
	   getLoginPageOrangeHrm =new LoginPageOrangeHrm(driver);
	}

	@Then("user should be able to see username input field")
	public void user_should_be_able_to_see_username_input_field() {
	 boolean dispstatus=isElementExist(getLoginPageOrangeHrm.getFirstName());
	 boolean enblestatus =isElementFunctional(getLoginPageOrangeHrm.getFirstName());
	 String actualUsernamePlaceholdername=getAttributeValueFromElement(getLoginPageOrangeHrm.getFirstName(), "placeholder");
	 String expectedUsernamePasswordname="Username1";
	 Assert.assertTrue(dispstatus,"username field is not displayed");
	 Assert.assertTrue(enblestatus,"username filed is not functional");
	 Assert.assertEquals(actualUsernamePlaceholdername, expectedUsernamePasswordname);
	 
	 
	}

	@Then("user should be able to see password input field")
	public void user_should_be_able_to_see_password_input_field() {
	    
	   
	}

	@Then("user should be able to see login button")
	public void user_should_be_able_to_see_login_button() {
	    
	   
	}

	@Then("user should be able to see forrgot your password link")
	public void user_should_be_able_to_see_forrgot_your_password_link() {
	    
	   
	}

}
