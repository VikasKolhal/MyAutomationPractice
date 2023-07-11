package day1.basic_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class OrngeHrm {
	WebDriver driver;
	WebDriverWait wait;
  @Test
  public void a_cratePIM() {
	  SeleniumUtility s1=new SeleniumUtility();
	driver=  s1.setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.findElement(By.name("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin123", Keys.ENTER);
	 wait = new WebDriverWait(driver, 20);
	// click on PIM
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.cssSelector(".oxd-sidepanel-body>ul>li:nth-of-type(2)>a")));
	driver.findElement(By.cssSelector(".oxd-sidepanel-body>ul>li:nth-of-type(2)>a")).click();

	// click on add

	driver.findElement(By.cssSelector(".orangehrm-paper-container>div:nth-of-type(1)>button")).click();

	// enter first name
	wait.until(ExpectedConditions.elementToBeClickable(
			By.cssSelector(".--name-grouped-field>div:nth-of-type(1)>div:nth-of-type(2)>input")));
	driver.findElement(By.cssSelector(".--name-grouped-field>div:nth-of-type(1)>div:nth-of-type(2)>input"))
			.sendKeys("Vikas");

	// enter last name
	driver.findElement(By.cssSelector(".--name-grouped-field>div:nth-of-type(3)>div:nth-of-type(2)>input"))
			.sendKeys("Kolhal");

	WebElement empId = driver.findElement(By.cssSelector(".oxd-grid-2 .oxd-input"));
	empId.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), "999");

	// click on save
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
	driver.findElement(By.xpath("//button[@type='submit']")).click();

	// click on PIM
	driver.findElement(By.cssSelector(".oxd-sidepanel-body>ul>li:nth-of-type(2)>a")).click();

	// click on empId
	driver.findElement(By.cssSelector(".oxd-form-row>div>div:nth-of-type(2)>div .oxd-input.oxd-input--active"))
			.sendKeys("999");

	// click on search
	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
	driver.findElement(By.xpath("//button[@type='submit']")).click();
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='999']")));
	WebElement id = driver.findElement(By.xpath("//div[text()='999']"));
	
	String idDetils = id.getText();
	System.out.println("id details:"+idDetils);
    Assert.assertEquals(idDetils, "999");
  }
  @Test
  public void b_editPIM() {
	  wait = new WebDriverWait(driver, 20);
		// click on edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[div[div[div[text()='999']]]]/div/div[9]/div/button[2]")));
		//driver.findElement(By.xpath("//div[div[div[div[text()='999']]]]/div/div[9]/div/button[2]"));
		try{
			driver.findElement(By.xpath("//div[div[div[div[text()='999']]]]/div/div[9]/div/button[2]")).click();
		}
		catch(StaleElementReferenceException e) {
			driver.findElement(By.xpath("//div[div[div[div[text()='999']]]]/div/div[9]/div/button[2]"));
			driver.findElement(By.xpath("//div[div[div[div[text()='999']]]]/div/div[9]/div/button[2]")).click();
		}

		// click on job
		driver.findElement(By.cssSelector(".orangehrm-edit-employee-navigation>div:nth-of-type(2)>div:nth-of-type(6)"))
				.click();

		// click on select job titlr
		driver.findElement(By.cssSelector(
				".oxd-form>div:nth-of-type(1)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)>i"))
				.click();

		// click on Sales Representitive
		driver.findElement(By.cssSelector(".oxd-select-dropdown.--positon-bottom>div:nth-of-type(19)")).click();

		// click on save
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// click on PIM
		driver.findElement(By.cssSelector(".oxd-sidepanel-body>ul>li:nth-of-type(2)>a")).click();

		// click on empId
		driver.findElement(By.cssSelector(".oxd-form-row>div>div:nth-of-type(2)>div .oxd-input.oxd-input--active"))
				.sendKeys("999");

		// click on search
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
      
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[div[div[div[text()='999']]]]//div[5]")));
		WebElement upadate = driver.findElement(By.xpath("//div[div[div[div[text()='999']]]]//div[5]"));

		String detailsOfUpdate = upadate.getText();
		System.out.println("updatation details:"+detailsOfUpdate);
       Assert.assertEquals(detailsOfUpdate, "Sales Representative");
  }
  @Test
  public void c_deletePIM() {
	  wait = new WebDriverWait(driver, 20);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[div[div[text()='999']]]//input")));
			//driver.findElement(By.xpath("//div[div[div[text()='999']]]//input")).click();//click on check box
			// click on delete
			driver.findElement(By.cssSelector(".oxd-table-cell-actions>button:nth-of-type(1)>i"));
			driver.findElement(By.cssSelector(".oxd-table-cell-actions>button:nth-of-type(1)>i")).click();

			// click on yes,d elete
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='orangehrm-modal-footer']/button[2]/i")));
			driver.findElement(By.xpath("//div[@class='orangehrm-modal-footer']/button[2]/i")).click();

			// click on PIM
			driver.findElement(By.cssSelector(".oxd-sidepanel-body>ul>li:nth-of-type(2)>a")).click();

			// click on empId
			driver.findElement(By.cssSelector(".oxd-form-row>div>div:nth-of-type(2)>div .oxd-input.oxd-input--active"))
					.sendKeys("999");

			// click on search
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='No Records Found']")));
			WebElement deleteConfirmation=driver.findElement(By.xpath("//span[text()='No Records Found']"));
			String deleteConfirmationMsg=deleteConfirmation.getText();
			System.out.println("delete confiration msg:"+deleteConfirmationMsg);
           Assert.assertEquals(deleteConfirmationMsg, "No Records Found");
  }
}
