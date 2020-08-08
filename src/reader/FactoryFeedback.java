

	
	package reader;

	import java.io.IOException;
	import java.util.ArrayList;

	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.annotations.Factory;

import PCSAT.FeebackDevelopment;
import PCSAT.FeedBackMaintainance;
import PCSAT.FeedbackTesting;
	import PCSAT.PM1;
import PCSAT.check;

	public  class FactoryFeedback {
		
		@Factory
		  public Object[] createInstances() throws IOException {
			 readtest read1;
			 WebDriver driver = null;
			Object[] result=new Object[1];
		   for (int i = 0; i < 1; i++) {
			 
			   read1= new readtest("C:/Users/vpujar/Desktop/test.xls",i+1);
			   
			   driver=launchbrowser(driver,read1);
			   
			   if(read1.Template.equalsIgnoreCase("1")){
	            result[i]=new FeebackDevelopment(driver,read1);
			   }
			   else if(read1.Template.equalsIgnoreCase("2")){
				   result[i]=new FeedBackMaintainance(driver,read1);
			   }
			   else if(read1.Template.equalsIgnoreCase("3")){
				   result[i]=new FeedbackTesting(driver,read1); 
			   }
		    		  
		   
		    }
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


