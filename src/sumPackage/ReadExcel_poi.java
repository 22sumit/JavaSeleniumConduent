package sumPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel_poi{
		String[][] strarr=null;
		
		@Test
		public void ReadEx() throws IOException{
		File xlsxfile=new File("D:\\Padhai\\Selenium Docs\\DataProviderExcel.xlsx");
		FileInputStream fin=new FileInputStream(xlsxfile);	
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet sh=wb.getSheet("Sheet1");
		int rowcount=sh.getLastRowNum();
		strarr=new String[rowcount][1];
		System.out.println(rowcount);
		for(int i=0;i<=rowcount;i++){
			XSSFRow row=sh.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++){
				strarr[i][j]=row.getCell(j).getStringCellValue();
		}

}
}
}

