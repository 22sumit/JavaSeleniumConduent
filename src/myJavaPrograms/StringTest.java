package myJava;

public class StringTest {

	public static void main(String[] args) {
	
    StringBuffer strB=new StringBuffer("This is a beautiful day.");
    StringBuffer strC=new StringBuffer(10);
    strB.replace(2,5,"###");
    System.out.println(strB);
    System.out.println(strB.substring(3));
    System.out.println(strB.reverse());
    System.out.println(strB.length());
    System.out.println(strB.capacity());
    System.out.println(strC.capacity());
	}

}
