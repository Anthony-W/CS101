import java.util.Random;

public class ArrayFunctions {

	static Random rng = new Random();
	
	public static int findMin(int[] arr) {
		int min = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[min]) min = i;
		}
		return min;
	}
	
	public static int findMax(int[] arr) {
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[max]) max = i;
		}
		return max;
	}
	
	public static double mean(int[] arr) {
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		double mean = sum / arr.length;
		return mean;
	}
	
	public static void populate(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rng.nextInt(101);
		}
	}
	
}
