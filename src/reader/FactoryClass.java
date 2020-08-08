package reader;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Factory;

import PCSAT.PM1;
import PCSAT.check;

public  class FactoryClass {
	
	@Factory
	  public Object[] createInstances()   {
		 readtest read1 = null;
		 WebDriver driver = null;
		Object[] result=new Object[1];

	   for (int i = 0; i < 1; i++) {
		   try {
				read1= new readtest("C:/Users/vpujar/Desktop/test.xls",i+1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		  
	        driver=launchbrowser(driver,read1);
			

			// TODO Auto-generated catch block
	        
            result[i]=new PM1(driver,read1);
	        
	    		  //PM1(read1);
	   
	    }
		
	   
	   
	//catch(Exception e){System.out.println("TESTNG!!!!!!!!!!ERROR");
	    return result;
	  }
	
	public WebDriver launchbrowser(WebDriver driver,readtest read1){
		 if(read1.Browser.equalsIgnoreCase("1")){
			  System.out.println("Firefox Browser started!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			   driver=new FirefoxDriver();  
		   }
		   else if(read1.Browser.equalsIgnoreCase("2")){
			   System.out.println("IE Browser started!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		   System.setProperty("webdriver.ie.driver", "E:\\vishwa\\vishwa\\downloads\\indigo ide-selenium (10.201.17.44)\\Ecube\\IEDriverServer.exe");
			 DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			 driver = new InternetExplorerDriver();
		   
		   }else if(read1.Browser.equalsIgnoreCase("3")){
			   System.out.println("Chrome Browser started!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			   System.setProperty("webdriver.chrome.driver", "E:\\vishwa\\vishwa\\downloads\\indigo ide-selenium (10.201.17.44)\\Ecube\\chromedriver.exe");
				 
				 driver = new ChromeDriver();
		   }
		 
		 return driver;
	}
}
