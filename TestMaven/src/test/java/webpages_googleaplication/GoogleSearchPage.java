/**
 * 
 */
package webpages_googleaplication;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.SeleniumUtility;

/**
 * @author Vikas
 *
 */   
public class GoogleSearchPage extends SeleniumUtility {
      
	public GoogleSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="q")
	private WebElement SearchInutField;
	
	@FindBy(css="#Alh6id .G43f7e>li")
	private List<WebElement> suggestions;
	
	public void searchText(String input) {
		typeInput(SearchInutField, input);
		getActiveElementFromUi().sendKeys(Keys.ENTER);
	}
	public void searchTextSugg(String input) {
		typeInput(SearchInutField, input);
	}
	public List<WebElement> getSugg(){
		wait.until(ExpectedConditions.visibilityOfAllElements(suggestions));
		return suggestions;
	}
}
