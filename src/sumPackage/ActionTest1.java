package sumPackage;
//Ecube Test Site Login
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.sun.jna.platform.win32.WinUser.INPUT;

public class ActionTest1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		WebDriver driver= new InternetExplorerDriver();
		driver.get("http://ec4dcvm0136.wipro.com/");
		driver.manage().window().maximize();
		WebElement myElement= driver.findElement(By.id("txtLogin"));
		myElement.sendKeys("86229");
		WebElement mypwd= driver.findElement(By.id("txtPassword"));
		mypwd.sendKeys("st@t!ce");
		driver.findElement(By.xpath(".//*[@id='tblCap00']/tbody/tr[6]/td[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("a[href*=Logout]")).click();
		int s=driver.findElements(By.tagName("Frameset")).size();
		for(int i=0;i<s;i++){
			System.out.println(driver.findElements(By.tagName("Frameset")).get(i).getText());
		}
		driver.switchTo().frame(driver.findElement(By.id("Sub")));
		
		List<WebElement> linkelements= driver.findElements(By.tagName("a"));
		String[] linkTexts = new String[linkelements.size()];
        int i = 0;
        for (WebElement e : linkelements) {
            linkTexts[i] = e.getText();
            i++;
            for (String t : linkTexts) {
            	System.out.println(t);
            }
        }
		
		
		//driver.findElement(By.cssSelector(INPUT.class));
		/*Actions builder=new Actions(driver);
		builder.doubleClick(myElement);
		builder.contextClick(myElement).perform();
		builder.keyDown(Keys.CONTROL).sendKeys("a").perform(); 
*/
	}

}
