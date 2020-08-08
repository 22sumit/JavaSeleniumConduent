package pom_TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	static WebDriver driver;
	
	//need to return this driver from here, so change type of method to WebDriver
	//why to use static here?? Ans: A static method can be invoked without the need for creating an instance of a class.
	public static WebDriver startBrowser(String BrowserName, String url){
		if (BrowserName.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		else if (BrowserName.equalsIgnoreCase("IE")){
			driver=new InternetExplorerDriver();
		}
		else if (BrowserName.equalsIgnoreCase("chrome")){
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver; 
	}
}
