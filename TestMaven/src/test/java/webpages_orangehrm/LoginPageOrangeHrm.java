package webpages_orangehrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class LoginPageOrangeHrm extends SeleniumUtility {
 public LoginPageOrangeHrm(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }
 @FindBy(name="username")
 private WebElement firstName;
 
 @FindBy(name="password")
 private WebElement lastName;
 
 @FindBy(xpath="//button[@type='submit']")
 private WebElement loginBtn;
 

 public WebElement getFirstName() {
	return firstName;
}


public WebElement getLastName() {
	return lastName;
}


public WebElement getLoginBtn() {
	return loginBtn;
}


public WebElement getForgotpasswordLink() {
	return forgotpasswordLink;
}
@FindBy(css=".orangehrm-login-forgot>p")
 private WebElement forgotpasswordLink;
		 
 
 public void loginOrangeHrm(String input,String password) {
	 typeInput(firstName, input);
	 typeInput(lastName, password);
	 clickOnElement(loginBtn);
	 
 }
}
