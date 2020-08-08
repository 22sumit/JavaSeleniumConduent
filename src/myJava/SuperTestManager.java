package myJava;

class EmployeeDet{
	int employeeno;
	String empname;
	
	EmployeeDet(){
		System.out.println("no arg constructor begins");
		employeeno=0;empname=null;
		System.out.println("no arg constructor ends");
	}
	EmployeeDet(int employeeno){
		System.out.println("single arg constructor begins");
		this.employeeno=employeeno;
		this.empname="unknown";
		System.out.println("single arg constructor ends");
	}
	EmployeeDet(int employeeno, String empname){
		this(30);
		System.out.println("two arg constructor begins");
		this.employeeno=employeeno;
		this.empname=empname;
		System.out.println("two arg constructor ends");
	}
	void display(){
		System.out.println("EmployeeNumber: "+employeeno);
		System.out.println("employeename: "+empname);
	}
}

public class SuperTestManager extends EmployeeDet{
	int deptno;
	//if a class has parameterized constr. then it must have a default constr also, if its child class has a default constr
	SuperTestManager(int employeeno, String empname,int deptno){
		super(employeeno,empname);
		System.out.println("3 arg manager const begins");
		this.deptno=deptno;
		System.out.println("3 arg manager const ends");
	}
	void display(){
		super.display();
		System.out.println("Department Number: "+deptno);
	}
	
	public static void main(String[] args) {
		SuperTestManager mn=new SuperTestManager(12,"sum",50);
		mn.display();

	}

}
