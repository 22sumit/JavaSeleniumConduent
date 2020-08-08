package reader;
//creating the excel library to be used anywhere
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	int rowcount;
	String[] Data1=null;
	
	public ExcelDataConfig(String filepath) throws IOException{
		
		File file=new File(filepath);
		FileInputStream fin=new FileInputStream(file);
		wb=new XSSFWorkbook(fin);
		sheet=wb.getSheet("Sheet1");
		

	}
	
	public void getData(int sheetnum,int row, int col){
		//String Data1=sheet.getRow(row).getCell(col).getStringCellValue();
		rowcount=sheet.getLastRowNum()+1;
		Data1=new String[rowcount];
		for(int rows=0;rows<rowcount;rows++){
			Data1[rows]=sheet.getRow(rows).getCell(col).getStringCellValue();
			int dataType=sheet.getRow(rows).getCell(col).getCellType();
			switch (dataType){
			case 0:double c=sheet.getRow(rows).getCell(col).getNumericCellValue();
					break;
			case 1:String s=sheet.getRow(rows).getCell(col).getStringCellValue();
					break;
			case 4:Boolean b=sheet.getRow(rows).getCell(col).getBooleanCellValue();
					break;
			case 3:System.out.print(" "+" ");
                	break; 
			default:
                	System.out.print("inside the default..");
			}
			System.out.println(Data1[rows]);
		}
		//how to return an array containing excel data ??
		

	}
}
