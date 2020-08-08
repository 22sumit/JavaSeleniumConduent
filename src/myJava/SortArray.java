package myJava;

public class SortArray {

	public static void main(String[] args) {
		int a[]={10,90,40,30,70};
		
		int n = a.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
         for(int j=1; j < (n-i); j++){  
	          if(a[j-1] < a[j]){  
	                 //swap elements  
	                 temp = a[j-1];  
	                 a[j-1] = a[j];  
	                 a[j] = temp;  
	         }  
          }
	}
         for(int j=0;j<a.length;j++){
 			System.out.println(a[j]);
 		}
	}
}
