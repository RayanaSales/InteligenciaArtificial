package solution;

public class Main
{
	public static void main(String[] args)
	{
		// SEM SOLU��O
		 Board node = new Board(new int[] { 3, 6, 1, 2, 7 });
//		 Board node = new Board(new int[] { 0, 0, 0, 0, 0, 0, 0, 0 });
//		 Board node = new Board(new int[] { 5,5,5,5,5,5,5,5 });
//		 Board node = new Board(new int[] { 0, 1, 2, 3, 4, 3, 2, 1 });
//		 Board node = new Board(new int[] { 4, 3, 2, 7, 7, 5, 4, 0 });
//		 Board node = new Board(new int[] { 7, 4, 5, 4, 3, 2, 7, 0 });

		// COM SOLU��O:
//		 Board node = new Board(new int[] { 0, 2,4 , 1, 3, 6, 7, 5 });
//		 Board node = new Board(new int[] { 0,4,2,3,1,5,6,7});
//		 Board node = new Board(new int[] { 0, 1, 2, 3, 4, 5, 6, 7 });
//		 Board node = new Board(new int[] { 7, 6, 5, 4, 3, 2, 1, 0 });
//		 Board node = new Board(new int[] { 2, 5, 0, 1, 6, 3, 4, 7 });

		System.out.println("Executando 8 rainhas versao 2...");
		Solver.solve(node);
	}
}
