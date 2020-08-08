package sumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

//handling mouse and keyboard actions
public class myAction {

	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement txtusername= driver.findElement(By.id("email"));
		Actions act= new Actions(driver);
		Action series= act
				.moveToElement(txtusername)
				.click()
				.keyDown(txtusername, Keys.SHIFT)
				.sendKeys(txtusername,"hello")
				.doubleClick(txtusername)
				.contextClick(txtusername)
				.build();
		series.perform();
				
	}

}
