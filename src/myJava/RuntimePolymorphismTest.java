package myJava;

class Figure{
	double dimension1;
	double dimension2;
	Figure(double x, double y){
		dimension1 =x;
		dimension2=y;
		
	}
	double area(){
		return 0;
	}
}

class Rectangle extends Figure{
	Rectangle(double x, double y){
		super(x,y);
	}
	double area(){
		return dimension1*dimension2;
	}
}	
class Triangle extends Figure{
	Triangle(double x, double y){
		super (x,y);
	}
	double area(){
		return dimension1*dimension2/2;
	}

}
public class RuntimePolymorphismTest {

	public static void main(String[] args) {
		Figure f=new Figure(10,20);
		Rectangle r=new Rectangle(20,20);
		Triangle t=new Triangle(10,20);
		Figure fig;
		fig=r;
		System.out.println("Area of rectangle: "+fig.area());
		fig=t;
		System.out.println("Area of triangle: "+fig.area());
		fig=f;
		System.out.println("Undefined Area of Figure:"+fig.area());

	}

}
