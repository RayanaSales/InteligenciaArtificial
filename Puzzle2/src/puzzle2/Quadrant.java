package puzzle2;

import java.util.Arrays;

public class Quadrant
{
	// current
	int[][] puzzle = new int[3][3];

	// moves
	Quadrant previous;

	// childs
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
	public int hashCode()
	{
		// TODO Auto-generated method stub
		return Arrays.deepHashCode(puzzle);
	}

	@Override
	public boolean equals(Object obj)
	{
		Quadrant teste = (Quadrant) obj;
		return Help.similars(teste.puzzle, puzzle);
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
