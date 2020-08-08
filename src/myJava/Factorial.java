package myJava;

import java.util.Scanner;

public class Factorial {

	static int fact=1;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the no. to calculate factorial");
		int n= sc.nextInt();
		sc.close();
		if (n<0) {
			System.out.println("Number can't be negative");
		}
		for (int i=1;i<=n;i++){
			fact=fact*i;
		}
		System.out.println("Factorial of "+n+" is: " +fact);
	}
}
/* ************USING RECURSIVE FUNCTION***************
static int s=1;
public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the number: ");
	int n=sc.nextInt();
	if (n<0) {
		System.out.println("Enter a valid number!!");
	}
	else System.out.println(f(n));
	}
public static int f(int n){
	if (n==0) return 1;
	else return n*f(n-1);
}*/
