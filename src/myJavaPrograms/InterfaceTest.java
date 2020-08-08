package myJava;

interface living{
	public void human();
}
public class InterfaceTest implements living {
	public void human(){
		System.out.println("I'm a human being too !!");
	}
	public static void main(String[] args) {
		living h= new InterfaceTest();
		h.human();
	}

}
