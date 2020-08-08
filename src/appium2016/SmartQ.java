package appium2016;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


public class SmartQ {
WebDriver driver;

@BeforeClass
public void setUp() throws MalformedURLException{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("BROWSER_NAME", "Android");
	capabilities.setCapability("VERSION", "4.4.2"); 
	capabilities.setCapability("deviceName","Emulator");
	capabilities.setCapability("platformName","Android");
	
	//capabilities.setCapability("app", "D:\\Appium\\SmartQ1.14.apk");
   
   capabilities.setCapability("appPackage", "com.thesmartq.smartq");
// This package name of your app (you can get it from apk info app)
	capabilities.setCapability("appActivity","com.thesmartq.smartq/.Splashscreen"); // This is Launcher activity of your app (you can get it from apk info app)
	//capabilities.setCapability("appActivity","com.thesmartq.smartq/.Loginorsignup");
	//Create RemoteWebDriver instance and connect to the Appium server
 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
   driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
}

@Test
public void testCal() throws Exception {
   //locate the Text on the calculator by using By.name()
   WebElement signup=driver.findElement(By.id("com.thesmartq.smartq:id/btnsignup"));
   signup.click();
   WebElement name1=driver.findElement(By.id("com.thesmartq.smartq:id/editname"));
   name1.sendKeys("Sumit");
   WebElement email=driver.findElement(By.id("com.thesmartq.smartq:id/editemail"));
   email.sendKeys("rjdixit9999@gmail.com");
   WebElement mobile=driver.findElement(By.id("com.thesmartq.smartq:id/editmobilenumber"));
   mobile.sendKeys("0000000012");
   WebElement pwd=driver.findElement(By.id("com.thesmartq.smartq:id/editpassword1"));
   pwd.sendKeys("smartq123");
   WebElement refer=driver.findElement(By.id("com.thesmartq.smartq:id/promocode"));
   refer.sendKeys("7870020148");
   WebElement create=driver.findElement(By.id("com.thesmartq.smartq:id/btnsignup"));
   create.click();
}

@AfterClass
public void teardown(){
	//close the app
	//driver.quit();
}
}
