/*
* @author (Student Name)
* <p> (File Name)
* <p> (Assignment)
* <p> (Describe, in general, the code contained.)
*/
public class CappedChecking extends Checking
{
	
	static final double MAX_AMOUNT = 10000;
	//
    // TODO: Constructors and other required methods.
    //
	
	public CappedChecking() {
		super();
	}
	
    public CappedChecking(String name)
	{
		super(name);
	}
    
    public void deposit(double amt) throws LinkAccountException
    {
    	if (_balance + amt <= MAX_AMOUNT)
    	{
    		_balance += amt;
    	}
    	else
    	{
    		if (_link == null) throw new LinkAccountException("Overflowed, no linked account");
    		
    		amt -= (MAX_AMOUNT - _balance);
    		_balance = MAX_AMOUNT;
    		_link.deposit(amt);
    	}
    	
    }

	@Override
    public boolean equals(Object obj)
    {
    	if (obj == null) return false;
    	
    	if (!(obj instanceof CappedChecking)) return false;

    	return super.equals(obj);
    }
	
    @Override
    public String toString()
    {
    	return "Capped-Checking " + super.toString();
    }
}
