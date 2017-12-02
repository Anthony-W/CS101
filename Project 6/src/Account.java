/*
* @author Anthony Wessel
* <p> Account.java
* <p> Project 6
* <p> implements the methods and variables used by every account
*/
public class Account implements Filterable
{
	// current balance of this account
	protected double _balance;
	public double getBalance() { return _balance; }

	// name of this account
	protected String _name;
	public String getName() { return _name; }

	// account linked to this one
	protected Account _link;
	public Account getLink() { return _link; }

	/*
	 * default constructor
	 */
	public Account()
	{
		this("");
	}

	/*
	 * overloaded constructor
	 * 
	 * @param name		name of account
	 */
	public Account(String name)
	{
		_name = name;
		_balance = 0;
		_link = null;
	}

	/*
	 * links this account to another account, and vice versa
	 * 
	 * @param linkAcct account to link to
	 * 
	 * @return whether or not the new link was established
	 */
	public boolean link(Account linkAcct)
	{
		if (linkAcct == null)
			return false;
		if (this == linkAcct)
			return false;

		unlink();
		_link = linkAcct;
		linkAcct._link = this;
		return true;
	}

	/*
	 * adds money to this account
	 * 
	 * @param amt amount to be deposited
	 */
	public void deposit(double amt) throws LinkAccountException
	{
		_balance += amt;
	}

	/*
	 * removes money from this account
	 * 
	 * @param amt amount to be withdrawn
	 */
	public void withdraw(double amt) throws InsufficientFundsException
	{
		if (_balance >= amt)
		{
			_balance -= amt;
		} else
		{
			if (_link == null)
				throw new InsufficientFundsException("Overdraft with no linked account");
			if (_balance + _link._balance < amt)
				throw new InsufficientFundsException("Not enough funds in accounts");

			amt -= _balance;
			_balance = 0;
			_link.withdraw(amt);
		}
	}

	/*
	 * removes any link from this account
	 */
	public void unlink()
	{
		if (_link == null)
			return;

		_link._link = null;
		_link = null;
	}

	/*
	 * gets the minimum value of this account
	 * 
	 * @return the minimum
	 */
	public double getMinimum()
	{
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Filterable#accept()
	 */
	public boolean accept()
	{
		return true;
	}

	
	
	// provided methods

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;

		if (!(obj instanceof Account))
			return false;

		Account that = (Account) obj;

		if (Math.abs(_balance - that._balance) > 0.001)
			return false;

		if (!_name.equals(that._name))
			return false;

		if (_link != that._link)
			return false;

		return this == obj;
	}

	@Override
	public String toString()
	{
		String retS = "";

		retS += "account: " + _name + "\n";
		retS += "\tBalance: " + _balance + "\n";
		retS += "\tLink account name: " + _link._name;

		return retS;
	}
}