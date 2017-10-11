public class Kennel {

	public static void main(String[] args) {
		Dog wolfy = new Dog();
		wolfy.printInfo();
		
		Dog oakley = new Dog("Oakley");
		oakley.bark = "Arf!";
		oakley.printInfo();
		
		Dog spot = new Dog();
		spot.name = "Spot";
		spot.age = 1;
		spot.tail = Dog.Tail.LONG;
		spot.weight = 30.0;
		spot.printInfo();
		
		Dog rufus = new Dog("Rufus");
		rufus.age = 3;
		rufus.weight = 5.0;
		rufus.bark = "Ruff!";
		rufus.printInfo();
		
		Dog wolfy2 = new Dog("&Spike&");
		wolfy2.age = 3;
		wolfy2.tail = Dog.Tail.NONE;
		wolfy2.printInfo();
	}

}
