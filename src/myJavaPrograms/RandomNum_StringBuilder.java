package myJava;

//Using StringBuffer and Random class

import java.util.Random;

public class RandomNum_StringBuilder {

	public static void main(String[] args) {
		
		Random r=new Random();
		int arr[]=new int[5];
		for(int i=0;i<5;i++){
		int n=r.nextInt(9);
		//System.out.println(n);
		arr[i]=n;
		}
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<arr.length;i++){
			sb.append(arr[i]);
		}
		String str=sb.toString();
		System.out.println(str+"sumit");
	}
}
