package webpages_actitime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.SeleniumUtility;

public class ActitimeHomepage extends SeleniumUtility {
     public ActitimeHomepage(WebDriver driver) {
    	 PageFactory.initElements(driver, this);
}
     @FindBy(id="logo_aT")
     private WebElement ActitimeLogo;
     
     @FindBy(id="logoutLink")
     private WebElement logoutBtn;
     
     @FindBy(id="container_tasks")
     private WebElement tasksbtn;
     
     
     public String titleOfActiTime(String title1) {
    	 return getCurrentTitleOfApplication(title1);
     }
     public void clickOnTasks() {
    	 wait.until(ExpectedConditions.elementToBeClickable(By.id("container_tasks")));
    	 clickOnElement(tasksbtn);
     }
     
     public boolean checkLogo() {
    	return isElementExist(ActitimeLogo);
     }
     
     public void ClicklogOut() {
    	 clickOnElement(logoutBtn);
     }
}