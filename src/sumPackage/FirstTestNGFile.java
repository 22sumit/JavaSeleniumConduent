package sumPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class FirstTestNGFile {
	public WebDriver driver;
	
  @Test
  public void test1() {
      System.setProperty("webdriver.ie.driver","D:\\selenium jar file\\IEDriverServer.exe");
      
      //create IE instance
      driver = new InternetExplorerDriver();
		driver.get("http://google.com");
		driver.quit();
		System.out.println("test successful");
  }
  }