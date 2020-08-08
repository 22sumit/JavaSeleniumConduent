package defaultTSG;

//show account details by entering ac number

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://10.36.20.30/callcenter_enu/start.swe?SWECmd=Login&SWEBHWND=1&SRN=&SWEHo=10.36.20.30&SWETS=1455712374");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("s_swepi_1")).sendKeys("TESTER3");
		driver.findElement(By.id("s_swepi_2")).sendKeys("Welcome1");
		driver.findElement(By.id("s_swepi_22")).click();
		
		//add code to wait for the page to load
		WebDriverWait wait=new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()[contains(.,'Accounts')]]")));
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.findElement(By.id("ui-id-88")).click();
		driver.findElement(By.name("s_1_1_26_0")).sendKeys("2000301171112");
		driver.findElement(By.id("s_1_1_12_0_Ctrl")).click();
		//Thread.sleep(10000);
		//Clicking on Violation
		
/*		
		driver.findElement(By.xpath("//li[a[text()='Violation']]")).click();
		driver.findElement(By.id("button[id='s_1_1_10_0_Ctrl']")).click();*/
		WebElement e=driver.findElement(By.cssSelector("input[name='s_1_1_29_0']"));
		Boolean b=e.isDisplayed();
		String s=e.getAttribute("value");
		System.out.println(s+" element "+"displayed: "+b);
		driver.quit();
		
	}

}
