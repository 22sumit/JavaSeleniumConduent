package sumPackage;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//testNG priority 
public class titleVerification {
	WebDriver driver=new FirefoxDriver();
	
  @Test(priority=5)
  public void f() {  
		driver.get("http://epdev2cidb.wipro.com:50000/irj/portal");
		String Webtitle="myWipro Portal";
		String Gettitle=driver.getTitle();
		Assert.assertEquals(Gettitle, Webtitle);
  }
  
  @Test(priority=-2)
  public void fr() {
	  Assert.fail();
  }
  
  @BeforeTest
  public void g(){
	  int a=10,b=20;
	  int sum=a+b;
	  System.out.println("********************");
	  System.out.println("sum is: "+sum);
  }
  @AfterTest
  public void closeBrowser() {
	  System.out.println("=======================");
	  driver.quit();
}
}
