package sumPackage;

import org.testng.annotations.Factory;
//linked with FactoryTest.java
public class SampleFactory{
	@Factory
	public Object[] fm(){
		Object[] data=new Object[]{
				new FactoryTest("one"),
				new FactoryTest("two")
				};
		return data;
	}
	
}