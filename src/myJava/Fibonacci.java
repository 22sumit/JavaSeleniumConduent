package myJava;

import java.util.Scanner;

public class Fibonacci {

	public int fib(int x){
		if (x==1 || x==2){
			return 1; 
		}
		
		return fib(x-1)+fib(x-2);
		
		
	}
	public static void main(String[] args) {
		Fibonacci f1=new Fibonacci();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number: ");
		int x=sc.nextInt();
		sc.close();
		System.out.println("Fibonacci series upto "+x+" numbers is: ");
		for(int i=1;i<=x;i++)
		System.out.println(f1.fib(i));
	}

}
