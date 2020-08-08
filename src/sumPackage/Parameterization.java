package sumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//launch as testNG suite from ParamTest.xml

public class Parameterization {
	WebDriver driver=new FirefoxDriver();
	
  @BeforeTest
  public void launch(){
	  System.out.println("Launching Browser...Please Wait...");
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("http://google.com");
  }
  
  @Test
  @Parameters({"author", "searchkey"})
  public void f(String author, String searchkey) {
	  driver.findElement(By.id("lst-ib")).sendKeys(searchkey);
	  System.out.println("Welcome "+author+" You searched for: "+searchkey);
	  driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
	  String query=driver.findElement(By.id("lst-ib")).getAttribute("value");
	  System.out.println("query: "+query);
	  Assert.assertEquals(query, searchkey);	 
  }
  
  @AfterTest
  public void terminate(){
	  System.out.println("Closing Browser");
	  //driver.quit();
  }
  }
