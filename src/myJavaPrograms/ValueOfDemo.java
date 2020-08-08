package myJava;
//double to string and string to int
public class ValueOfDemo {

	public static void main(String[] args) {
		double a=10.09;
		String s=String.valueOf(a);// converts double to string
		System.out.println(s);
		String s1="200";
		String s2="Sum";
		int b=Integer.parseInt(s1);
		System.out.println(s1+100+s2);
		System.out.println(100.1+b);
	}

}
