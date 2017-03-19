package puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main
{
	static int[][] PUZZLE_TARGET = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };

	static ArrayList<Quadrant> queue = new ArrayList<Quadrant>(); // fila
	static ArrayList<Quadrant> useds = new ArrayList<Quadrant>(); // visitados

	static int COORDINATE_X_I = 0, COORDINATE_X_J = 0; // coordinadas do x

	public static void main(String[] args)
	{
		Quadrant current;
		Quadrant head = new Quadrant(getUserPuzzle(), null, null);

		queue.add(head);
		do
		{
			current = queue.remove(queue.size() - 1);

			if (similars(current.next.puzzle, PUZZLE_TARGET) == false && !useds.contains(current))
			{
				expand(current);
				useds.add(current);
			}

		} while (similars(current.next.puzzle, PUZZLE_TARGET) == true || queue.isEmpty());
		
		if(queue.isEmpty()){
			System.out.println("Não achei solução!!!");
		}
		else{
			System.out.println("SOLUÇÃO:");
			printSolution(current);
			System.out.println("FIM DA SOLUÇÃO!");
		}
	}

	private static int[][] getUserPuzzle()
	{
		int[][] puzzle = new int[3][3];
		Scanner input = new Scanner(System.in);

		System.out.println("Insira os valores da sua matriz. obs: x = 0");
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				puzzle[i][j] = input.nextInt();
			}
			System.out.println();
		}

		input.close();
		return puzzle;
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
		//moviments
		int[][] one = new int[3][3];
		int[][] two = new int[3][3];
		int[][] three = new int[3][3];
		int[][] four = new int[3][3];

		// 1 - check possibilities (max = 4)
		/*
		 * 1.1 - find x 
		 * 1.2 - move up? one = move 
		 * 1.3 - move down? two = move
		 * 1.4 - move right? three = move 
		 * 1.5 - move left? four = move
		 */

		// 1.1 - find x
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (puzzle[i][j] == 0)
				{
					COORDINATE_X_I = i;
					COORDINATE_X_J = j;
					break;
				}
			}
		}

		//moviments
		if (validateMove(Move.UP))
		{
			one = swap(Move.UP, puzzle);
		}

		if (validateMove(Move.RIGHT))
		{
			two = swap(Move.RIGHT, puzzle);
		}
		
		if (validateMove(Move.DOWN))
		{
			three = swap(Move.DOWN, puzzle);
		}
		
		if (validateMove(Move.LEFT))
		{
			four = swap(Move.LEFT, puzzle);
		}

		// 2 - compare possibilities with target. count tired
		List<Integer> tireds = new ArrayList<Integer>();
		tireds.add(getTired(one));
		tireds.add(getTired(two));
		tireds.add(getTired(three));
		tireds.add(getTired(four));
		
		int min = Collections.min(tireds); //menor esforço
		int indexOfBestShot = tireds.indexOf(min); //pegar o index doq elemento que gasta menos esforço.
		
		// 3 - give your best shot 
		if(indexOfBestShot == 0){
			return one;
		}
		
		else if(indexOfBestShot == 1){
			return two;
		}
		
		else if(indexOfBestShot == 2){
			return three;
		}
		
		else if(indexOfBestShot == 3){
			return four;
		}
		else return null;
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
	
	private static int getTired(int[][] puzzle) //quantas trocas tem que fazer para chegar no objetivo?
	{
		int tired = 0;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if(PUZZLE_TARGET[i][j] != puzzle[i][j]){
					tired++;
				}
			}
		}
		
		return tired / 2;
	}
	
	private static boolean similars(int[][] a, int[][]b)
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
	
	private static void printSolution(Quadrant solution)
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
				
		if(solution.next != null)
		{
			printSolution(solution.next);
		}
	}
	
	public enum Move
	{
		UP, RIGHT, DOWN, LEFT;
	}
}
