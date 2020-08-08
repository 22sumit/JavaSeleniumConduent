package package2016;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertiesFileDemo {
	
	//FileInputStream fin;
	public static void main (String[] args){
	//public void readProp(){
	File file=new File("D:\\Padhai\\SeleniumPractice\\SeleniumRebirth\\src\\package2016\\dataFile.properties");
	FileInputStream fin = null;
	try {
		fin=new FileInputStream(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Properties prop=new Properties();
	try {
		prop.load(fin);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	WebDriver driver=new FirefoxDriver();
	driver.get(prop.getProperty("url"));
	driver.findElement(By.xpath(".//*[@id='loginBarHandle']/label/a")).click();
	driver.findElement(By.xpath(".//*[@id='LoginControl']")).sendKeys(prop.getProperty("username"));
	driver.findElement(By.xpath(".//*[@id='ctrl_password']")).sendKeys(prop.getProperty("password"));
	driver.findElement(By.xpath(".//*[@id='login']/div/dl[3]/dd/input")).click();
}
}
