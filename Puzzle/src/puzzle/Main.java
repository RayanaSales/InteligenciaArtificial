package puzzle;

public class Main
{
	/*GRUPO DE TESTES 1*/
//	static int[][] user_puzzle = { { 1, 2, 3 }, { 4, 5, 0 }, { 7, 8, 6 } };
//	static int[][] user_puzzle = { { 1, 2, 0 }, { 4, 5, 3 }, { 7, 8, 6 } };
//	static int[][] user_puzzle = { { 1, 0, 2 }, { 4, 5, 3 }, { 7, 8, 6 } };
//	static int[][] user_puzzle = { { 1, 5, 2 }, { 4, 0, 3 }, { 7, 8, 6 } };
//	static int[][] user_puzzle = { { 1, 5, 2 }, { 0, 4, 3 }, { 7, 8, 6 } };
	
	
	/*GRUPO DE TESTES 2*/
//	static int[][] user_puzzle = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 0, 8 } };
//	static int[][] user_puzzle = { { 1, 2, 3 }, { 4, 5, 6 }, { 0, 7, 8 } };
//	static int[][] user_puzzle = { { 1, 2, 3 }, { 0, 5, 6 }, { 4, 7, 8 } };
//	static int[][] user_puzzle = { { 0, 2, 3 }, { 1, 5, 6 }, { 4, 7, 8 } };
//	static int[][] user_puzzle = { { 2, 3, 0 }, { 1, 5, 6 }, { 4, 7, 8 } };
//	static int[][] user_puzzle = { { 2, 3, 6 }, { 1, 5, 0 }, { 4, 7, 8 } };
//	static int[][] user_puzzle = { { 2, 3, 6 }, { 1, 5, 8 }, { 4, 7, 0 } };
	
	
	/*GRUPO DE TESTES 3*/
//	static int[][] user_puzzle = { { 1, 2, 3 }, { 4, 5, 0 }, { 7, 8, 6 } };
//	static int[][] user_puzzle = { { 1, 2, 3 }, { 4, 0, 5 }, { 7, 8, 6 } };
//	static int[][] user_puzzle = { { 1, 2, 3 }, { 4, 8, 5 }, { 7, 0, 6 } };
//	static int[][] user_puzzle = { { 1, 2, 3 }, { 4, 8, 5 }, { 0, 7, 6 } };
//	static int[][] user_puzzle = { { 1, 2, 3 }, { 0, 8, 5 }, { 4, 7, 6 } };
	static int[][] user_puzzle = { { 0, 2, 3 }, { 1, 8, 5 }, { 4, 7, 6 } };
		
	public static void main(String[] args)
	{
		Solver.solve(user_puzzle);
	}
}
