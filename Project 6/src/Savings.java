/*
* @author (Student Name)
* <p> (File Name)
* <p> (Assignment)
* <p> (Describe, in general, the code contained.)
*/
public class Savings extends Account
{
	
	protected static final double MIN_AMOUNT = 100;
	
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
		super.withdraw(amt);
		if (_balance < MIN_AMOUNT) {
			if (_link == null) throw new InsufficientFundsException("Below minimum, no linked account");
			_link._balance -= (MIN_AMOUNT - _balance);
			_balance = MIN_AMOUNT;
		}
	}
	
	
	@Override
	public void deposit(double amt) throws LinkAccountException
	{
    	_balance += amt;
    	
    }
	

	@Override
    public boolean link(Account linkAcct)
    {
    	if (linkAcct == null) return false;
    	
		if (linkAcct instanceof Savings) return false;
		
		return super.link(linkAcct);
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
