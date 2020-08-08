package defaultTSG;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.jboss.netty.util.Timeout;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountCreation_FL_FF {
	
	WebDriver driver=new FirefoxDriver();
	
	public static void screenshot(String s,WebDriver driver) throws IOException{
		Date d=new Date();
		SimpleDateFormat ft=new SimpleDateFormat("dd_MM_yyyy hh_mm_ss");
		
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scr, new File("c:\\screenshots\\"+ft.format(d)+"\\"+s+".jpeg"));
		FileUtils.copyFile(scr, new File("c:\\screenshots\\"+s+".jpeg"));
	}

	@Test(priority=1)
	public void login() throws IOException{
		
		driver.get("http://10.36.20.4/callcenter_enu/start.swe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("s_swepi_1")).sendKeys("sumitb");
		driver.findElement(By.id("s_swepi_2")).sendKeys("burnwal");
		screenshot("LoginPage",driver);
		driver.findElement(By.id("s_swepi_22")).click();
		System.out.println("Login Successful");
	}
	@Test(priority=2)
	public void accDetails() throws InterruptedException, IOException{
				
		//add code to wait for the page to load
		WebDriverWait wait=new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()[contains(.,'Account Opening')]]")));
		driver.findElement(By.xpath("//a[text()='Account Opening']")).click();
		
		driver.findElement(By.xpath("//*[text()[contains(.,'Account Opening')]]")).click();
		System.out.println("ac opening clicked");
		Thread.sleep(5000);
		driver.findElement(By.id("s_3_1_55_0_Ctrl")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("[name='s_3_1_30_0']")).sendKeys("2070");
		driver.findElement(By.cssSelector("[name='s_3_1_37_0']")).sendKeys("Last 4 digits of Phone Number?");
		driver.findElement(By.cssSelector("[name='s_3_1_46_0']")).sendKeys("9862");
		driver.findElement(By.cssSelector("[name='s_3_1_15_0']")).sendKeys("sumit.burnwal@xerox.com");
		
		driver.findElement(By.cssSelector("[name='s_1_1_11_0']")).click(); //click on "New"
		driver.findElement(By.xpath(".//*[@id='1_s_1_l_Last_Name']")).click();
		driver.findElement(By.xpath(".//*[@id='1_Last_Name']")).sendKeys("Kidman");
		driver.findElement(By.xpath(".//*[@id='1_s_1_l_First_Name']")).click();
		driver.findElement(By.xpath(".//*[@id='1_First_Name']")).sendKeys("Nicole");
		driver.findElement(By.xpath(".//*[@id='1_s_1_l_Contact_Phone_Number']")).click();
		driver.findElement(By.xpath(".//*[@id='1_Contact_Phone_Number']")).sendKeys("2543342220");
		
		driver.findElement(By.xpath(".//*[@id='s_1_1_16_0_Ctrl']")).click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 10 /*timeout in seconds*/);
		if(wait1.until(ExpectedConditions.alertIsPresent())==null)
		    System.out.println("alert was not present");
		else{
		    System.out.println("alert was present");
			Alert ale=driver.switchTo().alert();
			Thread.sleep(2000);
			System.out.println(ale.getText());
			ale.accept();
			}
		System.out.println("Added Contact Details");
		
		driver.findElement(By.xpath(".//button[@id='s_2_1_11_0_Ctrl']")).click();
		
		//driver.findElement(By.xpath(".//div/*[@title='Addresses:New']")).click();
		driver.findElement(By.xpath(".//*[@id='1_s_2_l_Street_Address']")).click();
		driver.findElement(By.xpath(".//*[@id='1_Street_Address']")).sendKeys("6437 FURMAN BLVD");
		driver.findElement(By.xpath(".//*[@id='1_s_2_l_Postal_Code']")).click();
		driver.findElement(By.xpath(".//*[@id='1_Postal_Code']")).sendKeys("33919");
		driver.findElement(By.xpath("//button[@id='s_2_1_16_0_Ctrl']")).click();
		System.out.println("Added Address");
		screenshot("DataEntered",driver);
		TimeUnit.SECONDS.sleep(5);
	}
	@Test(priority=3)
	public void replenishments() throws IOException, InterruptedException{
		driver.findElement(By.xpath(".//a[text()[contains(.,'Replenishments')]]")).click();
		
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@title='Account Replenishment Info List:New']")).click();
		//driver.findElement(By.xpath(".//button[@id='s_1_1_12_0_Ctrl']")).click();
		driver.findElement(By.xpath(".//*[@id='1_s_1_l_Rebill_Pay_Type']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='1_Rebill_Pay_Type']")).sendKeys("CHECK");
		
