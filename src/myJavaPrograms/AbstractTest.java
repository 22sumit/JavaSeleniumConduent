package myJava;

abstract class A{
	final static int b=10;
	public void display(){
		System.out.println("Concrete method");
	};

	public abstract void calc(int x);
}

public class AbstractTest extends A{

	public static void main(String[] args) {
		AbstractTest obj=new AbstractTest();
		obj.display();
		//obj.b=20; final value can't be assigned
		obj.calc(b);

	}

	@Override
	public void calc(int y) {
		System.out.println("Square of "+y+ " is: "+(y*y));	
	}

}
