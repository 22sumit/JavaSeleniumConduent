package myJava;

import java.util.Scanner;

public class AlternateCharsofName {

	public static void main(String[] args) {
		String name="Sumit Kumar Burnwal";
		Scanner sc=new Scanner(System.in);
		
		int l=name.length();
		for(int i=0;i<l;i++){
			if (i%2!=0)
			System.out.print(name.charAt(i));
		}
	}

}
