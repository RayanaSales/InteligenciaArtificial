package rainhas;

import java.util.Random;

public class Geracao
{
	int id = 0;	
	Individuo[] individuos = new Individuo[Main.TAMANHO_POPULACAO]; // pais	
	private Individuo[] maisAptos = new Individuo[Main.TAMANHO_POPULACAO]; // pais mais aptos
		
	public Geracao(int id)
	{
		this.id = id;
	}
	
	public Geracao(int id, Individuo[] individuos)
	{
		this.id = id;
		this.individuos = individuos;		
	}

	public boolean AvaliarIndividuos()
	{
		/*
		 * Nessa geracao, ha uma solucao? Ainda nao achou solucao = return true / else false
		 * 
		 */	
		for (Individuo individuo : individuos)
		{
			individuo.CalcularAptidao();
			if (individuo.ataques == 0)
			{								
				return false;
			}	
		}		
		return true;
	}
	
	public void SelecionarMaisAptos()
	{		
		Random sorteia = new Random();	
		
		for(int a = 0 ; a < Main.TAMANHO_POPULACAO ; a++)
		{
			int i = sorteia.nextInt(Main.TAMANHO_POPULACAO);
			int j = sorteia.nextInt(Main.TAMANHO_POPULACAO);				
			while (i == j){
				j = sorteia.nextInt(Main.TAMANHO_POPULACAO);	
			}
			maisAptos[a] = (individuos[i].ataques < individuos[j].ataques ? individuos[i] : individuos[j]);
		}
	}

	public Individuo[] Crossover()
	{	
		Random sorteia = new Random();	
		Individuo[] filhos = new Individuo[Main.TAMANHO_POPULACAO];
		
		for (int i = 0; i < Main.TAMANHO_POPULACAO; i++)
		{
			if (i < maisAptos.length - 1) //se nao for o ultimo
			{
					int posicaoCorte = sorteia.nextInt(22);
					
					//trocar os rabinhos
					String f1 = maisAptos[i].tabuleiroStr.substring(0, posicaoCorte) + 
								maisAptos[i + 1].tabuleiroStr.substring(posicaoCorte, 24);
					
					String f2 = maisAptos[i + 1].tabuleiroStr.substring(0, posicaoCorte) + 
							maisAptos[i].tabuleiroStr.substring(posicaoCorte, 24);	
					
					Individuo i1 = new Individuo(f1);
					Individuo i2 = new Individuo(f2);
					
					if(AplicarMutacao())
					{
						System.out.println("mutando...");
						i2 = GerarMutante(i2);
					}
					
					filhos[i] = i1;
					filhos[i + 1] = i2;
			}
		}
		return filhos;
	}
	
	private boolean AplicarMutacao()
	{
		double randon = new Random().nextDouble() * 1;		
		
		if(randon < Main.TAXA_MUTACA0)
		{
			return true;
		}
		
		return false;
	}	
	
	private Individuo GerarMutante(Individuo filho)
	{
		char[] novoTabuleiroStr = filho.tabuleiroStr.toCharArray();
		Random sorteia = new Random();
		int posicao = sorteia.nextInt(24);
	
		novoTabuleiroStr[posicao] = (filho.tabuleiroStr.charAt(posicao) == '1' ? '0' : '1');
		
		filho.tabuleiroStr = new String(novoTabuleiroStr);		
		return filho;
	}
}
