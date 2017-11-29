/*
* @author (Student Name)
* <p> (File Name)
* <p> (Assignment)
* <p> (Describe, in general, the code contained.)
*/
public class Savings extends Account
{	
	static final double MIN_AMOUNT = 100;
	
	//
    // TODO: Constructors and other required methods.
    //
	
	public Savings() {
		super();
		
	}
	
	public Savings(String name)
	{
		super(name);
	}
	
	
	public void withdraw(double amt) throws InsufficientFundsException
	{
		if (_balance - getMinimum() >= amt)
    	{
    		_balance -= amt;
    	}
    	else
    	{
    		if (_link == null) throw new InsufficientFundsException("Overdraft with no linked account");
    		if (_balance - getMinimum() + _link._balance < amt) throw new InsufficientFundsException("Not enough funds in accounts");
	    	
    		amt -= (_balance - getMinimum());
    		_balance = getMinimum();
    		_link.withdraw(amt);
    	}
	}
	
	
	public double getMinimum()
	{
    	return 100;
    }

	
	@Override
    public boolean link(Account linkAcct)
    {
    	if (linkAcct == null) return false;
    	
		if (linkAcct instanceof Savings) return false;
		
		return super.link(linkAcct);
    }
	
	
	public boolean accept() {
    	return _balance >= getMinimum();
    }
	
	
	
	
    @Override
    public boolean equals(Object obj)
    {
    	if (obj == null) return false;
    	
    	if (!(obj instanceof Savings)) return false;

    	return super.equals(obj);
    }
	
    @Override
    public String toString()
    {
    	return "Savings " + super.toString();
    }
}
