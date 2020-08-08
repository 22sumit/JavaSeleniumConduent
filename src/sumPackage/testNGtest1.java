package sumPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testNGtest1 {
  @Test
  public void f() {
	  Assert.fail();
  }
  
  @Test
  public void g(){
	  Assert.assertTrue(true);
  }
}
