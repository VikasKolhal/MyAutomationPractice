package webpages_actitime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class ActitimeLoginPage extends SeleniumUtility {
     public ActitimeLoginPage(WebDriver driver) {
    	 PageFactory.initElements(driver, this);
     }
     @FindBy(id="username")
     private WebElement userNamInputField;
     
     @FindBy(name="pwd")
     private WebElement passwordInputField;
     
     @FindBy(id="loginButton")
     private WebElement logiBtn;
     
     
     public void logiActitime(String username,String password) {
    	 typeInput(userNamInputField, username);
    	 typeInput(passwordInputField, password);
    	 clickOnElement(logiBtn);
    	 
     }
    
     
    
     }

