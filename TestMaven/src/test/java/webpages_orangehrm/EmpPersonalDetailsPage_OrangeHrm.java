package webpages_orangehrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class EmpPersonalDetailsPage_OrangeHrm extends SeleniumUtility {
public EmpPersonalDetailsPage_OrangeHrm(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(css=".orangehrm-edit-employee-navigation>div:nth-of-type(2)>div:nth-of-type(6)")
private WebElement jobBtn;

@FindBy(css=".oxd-form>div:nth-of-type(1)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)>i")
private WebElement jobTitle;

@FindBy(css=".oxd-select-dropdown.--positon-bottom>div:nth-of-type(19)")
private WebElement reqJobBtn;

@FindBy(css="button[type='submit']")
private WebElement saveButton;

public void editJob() {
	clickOnElement(jobBtn);
	clickOnElement(jobTitle);
	clickOnElement(reqJobBtn);
	clickOnElement(saveButton);
	
}
}