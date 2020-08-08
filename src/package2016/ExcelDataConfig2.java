package package2016;
//creating the excel library to be used anywhere
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig2 {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	int rowcount;
	Object valueofcell;
	String[] Data1=null;
	int rows;
	
	public ExcelDataConfig2(String filepath) throws IOException{
		
		File file=new File(filepath);
		FileInputStream fin=new FileInputStream(file);
		wb=new XSSFWorkbook(fin);
		sheet=wb.getSheet("Sheet1");
	}
	
	public String[] getData(int sheetnum,int row, int col){
			
			int rows=sheet.getLastRowNum()+1; //getting row count
			String[] cellContent=new String[rows]; //initialize a new string array of size= row count
			
			for(int i=0;i<rows;i++){
			for(Cell cellr:sheet.getRow(i)){
				String myCellValue=celltoString(cellr);
				cellContent[i]=myCellValue;
				System.out.println(myCellValue);
			}	
			}
			return cellContent;
		}
		
		public String celltoString(Cell cell1){

			switch (cell1.getCellType()){
			case Cell.CELL_TYPE_STRING:
				valueofcell=cell1.getStringCellValue();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				valueofcell=cell1.getNumericCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				valueofcell=cell1.getBooleanCellValue();
				break;	
			case Cell.CELL_TYPE_BLANK:
				valueofcell="";
				break;
			}
			return valueofcell.toString();
			}
		//return Data1;
		//how to return an array containing excel data ??
/*		for(int i=0;i<rows;i++){
			System.out.println(Data1[i]);
		}*/

	}

