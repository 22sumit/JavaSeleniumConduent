package sumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderTest {
	
  WebDriver driver=new FirefoxDriver();
	
  @BeforeTest
  public void launch(){
	  System.out.println("Launching Browser...Please Wait...");
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("http://google.com");
  }
  
  @Test(dataProvider="searchtext")
  public void f(String author, String searchkey) throws InterruptedException {
	  driver.findElement(By.id("lst-ib")).sendKeys(searchkey);
	  System.out.println("Welcome "+author+" You searched for: "+searchkey);
	  driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
	  String query=driver.findElement(By.id("lst-ib")).getAttribute("value");
	  System.out.println("query: "+query);
	  driver.findElement(By.id("lst-ib")).clear();
	  //Assert.assertEquals(query, searchkey);
	  Assert.assertTrue(query.equalsIgnoreCase(searchkey));
  }
  
  @DataProvider(name="searchtext")
  public Object[][] getDatafromDataProvider(){
	  return new Object[][] {
			  { "Guru99", "India" },			  
              { "Krishna", "UK" },
              { "Bhupesh", "USA" }
	  };
  }
  
  @AfterTest
  public void terminate(){
	  System.out.println("Closing Browser");
	  driver.quit();
  }
}
