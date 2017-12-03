/*
* @author Anthony Wessel
* <p> CappedChecking.java
* <p> Project 6
* <p> implements a capped checking account
*/
public class CappedChecking extends Checking
{
	
	static final double MAX_AMOUNT = 10000;
	
	
	/*
	 * default constructor
	 */
	public CappedChecking()
	{
		super();
	}
	
	
	/*
	 * overloaded constructor
	 * 
	 * @param name		name of account
	 */
    public CappedChecking(String name)
	{
		super(name);
	}
    
    
    /*
     * (non-Javadoc)
     * @see Account#deposit(double)
     */
    public void deposit(double amt) throws LinkAccountException
    {
    	//check if depositing amt will pass the maximum for this account
    	if (_balance + amt <= MAX_AMOUNT)
    	{
    		_balance += amt;
    	}
    	
    	//cannot deposit full amount in this account
    	else
    	{
    		//check if this account has a linked account
    		if (_link == null) throw new LinkAccountException("Overflowed, no linked account");
    		
    		//deposit into both accounts
    		amt -= (MAX_AMOUNT - _balance);
    		_balance = MAX_AMOUNT;
    		_link.deposit(amt);
    	}
    	
    }

    
    
    //provided methods
    
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
