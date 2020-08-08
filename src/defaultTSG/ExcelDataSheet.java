package defaultTSG;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataSheet {
	
	@Test
	public void readExcel() throws IOException{
	File file=new File("D:\\Sumit Selenium\\TSG\\TestData\\myExcel.xlsx");
	FileInputStream fin=new FileInputStream(file);
	XSSFWorkbook wb=new XSSFWorkbook(fin);
	XSSFSheet sheet=wb.getSheet("Sheet1");
	int rows=sheet.getLastRowNum()+1;
	System.out.println("rows count: "+rows);
	for(int i=0;i<rows;i++){
		int col=sheet.getRow(i).getLastCellNum();
		for(int j=0;j<col;j++){
			System.out.println(sheet.getRow(i).getCell(j));
			System.out.println();
		}
		wb.close();
	}
	
	}

}
