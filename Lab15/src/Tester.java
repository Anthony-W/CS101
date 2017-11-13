
public class Tester
{

	public static void main(String[] args)
	{
		//create new QuadraticSolver and print the quadratic
		QuadraticSolver qs = new QuadraticSolver(4, 2, 0);
		System.out.println(qs.toString());
		
		//print the discriminant
		System.out.println("Discriminant = " + qs.getDiscriminant());
		
		//if the first root is real, print it
		if (qs.isFirstRootReal()) System.out.println("First root = " + qs.root1());
		else System.out.println("Non-real first root");
		
		//if the second root is real, print it
		if (qs.isSecondRootReal())System.out.println("Second root = " + qs.root2());
		else System.out.println("Non-real second root");
	}

}
