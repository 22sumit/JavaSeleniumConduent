package myJava;

import java.util.Arrays;

//Reverse an integer array

public class ReverseArray {

	public static void main(String[] args) {
		int a[]={10,40,20,30,60};
		int temp=0;
		for(int i=0;i<a.length/2;i++){
			temp=a[i];
			a[i]=a[a.length-i-1];
			a[a.length-i-1]=temp;
	}
		for (int j=0;j<a.length;j++){
			System.out.println(a[j]);
		}
		
		System.out.println("pos "+Arrays.asList(a).indexOf(2));
	}
	
}
