package webpages_orangehrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.SeleniumUtility;

public class HomePageOrangeHrm extends SeleniumUtility {
   public HomePageOrangeHrm(WebDriver driver) {
	   PageFactory.initElements(driver, this);
   }
   @FindBy(css=".oxd-sidepanel-body>ul>li:nth-of-type(2)>a")
  private WebElement PIMLink;
   
   public void clickOnPIM() {
	   wait.until(ExpectedConditions.visibilityOf(PIMLink));
	   clickOnElement(PIMLink);
   }
}
