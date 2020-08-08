package javaPractice;

public class DefaultConstructor {
	
	int i;
	String str;
	
	DefaultConstructor(int x, String s){
		i=x;
		str=s;
	}
	public DefaultConstructor() {
		
	}
	void display(){
		System.out.println("Integer: "+i+" String: "+str);
	}
	public static void main(String[] args) {
		DefaultConstructor dc1=new DefaultConstructor(10,"sumit");
		DefaultConstructor dc2=new DefaultConstructor(20,"kumar");
		dc1.display();
		dc2.display();
		DefaultConstructor dc3=new DefaultConstructor();
		dc3.display();
	}

}
