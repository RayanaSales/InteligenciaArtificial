package rainhas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Geracao
{
	public List<Individuo> individuos = new ArrayList<Individuo>();
	//private List<Individuo> maisAptos = new ArrayList<Individuo>();
	
	public Geracao()
	{
		
	}
	
	public Geracao(List<Individuo> individuos)
	{
		this.individuos = individuos;
	}

	public boolean AvaliarIndividuos()
	{
		/*
		 * Nessa geracao, ha uma solucao? Ainda nao achou solucao = return true
		 * / else false
		 * 
		 */

		for (Individuo individuo : individuos)
		{
			if (individuo.ataques == 0)
			{
				return false;
			}
		}

		return true;
	}

	public void SelecionarMaisAptos()
	{
		Collections.sort(individuos, new Comparator<Individuo>()
		{
			@Override
			public int compare(Individuo b, Individuo b1)
			{
				// -1 - less than, 1 - greater than, 0 - equal, all inversed for
				// descending
				return b1.ataques > b.ataques ? -1 : (b1.ataques < b.ataques) ? 1 : 0;
			}
		});
		
		//maisAptos.addAll(individuos);
	}

	public List<Individuo> Crossover()
	{
		int troca = 0;
		
		for(int i = 0 ; i<individuos.size() ; i++)
		{
			if(i != individuos.size() - 1)
			{
				troca = individuos.get(i).tabuleiro[0];
				individuos.get(i).tabuleiro[0] = individuos.get(i + 1).tabuleiro[2];
				individuos.get(i + 1).tabuleiro[2] = troca;
				
				troca = individuos.get(i).tabuleiro[1];
				individuos.get(i).tabuleiro[1] = individuos.get(i + 1).tabuleiro[3];
				individuos.get(i + 1).tabuleiro[3] = troca;
				
				troca = individuos.get(i).tabuleiro[4];
				individuos.get(i).tabuleiro[4] = individuos.get(i + 1).tabuleiro[6];
				individuos.get(i + 1).tabuleiro[6] = troca;
				
				troca = individuos.get(i).tabuleiro[5];
				individuos.get(i).tabuleiro[5] = individuos.get(i + 1).tabuleiro[7];
				individuos.get(i + 1).tabuleiro[7] = troca;
			}
		}	
		
		AplicarMutacao();
		return individuos;
	}

	private void AplicarMutacao()
	{
		Random sorteia = new Random();		
		int posicao1 = 0, posicao2 = 0, troca = 0;	
		int apto = sorteia.nextInt(individuos.size());
				
		while(posicao1 == posicao2)
		{
			posicao1 = sorteia.nextInt(individuos.get(apto).tabuleiro.length);
			posicao2 = sorteia.nextInt(individuos.get(apto).tabuleiro.length);
		}		
				
		troca = individuos.get(apto).tabuleiro[posicao1];
		individuos.get(apto).tabuleiro[posicao1] = individuos.get(apto).tabuleiro[posicao2];
		individuos.get(apto).tabuleiro[posicao2] = troca;		
	}
}
