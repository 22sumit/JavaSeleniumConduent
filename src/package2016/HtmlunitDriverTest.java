package package2016;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HtmlunitDriverTest {
	WebDriver driver;
	String url="http://www.desidime.com/forums/hot-deals-online";
	
	@Test
	public void titleName(){
		driver=new HtmlUnitDriver();
		
	}
}
