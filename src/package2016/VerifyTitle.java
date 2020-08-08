package package2016;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTitle {
	WebDriver driver=new FirefoxDriver();
	
	@Test
	public void title(){
		driver.get("http://google.com");
		String expTitle="Goog";
		String mytitle=driver.getTitle();
		//Assert.assertEquals(mytitle,expTitle);
		//System.out.println("test completed");
		Assert.assertTrue(mytitle.contains(expTitle));
		System.out.println("passed");
	}
	
}
