package testNGListenersDemo;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;

@Listeners(testNGListenersDemo.TestNGListener.class)
//either add the above line of listeners or use the testngListeners.xml to run this test
public class VerifyListeners {
	
	@Test
	public void verifyTrue(){
		Assert.assertTrue(true);
	}
	
	@Test
	public  void verifyFalse(){
		Assert.assertTrue(false);
	}
}
