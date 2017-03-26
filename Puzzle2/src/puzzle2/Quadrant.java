package puzzle2;

public class Quadrant
{
	//current
	int[][] puzzle = new int[3][3];

	//moves
	Quadrant previous;
		
	//childs
	Quadrant up;
	Quadrant right;
	Quadrant down;
	Quadrant left;
	
	public Quadrant(int[][] puzzle, Quadrant previous)
	{
		this.puzzle = puzzle;
		this.previous = previous;
	}
	
	@Override
	public boolean equals(Object quadrant) //nao funcionou '-'
	{
		Quadrant other = (Quadrant) quadrant;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (this.puzzle[i][j] != other.puzzle[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
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
