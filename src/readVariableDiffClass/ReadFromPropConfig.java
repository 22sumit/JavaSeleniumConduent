package readVariableDiffClass;

import org.testng.annotations.Test;

public class ReadFromPropConfig {
	
	String url1;
	@Test
	public void test() {
		PropConfigParam read=new PropConfigParam();
		read.readProperty();
		url1=read.url;

	}
	
	@Test
	public void test2(){
		System.out.println("entered URL is: "+url1);
	}

}
