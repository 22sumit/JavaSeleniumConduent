package sumPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkart {

	public static void main(String[] args) {
		System.setProperty("webdriver.driver.chrome","F:\\Padhai\\SeleniumPractice\\SeleniumRebirth\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.flipkart.com");
		//driver.findElement(By.partialLinkText("Gift Voucher")).click();
		
        //extract the link texts of each link element
		
/*		List<WebElement> linkelements= driver.findElements(By.tagName("a"));
		String[] linkTexts = new String[linkelements.size()];
        int i = 0;
        for (WebElement e : linkelements) {
            linkTexts[i] = e.getText();
            i++;
            for (String t : linkTexts) {
            	System.out.println(t);*/
            }
		//driver.findElement(By.id("fk-top-search-box")).sendKeys("sony");
		//driver.findElement(By.id("fk-top-search-box")).sendKeys(Keys.ENTER);


}
