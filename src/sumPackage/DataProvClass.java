package sumPackage;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

//DataProvider defined in another class and using parameter as 'Method'
public class DataProvClass {
	@DataProvider(name="searchtext")
	public static Object[][] getdatafromDataProvider(Method m){
		if(m.getName().equalsIgnoreCase("methodA")){
		return new Object[][]{
				{"Sumit", "India"},
				{"Heidi", "USA"},
				{"George", "UK"}
		};}
		else {
			return new Object[][]{
					{"Sumit"},
					{"Heidi"},
					{"George"}
		};
	}
}
}