package sumPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//linked with SampleFactory.java, execute SampleFactory.java
public class FactoryTest{
	
	private String i="";
	
	public FactoryTest(String i) {
		this.i=i;
	}
	
	@BeforeClass
	public void MethodBeforeClass(){
		System.out.println("Executing before class");
	}
	@Test
	public void MethodOne(){
		System.out.println("Execution Method One: "+this.i);
	}

}
	
	