//      For credit card
//		driver.findElement(By.xpath(".//*[@id='1_Rebill_Pay_Type']")).sendKeys("VISA");
//		driver.findElement(By.xpath(".//*[@id='1_s_1_l_Card_Number']")).click();
//		driver.findElement(By.xpath(".//*[@id='1_Card_Number']")).sendKeys("4111111111111111");
//		driver.findElement(By.xpath(".//*[@id='1_s_2_l_Expiration_Month']")).click();
//		driver.findElement(By.xpath(".//*[@id='1_Expiration_Month']")).sendKeys("10");
//		driver.findElement(By.xpath(".//*[@id='1_s_2_l_Expiration_Year']")).click();
//		driver.findElement(By.xpath(".//*[@id='1_Expiration_Year']")).sendKeys("2017");
		
		System.out.println("Added Payment Details");
		screenshot("Replenishments",driver);
		TimeUnit.SECONDS.sleep(5);
		
	}
	
	@Test(priority=4)
	public void vehicles() throws IOException, InterruptedException{
		driver.findElement(By.xpath("//a[text()[contains(.,'Vehicles')]]")).click();
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.xpath(".//button[@id='s_1_1_14_0_Ctrl']")).click();
		
		Date d=new Date();
		SimpleDateFormat df=new SimpleDateFormat("mmssS");	
		
		driver.findElement(By.xpath(".//*[@id='1_Plate_Number']")).sendKeys("FL"+df.format(d));
		driver.findElement(By.xpath(".//*[@id='1_s_1_l_Year_of_Vehicle']")).click();
		driver.findElement(By.xpath(".//*[@id='1_Year_of_Vehicle']")).sendKeys("2016");
		driver.findElement(By.xpath(".//*[@id='1_s_1_l_Vehicle_Make']")).click();
		driver.findElement(By.xpath(".//*[@id='1_Vehicle_Make']")).sendKeys("AUDI");
		driver.findElement(By.xpath(".//*[@id='1_s_1_l_Vehicle_Model']")).click();
		driver.findElement(By.xpath(".//*[@id='1_Vehicle_Model']")).sendKeys("A6");
		//driver.findElement(By.xpath(".//*[@id='1_s_2_l_Is_Metal_Oxide_Wind_Shield']")).click();
		//driver.findElement(By.xpath(".//*[@id='1_Is_Metal_Oxide_Wind_Shield']")).click();
		driver.findElement(By.xpath(".//*[@id='1_s_1_l_Contact_Full_Name']")).click();
		driver.findElement(By.xpath(".//*[@id='s_1_2_25_0_icon']")).click();
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.xpath(".//*[@class='siebui-popup-btm']/child::span[1]")).click();
		
		//driver.findElement(By.xpath(".//*[@id='1_s_4_l_Account']")).click();
		//driver.findElement(By.xpath(".//*[@id='s_4_1_51_0_Ctrl']")).click(); // ok
		
		driver.findElement(By.xpath(".//*[@id='s_1_1_19_0_Ctrl']")).click();
		System.out.println("Added Vehicle");
		screenshot("Vehicles",driver);
		TimeUnit.SECONDS.sleep(5);
	}
	@Test(priority=5)
	public void deviceRequest() throws IOException, InterruptedException{
		driver.findElement(By.xpath("//a[text()[contains(.,'Device Request')]]")).click();
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.xpath("//button[@id='s_1_1_11_0_Ctrl']")).click();
		driver.findElement(By.cssSelector("span[id='s_1_2_32_0_icon']")).click();
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.xpath(".//*[@title='Vector Device Model PickList List Applet']/form/div/table/tbody/tr/td[2]/span[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@title='Vector Device Model PickList List Applet']/form/div/table/tbody/tr/td[2]/span[2]/input")).sendKeys("Device Description");
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.xpath(".//*[@title='Vector Device Model PickList List Applet']/form/div/table/tbody/tr/td[2]/span[4]/input")).sendKeys("SunPass Bumper Mount"); //SunPass Bumper Mount //SunPass Mini Sticker
		driver.findElement(By.xpath(".//*[@data-display='Find']")).click();
		Thread.sleep(5000);
		WebElement plate=driver.findElement(By.xpath(".//*[@id='1_s_1_l_Plate_Number']"));
		if (plate.isDisplayed()){
			System.out.println("plate webelement is visible");
			plate.click();
		}
		else System.exit(0);
		driver.findElement(By.xpath(".//*[@id='s_1_2_24_0_icon']")).click();
		driver.findElement(By.xpath(".//*[@class='siebui-popup-btm']/child::span[1]")).click();  //PICK
		//driver.findElement(By.xpath(".//*[@id='1_Plate_Number']")).click();
		//driver.findElement(By.xpath(".//*[@id='s_4_1_38_0_Ctrl']")).click();
		driver.findElement(By.xpath(".//*[@id='s_1_1_16_0_Ctrl']")).click(); //save
		System.out.println("Added Device");
		screenshot("DeviceRequest",driver);
		TimeUnit.SECONDS.sleep(5);
		
	}
	
	@Test(priority=6)
	public void plans() throws IOException, InterruptedException{
		driver.findElement(By.xpath("//a[text()[contains(.,'Plans')]]")).click();
		//click on Pay button
		TimeUnit.SECONDS.sleep(5);
		
		//WebDriverWait wait3=new WebDriverWait(driver,10);
		//wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(text(),'Pay')]"));
		//wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(text(),'Pay')]"))).click();
		driver.findElement(By.xpath(".//*[contains(text(),'Pay')]")).click();
		String foo = driver.findElement(By.xpath(".//*[@title='PENDING PAY']")).getAttribute("title");
		System.out.println("Account Status: "+foo);
		screenshot("PendingPay",driver);
		//click on New button
		WebElement element = driver.findElement(By.xpath(".//*[@id='s_2_1_13_0_Ctrl']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
		//.//*[@title="Payments List:New"]
		//driver.findElement(By.xpath(".//*[@id='s_2_1_13_0_Ctrl']")).click();
		element.click();
		TimeUnit.SECONDS.sleep(5);
		
		//Use For CHECK only
		 driver.findElement(By.xpath(".//*[@id='1_s_2_l_Check_Number']")).click();
		 Date ch=new Date();
		 SimpleDateFormat chn=new SimpleDateFormat("hhmmss");
		 driver.findElement(By.xpath(".//*[@id='1_Check_Number']")).sendKeys(chn.format(ch));

		//click on save button
		
		
		String mainwind=driver.getWindowHandle();
		driver.findElement(By.xpath(".//*[@id='s_2_1_18_0_Ctrl']")).click(); //save
		TimeUnit.SECONDS.sleep(3);
		Set<String> str=driver.getWindowHandles();
		Iterator<String> i=str.iterator();
		while(i.hasNext()){
			String childwindow=i.next();
			if(!mainwind.equalsIgnoreCase(childwindow)){
				driver.switchTo().window(childwindow);
				Actions act=new Actions(driver);
				act.keyDown(Keys.ENTER)
				.keyUp(Keys.ENTER).build().perform();
			}
			driver.switchTo().window(mainwind);
		}
		
		//process pay
		driver.findElement(By.xpath(".//*[@id='s_2_1_4_0_Ctrl']")).click();
		TimeUnit.SECONDS.sleep(5);
		screenshot("Plans",driver);
		
//		String act = driver.findElement(By.xpath(".//*[@title='ACTIVE']")).getAttribute("title");
//		System.out.println("Account Status: "+act);
//		screenshot("Final Ac Status",driver);
		
		WebElement e=driver.findElement(By.cssSelector("input[name='s_1_1_35_0']"));
		String s=e.getAttribute("value");
		System.out.println("Account Number: "+s);
		
	}
}
