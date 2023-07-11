

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {
	 //System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     driver.get("https://demo.actitime.com");
    String title= driver.getTitle();
    System.out.println("title:"+title);
    System.out.println("length of titlr:"+title.length());
    String expUrl="https://demo.actitime.com";
  String currentUrl= driver.getCurrentUrl();
  System.out.println("validation of URl:"+currentUrl.equals(expUrl));
  System.out.println("page source length:"+driver.getPageSource().length());
	}

}
