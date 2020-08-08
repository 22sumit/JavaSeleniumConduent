package package2016;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinks {
	
	public static List allLinks(WebDriver driver){
		List<WebElement> elementList=driver.findElements(By.tagName("a"));
		elementList.addAll(driver.findElements(By.tagName("img")));
		List finalList=new ArrayList();
		for(WebElement element:elementList){
			if(element.getAttribute("href")!=null){
				finalList.add(element);
			}
		}
		return finalList;	
	}
	
	public static String isLinkBroken(URL url){
		try {
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			connection.connect();
			String response=connection.getResponseMessage();
			connection.disconnect();
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}	
	}
	
	public static void main(String[] args) {
		WebDriver ff=new FirefoxDriver();
		ff.get("http://toolsqa.com/automation-practice-switch-windows/");		
		List<WebElement> str=allLinks(ff);
		for(WebElement element:str){
		try {
			System.out.println("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		}
		ff.quit();
	}

}
