package extentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.ScreenshotUtility;


public class ExtentReportTest {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void startBrowser(){
		driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
	}
	@Test
	public void verifyTitle(){
		report=new ExtentReports(".\\Report\\ExtReport.html");
		logger=report.startTest("TitleVerification");
		String title=driver.getTitle();
		logger.log(LogStatus.INFO, "Fetched Title");
		Assert.assertTrue(title.contains("facebook"));
		logger.log(LogStatus.PASS, "verified title");
	}
	@AfterMethod
	public void teardown(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
			String scrPath=ScreenshotUtility.CaptureScreenshot1(driver, result.getName());
			String image=logger.addScreenCapture(scrPath);
			logger.log(LogStatus.FAIL, "Failed verification", image);
		}
		report.endTest(logger);
		report.flush();
		driver.get(".\\Report\\ExtReport.html");
		//driver.quit();
	}

}
