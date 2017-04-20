package solution;

import java.util.Arrays;

public class Board
{
	Board previous;
	int[] config;
	public int attacks;

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

		// 1- tem alguem na msm linha q eu?
		attacks += Help.getOccurrences(config, cord_i_queen) - 1;

		// 2- tem alguem nas minhas diagonais? (percorro diagonais, se tiver alguem la, ta em ataque)		
		int x = cord_i_queen;
		int y = cord_j_queen;
		
		int rival_column = column; //coluna da rival que estou testando no momento

		while (x >= 0 && y <= 7) //up, right
		{
			rival_column++;
			x--;
			y++;

			if (x < 0 || y > 7)
				break;

			if (anyAttack(rival_column, x, y))
				attacks++;			
		}

		x = cord_i_queen;
		y = cord_j_queen;
		rival_column = column;

		while (x <= 7 && y <= 7) //down, right
		{
			rival_column++;
			x++;
			y++;

			if (x > 7 || y > 7)
				break;

			if (anyAttack(rival_column, x, y))
				attacks++;
		}

		x = cord_i_queen;
		y = cord_j_queen;
		rival_column = column;

		while (x <= 7 && y >= 0) //down, left
		{
			rival_column--;
			x++;
			y--;

			if (x > 7 || y < 0)
				break;

			if (anyAttack(rival_column, x, y))
				attacks++;
		}

		x = cord_i_queen;
		y = cord_j_queen;
		rival_column = column;

		while (x >= 0 && y >= 0) //down, left
		{
			rival_column--;
			x--;
			y--;

			if (x < 0 || y < 0)
				break;

			if (anyAttack(rival_column, x, y))
				attacks++;
		}

		return attacks;
	}

	private boolean anyAttack(int rival_column, int x, int y)
	{
		//x e y representam um dos pontos que formam as diagonais
		
		// coordenadas da rival
		int rival_x = config[rival_column];
		int rival_y = rival_column;

		// se a rival estiver em x, e y ta em ataque
		if (rival_x == x && rival_y == y)
			return true;
		else
			return false;
	}

	
}
