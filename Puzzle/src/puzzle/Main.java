package puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{
	static int[][] PUZZLE_TARGET = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };

	static ArrayList<Quadrant> queue = new ArrayList<Quadrant>(); // fila
	static ArrayList<Quadrant> useds = new ArrayList<Quadrant>(); // visitados

	static int COORDINATE_X_I = 0, COORDINATE_X_J = 0; // coordinadas do x

	public static void main(String[] args)
	{
		Quadrant head = new Quadrant(Help.getUserPuzzle(), null, null);
		queue.add(head);	
		
		Quadrant current = queue.remove(queue.size() - 1);
		
		while( !Help.similars(current.puzzle, PUZZLE_TARGET) )
		{
			if (!Help.usedBefore(current.puzzle))
			{
				expand(current);
				useds.add(current);				
			}
			else break;
			
			current = queue.remove(queue.size() - 1);
		}
		
		if(Help.usedBefore(current.puzzle))
		{
			System.out.println("Não achei solução");
		}
		else
		{
			System.out.println("SOLUÇÃO:");
			Help.printSolution(current);
			System.out.println("FIM DA SOLUÇÃO!");
		}
	}

	private static void expand(Quadrant current)
	{
		Quadrant bestShot = new Quadrant(getBestShot(current.puzzle), null, null);

		bestShot.previous = current;
		current.next = bestShot;

		queue.add(bestShot); //add a melhor jogada, na lista de jogadas
	}

	private static int[][] getBestShot(int[][] puzzle)
	{
		//possible moviments (max = 4)
		int[][] one = new int[3][3];
		int[][] two = new int[3][3];
		int[][] three = new int[3][3];
		int[][] four = new int[3][3];
		
		// 1.1 - find x
		Help.findX(puzzle);

		// 1.2 - swap if you can
		if (validateMove(Move.UP))		
			one = swap(Move.UP, puzzle);

		if (validateMove(Move.RIGHT))		
			two = swap(Move.RIGHT, puzzle);
		
		if (validateMove(Move.DOWN))		
			three = swap(Move.DOWN, puzzle);
		
		if (validateMove(Move.LEFT))
			four = swap(Move.LEFT, puzzle);

		// 2 - compare possibilities with target. count tired of each one
		List<Integer> tireds = new ArrayList<Integer>();
		tireds.add(Help.getTired(one));
		tireds.add(Help.getTired(two));
		tireds.add(Help.getTired(three));
		tireds.add(Help.getTired(four));
		
		// 3 - choose the best shot
		int min = Collections.min(tireds); //menor esforço
		int indexOfBestShot = tireds.indexOf(min); //pegar o index doq elemento que gasta menos esforço.
		
		switch (indexOfBestShot)
		{
			case 0:
				return one;				
			case 1:
				return two;
			case 2:
				return three;
			case 3:
				return four;
			default:
				return null;			
		}
	}

	private static boolean validateMove(Move moving)
	{
		if (Move.UP.equals(moving))
		{
			if (COORDINATE_X_I - 1 >= 0)
			{
				return true;
			}
		}

		else if (Move.RIGHT.equals(moving))
		{
			if (COORDINATE_X_J + 1 <= 2)
			{
				return true;
			}
		}

		else if (Move.DOWN.equals(moving))
		{
			if (COORDINATE_X_I + 1 <= 2)
			{
				return true;
			}
		}

		else if (Move.LEFT.equals(moving))
		{
			if (COORDINATE_X_J - 1 >= 0)
			{
				return true;
			}
		}
		return false;
	}

	private static int[][] swap(Move moving, int[][] puzzle)
	{
		int help = 0;
		int[][] newPuzzle = new int[3][3];
		
		//copy values for another array
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				newPuzzle[i][j] = puzzle[i][j];				
			}
		}
		
		if (Move.UP.equals(moving))
		{
			help = newPuzzle[COORDINATE_X_I][COORDINATE_X_J];
			newPuzzle[COORDINATE_X_I][COORDINATE_X_J] = newPuzzle[COORDINATE_X_I - 1][COORDINATE_X_J];
			newPuzzle[COORDINATE_X_I - 1][COORDINATE_X_J] = help;
		}
		
		else if (Move.RIGHT.equals(moving))
		{
			help = newPuzzle[COORDINATE_X_I][COORDINATE_X_J];
			newPuzzle[COORDINATE_X_I][COORDINATE_X_J] = newPuzzle[COORDINATE_X_I][COORDINATE_X_J + 1];
			newPuzzle[COORDINATE_X_I][COORDINATE_X_J + 1] = help;
		}
		
		else if (Move.DOWN.equals(moving))
		{
			help = newPuzzle[COORDINATE_X_I][COORDINATE_X_J];
			newPuzzle[COORDINATE_X_I][COORDINATE_X_J] = newPuzzle[COORDINATE_X_I + 1][COORDINATE_X_J];
			newPuzzle[COORDINATE_X_I + 1][COORDINATE_X_J] = help;
		}
		
		else if (Move.LEFT.equals(moving))
		{
			help = newPuzzle[COORDINATE_X_I][COORDINATE_X_J];
			newPuzzle[COORDINATE_X_I][COORDINATE_X_J] = newPuzzle[COORDINATE_X_I][COORDINATE_X_J - 1];
			newPuzzle[COORDINATE_X_I][COORDINATE_X_J - 1] = help;
		}
		
		return newPuzzle;
	}
	
	
	
	
	
	
	
	public enum Move
	{
		UP, RIGHT, DOWN, LEFT;
	}
}
