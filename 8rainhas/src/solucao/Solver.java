package solucao;

import java.util.ArrayList;

public class Solver
{
	static ArrayList<Node> fila = new ArrayList<Node>(); 
	static ArrayList<Node> useds = new ArrayList<Node>(); 
	
	public static void solve(int[] entrada)
	{
		Node current = new Node();;
		boolean resolvido = false;
		
		fila.add(current);
		
		do {
			current = fila.remove(0);	
						
			if (Help.solved(current.board))
			{
				resolvido = true;
				break;
			}
			if (!Help.used(current))
			{
				useds.add(current);
				expand(current);
			}
		} while (!fila.isEmpty() && !resolvido);
		
		if(resolvido)
		{
			System.out.println("SOLUÇÃO:");
			Help.printSolution(current);
			System.out.println("FIM DA SOLUÇÃO!");
		}
		else
		{
			System.out.println("Não achei solução");
		}
	}
	
	private static void expand(Node node)
	{
		//gera todas permutações
		//escolhe a melhor (menor qtd de ataques)
		//adiciona melhor na fila
	}
}
