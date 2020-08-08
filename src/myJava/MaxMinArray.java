package myJava;

public class MaxMinArray {

	public static void main(String[] args) {
		int[] a={40,20,60,10,30};
		int max=0;
		//int min=0;
		int temp;
		for (int i=0;i<a.length-1;i++){
			max=a[i];
			System.out.println("max1: "+max);
			if (max>a[i+1]){
				System.out.println("Before a["+i+"] & a["+i+1+"]: "+a[i]+"   "+a[i+1]);
				temp=a[i];
				a[i]=a[i+1];
				a[i+1]=temp;
				System.out.println("After Swapping a["+i+"] & a["+i+1+"]: "+a[i]+"   "+a[i+1]);
			}
			System.out.println("Maximum digit: "+max);
		}
		/*for (int i=0;i<a.length-1;i++){
			min=a[i];
			System.out.println("min1: "+min);
			if (min<a[i+1]){
				temp=a[i];
				a[i]=a[i+1];
				a[i+1]=temp;
			}
			System.out.println("min2: "+min);
		}
		System.out.println("Minimum digit: " +min);*/
	}

}
