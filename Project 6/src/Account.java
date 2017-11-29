/*
* @author (Student Name)
* <p> (File Name)
* <p> (Assignment)
* <p> (Describe, in general, the code contained.)
*/
public class Account implements Filterable
{
    protected double _balance;
    public double getBalance() { return _balance; }
    
    protected String _name;
    public String getName() { return _name; }
    
    protected Account _link;
    public Account getLink() { return _link; }

	//
    // TODO: Constructors and other required methods.
    //
    
    public Account() {
    	this("");
    }
    
    public Account(String name) {
    	_name = name;
    	_balance = 0;
    	_link = null;
    }
    
    
    //
    // Link this account with the given account;
    //  Cannot link accounts if this equals linkAcct
    //  Otherwise:
    //     Unlink this account, if it is linked
    //     Link the new accounts in BOTH directions
    //
    public boolean link(Account linkAcct)
    {
    	if (linkAcct == null) return false;
    	if (this == linkAcct) return false;
    	
    	unlink();
		_link = linkAcct;
		linkAcct._link = this;
		return true;
    }
    
    
    public void deposit(double amt) throws LinkAccountException
    {
    	_balance += amt;
    }
    

    //
    // Take $amt from this account, if available.
    //
    // Specifically,
    //   If amt is available in this account, withdraw
    //   If amt is not available,
    //      Determine if it is available, in total, from this and the linked account.
    //      If so, take from both.
    //      If not, throw an exception and leave account balances unmodified.
    // 
    public void withdraw(double amt) throws InsufficientFundsException
    {
    	if (_balance >= amt)
    	{
    		_balance -= amt;
    	}
    	else
    	{
    		if (_link == null) throw new InsufficientFundsException("Overdraft with no linked account");
    		if (_balance + (_link._balance - _link.getMinimum()) < amt) throw new InsufficientFundsException("Not enough funds in accounts");
	    	
    		amt -= _balance;
    		_balance = 0;
    		_link.withdraw(amt);
    	}
    }
    
    //
    // Unlink the accounts in BOTH directions
    //
    public void unlink()
    {
    	if (_link == null) return;
    	
    	_link._link = null;
		_link = null;
    }
    
    
    public double getMinimum() {
    	return 0;
    }
    
    public boolean accept() {
    	return true;
    }
    
    
       
    @Override
    public boolean equals(Object obj)
    {
    	if (obj == null) return false;
    	
    	if (!(obj instanceof Account)) return false;

    	Account that = (Account)obj;
    	
    	if (Math.abs(_balance - that._balance) > 0.001) return false; 

    	if (!_name.equals(that._name)) return false;
    	
    	if (_link != that._link) return false;
    	
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