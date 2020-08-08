package package2016;
//uses ScreenshotUtility.java file as utility class
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class FailedTCScreenshot {
	public WebDriver driver;
	
	@Test
	public void set_up(){
		driver=new FirefoxDriver();
		driver.get("http://www.desidime.com/forums/hot-deals-online");
	}
	
	@Test
	public void verifyTitle(){
		
		String s=driver.getTitle();
		System.out.println(s);
		//ScreenshotUtility.CaptureScreenshot(driver,"Browser Started");
		Assert.assertEquals("Hot Deals - Online Forum - DesiDime, India's Shopping Community for Best Deal", s);
		System.out.println("pass");
	}
	
	@AfterMethod
	public void tear_down(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
		ScreenshotUtility.CaptureScreenshot(driver,result.getName());
		}
	}
	@AfterTest
	public void tear_up(){
		driver.quit();
	}

	
	
}
