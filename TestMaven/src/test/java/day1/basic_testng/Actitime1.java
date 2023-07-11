package day1.basic_testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class Actitime1  {
	WebDriver driver;
	WebDriverWait wait;

	 
 
  @Test
  public void a_loginActitime() {
	
	  SeleniumUtility s1=new SeleniumUtility();
	  driver=s1.setUp("chrome", "https://demo.actitime.com/login.do");
	  driver.findElement(By.id("username")).sendKeys("admin");
      driver.findElement(By.name("pwd")).sendKeys("manager");
      driver.findElement(By.id("loginButton")).click();
  }
  @Test
  public void b_verifyTaskcreation()  {
	wait=new WebDriverWait(driver,20);
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("container_tasks")));
	  driver.findElement(By.id("container_tasks")).click();
      driver.findElement(By.cssSelector(".title.ellipsis")).click();
      driver.findElement(By.cssSelector(".item.createNewTasks")).click();
       wait=new WebDriverWait(driver,20);
      //click on company dropdown
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='customerSelector customerOrProjectSelector selectorWithPlaceholderContainer']/div/div[1]/div[3]")));
      driver.findElement(By.xpath("//div[@class='customerSelector customerOrProjectSelector selectorWithPlaceholderContainer']/div/div[1]/div[3]")).click();
    
      List<WebElement> companyList=driver.findElements(By.xpath("//div[@class='customerProjectSelectorPlaceholder']/div/table/tbody/tr[1]/td[1]/div/div/div[2]/div/div[1]/div/div"));
	   for(int i=0;i<companyList.size();i++) {
		   if(companyList.get(i).getText().equals("Big Bang Company")) {
			   companyList.get(i).click();
			   System.out.println("big bang company added");
			   
		   }
		   
	   }
	   
	   //click on project dropdown
	   driver.findElement(By.xpath("//div[@class='projectSelector customerOrProjectSelector selectorWithPlaceholderContainer']/div/div/div[3]")).click();
	
	List<WebElement> projectList=driver.findElements(By.xpath("//div[@class='projectSelector customerOrProjectSelector selectorWithPlaceholderContainer']/div/div[2]/div/div[1]/div/div"));
	for(int i=0;i<projectList.size();i++) {
		projectList=driver.findElements(By.xpath("//div[@class='projectSelector customerOrProjectSelector selectorWithPlaceholderContainer']/div/div[2]/div/div[1]/div/div"));
		if(projectList.get(i).getText().equals("Flight operations")) {
			   projectList.get(i).click();
			   System.out.println("flight operations added");
		   }
		   
	}
	
	
	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='Enter task name']")));
   driver.findElement(By.cssSelector("input[placeholder='Enter task name']")).sendKeys("TestNG");//
   driver.findElement(By.cssSelector(".x-btn-text")).click();//click on dead line
   driver.findElement(By.cssSelector(".x-date-right")).click();//click on next month
   driver.findElement(By.cssSelector(".x-date-inner>tbody>tr:nth-of-type(3)>td:nth-of-type(3)")).click();
   
   wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(".taskTableContainer  .value.ellipsis"))));
   driver.findElement(By.cssSelector(".taskTableContainer  .value.ellipsis ")).click();//click on typr of work;
	   driver.findElement(By.cssSelector(".tablePlaceholder .typeOfWorkList>div:nth-of-type(11)")).click();
   driver.findElement(By.cssSelector(".commitButtonPlaceHolder>div>div:nth-of-type(1)")).click();	
   
   List<WebElement> tasks=driver.findElements(By.xpath("//table[@class='taskRowsTable']//td[2]"));
  // tasks=driver.findElements(By.xpath("//table[@class='taskRowsTable']//td[2]"));
   
   wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@class='taskRowsTable']//td[2]")));
   for(int i=0;i<tasks.size();i++) {
   	tasks=driver.findElements(By.xpath("//table[@class='taskRowsTable']//td[2]"));
   	try {
   		
   	if(tasks.get(i).getText().equals("TestNG")) {
   		System.out.println("task  crated");
   		
   	}
   	else {	
   		System.out.println("task  not created");
   		
   	}
   	break;
   	
   }
   	
   	catch(StaleElementReferenceException e) {
   		
   	}
   	System.out.println("all tasks:"+tasks.get(i).getText());
   }
   

  }
  @Test
  public void c_verifyTaskDeletion() {
	  wait=new WebDriverWait(driver,20);
	   
	  //click on checkbox
	     driver.findElement(By.xpath("//table[@class='createdTasksRowsTable']/tbody/tr/td[1]/div")).click();

	     //click on delet
	     driver.findElement(By.xpath("//div[@class='bulkOperationsPanel']/div[6]")).click();
	     
	     //delete permentely
	     driver.findElement(By.xpath("//span[text()='Delete permanently']")).click();

	     
	     List<WebElement> tasks=driver.findElements(By.xpath("//table[@class='taskRowsTable']//td[2]"));
	     for(int i=0;i<tasks.size();i++) {
	     	//tasks=driver.findElements(By.xpath("//table[@class='taskRowsTable']//td[2]"));
	     	try {
	     	if(tasks.get(i).getText().equals("TestNG")) {
	     		System.out.println("task not deleted");
	     	}
	     	else {
	     		System.out.println("task deleted");
	     		break;
	     	}
	     	
	     }
	     	catch(StaleElementReferenceException e) {
	     		
	     	}
	     }
	 }
  }

