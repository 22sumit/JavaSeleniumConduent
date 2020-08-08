package sumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Upload_Demo {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://encodable.com/uploaddemo/");
		WebElement uploadElement= driver.findElement(By.name("uploadname1"));
		
		/*There is no need to simulate the clicking of the "Browse" button. 
		//WebDriver automatically enters the file path onto the file-selection text 
		box of the <input type="file"> element */
		
		uploadElement.sendKeys("D:\\Sumit\\Personal\\test12.txt");
		driver.findElement(By.id("newsubdir1")).sendKeys("Sumit12");
		
	}

}
