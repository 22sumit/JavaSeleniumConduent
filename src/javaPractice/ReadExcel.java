package javaPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		File file=new File ("D:\\Padhai\\SeleniumPractice\\TestSe.xlsx");
		FileInputStream fin=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet sh=wb.getSheetAt(0);
		String value=sh.getRow(0).getCell(0).getStringCellValue();
		System.out.println(value);
				
		sh.getRow(0).createCell(2).setCellValue("SUMIT");
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		wb.close();
	}

}
