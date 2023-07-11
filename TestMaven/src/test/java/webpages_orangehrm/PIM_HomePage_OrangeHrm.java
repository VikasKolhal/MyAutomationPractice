package webpages_orangehrm;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.SeleniumUtility;

public class PIM_HomePage_OrangeHrm extends SeleniumUtility {
	public PIM_HomePage_OrangeHrm(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// click on add
	@FindBy(css = ".orangehrm-paper-container>div:nth-of-type(1)>button")
	private WebElement addBtn;

	// enter emp id
	@FindBy(css = ".oxd-form-row>div>div:nth-of-type(2)>div .oxd-input.oxd-input--active")
	private WebElement empIddetails;

	// click on search btn
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchBtn;

	// click on edit
	@FindBy(xpath = "//div[div[div[div[text()='999']]]]/div/div[9]/div/button[2]")
	private WebElement editBtn;

	// click on delete
	@FindBy(css = ".oxd-table-cell-actions>button:nth-of-type(1)>i")
	private WebElement deleteBtn;

	// yes confiramtion popup
	@FindBy(xpath = "//div[@class='orangehrm-modal-footer']/button[2]/i")
	private WebElement deletConfirmaionPopup;
	
	//id details
	@FindBy(xpath="//div[text()='999']")
	private WebElement id;
	
	//update details
	@FindBy(xpath="//div[div[div[div[text()='999']]]]//div[5]")
	private WebElement update;
	
	//delete comfirmation msg
	@FindBy(xpath="//span[text()='No Records Found']")
	private WebElement deleteConfirmationText;
	
	public String getdeleteConfirmationText() {
		wait.until(ExpectedConditions.visibilityOf(deleteConfirmationText));
		return deleteConfirmationText.getText();
	}
	
	public String getIdtext() {
		wait.until(ExpectedConditions.visibilityOf(id));
	return id.getText();
	}
	
	public String getUpdatetext() {
		waitForElementToBeClickable(update);
	return update.getText();
	}
	
	

	
	public void clickAddBtn() {
		clickOnElement(addBtn);
	}
	public void searchPIM(String input) {
		typeInput(empIddetails, input);
		waitForElementToBeClickable(searchBtn);
		clickOnElement(searchBtn);
	}

	public void editpim() {
		wait.until(ExpectedConditions.visibilityOf(deleteBtn));
		try{
			clickOnElement(editBtn);
		}
		catch(StaleElementReferenceException e) {
			clickOnElement(editBtn);
			
		}
	}

	public void deletpim() {
		clickOnElement(deleteBtn);
		waitForElementToBeClickable(deletConfirmaionPopup);
		clickOnElement(deletConfirmaionPopup);
	}

}
