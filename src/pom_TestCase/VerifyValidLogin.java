package pom_TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pom_page.LoginPage;

public class VerifyValidLogin {

	@Test
	public void checkValidUser(){
		
		//returns a WebDriver reference
		//launches browser and specify url
		WebDriver driver=BrowserFactory.startBrowser("firefox", "https://accounts.google.com/ServiceLogin");
		
		//create Page Object by calling PageFactory class
		//driver is passed to the Page Object class from here
		//using .class binary returns the byte code of the particular page
		//initElements returns page object of the same page
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		login.login_gmail("rockingages", "missus22");
	}
}
