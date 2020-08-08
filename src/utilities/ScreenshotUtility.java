package utilities;
//this is the screenshot utility class to be used anywhere required
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
	public static void CaptureScreenshot(WebDriver driver, String ScrName){
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(source, new File("./Screenshots/"+ScrName+".png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println("ScreenshotCaptured");
	}

	public static String CaptureScreenshot1(WebDriver driver, String ScrName){
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String dest="./Screenshots/"+ScrName+".png";
		try {
			FileUtils.copyFile(source, new File(dest));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ScreenshotCaptured");
		return dest;
		}
	
}
