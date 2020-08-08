package myJava;

public class ReverseEachWordInString {

	public static void main(String[] args) {
		String s="This is a beautiful day";		
		String words[]=s.split("\\s");
		String s2="";
		for (String w:words){
			StringBuilder sb=new StringBuilder(w);
			sb.reverse();			
			s2+=sb.toString()+" ";
		}
		System.out.print(s2.trim());
	}

}
