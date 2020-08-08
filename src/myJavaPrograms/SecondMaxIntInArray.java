package myJava;

public class SecondMaxIntInArray {

	public static void main(String[] args) {
		int[] a={10,40,80,70,100};
		int max=a[0];
		int smax=a[1];
		for(int i=0;i<a.length;i++){
			if (a[i]>max){
				smax=max;
				max=a[i];
			} else if (a[i]>smax &&a[i]!=max){
				smax=a[i];
			}
		}
		System.out.println("Max: "+max);
		System.out.println("Second Max: "+smax);
	}

}
