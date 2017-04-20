package puzzle2;

public class Help
{
	protected static boolean similars(int[][] a, int[][] b)
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (a[i][j] != b[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}

	protected static void findX(int[][] puzzle)
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (puzzle[i][j] == 0)
				{
					Solver.COORDINATE_X_I = i;
					Solver.COORDINATE_X_J = j;
					break;
				}
			}
		}
	}

	public static int steps = 1;

	// recursao. Se vc tem um pai, chame ele.
	protected static void printSolution(Quadrant solution)
	{
		if (solution.previous != null)
		{
			++steps;
			printSolution(solution.previous);
		}

		// qd chega no head, ele vai retornando e imprimindo o puzzle atual.
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				System.out.print(solution.puzzle[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
