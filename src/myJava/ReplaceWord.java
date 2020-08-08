package myJava;
//StringBuffer methods demo
public class ReplaceWord {

	public static void main(String[] args) {
		
		String str="He is new to java but He will succeed";
		String[] strarr=str.split(" ");
		System.out.println("Words count: " + strarr.length);
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<=strarr.length-1;i++){
			if (strarr[i].equals("He")){
				strarr[i]="This";
			}
			sb=sb.append(strarr[i]+" ");
		}
		System.out.println(sb);
		System.out.println(sb.insert(5,"still "));
		System.out.println(sb.replace(11, 20, "rat"));
		System.out.println(sb.delete(5, 11));
		System.out.println(sb.substring(12));
		System.out.println(sb.substring(12,20));
		System.out.println(sb.reverse());
	}
}