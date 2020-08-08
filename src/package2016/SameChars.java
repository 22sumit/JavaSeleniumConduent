package package2016;

public class SameChars {

	public static void main(String[] args) {
		int count = 0;
		String str="sumitisaasutoundingstudent";
		int l=str.length();
		for (int i=0;i<l;i++){
			if (str.charAt(i)=='s'){
				count++;
			}
			
		}
		System.out.println(count);
		String[] arr=str.split("sa+");
		System.out.println(arr.length);
	}

}
