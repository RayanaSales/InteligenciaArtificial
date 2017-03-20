package puzzle;

public class Quadrant
{
	int[][] puzzle = new int[3][3];

	Quadrant previous;
	Quadrant next;

	public Quadrant(int[][] puzzle)
	{
		this.puzzle = puzzle;
	}

	public String toString()
	{
		String result = "";
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				result += this.puzzle[i][j] + "";
			}
			result += "/n";
		}
		
		return result;
	}
}
