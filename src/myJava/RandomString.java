package myJava;

import java.util.Arrays;
import java.util.Random;

public class RandomString {

	public static void main(String[] args) {

		char c[]={'a','b','c','d','e','f'};
		String str1="qwertyuiopasdfghjklzxcvbnm";
		Random rnd=new Random();
		String s = "";
		int t=0;
		int arr[]=new int[6];
		StringBuilder sb1=new StringBuilder();
		for(int i=0;i<c.length;i++){
			s=s+sb1.append(str1.charAt(rnd.nextInt(str1.length())));
			arr[i]=new Random().nextInt(9);
			t=arr[i]+t*10;
		}
		//System.out.println(new Random().nextInt(10));
		//System.out.println(c[new Random().nextInt(c.length)]);
		System.out.println("Random String:" +s);
		String str=Arrays.toString(arr);
		System.out.println("Random Number:" +t);
		System.out.println(s+"-"+t);
		//*************************************//
		StringBuilder sb=new StringBuilder();
		for(int j=0;j<4;j++){
			sb.append(str1.charAt(rnd.nextInt(str1.length())));
		}
		String str2=sb.toString();
		System.out.println(str2);
	}

}
