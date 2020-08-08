package sumPackage;

import static org.junit.Assert.fail;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class jUnit {
	
	@BeforeClass
	public static void display1(){
		System.out.println("====================");
	}
	
	@Test
	public void test1(){
		if (add(10,30)==40){
			System.out.println("add passed");
		} else{
			System.out.println("failed to add");
			fail("addition failed");
		}
	}
	
	@Test
	public void test2(){
		if (multiply(10,30)==300){
			System.out.println("Multiplication passed");
		}else {
			System.out.println("failed to multiply");
			fail("multiplication failed");
		}
	}
	
	@AfterClass
	public static void display2(){
		System.out.println("*********************");
	}
	
	public int add(int x, int y){
		return (x+y);
	}

	public int multiply(int x, int y){
		return (x*y);
	}
}
