/*
* @author Anthony Wessel
* <p> Savings.java
* <p> Project 6
* <p> implements a savings account
*/
public class Savings extends Account
{
	static final double MIN_AMOUNT = 100;

	
	/*
	 * default constructor
	 */
	public Savings()
	{
		super();
	}

	
	/*
	 * overloaded constructor
	 * 
	 * @param name		name of account
	 */
	public Savings(String name)
	{
		super(name);
	}

	
	
	/*
	 * removes money from this account
	 * 
	 * @param amt amount to be withdrawn
	 */
	@Override
	public void withdraw(double amt) throws InsufficientFundsException
	{
		//check if there is enough money in this account
		if (_balance - getMinimum() >= amt)
		{
			//withdraw from this account
			_balance -= amt;
		}
		
		//not enough money in this account
		else
		{
			//check for a linked account
			if (_link == null)
				throw new InsufficientFundsException("Overdraft with no linked account");
			
			//check if there is enough money in this account and linked account combined
			if (_balance - getMinimum() + _link._balance < amt)
				throw new InsufficientFundsException("Not enough funds in accounts");

			//withdraw from both accounts
			amt -= (_balance - getMinimum());
			_balance = getMinimum();
			_link.withdraw(amt);
		}
	}
	

	/*
	 * gets the minimum value of this account
	 * 
	 * @return the minimum
	 */
	public double getMinimum()
	{
		return 100;
	}

	
	/*
	 * links this account to another account, and vice versa
	 * 
	 * @param linkAcct account to link to
	 * 
	 * @return whether or not the new link was established
	 */
	@Override
	public boolean link(Account linkAcct)
	{
		//check for null parameter
		if (linkAcct == null)
			return false;

		//check if linkAcct is another Savings account
		if (linkAcct instanceof Savings)
			return false;

		return super.link(linkAcct);
	}

	
	/*
	 * (non-Javadoc)
	 * @see Account#accept()
	 */
	@Override
	public boolean accept()
	{
		return _balance >= getMinimum();
	}

	
	
	// provided methods
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;

		if (!(obj instanceof Savings))
			return false;

		return super.equals(obj);
	}

	@Override
	public String toString()
	{
		return "Savings " + super.toString();
	}
}
