package package2016;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TextPresence {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://seleniumonlinetrainingexpert.wordpress.com/2012/11/29/how-to-use-regular-expression-in-selenium-ide/");
		WebElement wb1=driver.findElement(By.xpath("//h1[@class='entry-title']"));
		String str1=wb1.getText();
		Boolean b1=str1.contains("expression");
		System.out.println(b1);
		driver.quit();
	}
	

}
