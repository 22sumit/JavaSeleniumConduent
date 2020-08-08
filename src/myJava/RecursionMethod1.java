package myJava;

import java.util.Scanner;

//Recursive function demo
public class RecursionMethod1 {
	
	static int x;
	public static void main(String[] args) {
	@SuppressWarnings("resource")
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the number: ");
	int n=sc.nextInt();
	int f=fact(n);
	System.out.println("Factorial of "+n+ " is "+f);
	System.out.println("fibonacci series upto " +n+ " digits are: ");
	for (int i=0;i<=n-1;i++){
		System.out.println("   "+fib(i));
	}
	}
	//factorial
	public static int fact(int n){
		if(n==0 || n==1) return 1;
		else
		return n*fact(n-1);
	}
	
	//fibonacci
	public static int fib(int n){
		if (n==0 || n==1) return n;
		
		else return fib(n-1)+fib(n-2);
		
	}

}
