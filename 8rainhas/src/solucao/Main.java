package solucao;

public class Main
{
	public static void main(String[] args)
	{
		Node node = new Node(new int[] {4, 3, 2, 7, 7, 5, 4, 0});		
		
		
		
		
//		Node node = new Node(new int[] {2, 5, 7, 0, 4, 6, 1, 3});
		
		Solver.solve(node);
	}

}
