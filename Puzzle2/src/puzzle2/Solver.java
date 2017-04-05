package puzzle2;

import java.util.ArrayList;
import java.util.HashSet;

public class Solver
{
//	static int[][] PUZZLE_TARGET = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
	static int[][] PUZZLE_TARGET = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
	static ArrayList<Quadrant> queue = new ArrayList<Quadrant>(); 
	static ArrayList<Quadrant> useds = new ArrayList<Quadrant>(); 
	
	static int COORDINATE_X_I = 0, COORDINATE_X_J = 0; //help me find x on current node
	
	public static void solve(int[][] head)
	{
		Quadrant current = new Quadrant(head, null);
		HashSet<Quadrant> visitados =  new HashSet<>();
		
		boolean solved = false;
		
		queue.add(current);
		
		do {
			current = queue.remove(0);	
						
			if (Help.similars(current.puzzle, PUZZLE_TARGET))
			{
				solved = true;
				break;
			}
			if (!visitados.contains(current))
			{
				visitados.add(current);
				expand(current);
			}
		} while (!queue.isEmpty() && !solved);
		
		if(solved)
		{
			System.out.println("SOLUÇÃO:");
			Help.printSolution(current);
			Help.steps++;
			System.out.println("FIM DA SOLUÇÃO! " + Help.steps + " passos executados.");
		}
		else
		{
			System.out.println("Não achei solução");
		}
	}
	
	private static void expand(Quadrant current)
	{
		Help.findX(current.puzzle); //refresh coordinates
		
		// 1 - gere os filhos dele
		// 2 - adicione os filhos em queue (podando)
		
		if (validateMove(Move.UP))
		{
			current.up = new Quadrant(swap(Move.UP, current.puzzle), current);	
			if(!prune(current.up))
			{
				queue.add(current.up);
			}
		}		 
		
		if (validateMove(Move.RIGHT))	
		{
			current.right = new Quadrant(swap(Move.RIGHT, current.puzzle), current);
			if(!prune(current.right))
			{
				queue.add(current.right);
			}
		}	
		
		if (validateMove(Move.DOWN))	
		{
			current.down = new Quadrant(swap(Move.DOWN, current.puzzle), current);
			if(!prune(current.down))
			{
				queue.add(current.down);
			}
		}	
		
		if (validateMove(Move.LEFT))
		{
			current.left = new Quadrant(swap(Move.LEFT, current.puzzle), current);
			if(!prune(current.left))
			{
				queue.add(current.left);
			}
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
	
	private static boolean prune(Quadrant q)
	{
		//vc eh igual ao seu pai?
		if(Help.similars(q.puzzle, q.previous.puzzle))
		{
			return true;
		}
		
		//vc ja foi usado antes?
		if(Help.usedBefore(q.puzzle))
		{
			return true;
		}
		
		return false;
	}
	
	public enum Move
	{
		UP, RIGHT, DOWN, LEFT;
	}
}
