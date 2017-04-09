package solution;

public class Main
{
	public static void main(String[] args)
	{
		Board node = new Board(new int[] { 4, 3, 2, 7, 7, 5, 4, 0 });

		System.out.println("Executando 8 rainhas versão 2...");
		Solver.solve(node);		
	}
}
