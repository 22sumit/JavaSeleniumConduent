package package2016;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UploadFile {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://qtpselenium.com/test/uploadform/contactform.php");
		driver.findElement(By.id("resume")).sendKeys("D:\\Padhai\\QTP & UFT Docs\\Testfso1.txt");
		System.out.println("uploaded successfully !!");

	}

}
