package myJava;

public class PrivateAccessTest {
	private int x;
	
	public void setx(int y){
		x=(y>70?70:(y>24?y:0));
	}
	public int getx(){
		return x;
	}

	public static void main(String[] args) {
		PrivateAccessTest p1=new PrivateAccessTest();
		p1.setx(25);
		int a=p1.getx();
		System.out.println("x: "+a);

	}

}
