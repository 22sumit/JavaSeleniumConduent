package myJava;

class Employee{}
class Manager extends Employee{}
class Director extends Manager{}
public class TestMultiLevelInheritance {
	public static void Salary(Object obj){
// try after exchanging Director with Employee and vice versa in this method
		if(obj instanceof Director){
			System.out.println("Director Salary: 500$");
		}
		else if(obj instanceof Manager){
			System.out.println("Manager Salary: 300$");
		}
		else if(obj instanceof Employee){
			System.out.println("Employee Salary: 100$");
		}
	}

	public static void main(String[] args) {
		Employee e=new Employee();
		Manager m=new Manager();
		Director d=new Director();
		System.out.println("Salary(e) is called: ");
		Salary(e);
		System.out.println("Salary(m) is called: ");
		Salary(m);
		System.out.println("Salary(d) is called: ");
		Salary(d);

	}

}
