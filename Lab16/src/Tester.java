
public class Tester {

	public static void main(String[] args) {
		int[] myArr = new int[5];
		ArrayFunctions.populate(myArr);
		System.out.print("[" + myArr[0]);
		for(int i = 1; i < myArr.length; i++) {
			System.out.print(", " + myArr[i]);
		}
		System.out.println("]");
		System.out.println("min: " + ArrayFunctions.findMin(myArr));
		System.out.println("max: " + ArrayFunctions.findMax(myArr));
		System.out.println("mean: " + ArrayFunctions.mean(myArr));
	}

}
