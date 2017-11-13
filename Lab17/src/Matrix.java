public class Matrix {
	
	//two-dimensional array, stores the matrix values
	private int[][] thisMatrix;
	
	
	//contructs a matrix using the two-dimensional array parameter
	public Matrix(int[][] newMatrix) throws RuntimeException
	{
		int squareLength = newMatrix.length;
		thisMatrix = new int[newMatrix.length][];
		
		for (int i = 0; i < thisMatrix.length; i++)
		{
			thisMatrix[i] = new int[newMatrix[i].length];
			
			if (thisMatrix[i].length != squareLength) throw new RuntimeException("Matrix is not square.");
			
			for (int j = 0; j < thisMatrix[i].length; j++)
			{
				thisMatrix[i][j] = newMatrix[i][j];
			}
		}
	}
	
	
	// Description: Determines if a square matrix is row semi-magic
	// Parameters:
	// Assumptions: matrix is square
	// Returns: TRUE/FALSE whether the matrix attribute is row semi-magic 
	public boolean rowSemiMagic()
	{
		int length = thisMatrix.length;
		int[] sums = new int[3];
		
		for (int i = 0; i < length; i++)
		{
			for (int j = 0; j < length; j++)
			{
				sums[i] += thisMatrix[i][j];
			}
		}
		return sums[0] == sums[1] && sums[0] == sums[2];
	}
	
	
	// Description: Determines if a square matrix is column semi-magic
	// Parameters:
	// Assumptions: matrix is square
	// Returns: TRUE/FALSE whether the matrix attribute is column semi-magic
	public boolean columnSemiMagic()
	{
		int length = thisMatrix.length;
		int[] sums = new int[3];
		
		for (int i = 0; i < length; i++)
		{
			for (int j = 0; j < length; j++)
			{
				sums[i] += thisMatrix[j][i];
			}
		}
		return sums[0] == sums[1] && sums[0] == sums[2];
	}
	
	
	// Description: Determines if a square matrix is magic
	// Parameters:
	// Assumptions: matrix is square
	// Returns: TRUE/FALSE whether the matrix attribute is magic 
	public boolean magic()
	{
		return rowSemiMagic() && columnSemiMagic();
	}
	
	@Override
	public String toString() {
		String output = "Matrix:\n";
		for (int i = 0; i < thisMatrix.length; i++)
		{
			output += "[";
			for (int j = 0; j < thisMatrix[i].length; j++)
			{
				if (j > 0) output += ",";
				output += thisMatrix[i][j];
			}
			output += "]\n";
		}
		return output;
	}
}
