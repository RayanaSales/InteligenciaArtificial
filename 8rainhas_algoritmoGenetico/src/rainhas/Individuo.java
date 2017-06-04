package rainhas;

public class Individuo
{
	public Integer[] tabuleiro = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7}; //valores de 0 a 7
	public int ataques = 0;
	
	public Individuo(Integer[] tabuleiro) 
	{
		this.tabuleiro = tabuleiro;
		CalcularQuantidadeAtaques();
	}
	
	private int CalcularQuantidadeAtaques()
	{		
		for(int a = 0 ; a < tabuleiro.length; a++) //rainha 1
		{
			int cord_x_rainha1 = tabuleiro[a];
			int cord_y_rainha1 = a;
			
			for(int b = 0; b < tabuleiro.length; b++) //rainha 2
			{
				if(b != a) //nao verifique vc msm
				{
					int cord_x_rainha2 = tabuleiro[b];
					int cord_y_rainha2 = b;
					
					if((cord_x_rainha2 - cord_x_rainha1) * -1 == (cord_y_rainha2 - cord_y_rainha1) * -1)
					{
						ataques++;
					}
				}
			}
		}
		return ataques;
	}
}
