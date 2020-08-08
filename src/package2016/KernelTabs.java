package package2016;
//click on all the buttons in the page having text "Spoiler"
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KernelTabs {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://forums.yuplaygod.com/threads/yureka-gk-mr1-3-gods-kernel-true-god-of-kernels-android-l-m-26-01-2016.12081/");
		System.out.println("Page loaded");
		driver.findElement(By.cssSelector("#ctrl_pageLogin_login")).sendKeys("22sumit");
		driver.findElement(By.cssSelector("#ctrl_pageLogin_password")).sendKeys("0000");
		driver.findElement(By.cssSelector(".button.primary")).click();
		List<WebElement> fontlist=driver.findElements(By.xpath("//span[contains(text(),'Spoiler')]"));
		System.out.println("No.of elements: "+fontlist.size());

		for(WebElement  fl:fontlist){
			fl.click();
		}
		
		System.out.println("done clicking");
	}

}
