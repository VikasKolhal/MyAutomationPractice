package webpages_orangehrm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.SeleniumUtility;

public class AddingEmpDetailsPage_OrangeHrm extends SeleniumUtility {
	public AddingEmpDetailsPage_OrangeHrm(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".--name-grouped-field>div:nth-of-type(1)>div:nth-of-type(2)>input")
	private WebElement fName;

	@FindBy(css = ".--name-grouped-field>div:nth-of-type(3)>div:nth-of-type(2)>input")
	private WebElement lName;

	@FindBy(css = ".oxd-grid-2 .oxd-input")
	private WebElement id;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveBtn;
	
	public void addempDetails(String FName,String LName,String IdofEmp) {
		waitForElementToBeClickable(fName);
		typeInput(fName, FName);
		typeInput(lName, LName);
		id.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE),IdofEmp);
		
		wait.until(ExpectedConditions.visibilityOf(saveBtn));
		clickOnElement(saveBtn);
		
	}

}
