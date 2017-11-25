/*
* @author (Student Name)
* <p> (File Name)
* <p> (Assignment)
* <p> (Describe, in general, the code contained.)
*/
public class Checking extends Account
{
	//
    // TODO: Constructors and other required methods.
    //
	
	public Checking() {
		super();
	}
	
	public Checking(String name)
	{
		super(name);
	}

	@Override
    public boolean link(Account linkAcct)
    {
    	if (linkAcct == null) return false;
    	
		if (linkAcct instanceof Checking) return false;
		
		return super.link(linkAcct);
    }
	
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
