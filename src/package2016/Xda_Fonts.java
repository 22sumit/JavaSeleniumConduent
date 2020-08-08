package package2016;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Xda_Fonts {
	
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://forum.xda-developers.com/android/themes/fonts-flashable-zips-t2964304");
		System.out.println("Page loaded");
		List<WebElement> fontlist=driver.findElements(By.cssSelector("input[value='Click To Show Content']"));
		System.out.println("No.of elements: "+fontlist.size());
		//WebElement testclick=driver.findElement(By.cssSelector("input[value='Click To Show Content']"));
		WebDriverWait wait=new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.elementToBeClickable(fontlist.get(135)));
		for(WebElement  fl:fontlist){
			fl.click();
		}
		
		System.out.println("done clicking");
	}

}
