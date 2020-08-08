package myJava;

import java.util.Scanner;

public class PalindromeNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n=sc.nextInt();
		int sum=0;
		int a=n;
		while(a>0){
			int i=a%10;
			sum=sum*10+i;
			a=a/10;
		}
		if(n==sum){
			System.out.println(sum+" P");
		}
		else System.out.println(sum+" NP");
		sc.close();
	}

}
