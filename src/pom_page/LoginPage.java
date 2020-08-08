package pom_page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	//constructor to receive the driver coming from page factory
	public LoginPage(WebDriver ldriver){
		this.driver=ldriver;
	}
	
	
	@FindBy(id="Email")
	WebElement usermail;
	@CacheLookup  //used to store the WebElements for high performance
	@FindBy(xpath=".//*[@id='next']") 
	WebElement next;
	
	@FindBy(id="Passwd")
	WebElement password;
	@CacheLookup
	@FindBy(id="signIn")
	WebElement signin;
	
	//parameterized method to pass id and password
	public void login_gmail(String uid,String pwd){
		usermail.sendKeys(uid);
		next.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		password.sendKeys(pwd);
		signin.click();
	}
}
