/*
* @author Anthony Wessel
* <p> Rational
* <p> Project 4
* <p> represents a rational number, with methods to perform calculations between two rationals
* 
*/

public class Rational implements Comparable
{
	private long _numer;
	private long _denom;

	/*
	 * default constructor
	 */
	public Rational()
	{
		//set values
		_numer = 0;
		_denom = 1;
	}

	/*
	 * overloaded contructor
	 * takes numerator as a parameter
	 */
	public Rational(long a)
	{
		//set values
		_numer = a;
		_denom = 1;
	}

	/*
	 * overloaded constructor
	 * takes numerator and denominator as parameters
	 */
	public Rational(long a, long b) throws ArithmeticException
	{
		//input denominator is 0
		if (b == 0) throw new ArithmeticException("Tried to divide by zero");
		
		//set values
		_numer = a;
		_denom = b;
		
		//fix negative
		if (_denom < 0)
		{
			_denom *= -1;
			_numer *= -1;
		}
		
		//simplify
		long gcd = gcd(_numer, _denom);
		_numer /= gcd;
		_denom /= gcd;
	}

	/*
	 * returns the denominator of this rational
	 */
	public long getDenominator()
	{
		return _denom;
	}

	/*
	 * returns the numerator of this rational
	 */
	public long getNumerator()
	{
		return _numer;
	}

	/*
	 * returns the sum of the input rational and this rational
	 */
	public Rational add(Rational r)
	{
		//fix negatives
		if (r.getDenominator() < 0)
		{
			_numer *= -1;
			_denom *= -1;
		}
		if (_denom < 0)
		{
			_denom *= -1;
			_numer *= -1;
		}
		
		//check for common denominator and add if possible
		if (_denom != r.getDenominator())
		{
			System.out.println("These rationals must have a common denominator to be added together.");
		}
		else
		{
			_numer += r.getNumerator();
		}
		
		//simplify
		long gcd = gcd(_numer, _denom);
		_numer /= gcd;
		_denom /= gcd;
		
		return this;
	}

	/*
	 * returns the difference between the rational and the input rational
	 */
	public Rational subtract(Rational r)
	{
		//fix negatives
		if (r.getDenominator() < 0)
		{
			_numer *= -1;
			_denom *= -1;
		}
		if (_denom < 0)
		{
			_denom *= -1;
			_numer *= -1;
		}
		
		//check for common denominator and subtract if possible
		if (_denom != r.getDenominator())
		{
			System.out.println("These rationals must have a common denominator to be subtracted.");
		}
		else
		{
			_numer -= r.getNumerator();
		}
		
		//simplify
		long gcd = gcd(_numer, _denom);
		_numer /= gcd;
		_denom /= gcd;
		
		return this;
	}

	/*
	 * returns the product of the input rational and this rational
	 */
	public Rational multiply(Rational r)
	{
		//multiply
		_numer *= r.getNumerator();
		_denom *= r.getDenominator();
		
		//fix negative
		if (_denom < 0)
		{
			_denom *= -1;
			_numer *= -1;
		}
		
		//simplify
		long gcd = gcd(_numer, _denom);
		_numer /= gcd;
		_denom /= gcd;
		
		return this;
	}

	/*
	 * returns the quotient of this rational divided by the input rational
	 */
	public Rational divide(Rational r) throws ArithmeticException
	{
		//check for divide by 0
		if (r.getNumerator() == 0) throw new ArithmeticException("Tried to divide by zero");
		
		//divide (cross multiply)
		_numer *= r.getDenominator();
		_denom *= r.getNumerator();
		
		//fix negative
		if (_denom < 0)
		{
			_denom *= -1;
			_numer *= -1;
		}
		
		//simplify
		long gcd = gcd(_numer, _denom);
		_numer /= gcd;
		_denom /= gcd;
		
		return this;
	}

	/*
	 * Find the Greatest Common Divisor of Two Integers
	 */
	public long gcd(long p, long q)
	{
		//make both inputs positive
		if (p < 0) p *= -1;
		if (q < 0) q *= -1;
		
		long temp;
		
		//loop to calculate the gcd
		while (q != 0)
		{
			temp = q;
			q = p % q;
			p = temp;
		}
		
		return p;
	}

	public String toString()
	{
		if (_denom == 1) return "" + _numer;

		return _numer + "/" + _denom;
	}

	public int compareTo(Object obj)
	{
      if (obj == null) return -1;

		if (!(obj instanceof Rational)) return 1;

		if (this.equals((Rational)(obj))) return 0;

		return (this.subtract((Rational)(obj)).getNumerator() > 0 ? 1 : -1);
	}

	// Returns true if and only if obj are the same number or reference the same object
	public boolean equals(Object obj)
	{
		if (obj == null) return false;

		if (obj == this) return true;

		if (this.subtract((Rational)obj).getNumerator() == 0) return true;

		return false;
	}
}