
public class QuadraticSolver
{
	double a, b, c;
	
	/*
	 * create new quadratic using default parameters
	 * y = 1x^2 + 4x + 4
	 */
	public QuadraticSolver()
	{
		this(1, 4, 4);
	}
	
	/*
	 * Create new quadratic using parameters
	 * y = ax^2 + bx + c
	 * throws a QuadraticException if a is equal to 0
	 */
	public QuadraticSolver(double a, double b, double c)
	{
		//a is zero, not a quadratic
		if (a == 0) throw new QuadraticException("This is not a valid quadratic");
		
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/*
	 * returns the discriminant of the quadratic
	 */
	public double getDiscriminant()
	{
		return (b*b) - (4*a*c);
	}
	
	/*
	 * checks whether or not the first root is real
	 */
	public boolean isFirstRootReal()
	{
		try
		{
			root1();
		}
		catch (NonRealException e)
		{
			return false;
		}
		return true;
	}
	
	/*
	 * checks whether or not the second root is real
	 */
	public boolean isSecondRootReal()
	{
		try
		{
			root2();
		}
		catch (NonRealException e)
		{
			return false;
		}
		return true;
	}
	
	/*
	 * returns the first root
	 * throws a NonRealException if the first root is non-real
	 */
	public double root1()
	{
		//the root is non-real, throw exception
		if (getDiscriminant() < 0) throw new NonRealException("this root is non-real");
		
		//calculate the root
		double root = (-b + Math.sqrt(getDiscriminant()))/(2*a);
		return root;
	}
	
	/*
	 * returns the second root
	 * throws a NonRealException if the second root is non-real
	 */
	public double root2()
	{
		//the root is non-real, throw exception
		if (getDiscriminant() < 0) throw new NonRealException("this root is non-real");
		
		//calculate the root
		double root = (-b - Math.sqrt(getDiscriminant()))/(2*a);
		return root; 
	}
	
	/*
	 * prints out the quadratic function
	 * y = ax^2 + bx + c
	 */
	@Override
	public String toString()
	{
		return "y = " + a + "x^2 + " + b + "x + " + c;
	}
	
}
