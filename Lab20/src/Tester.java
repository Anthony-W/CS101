import java.util.ArrayList;

public class Tester
{
	public static void main( String[] args )
	{
		Dog  d = new Dog () ;
		Cat  c = new Cat () ;
		Bird b = new Bird() ;
		Fish f = new Fish() ;
		Fox  x = new Fox () ;

		//create the list and add the animals
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(d);
		animals.add(c);
		animals.add(b);
		animals.add(f);
		animals.add(x);
		
		//print details for each animal
		for(Animal a : animals) {
			printDetails(a);
		}
	}
	
	public static void printDetails(Animal a) {
		//print the number of legs, if any
		if (a.hasLegs())
			System.out.println("A " + a.getType() + " has " + a.numberOfLegs() + " legs.");
		
		//print the number of wings, if any
		if (a.hasWings())
			System.out.println("A " + a.getType() + " has " + a.numberOfLegs() + " wings.");
		
		//print that animal can breathe underwater if possible
		if (a.hasGills())
			System.out.println("A " + a.getType() + " can breathe underwater.");
		
		//print the sound made by the animal
		System.out.println("A " + a.getType() + " makes the sound " + a.getSoundMade());
	}
}
