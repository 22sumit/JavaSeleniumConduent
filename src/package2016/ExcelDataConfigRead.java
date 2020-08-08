package package2016;

public class ExcelDataConfigRead {

	public static void main(String[] args) throws Exception {
		ExcelDataConfig2 excel=new ExcelDataConfig2("D:\\Padhai\\SeleniumPractice\\TestSe.xlsx");
		//excel.getData(0, 0, 0);
		String[] cellData=excel.getData(0, 0, 0);
		for(int i=0;i<cellData.length;i++){
		System.out.println(cellData[i]);
	}
	}
}
