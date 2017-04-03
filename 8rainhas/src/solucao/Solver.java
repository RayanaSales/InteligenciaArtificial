package solucao;

import java.util.ArrayList;

public class Solver
{
	static ArrayList<Node> fila = new ArrayList<Node>(); 
	static ArrayList<Node> useds = new ArrayList<Node>(); 
	
	public static void solve(int[] entrada)
	{
		int column = 0;
		Node current = new Node();;
		boolean resolvido = false;
		
		fila.add(current);
		
		do {
			current = fila.remove(0);	
						
			if (Help.solved(current))
			{
				resolvido = true;
				break;
			}
			if (!Help.used(current))
			{
				if(column == 7)
					column = 0;
				
				useds.add(current);
				expand(current, column);
				
				column++;
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
	
	private static void expand(Node node, int column)
	{
		//gera todas permutações, da coluna
		//escolhe a melhor (menor qtd de ataques)
		//adiciona melhor na fila
		
		int cord_y_queen = column;
		int cord_x_queen = node.board[column];
		
		
	}
}
