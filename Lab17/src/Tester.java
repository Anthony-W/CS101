
public class Tester {

	static Matrix matrix;
	
	static int[][] newMatrix = {
				{1, 1, 2},
				{2, 0, 2},
				{1, 3, 0}
	};
	
	public static void main(String[] args)
	{
		
		try
		{
			matrix = new Matrix(newMatrix);
			
			System.out.println(matrix);
			System.out.println("Row semi-magic: " + matrix.rowSemiMagic());
			System.out.println("Column semi-magic: " + matrix.columnSemiMagic());
			System.out.println("Magic: " + matrix.magic());
		}
		catch (RuntimeException e)
		{
			System.err.println(e.getMessage() + "\n");
		}
		
	}

}
