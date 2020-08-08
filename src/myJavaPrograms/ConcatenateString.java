package myJava;

import java.util.Arrays;

public class ConcatenateString {

	public static void main(String[] args) {
		
		String[] strArray = new String[]{"Java", "PHP", ".NET", "PERL", "C", "COBOL"};
        String newString = Arrays.toString(strArray);
        newString = newString.substring(1, newString.length()-1);
        System.out.println("New String: " + newString);
        StringBuilder sb=new StringBuilder();
        sb.append(strArray[0]);
        sb.append(strArray[1]);
        sb.append(strArray[2]);
        sb.append(strArray[3]);
        sb.append(strArray[4]);
        
        System.out.println(sb.toString());
        //***************************************//
        String array[]={"one","two"};
        String s="";

        for(int i=0;i<array.length;i++)
        {
          s=s+array[i];
        }

        System.out.print(s);
	}

}
