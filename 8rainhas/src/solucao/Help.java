package solucao;

public class Help
{
	public static boolean solved(Node node)
	{
		// verifica se o array atual possui ataques = 0
		
		for(int i= 0 ; i<8 ; i++)
		{
			if(countAttacksByColumn(node, i) != 0)
			{
				return false;
			}
		}

		return true;
	}

	public static int countAttacksByColumn(Node node, int column)
	{
		//a rainha da coluna x, ataca quantas outras rainhas??
		
		// 1- rainhas não podem ocupar a msm coluna
		// 2- rainhas não podem ocupar a mesma linha
		// 3- rainhas não podem estar cruzando diagonais
		
		int attacks = 0;

		int cord_i_queen = node.board[column];
		int cord_j_queen = column;

		// tem alguem na msm linha q eu?		
		attacks += getOccurrences(node.board, cord_i_queen) - 1;

		// tem alguem nas minhas diagonais?
		int x = cord_i_queen;
		int y = cord_j_queen;

		while (x >= 0 && y <= 7)
		{
			x--;
			y++;	
			
			if(x < 0 || y > 7)
				break;
			
			if (anyAttack(node.board, x, y))
				attacks++;
		}

		x = cord_i_queen;
		y = cord_j_queen;

		while (x <= 7 && y <= 7)
		{
			x++;
			y++;
			
			if(x > 7 || y > 7)
				break;
			
			if (anyAttack(node.board, x, y))
				attacks++;
		}

		x = cord_i_queen;
		y = cord_j_queen;

		while (x <= 7 && y >= 0)
		{
			x++;
			y--;
			
			if(x > 7 || y < 0)
				break;
			
			if (anyAttack(node.board, x, y))
				attacks++;
		}
		
		x = cord_i_queen;
		y = cord_j_queen;

		while (x >= 0 && y >= 0)
		{
			x--;
			y--;
			
			if(x < 0 || y < 0)
				break;
			
			if (anyAttack(node.board, x, y))
				attacks++;
		}

		return attacks;
	}

	public static boolean used(Node node)
	{
		return false;
	}

	public static void printSolution(Node node)
	{

	}

	private static boolean anyAttack(int[] board, int x, int y)
	{
		// procura onde a rainha dessa coluna esta
		int queen_board_i = board[y];
		int queen_board_j = y;

		//essa rainha ataca alguem em tal posicao?
		if (queen_board_i == x && queen_board_j == y)
			return true;
		else
			return false;
	}

	private static int getOccurrences(int[] array, int element)
	{
		int occurrences = 0;
		
		for (int i : array)
		{
			if(i == element)
			{
				occurrences++;
			}
		}
		return occurrences;
	}
}
