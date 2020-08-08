package package2016;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Ksrtc_Popup {
	WebDriver driver=new FirefoxDriver();
	
	@Test
	public void popup() throws InterruptedException{
	driver.get("http://www.ksrtc.in");
	driver.findElement(By.xpath("//*[@id='matchStartPlace']")).sendKeys("DODDABALLAPURA");
	driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/form/div[8]/a")).click();
	Alert all=driver.switchTo().alert();
	System.out.println(all.getText());
	Thread.sleep(5000);
	all.accept();
	driver.close();
	}
}
