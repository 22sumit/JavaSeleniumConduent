package sumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get(" http://jsbin.com/osebed/2");
		Select drpfruit=new Select(driver.findElement(By.id("fruits")));
		drpfruit.selectByVisibleText("Apple");
		drpfruit.selectByVisibleText("Banana");
		drpfruit.selectByIndex(3);
		if(drpfruit.isMultiple()){
			System.out.println("Multiple values selected");
		}
		System.out.println("test complete");
	}

}
