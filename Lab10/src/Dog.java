import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Dog {
	enum Tail {
		LONG,
		SHORT,
		NONE;
	}
	
	int age;
	String name;
	String bark;
	boolean hasShortHair;
	double weight;
	Tail tail;
	
	
	public Dog() {
		this("Wolfy");
	}
	
	public Dog(String name) {
		if (validName(name))
			this.name = name;
		else
			this.name = "Wolfy";
		
		age = 2;
		bark = "Bark!";
		hasShortHair = true;
		weight = 20.0;
		tail = Tail.SHORT;
	}
	
	private boolean validName(String name) {
		Pattern pattern = Pattern.compile("[a-zA-Z]*");
		Matcher matcher = pattern.matcher(name);
		
		if (matcher.matches()) return true;
		else return false;
	}
	
	int humanAge() {
		return age * 7; //convert to human
	}
	
	public String speak() {
		return bark;
	}
	
	public void printInfo() {
		System.out.println("This dog's name is " + name);
		System.out.println(name + " is " + age + " years old (" + humanAge() + " in human years)");
		if (hasShortHair) System.out.println(name + " has short hair");
		else System.out.println(name + " does not have short hair");
		System.out.println(name + " weighs " + weight + " lbs");
		System.out.println(name + "'s tail length is " + tail);
		System.out.println(speak());
		System.out.println("");
	}
}
