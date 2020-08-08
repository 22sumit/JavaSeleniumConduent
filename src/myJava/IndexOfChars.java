package myJava;

public class IndexOfChars {

	public static void main(String[] args) {
		String s="the quick brown fox jumps over the lazy dog";
		int l=s.length();
		for (int i=0;i<l;i++){
			System.out.println("Index of char "+s.charAt(i)+" is "+s.indexOf(s.charAt(i)));
		}

	}

}
