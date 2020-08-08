package sumPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	/**
	 * @param filepath
	 * @param filename
	 * @param sheetname
	 * @throws IOException
	 */
	public void read(String filepath,String filename,String sheetname) throws IOException{
		File file=new File(filepath+"\\"+filename);
		FileInputStream fin=new FileInputStream(file);
		Workbook wb= new XSSFWorkbook(fin);
		Sheet sh=wb.getSheet(sheetname);
		int rowcount=sh.getLastRowNum()+1-sh.getFirstRowNum();
		System.out.println(sh.getLastRowNum());
		for(int i=0;i<rowcount;i++){
			Row row=sh.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++){
				System.out.println(row.getCell(j).getStringCellValue()+"||");
			}
			System.out.println();
		}
				
	}
	
	public void writeExcel(String path) throws InvalidFormatException, IOException{
		File file=new File(path);
		//FileInputStream fin=new FileInputStream(path);
		/*XSSFWorkbook wb1=new XSSFWorkbook(file);
		XSSFSheet sh1=wb1.getSheetAt(0);
		sh1.getRow(1).createCell(2).setCellValue("Pass");*/
		
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		Row row=sh.getRow(0);
		Cell cell=row.createCell(2);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue("Pass");
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
		fos.close();
		
	}

	public static void main(String[] args) throws IOException, InvalidFormatException {
		ExcelRead objExcelFile=new ExcelRead();
		String filepath="D:\\Padhai\\Selenium Docs";
		//objExcelFile.read(filepath,"DataProviderExcel.xlsx","Sheet1");
		objExcelFile.writeExcel("D:\\Padhai\\SeleniumPractice\\SeleniumRebirth\\Test Data\\TestExcel.xlsx");
	}

}
