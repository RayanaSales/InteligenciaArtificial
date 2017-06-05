package rainhas;

public class Individuo
{
	public Integer[] tabuleiro = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7}; //valores de 0 a 7
	public int ataques = 0;
	
	public Individuo(Integer[] tabuleiro) 
	{
		this.tabuleiro = tabuleiro;
		CalcularAptidao();
	}
	
	public int CalcularAptidao()
	{		
		ataques = 0;
		for (int i = 0; i <= 7; i++)
		{
			ataques += ContarAtaquesPorColuna(i);
		}
		
		return ataques;
	}
	
	private int ContarAtaquesPorColuna(int column)
	{
		// a rainha da coluna x, ataca quantas outras rainhas??

		// 1- rainhas nao podem ocupar a msm coluna
		// 2- rainhas nao podem ocupar a mesma linha
		// 3- rainhas nao podem estar cruzando diagonais

		int attacks = 0;
		int cord_i_queen = tabuleiro[column];
		int cord_j_queen = column;

		// 1- tem alguem na msm linha q eu?
		attacks += EncontrarAlguemNaMinhaLinha(tabuleiro, cord_i_queen) - 1;

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

			if (AlgumAtaque(rival_column, x, y))
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

			if (AlgumAtaque(rival_column, x, y))
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

			if (AlgumAtaque(rival_column, x, y))
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

			if (AlgumAtaque(rival_column, x, y))
				attacks++;
		}

		return attacks;
	}
	
	protected int EncontrarAlguemNaMinhaLinha(Integer[] tabuleiro2, int element)
	{
		int occurrences = 0;

		for (int i : tabuleiro2)
		{
			if (i == element)
			{
				occurrences++;
			}
		}
		return occurrences;
	}

	private boolean AlgumAtaque(int rival_column, int x, int y)
	{
		//x e y representam um dos pontos que formam as diagonais
		
		// coordenadas da rival
		int rival_x = tabuleiro[rival_column];
		int rival_y = rival_column;

		// se a rival estiver em x, e y ta em ataque
		if (rival_x == x && rival_y == y)
			return true;
		else
			return false;
	}
}
