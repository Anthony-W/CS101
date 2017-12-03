/*
* @author Anthony Wessel
* <p> Checking.java
* <p> Project 6
* <p> implements a checking account
*/
public class Checking extends Account
{
	/*
	 * default constructor
	 */
	public Checking()
	{
		super();
	}
	
	
	/*
	 * overloaded constructor
	 * 
	 * @param name		name of account
	 */
	public Checking(String name)
	{
		super(name);
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
    	if (linkAcct == null) return false;
    	
    	//check if linkAcct is another Checking account
		if (linkAcct instanceof Checking) return false;
		
		return super.link(linkAcct);
    }
	
	
	/*
	 * (non-Javadoc)
	 * @see Account#accept()
	 */
	@Override
	public boolean accept()
	{
    	return _link != null;
    }
	
	
	
	//provided methods
	
    @Override
    public boolean equals(Object obj)
    {
    	if (obj == null) return false;
    	
    	if (!(obj instanceof Checking)) return false;

    	return super.equals(obj);
    }
	
    @Override
    public String toString()
    {
    	return "Checking " + super.toString();
    }
}
