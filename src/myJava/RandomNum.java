package myJava;
//Inefficient since the 0th element is not coming in string if it's value is 0
import java.util.Arrays;

public class RandomNum {

	public static void main(String[] args) {
		
		int t=0;
		int arr[]=new int[5];
		for(int i=0;i<5;i++){
		int n=(int) (Math.random()*10);
		//System.out.println(n);
		arr[i]=n;
		t=t*10+arr[i];
		}
		System.out.println(Arrays.toString(arr)); //put integers into an array
			// parses the string argument
		    //int a = Integer.parseInt("12");
		System.out.println("t: "+t);
		String str = Integer.toString(t);  //convert an integer to String
		System.out.println(str);
		System.out.println(str+"sumit");
	}
	

}
