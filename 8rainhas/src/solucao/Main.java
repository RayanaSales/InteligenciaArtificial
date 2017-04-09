package solucao;

public class Main
{
	public static void main(String[] args)
	{		
		Node node = Help.createNode(null, new int[] {4, 3, 2, 7, 7, 5, 4, 0});
		
		System.out.println("Executando");
		Solver.solve(node);
	}

}
