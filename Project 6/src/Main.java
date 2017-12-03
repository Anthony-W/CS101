/*
* @author Anthony Wessel
* <p> Main.java
* <p> Project 6
* <p> runs the testing classes
*/
public class Main
{
	public static void main(String[] args)
    {
        AccountTester acctTester = new AccountTester();
        BankTester bankTester = new BankTester();

		System.out.println("\nAccount Tests:\n");
        acctTester.runAll();
        
		System.out.println("\nBank Tests:\n");
        bankTester.runAll();
	}
}
