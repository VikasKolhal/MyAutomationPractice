package webpages_actitime;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class ActitimeTasksPage extends SeleniumUtility{
	public ActitimeTasksPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".title.ellipsis")
	private WebElement addNewBtn;
	
	@FindBy(css=".item.createNewTasks")
	private WebElement newtasksBtn;
	
	@FindBy(xpath="//div[@class='customerSelector customerOrProjectSelector selectorWithPlaceholderContainer']/div/div[1]/div[3]")
	private WebElement companyDropDownBtn;
	
	@FindBy(xpath="//div[@class='customerProjectSelectorPlaceholder']/div/table/tbody/tr[1]/td[1]/div/div/div[2]/div/div[1]/div/div")
	private List<WebElement> companyList;
	
	@FindBy(xpath="//div[@class='projectSelector customerOrProjectSelector selectorWithPlaceholderContainer']/div/div/div[3]")
	private WebElement projectDropDownBtn;
	
	@FindBy(xpath="//div[@class='projectSelector customerOrProjectSelector selectorWithPlaceholderContainer']/div/div[2]/div/div[1]/div/div")
	private List<WebElement> projectList;
	
	@FindBy(css="input[placeholder='Enter task name']")
	private WebElement entertasknamebtn;
	
	@FindBy(css=".x-btn-text")
	private WebElement deadlineBtn;
	
	@FindBy(css=".x-date-right")
	private WebElement nextMonthBtn;
	
	@FindBy(css=".x-date-inner>tbody>tr:nth-of-type(3)>td:nth-of-type(3)")
	private WebElement dateBtn;
	
	@FindBy(css=".taskTableContainer  .value.ellipsis")
	private WebElement typeOfWorkBtn;
	
	@FindBy(css=".tablePlaceholder .typeOfWorkList>div:nth-of-type(11")
	private WebElement WorkBtn;
	
	
}
