package myJava;
//14-Jun-2017
public class ToggleCaseOfCharacters {

	public static void main(String[] args) {
		String s="THis iS a bEautIfUl dAy.";
		char ch[]=s.toCharArray();
		int a;
		for(int i=0;i<ch.length-1;i++){
			char c = ch[i];
	        if (Character.isUpperCase(c))
	        {
	            ch[i] = Character.toLowerCase(c);
	        }
	        else if (Character.isLowerCase(c))
	        {
	            ch[i] = Character.toUpperCase(c);
	        }
	    }
		String s2=new String(ch);// convert a char array to string METHOD 1
		String s3=String.valueOf(ch); //convert a char array to string METHOD 2
		System.out.println(s2);
		System.out.println(s3);

	}

}
