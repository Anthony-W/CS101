/*
* @author Anthony Wessel
* <p> Bank.java
* <p> Project 6
* <p> implements a bank which contains multiple accounts
*/
import java.util.ArrayList;

public class Bank
{
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	
	/*
	 * adds an account to this bank
	 * 
	 * @param acct		account to add
	 * 
	 * @return whether or not acct was successfully added
	 */
	public boolean addAccount(Account acct)
	{
		//checks for null parameter
		if (acct == null) return false;
		
		//check if acct is already part of this bank
		if (accounts.contains(acct)) return false;
		
		//adds the account
		accounts.add(acct);
		return true;
	}
	
	
	/*
	 * filters out all accounts which are not acceptable
	 * 
	 * @return list of filtered accounts
	 */
	public ArrayList<Account> getFiltered()
	{
		ArrayList<Account> filteredList = new ArrayList<Account>();
		
		//checks each account and adds acceptable accounts to filteredList
		for(Account acct : accounts)
		{
			if (acct.accept()) filteredList.add(acct);
		}
		
		
		return filteredList;
	}
	
	
	/*
	 * gets the size of this bank (how many accounts exist)
	 * 
	 * @return the number of accounts
	 */
	public int size()
	{
		return accounts.size();
	}
}

