import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random r = new Random();
		int firstNumber = r.nextInt(1000);
		while(Integer.toString(firstNumber).contains("8") 
			|| Integer.toString(firstNumber).contains("9"))
		{
			firstNumber = r.nextInt(1000);
		}
		int secondNumber = r.nextInt(787) + 101;
		int thirdNumber = r.nextInt(10000);
		System.out.println("(" + firstNumber + ")-" + secondNumber + "-" + thirdNumber);
	}

}
