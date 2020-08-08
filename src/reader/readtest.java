package reader;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;


public class readtest {



private String inputFile1;
 

public  String password,FeedBackName,ProjectName,FeedBackDetails,CustomerEmail,TypeOfFeedBack;
public  String userSQA="SQA",userPM="PM",userTM="TM",userAdmin="Admin",tm_remarks;
public  String userSQAPass,userPMPass,userTMPass,UserAdminPass;
public  String overallRating,overallRemarks,TMapproval,Browser;
public  String DeliveredRemarks,DeliveredRating,FeedbackURL,Template;






public readtest(String file,int i) throws IOException{
	
	File inputWorkbook = new File(file);//inputFile
    Workbook w;

    try {
      w = Workbook.getWorkbook(inputWorkbook);
      // Get the first sheet
      Sheet sheet = w.getSheet(0);
      // Loop over first 10 column and lines

   
      //System.out.println(sheet.getCell(i, 0).getContents());
      Cell cell13 = sheet.getCell(i, 0);
      this.userPMPass=cell13.getContents();
      System.out.println(userPMPass);
      
      Cell cell1 = sheet.getCell(i, 1);
      this.userSQAPass=cell1.getContents();
      System.out.println(userSQAPass);
      
      Cell cell14 = sheet.getCell(i, 2);
      this.userTMPass=cell14.getContents();
      System.out.println(userTMPass);
      
      Cell cell3 = sheet.getCell(i, 3);
      this.FeedBackName=cell3.getContents();
      System.out.println(FeedBackName);
      
      Cell cell4 = sheet.getCell(i,4);
      this.ProjectName=cell4.getContents();
      System.out.println(ProjectName);
      
      Cell cell5 = sheet.getCell(i,5);
      this.FeedBackDetails=cell5.getContents();
      System.out.println(FeedBackDetails);
      
      Cell cell6 = sheet.getCell(i,6);
      this.CustomerEmail=cell6.getContents();
      System.out.println(CustomerEmail);
      
      Cell cell7 = sheet.getCell(i,7);
      this.TypeOfFeedBack=cell7.getContents();
      System.out.println(TypeOfFeedBack);
      
      Cell cell8 = sheet.getCell(i, 8);
      this.tm_remarks=cell8.getContents();
      System.out.println(tm_remarks);
      
      Cell cell9 = sheet.getCell(i, 9);
      this.overallRating=cell9.getContents();
      System.out.println(overallRating);
     
      
      Cell cell10 = sheet.getCell(i, 10);
      this.overallRemarks=cell10.getContents();
      System.out.println(overallRemarks);
      
      
      Cell cell11 = sheet.getCell(i, 11);
      this.DeliveredRating=cell11.getContents();
      System.out.println(DeliveredRating);
     
      Cell cell12 = sheet.getCell(i, 12);
      this.DeliveredRemarks=cell12.getContents();
      System.out.println(DeliveredRemarks);
     
      Cell cell2 = sheet.getCell(i, 13);
      this.UserAdminPass=cell2.getContents();
      System.out.println(UserAdminPass);
      

      Cell cell15 = sheet.getCell(i, 14);
      this.FeedbackURL=cell15.getContents();
      System.out.println(FeedbackURL);
      
      Cell cell16 = sheet.getCell(i, 15);
      this.TMapproval=cell16.getContents();
      System.out.println(TMapproval);
           
      Cell cell17 = sheet.getCell(i, 16);
      this.Browser=cell17.getContents();
      System.out.println(Browser); 
       
      Cell cell18 = sheet.getCell(i, 17);
      this.Template=cell18.getContents();
      System.out.println(Template);
      
         
          
       
          
  
        
          
          
          
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
	readtest test = new readtest("C:/Users/vpujar/Desktop/test.xls",1);

 


}
}  

