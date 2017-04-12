package solution;

import java.util.Arrays;

public class Board
{
	Board previous;
	int[] config;
	public int attacks;
	
	private boolean alreadyCounted = false;

	public Board(int[] config)
	{
		this.config = config;
		this.attacks = 0;
	}

	public Board()
	{
		this.attacks = 0;
	}

	@Override
	public int hashCode()
	{
		// TODO Auto-generated method stub
		return Arrays.hashCode(config);
	}

	@Override
	public boolean equals(Object obj)
	{
		boolean similars = true;
		Board b = (Board) obj;

		for (int i = 0; i < 8; i++)
		{
			if (b.config[i] != this.config[i])
			{
				similars = false;
				break;
			}
		}
		return similars;
	}

	public int countAttacks()
	{
		this.attacks = 0;
		
		for (int i = 0; i <= 7; i++)
		{
			//System.out.println("Contando ataques, coluna: " + i);
			this.attacks += countAttacksByColumn(i);
		}

		return this.attacks;
	}

	private int countAttacksByColumn(int column)
	{
		// a rainha da coluna x, ataca quantas outras rainhas??

		// 1- rainhas nao podem ocupar a msm coluna
		// 2- rainhas nao podem ocupar a mesma linha
		// 3- rainhas nao podem estar cruzando diagonais

		int attacks = 0;

		int cord_i_queen = config[column];
		int cord_j_queen = column;

		// tem alguem na msm linha q eu?
		attacks += getOccurrences(config, cord_i_queen) - 1;

		// tem alguem nas minhas diagonais?
		int x = cord_i_queen;
		int y = cord_j_queen;

		while (x >= 0 && y <= 7)
		{
			x--;
			y++;

			if (x < 0 || y > 7)
				break;

			if (anyAttack(config, x, y))
				attacks++;
		}

		x = cord_i_queen;
		y = cord_j_queen;

		while (x <= 7 && y <= 7)
		{
			x++;
			y++;

			if (x > 7 || y > 7)
				break;

			if (anyAttack(config, x, y))
				attacks++;
		}

		x = cord_i_queen;
		y = cord_j_queen;

		while (x <= 7 && y >= 0)
		{
			x++;
			y--;

			if (x > 7 || y < 0)
				break;

			if (anyAttack(config, x, y))
				attacks++;
		}

		x = cord_i_queen;
		y = cord_j_queen;

		while (x >= 0 && y >= 0)
		{
			x--;
			y--;

			if (x < 0 || y < 0)
				break;

			if (anyAttack(config, x, y))
				attacks++;
		}

		return attacks;
	}

	private boolean anyAttack(int[] board, int x, int y)
	{
		// procura onde a rainha dessa coluna esta
		int queen_board_i = board[y];
		int queen_board_j = y;

		// essa rainha ataca alguem em tal posicao?
		if (queen_board_i == x && queen_board_j == y)
			return true;
		else
			return false;
	}

	private int getOccurrences(int[] array, int element)
	{
		int occurrences = 0;

		for (int i : array)
		{
			if (i == element)
			{
				occurrences++;
			}
		}
		return occurrences;
	}
}
