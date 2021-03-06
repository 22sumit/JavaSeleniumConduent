package defaultTSG;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreation_withoutSave {
	
	
	static void alwayswait(int timeinseconds) throws InterruptedException
	{
		Thread.sleep(timeinseconds * 1000);
		//System.out.println(timeinseconds+" seconds Wait is over");
	}
	
	static void alwayswait(int timeinseconds,String msg) throws InterruptedException
	{
		Thread.sleep(timeinseconds * 1000);
		System.out.println(timeinseconds+" seconds Wait is over and "+msg+" has been completed");
	}
	
	static void controlplus(WebDriver driver,String character)
	{
		Actions actionObj = new Actions(driver);
	    actionObj.keyDown(Keys.CONTROL)
	             .sendKeys(Keys.chord(character))
	             .keyUp(Keys.CONTROL)
	             .perform();
	}
	
	static void dropdown(WebDriver driver, WebElement element, String value)
	{
		Select select = new Select(element);
	    select.deselectAll();
	    select.selectByVisibleText(value);
	}
	
	static void generaldetails(WebDriver driver, String pinnumber,int accounttype, String companyname ,String sheetpath, int Rownum) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		WebElement addbtn = null;
		WebElement pin=null;
		WebElement challengeQues=null;
	    WebElement challengeAnswer=null;
	    
	    WebElement accntType=null; 
	    WebElement accntName=null;
	    WebElement dbaName=null;
	    WebElement commerical = driver.findElement(By.xpath("//li[a[contains(text(),'Commercial')]]"));
	    WebElement org=null;
	    WebElement statementFreq =null;
	    WebElement ok = null;
	    String orgname;
	    String freq;
	    if(accounttype==1)
	    {
	    	orgname = ExcelRead("Private", sheetpath, Rownum, 14);
		    freq = ExcelRead("Private", sheetpath, Rownum, 15);
	    }
	    else if (accounttype==2)
	    {
	    	
	    	orgname = ExcelRead("Business", sheetpath, Rownum, 14);
		    freq = ExcelRead("Business", sheetpath, Rownum, 15);
	    }
	    else
	    {
	    	orgname = ExcelRead("Commercial", sheetpath, Rownum, 14);
		    freq = ExcelRead("Commercial", sheetpath, Rownum, 15);
	    }
	    
	    
	    
	    
		switch(accounttype)
		{
		  
		case 1 :  addbtn = driver.findElement(By.xpath("//div[div[text()='Private']]//span[text()='New']")); 
		          addbtn.click();
		          //org = driver.findElement(By.xpath("//input[@name='s_1_1_30_0']"));
		          alwayswait(2);
		         // org.clear();
		          //org.sendKeys(orgname);
		          challengeQues = driver.findElement(By.xpath("//input[@name='s_3_1_37_0']"));
		          challengeQues.sendKeys("Last 4 digits of Phone Number?");
		          pin = driver.findElement(By.xpath("//input[@name='s_3_1_30_0']"));
		          challengeAnswer = driver.findElement(By.xpath("//input[@name='s_3_1_46_0']"));
		          //accntType = driver.findElement(By.xpath("//input[@name='s_3_1_36_0']"));
		          //statementFreq = driver.findElement(By.name("s_1_1_22_0"));
		          //statementFreq.clear();
		          //statementFreq.sendKeys(freq);
		          pin.click();
		          //ok = driver.findElement(By.id("s_4_1_63_0_Ctrl"));  //statement freq
		          //ok.click();
		          break;
		          
		case 2 :  
	    		  commerical.click();
	    		  addbtn = driver.findElement(By.xpath("//button[@id='s_2_1_50_0_Ctrl']")); 
			      addbtn.click();
			      org = driver.findElement(By.xpath("//input[@name='s_2_1_28_0']"));
		          alwayswait(2);
		          org.clear();
		          org.sendKeys("NEW JERSEY E-ZPASS");
		          challengeQues = driver.findElement(By.xpath("//input[@name='s_2_1_32_0']"));
		  		  challengeQues.clear();
		          challengeQues.sendKeys("Name of your pet?");
			      pin = driver.findElement(By.xpath("//input[@name='s_2_1_24_0']"));
				  challengeAnswer = driver.findElement(By.xpath("//input[@name='s_2_1_41_0']"));
				  accntType = driver.findElement(By.xpath("//input[@name='s_2_1_31_0']"));
				  accntName = driver.findElement(By.xpath("//input[@name='s_2_1_30_0']"));
				  
				  dbaName = driver.findElement(By.xpath("//input[@name='s_2_1_9_0']"));
				  dbaName.sendKeys(companyname);
				  accntName.sendKeys(companyname);
				  statementFreq = driver.findElement(By.name("s_2_1_19_0"));
				  statementFreq.clear();
		          statementFreq.sendKeys("NONE");
		          pin.click();
		          ok = driver.findElement(By.id("s_4_1_61_0_Ctrl")); 
		          ok.click();
				  break;
				 
		case 3 :  commerical.click();
		  		  addbtn = driver.findElement(By.xpath("//button[@id='s_2_1_50_0_Ctrl']")); 
		  		  addbtn.click();
		  		  org = driver.findElement(By.xpath("//input[@name='s_2_1_28_0']"));
		  		  alwayswait(2);
		  		  org.clear();
		  		  org.sendKeys("NEW JERSEY E-ZPASS");
		  		  challengeQues = driver.findElement(By.xpath("//input[@name='s_2_1_32_0']"));
		  		  challengeQues.clear();
		          challengeQues.sendKeys("Name of your pet?");
		  		  accntType = driver.findElement(By.name("s_2_1_31_0"));
		          accntType.clear();
		          accntType.sendKeys("COMMERCIAL");
		  		  pin = driver.findElement(By.xpath("//input[@name='s_2_1_24_0']"));
		  		  challengeAnswer = driver.findElement(By.xpath("//input[@name='s_2_1_41_0']"));
		  		  
		  		  accntName = driver.findElement(By.xpath("//input[@name='s_2_1_30_0']"));
		  
		  		  dbaName = driver.findElement(By.xpath("//input[@name='s_2_1_9_0']"));
		  		  dbaName.sendKeys(companyname);
		  		  accntName.sendKeys(companyname);
		  		  statementFreq = driver.findElement(By.name("s_2_1_19_0"));
		  		  statementFreq.clear();
		  		  statementFreq.sendKeys("NONE");
		  		  pin.click();
		  		  ok= driver.findElement(By.id("s_4_1_61_0_Ctrl")); 
		  		  ok.click();
		  		  break;
				  
       default :  break;			  
				  
		
		}
		
		alwayswait(3);
        pin.sendKeys(pinnumber);   
	    challengeAnswer.sendKeys(pinnumber);
	    driver.findElement(By.cssSelector("[name='s_3_1_15_0']")).sendKeys("sumit.burnwal@xerox.com");
	    
		
	}
	
	
	public static String ExcelRead(String Sheetname,String Path,int row1, int col1) throws EncryptedDocumentException, InvalidFormatException, IOException{

			
		FileInputStream fis=new FileInputStream(Path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(Sheetname);
		Row row=sh.getRow(row1);
		Cell cell=row.getCell(col1);
		String cellvalue=cell.getStringCellValue();	
		return cellvalue;

	}



	public static void ExcelWrite(String Sheetname,String Path,int row1, int col1, String value) throws EncryptedDocumentException, InvalidFormatException, IOException{

		
		FileInputStream fis=new FileInputStream(Path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(Sheetname);
		Row row=sh.getRow(row1);
		Cell cell=row.createCell(col1);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(Path);
		wb.write(fos);
		fos.close();
		

	 }
	
	
	

	public static void contactdetailsPrivate(WebDriver driver,String Lastname,String Firstname,String phnumber) throws InterruptedException 
	{
		WebElement addbtn = driver.findElement(By.xpath("//div[div[text()='Contacts']]//span[text()='New']")); 
        addbtn.click();
        
        alwayswait(2);
               
        WebElement lastnamebox = driver.findElement(By.xpath("//td[@id='1_s_1_l_Last_Name']"));
        lastnamebox.click();
        WebElement lastname = driver.findElement(By.xpath("//input[@id='1_Last_Name']"));
      
        lastname.sendKeys(Lastname);
        
        WebElement firstnamebox = driver.findElement(By.xpath("//td[@id='1_s_1_l_First_Name']"));
        firstnamebox.click();
        WebElement firstname = driver.findElement(By.xpath("//input[@id='1_First_Name']"));
        firstname.sendKeys(Firstname);
        
        WebElement daynobox = driver.findElement(By.xpath("//td[@id='1_s_1_l_Contact_Phone_Number']"));
        daynobox.click();
        WebElement dayno = driver.findElement(By.xpath("//input[@id='1_Contact_Phone_Number']"));
        dayno.sendKeys(phnumber);  
        driver.findElement(By.xpath(".//div/*[@title='Contacts:Save']")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 30 /*timeout in seconds*/);
		if(wait1.until(ExpectedConditions.alertIsPresent())==null)
		    System.out.println("alert was not present");
		else{
		    System.out.println("alert was present");
			Alert ale=driver.switchTo().alert();
			Thread.sleep(2000);
			System.out.println(ale.getText());
			ale.accept();
			}
		alwayswait(5);
        		
	}
	
	
	public static void contactdetailsBusiness(WebDriver driver,String Lastname,String Firstname,String phnumber) throws InterruptedException 
	{
		WebElement addbtn = driver.findElement(By.xpath("//button[@id='s_1_1_11_0_Ctrl']")); 
        addbtn.click();
        
        alwayswait(2);
               
        WebElement lastnamebox = driver.findElement(By.xpath("//td[@id='1_s_1_l_Last_Name']"));
        lastnamebox.click();
        WebElement lastname = driver.findElement(By.xpath("//input[@id='1_Last_Name']"));
      
        lastname.sendKeys(Lastname);
        
        WebElement firstnamebox = driver.findElement(By.xpath("//td[@id='1_s_1_l_First_Name']"));
        firstnamebox.click();
        WebElement firstname = driver.findElement(By.xpath("//input[@id='1_First_Name']"));
        firstname.sendKeys(Firstname);
        
        WebElement daynobox = driver.findElement(By.xpath("//td[@id='1_s_1_l_Contact_Phone_Number']"));
        daynobox.click();
        WebElement dayno = driver.findElement(By.xpath("//input[@id='1_Contact_Phone_Number']"));
        dayno.sendKeys(phnumber);  
        
        		
	}
	
	public static void addressDetailsPrivate(WebDriver driver,String add1,String add2,String zip) 
	{
		WebElement addbtn = driver.findElement(By.xpath(".//div/*[@title='Addresses:New']"));  
        addbtn.click();
        WebElement address1box = driver.findElement(By.id("1_s_2_l_Street_Address")); 
        address1box.click();
        WebElement address1 = driver.findElement(By.id("1_Street_Address"));        
        address1.sendKeys(add1);
        
        WebElement address2box = driver.findElement(By.id("1_s_2_l_Street_Address_2")); 
        address2box.click();
        WebElement address2 = driver.findElement(By.id("1_Street_Address_2"));
        address2.sendKeys(add2);
        
        WebElement zipcodetxt = driver.findElement(By.xpath("//td[@id='1_s_2_l_Postal_Code']"));
        zipcodetxt.click();
        
        WebElement zipcodetext = driver.findElement(By.xpath("//input[@id='1_Postal_Code']"));
        zipcodetext.sendKeys(zip);   
        
        WebElement zipcodeplustxt = driver.findElement(By.xpath("//td[@id='1_s_2_l_Zip_Plus']"));
        zipcodeplustxt.click(); 
        
        
	}
	
	public static void addressDetailsBusiness(WebDriver driver,String add1,String add2,String zip) 
	{
		WebElement addbtn = driver.findElement(By.xpath("//button[@id='s_3_1_11_0_Ctrl']"));  
        addbtn.click();
        WebElement address1box = driver.findElement(By.id("1_s_3_l_Street_Address")); 
        address1box.click();
        WebElement address1 = driver.findElement(By.id("1_Street_Address"));        
        address1.sendKeys(add1);
        
        WebElement address2box = driver.findElement(By.id("1_s_3_l_Street_Address_2")); 
        address2box.click();
        WebElement address2 = driver.findElement(By.id("1_Street_Address_2"));
        address2.sendKeys(add2);
        
        WebElement zipcodetxt = driver.findElement(By.xpath("//td[@id='1_s_3_l_Postal_Code']"));
        zipcodetxt.click();
        
        WebElement zipcodetext = driver.findElement(By.xpath("//input[@id='1_Postal_Code']"));
        zipcodetext.sendKeys(zip);   
        
        WebElement zipcodeplustxt = driver.findElement(By.xpath("//td[@id='1_s_3_l_Zip_Plus']"));
        zipcodeplustxt.click(); 
        
        
	}
	
	
	public static void replenishment(WebDriver driver,String accountype,String sheetpath, int Rownum) throws AWTException, EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException 
	{
		   WebElement addReplbtn = null;
		    WebElement rebilltypefield = null;
		    WebElement rebilltype = null;
		    WebElement ccnumfield = null;
		    WebElement ccnum = null;
		    WebElement ccmonthfield = null;
		    WebElement ccmonth = null;
		    WebElement ccyearfield = null;
		    WebElement ccyear = null;
		    
		    String Rpaytype = ExcelRead(accountype, sheetpath, Rownum, 16);
		    String cnum = ExcelRead(accountype, sheetpath, Rownum, 17);
		    String cmonth = ExcelRead(accountype, sheetpath, Rownum, 18);
		    String cyear = ExcelRead(accountype, sheetpath, Rownum, 19);
		    
		    
		    	
		    
		    if(accountype.equals("Private"))
		    {   
		    	addReplbtn= driver.findElement(By.xpath(".//*[@title='Account Replenishment Info List:New']"));
		    	addReplbtn.click();
		    	alwayswait(4);
		    	rebilltypefield = driver.findElement(By.id("1_s_1_l_Rebill_Pay_Type"));
		        rebilltypefield.click();
		        rebilltype = driver.findElement(By.id("1_Rebill_Pay_Type"));
		        rebilltype.sendKeys(Rpaytype);
		    	if(Rpaytype.equals("CHECK"))
		    	{
		    		
		    	}
		    	else if (Rpaytype.equalsIgnoreCase("CASH")){
		    		
		    	}
		    	else
		    	{	
		    	  
		        
		        ccnumfield = driver.findElement(By.id("1_s_2_l_Card_Number"));
		        ccnumfield.click();	  
		        ccnum = driver.findElement(By.id("1_Card_Number"));
		        ccnum.sendKeys(cnum);
		        ccmonthfield = driver.findElement(By.id("1_s_2_l_Expiration_Month"));
		        ccmonthfield.click();	
		        ccmonth = driver.findElement(By.id("1_Expiration_Month"));
		        ccmonth.sendKeys(cmonth);
		        ccyearfield = driver.findElement(By.id("1_s_2_l_Expiration_Year"));
		        ccyearfield.click();
		        ccyear = driver.findElement(By.id("1_Expiration_Year"));
		        ccyear.sendKeys(cyear);
		    	}
		    }   	    
		    else
		    {
		    	addReplbtn= driver.findElement(By.id("s_1_1_12_0_Ctrl"));
		    	addReplbtn.click();
		        rebilltypefield = driver.findElement(By.id("1_s_1_l_Rebill_Pay_Type"));
		        rebilltypefield.click();
		        rebilltype = driver.findElement(By.id("1_Rebill_Pay_Type"));
		        rebilltype.sendKeys(Rpaytype);
		        
		        if(Rpaytype.equals("CHECK"))
		    	{
		    		
		    	}
		        else if (Rpaytype.equalsIgnoreCase("CASH")){
		    		
		    	}
		    	else
		    	{	
		        ccnumfield = driver.findElement(By.id("1_s_1_l_Card_Number"));
		        ccnumfield.click();	  
		        ccnum = driver.findElement(By.id("1_Card_Number"));
		        ccnum.sendKeys(cnum);
		        ccmonthfield = driver.findElement(By.id("1_s_1_l_Expiration_Month"));
		        ccmonthfield.click();	
		        ccmonth = driver.findElement(By.id("1_Expiration_Month"));
		        ccmonth.sendKeys(cmonth);
		        ccyearfield = driver.findElement(By.id("1_s_1_l_Expiration_Year"));
		        ccyearfield.click();
		        ccyear = driver.findElement(By.id("1_Expiration_Year"));
		        ccyear.sendKeys(cyear);
		    	}
		    }
		    
		   //savefunc();
		
	}
	
	
	public static void vehicles(WebDriver driver,String accountype,String sheetpath, int Rownum) throws AWTException, InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException 
	{
		WebElement addvehicle = null;
	    WebElement platenumberfield = null;
	    WebElement platenumber = null;
	    WebElement plateyearfield = null;
	    WebElement plateyear = null;
	    WebElement platemakefield = null;
	    WebElement platemake = null;
	    WebElement platemodelfield = null;
	    WebElement platemodel = null;
	    
	    alwayswait(5);
	    
	    
	    String pname = ExcelRead(accountype, sheetpath, Rownum, 20);
	    String pyear = ExcelRead(accountype, sheetpath, Rownum, 21);
	    String pmake = ExcelRead(accountype, sheetpath, Rownum, 22);
	    String pmodel = ExcelRead(accountype, sheetpath, Rownum, 23);
	    
	    
	    
	   
	    	int i= 1;
	    	addvehicle= driver.findElement(By.id("s_1_1_14_0_Ctrl"));
	    	addvehicle.click();
	    	platenumberfield = driver.findElement(By.id("1_s_1_l_Plate_Number"));
	    	platenumberfield.click();
	    	platenumber = driver.findElement(By.name("Plate_Number"));
	    	//Plate number formatted with date
	    	Date d=new Date();
			SimpleDateFormat df=new SimpleDateFormat("mmssS");	
			platenumber.sendKeys("FL"+df.format(d));
	    	//platenumber.sendKeys(pname+i);
	    	plateyearfield = driver.findElement(By.id("1_s_1_l_Year_of_Vehicle"));
	    	plateyearfield.click();
	    	plateyear = driver.findElement(By.id("1_Year_of_Vehicle"));
	    	plateyear.sendKeys(pyear);
	    	platemakefield = driver.findElement(By.id("1_s_1_l_Vehicle_Make"));
	    	platemakefield.click();
	    	platemake = driver.findElement(By.id("1_Vehicle_Make"));
	    	platemake.sendKeys(pmake);
	    	platemodelfield = driver.findElement(By.id("1_s_1_l_Vehicle_Model"));
	    	platemodelfield.click();
	    	platemodel = driver.findElement(By.id("1_Vehicle_Model"));
	    	platemodel.sendKeys(pmodel);
	    
	    
	    
	    	
	    	//savefunc();
	    	
	    	alwayswait(3);
	    	/*int value = driver.findElements(By.id("btn-accept")).size();
	    	System.out.println("Value is " +value);
	    	if(value>0)
	    	{	
	    	while(driver.findElement(By.id("btn-accept")).isDisplayed())
	    	{
	    		i++;
	    		alwayswait(1);
	    		
	    		driver.findElement(By.id("btn-accept")).click();
	    		plateyearfield.click();
	    		platenumberfield.click();
	    		platenumber = driver.findElement(By.name("Plate_Number"));
	    		platenumber.clear();
	    		platenumber.sendKeys(pname+i);    		
	    		//savefunc();
	    		
	    		alwayswait(3);
	    	}
	    	}*/
	    	
	    
		
	}
	
	
	public static void devicerequest(WebDriver driver,String accountype,String sheetname,int Rownum) throws AWTException, EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException 
	{
		WebElement adddevicerequest = null;
	    WebElement devicedescfield = null;
	    WebElement devicedesc = null;
	    WebElement modelselector = null;
	    
	    WebElement modelnumber = null;
	    
	    String drequesttype = ExcelRead(accountype, sheetname, Rownum, 24);
	    String drequestvalue = ExcelRead(accountype, sheetname, Rownum, 25);
	    
	    
	    if(accountype.equals("Private"))
	    {
	    	adddevicerequest= driver.findElement(By.id("s_1_1_11_0_Ctrl"));
	    	adddevicerequest.click();
	    	//devicedescfield = driver.findElement(By.id("1_s_2_l_Smart_Issue_Id"));
	    	//devicedescfield.click();
	    	devicedesc = driver.findElement(By.id("s_1_2_32_0_icon"));
	    	devicedesc.click();
	    	alwayswait(5);
	    	modelselector = driver.findElement(By.name("s_3_1_38_0"));
	    	modelselector.clear();
	    	modelselector.sendKeys(drequesttype);
	    	modelnumber = driver.findElement(By.name("s_3_1_39_0"));
	    	modelnumber.sendKeys(drequestvalue);
	    	modelnumber.sendKeys(Keys.ENTER);    	
	    	
	    	driver.findElement(By.xpath(".//*[@id='1_s_1_l_Plate_Number']")).click();
	    	driver.findElement(By.xpath(".//*[@id='s_1_2_24_0_icon']")).click();
			driver.findElement(By.xpath(".//*[@class='siebui-popup-btm']/child::span[1]")).click();
	    	//savefunc();
	    }
	    else
	    {
	    	adddevicerequest= driver.findElement(By.id("s_1_1_11_0_Ctrl"));
	    	adddevicerequest.click();
	    	devicedescfield = driver.findElement(By.id("1_s_1_l_Smart_Issue_Id"));
	    	devicedescfield.click();
	    	devicedesc = driver.findElement(By.id("s_1_2_32_0_icon"));
	    	devicedesc.click();
	    	modelselector = driver.findElement(By.name("s_3_1_38_0"));
	    	modelselector.clear();
	    	modelselector.sendKeys(drequesttype);
	    	modelnumber = driver.findElement(By.name("s_3_1_39_0"));
	    	modelnumber.sendKeys(drequestvalue);
	    	modelnumber.sendKeys(Keys.ENTER);    	
	    	//savefunc();
	    }
		
	}
	
	public static void addplan(WebDriver driver,String plantoadd) throws AWTException 
	{
		    WebElement adddPlan = null;
	        WebElement planName = null;  	   
	    	adddPlan= driver.findElement(By.id("s_3_1_12_0_Ctrl"));
	    	adddPlan.click();
	    	planName = driver.findElement(By.id("1_Plan_Name"));
	    	planName.sendKeys(plantoadd);    	

		
	}
	
	
	public static void addPaymentList(WebDriver driver,String accountype,String sheetpath,int Rownum) throws AWTException, InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException 
	{
		WebElement addPayment = null;
		WebElement processPay = null;
		alwayswait(10);
		Robot r  = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	
	    	alwayswait(10);
	    	
	    	addPayment= driver.findElement(By.xpath("//div[div[text()='Payments List']]//span[text()='New']"));
	    	
	    	//addPayment= driver.findElement(By.id("s_3_1_13_0_Ctrl"));
	    	while(!addPayment.isEnabled())
	    	{
	    		addPayment= driver.findElement(By.xpath("//div[div[text()='Payments List']]//span[text()='New']"));
	    	}
	    	addPayment.click();	
	    	String Rpaytype = ExcelRead(accountype, sheetpath, Rownum, 16);
	    	String checkno = ExcelRead(accountype, sheetpath, Rownum, 17);
	    	if(Rpaytype.equals("CHECK"))
	    	{
	    	WebElement checknumberbox = driver.findElement(By.xpath("//td[contains(@id,'Check_Number')]"));
	    	checknumberbox.click();
	    	WebElement checknum = driver.findElement(By.id("1_Check_Number"));
	    	checknum.sendKeys(checkno);
	    	
	    	}
	    	//alwayswait(2);
	    	//savefunc();
	    	

	    	driver.findElement(By.xpath("//div[div[text()='Payments List']]//span[text()='Save']")).click(); //save
	    	System.out.println("Clicked save Button");
	    	alwayswait(2);
		    r.keyPress(KeyEvent.VK_ENTER);
		    r.keyRelease(KeyEvent.VK_ENTER);
		    System.out.println("Pressed Enter Key");
		    alwayswait(2);
		    processPay= driver.findElement(By.xpath("//span[text()='Process Pay']"));
	    	processPay.click();
	    
		
	}

	
	public static void savefunc() throws AWTException
	{
		    Robot r  = new Robot();
		    r.keyPress(KeyEvent.VK_CONTROL);
		    r.keyPress(KeyEvent.VK_S);
		    r.keyRelease(KeyEvent.VK_CONTROL);
		    r.keyRelease(KeyEvent.VK_S);
		    
	}
	
	public static void deviceAssignment(WebDriver driver) throws InterruptedException, AWTException
	{
		WebElement Devicestab = driver.findElement(By.xpath("//a[text()='Devices']"));
	    Devicestab.click();
	    WebElement DeviceAssignmenttab = driver.findElement(By.xpath("//a[text()='Device Assignment']"));
	    DeviceAssignmenttab.click();
	    WebElement assignnew = driver.findElement(By.xpath("//button[@title='Device Assign:New']"));
	   	assignnew.click();
	  	alwayswait(4);
	   	WebElement assignmentaicon = driver.findElement(By.xpath("//span[@id='s_1_2_20_0_icon']"));
    	assignmentaicon.click();
    	WebElement Ok = driver.findElement(By.xpath("//button/span[text()='Ok']"));
    	Ok.click();
    	alwayswait(2);
	   	//savefunc();	   
	    System.out.println("Devices assigned");
	}
	public static void alertfunc(WebDriver driver)
	{
		Alert a = driver.switchTo().alert();		   
		a.accept();
	}

	
	public static void backdate(String accountnumber) throws SQLException
	{
		
		DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver()); 
		   String dbURL = "jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)(HOST = 10.36.20.51)(PORT = 1521))(CONNECT_DATA = (SERVER = DEDICATED)(SERVICE_NAME = njrbtst)))";
        String strUserID = "pbatch";
        String strPassword = "batchp"; 
        Connection c=DriverManager.getConnection(dbURL,strUserID,strPassword);
        String Statement1 = "update S_asset set START_DT = TO_DATE('2015/01/01', 'yyyy/mm/dd') where ROW_ID  in (select ROW_ID from s_asset a, v_etc_account etc where a.X_ETC_ACCOUNT_ID = etc.ETC_ACCOUNT_ID and etc.ACCOUNT_NO in ('"+accountnumber+"')and TYPE_CD = 'ACCOUNT PLAN')"; 
        String Statement2 = "update S_asset set START_DT = TO_DATE('2015/01/01', 'yyyy/mm/dd') where ROW_ID  in (select ROW_ID from s_asset a, v_etc_account etc where a.X_ETC_ACCOUNT_ID = etc.ETC_ACCOUNT_ID and etc.ACCOUNT_NO in ('"+accountnumber+"')and TYPE_CD = 'DEVICE')";
        String Statement3 = "update S_asset set INSTALL_DT = TO_DATE('2015/01/01', 'yyyy/mm/dd') where ROW_ID  in (select ROW_ID from s_asset a, v_etc_account etc where a.X_ETC_ACCOUNT_ID = etc.ETC_ACCOUNT_ID and etc.ACCOUNT_NO in ('"+accountnumber+"')and TYPE_CD = 'DEVICE')";
        String Statement4= "Update s_org_ext_x   set attrib_21 = 05 where par_row_id in   (select row_id from s_org_ext crm_account where crm_account.service_emp_cnt in (select ETC_ACCOUNT_ID from v_etc_account where ACCOUNT_NO in ('"+accountnumber+"')))";
        String Statement5= "Update s_org_ext set last_mgr_revw_dt = '01-JAN-2015' where SERVICE_EMP_CNT in (select ETC_ACCOUNT_ID from v_etc_account where ACCOUNT_NO in ('"+accountnumber+"'))";
        c.createStatement().executeQuery(Statement1);
        c.createStatement().executeQuery("Commit");
        c.createStatement().executeQuery(Statement2);
        c.createStatement().executeQuery("Commit");
        c.createStatement().executeQuery(Statement3);
        c.createStatement().executeQuery("Commit");
        c.createStatement().executeQuery(Statement4);
        c.createStatement().executeQuery("Commit");
        c.createStatement().executeQuery(Statement5);
        c.createStatement().executeQuery("Commit");
   	   c.close();
	}
	
	public static void accCreation(WebDriver driver,String accountype,String Sheetpath,int Rownum) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException, AWTException{
		
		WebElement accOpentab =driver.findElement(By.xpath("//a[contains(text(),'Account Opening')]"));
	    accOpentab.click();
	    
	    alwayswait(10);
	   // controlplus(driver, "N");
	    
	    String pin = ExcelRead(accountype,Sheetpath , Rownum, 5);
	    String companyname = ExcelRead(accountype, Sheetpath, Rownum,6);
	    String fname = ExcelRead(accountype, Sheetpath, Rownum, 7);
	    String lname = ExcelRead(accountype, Sheetpath, Rownum, 8);
	    String Phone = ExcelRead(accountype, Sheetpath, Rownum, 9);
	    String Address1 = ExcelRead(accountype, Sheetpath, Rownum, 10);
	    String Address2 = ExcelRead(accountype, Sheetpath, Rownum, 11);
	    String pincode = ExcelRead(accountype, Sheetpath, Rownum, 12);
	    
	    
	    if(accountype.equals("Private"))
	    {	
	    	
	   	    generaldetails(driver, pin,1, companyname,Sheetpath,Rownum);
	   	    contactdetailsPrivate(driver,fname,lname,Phone);
		    addressDetailsPrivate(driver, Address1, Address2, pincode);
		    
	    }
	    else if(accountype.equals("Business"))
	    {
	    	generaldetails(driver, pin,2, companyname,Sheetpath,Rownum);
	    	contactdetailsBusiness(driver,fname,lname,Phone);
		    addressDetailsPrivate(driver, Address1, Address2, pincode);
	    }
	    else 
	    {
	    	generaldetails(driver, pin,3, companyname,Sheetpath,Rownum);
	    	contactdetailsBusiness(driver,fname,lname,Phone);
	    	addressDetailsBusiness(driver, Address1, Address2, pincode);
	    }
	    	
	   	    
	    
	    
	   // WebElement savebtn = driver.findElement(By.xpath("//button[@id='s_3_1_16_0_Ctrl']"));
	   // savebtn.click();
	    
	   //savefunc();
	   alwayswait(3);
	//   if(ExpectedConditions.alertIsPresent() != null)
	//   {	   
	//   alertfunc(driver);
	   
	//   }
	 alwayswait(6);
	   
	    WebElement Replenishments =driver.findElement(By.xpath("//a[text()='Replenishments']"));
	   
	    Replenishments.click();
	    replenishment(driver,accountype,Sheetpath,Rownum);
	    
	   // Alert a =  driver.switchTo().alert();
	   // a.accept();
	 
	    
	    	WebElement vehicles =driver.findElement(By.xpath("//li[a[text()='Vehicles']]"));
		    alwayswait(5);
		    vehicles.click();
		    vehicles(driver,accountype,Sheetpath,Rownum);
		    WebElement devicerequest =driver.findElement(By.xpath("//li[a[text()='Device Request']]"));
		    alwayswait(2);
		    devicerequest.click();
		    devicerequest(driver,accountype,Sheetpath,Rownum);
		    WebElement plans =driver.findElement(By.xpath("//li[a[text()='Plans']]"));
		    alwayswait(2);
		    plans.click();
		    //String planname = "BUSINESS";
		    //addplan(driver,planname);
		    //WebElement business = driver.findElement(By.xpath("//li[text()='"+planname+"']"));
		    //business.click();
		    
		    
		    WebElement paybtn = null;
		    paybtn = driver.findElement(By.xpath("//span[text()='Pay']"));
	    	paybtn.click();
		    addPaymentList(driver, accountype,Sheetpath,Rownum);
		    
		    alwayswait(10);
		    alertfunc(driver);
		    alwayswait(10);	   
		    WebElement Accountinfotab = driver.findElement(By.xpath("//a[text()='Account Info']"));
		    Accountinfotab.click();
		     
		    
		   String accountNumber = driver.findElement(By.xpath("//input[@aria-label ='Acct #']")).getAttribute("value");;
		   System.out.println("accountnumber is "+accountNumber);
		   ExcelWrite(accountype, Sheetpath, Rownum, 0, "Y"); 
		   ExcelWrite(accountype, Sheetpath, Rownum, 4,accountNumber);
		   //deviceAssignment(driver);
		 //  backdate(accountNumber);	   
		   
		  
	}
	

	
	public static void  main(String args[]) throws InterruptedException, AWTException, EncryptedDocumentException, InvalidFormatException, IOException, SQLException
	{
		
	    
		System.setProperty("webdriver.chrome.driver", "D:\\Sumit Selenium\\TSG\\chromedriver.exe");
	    //Disable Chrome Developer Mode Extensions
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-extensions");
	    WebDriver driver = new ChromeDriver(options);
	    
	    final long startTime = System.currentTimeMillis();
	    String Sheetpath =  "D:\\Personal_Documents\\Selenium Roughwork\\Sandeep Script Acc Creation\\Datasheet.xlsx";
	    String accountype = ExcelRead("LoginDetails", Sheetpath, 1, 3); 
		String URL = ExcelRead("LoginDetails", Sheetpath, 1, 0);
		System.out.println(URL);
	    driver.get(URL);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();

	    WebElement username = driver.findElement(By.id("s_swepi_1"));
	    WebElement password = driver.findElement(By.id("s_swepi_2"));
	    WebElement Loginbtn = driver.findElement(By.xpath("//input[@value='Login']"));
	    String uname = ExcelRead("LoginDetails", Sheetpath, 1, 1);
	    String pwd = ExcelRead("LoginDetails", Sheetpath, 1, 2);
	    username.sendKeys(uname);
	    password.sendKeys(pwd);
	    Loginbtn.click();
	    alwayswait(100);	    
	    int i=1;
	    int Rownum=1;
	    String Dataused=ExcelRead(accountype, Sheetpath, i, 0);
	    
	    while(!Dataused.equals("END"))
	    {	
	    	if(Dataused.equalsIgnoreCase("N"))
	    	{
	    		System.out.println("Dataused: "+ExcelRead(accountype, Sheetpath, i, 8));
	    		alwayswait(30);
	    		accCreation(driver,accountype,Sheetpath,Rownum);
	    	}
	    	
	    	i++;	
	    	Dataused = ExcelRead(accountype, Sheetpath, i, 0);
	    	Rownum = i;	 
	   
	    }	
	    
	    System.out.println(Rownum);

	    final long endTime = System.currentTimeMillis();
		   System.out.println("Time taken to create Account "+(endTime-startTime)/1000 + " Seconds");
		   driver.quit();
	    
	    }
	    
	      		
	}
	



