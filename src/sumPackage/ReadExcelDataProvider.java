package sumPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ReadExcelDataProvider {
	public WebDriver driver;
	public WebDriverWait wait;
	
	@Test
	public void Setup(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver, 5);
		driver.get("http://ec4dcvm0136.wipro.com:81/PCSAT/login.aspx");
	}
	@Test(dataProvider="empLogin")
	public void Login(String Username, String Password){
		driver.findElement(By.id("txtLoginName")).sendKeys(Username);
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnLogin")));
		driver.findElement(By.id("btnLogin")).click();
		
	}
	
	@DataProvider(name="empLogin")
	public Object[][] Logindata() throws IOException{
		Object[][] data= getExcelData();
		return data;
	}
	
	public String[][] getExcelData() throws IOException{
		String[][] strarr=null;
		File xlsxfile=new File("D:\\E drive\\indigo ide-selenium\\Sum_ReVisit\\DataProviderExcel.xlsx");
		FileInputStream fin=new FileInputStream(xlsxfile);	
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet sh=wb.getSheet("Sheet1");
		int rowcount=sh.getLastRowNum();
		strarr=new String[rowcount][];
		System.out.println(rowcount);
		for(int i=0;i<=rowcount;i++){
			XSSFRow row=sh.getRow(i);
			for(int j=0;j<rowcount-1;j++){
				strarr[i][j]=row.getCell(j).getStringCellValue();
		}	
	}
		return strarr;
}
}
