package puzzle;

import java.util.Scanner;

public class Help
{
	protected static int[][] getUserPuzzle()
	{
		int[][] puzzle = new int[3][3];
		String line = "";
		Scanner input = new Scanner(System.in);

		System.out.println("Insira os valores da sua matriz. obs: x = 0");
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				line = input.next();
				int value = Integer.parseInt(line);
				puzzle[i][j] = value;
			}			
			System.out.println();
		}

		input.close();
		return puzzle;
	}
	
	protected static boolean similars(int[][] a, int[][]b)
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if(a[i][j] != b[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}
	
	protected static boolean usedBefore(int[][] puzzle)
	{
		for (Quadrant used : Main.useds)
		{
			if(used.puzzle == puzzle)
			{
				return true;
			}
		}
		return false;
	}
	
	protected static void findX(int[][] puzzle)
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (puzzle[i][j] == 0)
				{
					Main.COORDINATE_X_I = i;
					Main.COORDINATE_X_J = j;
					break;
				}
			}
		}
	}
	
//	protected static boolean containsValidValues(int[][] puzzle)
//	{
//		for (int i = 0; i < 3; i++)
//		{
//			for (int j = 0; j < 3; j++)
//			{
//				if(puzzle[i][j] != 0 && puzzle[i][j] <= 8){
//					return true;
//				}
//			}
//		}
//		return false;
//	}
	
	protected static int getTired(int[][] puzzle) //quantas trocas tem que fazer para chegar no objetivo?
	{
		int tired = 0;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if(Main.PUZZLE_TARGET[i][j] != puzzle[i][j]){
					tired++;
				}
			}
		}
		return tired;
	}
	
	protected static void printSolution(Quadrant solution)
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				System.out.print(solution.puzzle[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
				
		if(solution.previous != null)
		{
			printSolution(solution.previous);
		}
	}
}
