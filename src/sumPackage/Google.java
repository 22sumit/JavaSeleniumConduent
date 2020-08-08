package sumPackage;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;


//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Google {
	//WebDriver driver=new FirefoxDriver();
	

		@Test		

		public void search(){
			//System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
			//WebDriver driver=new InternetExplorerDriver();
			WebDriver driver=new FirefoxDriver();
			driver.get("http://google.com");
			System.out.println(driver.getTitle());		
			driver.quit();
			System.out.println("test successful");
}
}
