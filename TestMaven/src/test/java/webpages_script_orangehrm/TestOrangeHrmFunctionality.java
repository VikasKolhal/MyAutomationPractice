package webpages_script_orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;
import webpages_orangehrm.AddingEmpDetailsPage_OrangeHrm;
import webpages_orangehrm.EmpPersonalDetailsPage_OrangeHrm;
import webpages_orangehrm.HomePageOrangeHrm;
import webpages_orangehrm.LoginPageOrangeHrm;
import webpages_orangehrm.PIM_HomePage_OrangeHrm;

public class TestOrangeHrmFunctionality  extends SeleniumUtility{
	LoginPageOrangeHrm getLoginPageOrangeHrm;
	HomePageOrangeHrm getHomePageOrangeHrm;
	PIM_HomePage_OrangeHrm getPIM_HomePage_OrangeHrm;
	AddingEmpDetailsPage_OrangeHrm getAddingEmpDetailsPage_OrangeHrm;
	EmpPersonalDetailsPage_OrangeHrm getEmpPersonalDetailsPage_OrangeHrm;
	WebDriver driver;
	@BeforeTest
	public void startUp() {
		driver=setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		getLoginPageOrangeHrm=new LoginPageOrangeHrm(driver);
		getHomePageOrangeHrm =new HomePageOrangeHrm(driver);
		getPIM_HomePage_OrangeHrm =new PIM_HomePage_OrangeHrm(driver);
		getAddingEmpDetailsPage_OrangeHrm=new AddingEmpDetailsPage_OrangeHrm(driver);
		getEmpPersonalDetailsPage_OrangeHrm=new EmpPersonalDetailsPage_OrangeHrm(driver);
		 
		 getLoginPageOrangeHrm.loginOrangeHrm("Admin", "admin123");
	}
	@Test(priority=1)
	public void pimCreation() {
		getHomePageOrangeHrm.clickOnPIM();
		getPIM_HomePage_OrangeHrm.clickAddBtn();
		//getPIM_HomePage_OrangeHrm.clickAddBtn();
		getAddingEmpDetailsPage_OrangeHrm.addempDetails("Vikas", "Kolhal", "999");
		getHomePageOrangeHrm.clickOnPIM();
		getPIM_HomePage_OrangeHrm.searchPIM("999");
		
		//getPIM_HomePage_OrangeHrm.getIdtext();
		/*
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//div[text()='999']"))); WebElement id =
		 * driver.findElement(By.xpath("//div[text()='999']"));
		 */
		//String idDetils = id.getText();
		//System.out.println("id details:"+idDetils);
	    Assert.assertEquals(getPIM_HomePage_OrangeHrm.getIdtext(), "999");
		
	}
	@Test(priority=2)
	public void pimModitification() {
		getPIM_HomePage_OrangeHrm.editpim();
		getEmpPersonalDetailsPage_OrangeHrm.editJob();
		getHomePageOrangeHrm.clickOnPIM();
		getPIM_HomePage_OrangeHrm.searchPIM("999");
		
		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//div[div[div[div[text()='999']]]]//div[5]"))); WebElement upadate =
		 * driver.findElement(By.xpath("//div[div[div[div[text()='999']]]]//div[5]"));
		 * 
		 * String detailsOfUpdate = upadate.getText();
		 * System.out.println("updatation details:"+detailsOfUpdate);
		 */
       Assert.assertEquals(getPIM_HomePage_OrangeHrm.getUpdatetext(), "Pre-Sales Coordinator");
  }
	
	@Test(priority=3)
	public void pimDeletaion() {
		getPIM_HomePage_OrangeHrm.deletpim();
		getHomePageOrangeHrm.clickOnPIM();
		getPIM_HomePage_OrangeHrm.searchPIM("999");
		
		
		/*
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//span[text()='No Records Found']"))); WebElement
		 * deleteConfirmation=driver.findElement(By.
		 * xpath("//span[text()='No Records Found']")); String
		 * deleteConfirmationMsg=deleteConfirmation.getText();
		 * System.out.println("delete confiration msg:"+deleteConfirmationMsg);
		 */  
		Assert.assertEquals(getPIM_HomePage_OrangeHrm.getdeleteConfirmationText(), "No Records Found");
		
	}
	}

