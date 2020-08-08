package sikuliDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class GmailLogin {

	public static void main(String[] args) throws FindFailed, InterruptedException {
		Screen s=new Screen();
		Pattern image1=new Pattern("D:\\Padhai\\Sikuli\\images\\mailid.PNG");
		Pattern image2=new Pattern("D:\\Padhai\\Sikuli\\images\\next1.PNG");
		Pattern image3=new Pattern("D:\\Padhai\\Sikuli\\images\\password.PNG");
		Pattern image4=new Pattern("D:\\Padhai\\Sikuli\\images\\signin.PNG");
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		s.find(image1);
		s.type(image1, "sumitmirchi");
		s.find(image2);
		s.click(image2);
		s.find(image3);
		s.type(image3, "123456");
		s.find(image4);
		s.click(image4);
		driver.quit();
	}

}
