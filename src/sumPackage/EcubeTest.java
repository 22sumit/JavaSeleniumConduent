package sumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EcubeTest {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://ec4dcvm0136.wipro.com/");
		driver.findElement(By.id("txtLogin")).sendKeys("86229");
		driver.findElement(By.id("txtPassword")).sendKeys("st@t!ce");
		driver.findElement(By.cssSelector("input[value='Sign in']")).click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='link']")));
		driver.findElement(By.cssSelector("title='PROJECTS'")).click();

	}

}
