package myJava;

import java.util.Random;

public class RandomNumGen {

	public static void main(String[] args) {
		Random ran=new Random();
		int n=ran.nextInt(100);
		System.out.println(n);
	}

}
