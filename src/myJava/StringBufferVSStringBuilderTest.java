package myJava;

//String Buffer is synchronised and StringBuilder is not, so the former takes longer time for running.
//It means two threads can't call the methods of StringBuffer simultaneously.
//Unless you are sharing a buffer between threads use StringBuilder.
public class StringBufferVSStringBuilderTest {

	public static void main(String[] args) {
		int N=444444;
		long t;
		
		StringBuffer sb=new StringBuffer();
		t=System.currentTimeMillis();
		for(int i=N;i>0;i--){
			sb.append("");			
		}
		System.out.println(System.currentTimeMillis()-t);
		
		StringBuilder sbu=new StringBuilder();
		t=System.currentTimeMillis();
		for(int i=N;i>0;i--){
			sbu.append("");			
		}
		System.out.println(System.currentTimeMillis()-t);

	}

}
