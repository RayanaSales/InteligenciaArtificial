package solucao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solver
{
	static ArrayList<Node> queue = new ArrayList<Node>(); 
	static HashSet<Node> visitados =  new HashSet<>();
	
	public static void solve(Node current)
	{
		int column = 0;		
		boolean solved = false;
		
		queue.add(current);
		
		do {
			current = queue.remove(0);	
						
			if (Help.solved(current))
			{
				solved = true;
				break;
			}
			if (!visitados.contains(current))
			{
				if(column == 7)
					column = 0;
				
				expand(current, column);
				visitados.add(current);				
				column++;
			}
		} while (!queue.isEmpty() && !solved);
		
		if(solved)
		{
			System.out.println("SOLUÇÃO:");
			Help.printSolution(current);
			System.out.println("FIM DA SOLUÇÃO!" + Help.steps + " passos executados.");
		}
		else
		{
			System.out.println("Não achei solução");
		}
	}
	
	private static void expand(Node node, int column)
	{
//		-pega as coordenadas da primeira rainha
		int cord_x_queen = node.board[column];
		
//		-gera 4 novos tabuleiros (permutando a rainha da coluna x)		
		if(cord_x_queen != 0)
		{
			node.swap0.board = Arrays.copyOf(node.board, 8);
			node.swap0.board[column] = 0;
		}
		if(cord_x_queen != 1)
		{
			node.swap1.board = Arrays.copyOf(node.board, 8);
			node.swap1.board[column] = 1;
		}
		if(cord_x_queen != 2)
		{
			node.swap2.board = Arrays.copyOf(node.board, 8);
			node.swap2.board[column] = 2;
		}
		if(cord_x_queen != 3)
		{
			node.swap3.board = Arrays.copyOf(node.board, 8);
			node.swap3.board[column] = 3;
		}
		if(cord_x_queen != 4)
		{
			node.swap4.board = Arrays.copyOf(node.board, 8);
			node.swap4.board[column] = 4;
		}
		if(cord_x_queen != 5)
		{
			node.swap5.board = Arrays.copyOf(node.board, 8);
			node.swap5.board[column] = 5;
		}
		if(cord_x_queen != 6)
		{
			node.swap6.board = Arrays.copyOf(node.board, 8);
			node.swap6.board[column] = 6;
		}
		if(cord_x_queen != 7)
		{
			node.swap7.board = Arrays.copyOf(node.board, 8);
			node.swap7.board[column] = 7;
		}	
		
//		-calcula ataques para as permutações 
		Map<Node, Integer> map = new HashMap<Node, Integer>();
		
		if(node.swap0.board != null)
		{
			node.swap0.attacks = Help.countAttacksByColumn(node.swap0, column);
			map.put(node.swap0, node.swap0.attacks);
		}
		if(node.swap1.board != null)
		{	
			node.swap1.attacks = Help.countAttacksByColumn(node.swap1, column);
			map.put(node.swap1, node.swap1.attacks);
		}		
		if(node.swap2.board != null)
		{
			node.swap2.attacks = Help.countAttacksByColumn(node.swap2, column);
			map.put(node.swap2, node.swap2.attacks);
		}
		if(node.swap3.board != null)
		{
			node.swap3.attacks = Help.countAttacksByColumn(node.swap3, column);
			map.put(node.swap3, node.swap3.attacks);
		}
		if(node.swap4.board != null)
		{
			node.swap4.attacks = Help.countAttacksByColumn(node.swap4, column);
			map.put(node.swap4, node.swap4.attacks);
		}
		if(node.swap5.board != null)
		{
			node.swap5.attacks = Help.countAttacksByColumn(node.swap5, column);
			map.put(node.swap5, node.swap5.attacks);
		}
		if(node.swap6.board != null)
		{
			node.swap6.attacks = Help.countAttacksByColumn(node.swap6, column);
			map.put(node.swap6, node.swap6.attacks);
		}
		if(node.swap7.board != null)
		{
			node.swap7.attacks = Help.countAttacksByColumn(node.swap7, column);
			map.put(node.swap7, node.swap7.attacks);
		}
		
//		-get the best shot				
		Node next = Help.createNode(node, null);
		Integer bestShot = (Integer) Collections.min(map.values());
		
		for (java.util.Map.Entry<Node, Integer> entry : map.entrySet()) 
		{
            if (entry.getValue().equals(bestShot)) 
            {
                next.board = entry.getKey().board;
            }
        }
		
		if(!prune(next))
		{
			queue.add(next);
		}
	}
	
	private static boolean prune(Node node)
	{		
		//vc ja foi usado antes?
		if(visitados.contains(node))
		{
			return true;
		}
		
		return false;
	}
}
