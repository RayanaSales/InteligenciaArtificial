package puzzle;

public class Main
{
	static int[][] user_puzzle = { { 1, 2, 3 }, { 4, 5, 6 }, { 0, 7, 8 } };
	
	public static void main(String[] args)
	{
		Solver.solve(user_puzzle);
	}
}
