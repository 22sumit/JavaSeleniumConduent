package myJava;

public class RecursionArraySum {
	
	int l;
	static int d;
	int[] arr1;
	static int result;
	public static void main(String[] args) {
		int arr1[]={1,2,3,4,5,6};
		int sum=f(arr1,0,arr1.length-1);
		System.out.println("sum of array: "+sum);
	}
	public static int f(int[] arr2, int l, int s) {
		if (l==s)
			return arr2[s];
		else
		return arr2[l]+f(arr2,l+1,s);
		
	}
	}

