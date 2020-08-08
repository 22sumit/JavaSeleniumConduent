
package reader;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;

public class ReadFile {

  private String inputFile1;
 

public String password,FeedBackName,ProjectName,FeedBackDetails,CustomerEmail,TypeOfFeedBack;
public String username2,username1,tm_remarks;
public String overallRating,overallRemarks;
public String DeliveredRemarks,DeliveredRating;







  public void setInputFile(String inputFile) {
    this.inputFile1 = inputFile;
  }

  public void read() throws BiffException, IOException  {
    File inputWorkbook = new File(inputFile1);//inputFile
    Workbook w;

    try {
      w = Workbook.getWorkbook(inputWorkbook);
      // Get the first sheet
      Sheet sheet = w.getSheet(0);
      // Loop over first 10 column and lines

   
      System.out.println(sheet.getCell(1, 0).getContents());
          Cell cell1 = sheet.getCell(1, 1);
          this.username1=cell1.getContents();
          System.out.println(username1);
          
          Cell cell2 = sheet.getCell(1, 2);
          this.password=cell2.getContents();
          System.out.println(password);
          
          Cell cell3 = sheet.getCell(1, 3);
          this.FeedBackName=cell3.getContents();
          System.out.println(FeedBackName);
          
          Cell cell4 = sheet.getCell(1,4);
          this.ProjectName=cell4.getContents();
          System.out.println(ProjectName);
          
          Cell cell5 = sheet.getCell(1,5);
          this.FeedBackDetails=cell5.getContents();
          System.out.println(FeedBackDetails);
          
          Cell cell6 = sheet.getCell(1,6);
          this.CustomerEmail=cell6.getContents();
          System.out.println(CustomerEmail);
          
          Cell cell7 = sheet.getCell(1,7);
          this.TypeOfFeedBack=cell7.getContents();
          System.out.println(TypeOfFeedBack);
          
          Cell cell8 = sheet.getCell(1, 8);
          this.tm_remarks=cell8.getContents();
          System.out.println(tm_remarks);
          
          Cell cell9 = sheet.getCell(1, 9);
          this.overallRating=cell9.getContents();
          System.out.println(overallRating);
         
          
          Cell cell10 = sheet.getCell(1, 10);
          this.overallRemarks=cell10.getContents();
          System.out.println(overallRemarks);
          
          
          Cell cell11 = sheet.getCell(1, 11);
          this.DeliveredRating=cell11.getContents();
          System.out.println(DeliveredRating);
         
          Cell cell12 = sheet.getCell(1, 12);
          this.DeliveredRemarks=cell12.getContents();
          System.out.println(DeliveredRemarks);
         
          
          
          
       
          
  
        
          
          
          
          /*CellType type = cell.getType();
          if (type == CellType.LABEL) {
            System.out.println("I got a label "
                + cell.getContents());
          }

          if (type == CellType.NUMBER) {
            System.out.println("I got a number "
                + cell.getContents());
          }*/
          
        
      
    }catch (BiffException e) {
      e.printStackTrace();
    }

  }

public static void main(String[] args) throws IOException {
    ReadFile test = new ReadFile();
    test.setInputFile("C:/Users/vpujar/Desktop/PCSAT/TCTD/test.xls");
    try {
		test.read();
	} catch (BiffException e) {

		e.printStackTrace();
	}


}
}  