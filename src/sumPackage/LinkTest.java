package sumPackage;

import java.io.File;

import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//count and note the link names on the page and Take Screenshot
public class LinkTest {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.google.com");
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("c:\\screenshot.jpg"));
		int s=driver.findElements(By.tagName("a")).size();
		for(int i=0;i<s;i++){
			System.out.println(driver.findElements(By.tagName("a")).get(i).getText());
		}
		
	}

}
