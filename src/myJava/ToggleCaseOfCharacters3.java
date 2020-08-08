package myJava;
//14-Jun-2017
public class ToggleCaseOfCharacters3 {

	public static void main(String[] args) {
		String s="THis iS a bEautIfUl dAy.";
		char ch[]=s.toCharArray();
		int a;
		StringBuilder sb=new StringBuilder(s);
		for(int i=0;i<ch.length-1;i++){
			char c = s.charAt(i);
			//a=ch[i];
	        if (Character.isUpperCase(c))
	        	//if (a>=97 && a<=122)
	        {
	            sb.setCharAt(i, (char)(s.charAt(i)+32));
	        }
	        else if (Character.isLowerCase(c))
	        	//else if (a>=65 && a<=90)
	        {
	        	sb.setCharAt(i, (char)(s.charAt(i)-32));
	        }
	    }
		
		System.out.println(sb.toString());

	}

}
