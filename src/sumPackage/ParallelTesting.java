package sumPackage;

import org.testng.annotations.Test;

public class ParallelTesting {
	
  @Test
  public void method1() {
	  System.out.println("Now executing thread TC1: "+Thread.currentThread().getId());
  }
  
  @Test
  public void method2() {
	  System.out.println("Now executing thread TC2: "+Thread.currentThread().getId());
  }
  
  @Test
  public void method3() {
	  System.out.println("Now executing thread TC3: "+Thread.currentThread().getId());
  }
}
