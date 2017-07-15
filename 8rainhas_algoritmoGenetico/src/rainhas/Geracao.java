package rainhas;

import java.util.Random;

public class Geracao
{
	int id = 0;	
	Individuo[] individuos = new Individuo[Main.TAMANHO_POPULACAO]; // pais	
		
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
		 * Nessa geracao, ha uma solucao?
		 * 
		 */	
		for (Individuo individuo : individuos)
		{
			if (individuo.CalcularAptidao() == 0)
			{								
				return false;
			}
		}		
		return true;
	}
	
	public Individuo BuscarMelhorSolucao()
	{
		Individuo melhor = individuos[0];		
		for (Individuo individuo : individuos)
		{
			if(individuo.CalcularAptidao() < melhor.CalcularAptidao())
			{
				melhor = individuo;
			}
		}		
		return melhor;
	}
	
	public Individuo[] SelecaoNatural()
	{		
						
		Random sorteia = new Random();		
		Individuo[] sobreviventes = new Individuo[Main.TAMANHO_POPULACAO];
						
		for(int a = 0 ; a < Main.TAMANHO_POPULACAO ; a++)
		{
			int i = sorteia.nextInt(individuos.length);
			int j = sorteia.nextInt(individuos.length);
			int i_ataques = individuos[i].CalcularAptidao();
			int j_ataques = individuos[j].CalcularAptidao();
			
			sobreviventes[a] = (i_ataques < j_ataques ? individuos[i] : individuos[j]);			
		}
		
		return sobreviventes;
	}

	public Individuo[] CrossoverEMutacao(Individuo[] sobreviventes)
	{	
		/*
		 * GERA 500 FILHOS A PARTIR DOS 250 SOBREVIVENTES
		 * 
		 * */
		
		int tamanho_cromossomo = 24, filhos_index = 0;				
		Random sorteia = new Random();			
		String[] cromossomo_mascara = new String[tamanho_cromossomo];		
		Individuo[] filhos = new Individuo[Main.TAMANHO_POPULACAO];
		
		for(int i = 0; i < tamanho_cromossomo; i++)
		{
			cromossomo_mascara[i] = Integer.toString(sorteia.nextInt(2));
		}
		
		for(int i = 0 ; i < (Main.TAMANHO_POPULACAO / 2); i++)
		{
			Individuo pai = sobreviventes[i];
			Individuo mae = sobreviventes[i + 1];
			
			String cromossomo_filho = "";
			String cromossomo_filha = "";
			
			for(int j = 0 ; j < tamanho_cromossomo ; j++)
			{
				if(cromossomo_mascara[j].equals("0"))
				{
					cromossomo_filho += mae.tabuleiroStr.charAt(j);
					cromossomo_filha += pai.tabuleiroStr.charAt(j);
				}
				else
				{
					cromossomo_filho += pai.tabuleiroStr.charAt(j);
					cromossomo_filha += mae.tabuleiroStr.charAt(j);
				}
			}			
			Individuo filho = new Individuo(cromossomo_filho);
			Individuo filha = new Individuo(cromossomo_filha);
			
			filhos[filhos_index++] = filho;
			filhos[filhos_index++] = filha;
			
		} // fim crossover
		
		if(AplicarMutacao())
		{
			filhos = Mutacionar(filhos);
		}
		
		filhos = Evolucao.Eletismo(Evolucao.GetUltimaGeracao().individuos, filhos);
		
		return filhos;
	}
	
	private Individuo[] Mutacionar(Individuo[] filhos)
	{
		Random sorteia = new Random();
		int index_filho = sorteia.nextInt(filhos.length);
		int index_tabuleiro = sorteia.nextInt(filhos[index_filho].tabuleiroStr.length());
		char[] novoTabuleiroStr = filhos[index_filho].tabuleiroStr.toCharArray();				
		
		novoTabuleiroStr[index_tabuleiro] = (filhos[index_filho].tabuleiroStr.charAt(index_tabuleiro) == '1' ? '0' : '1');
		filhos[index_filho].tabuleiroStr = new String(novoTabuleiroStr);			
		return filhos;
	}
	
	private boolean AplicarMutacao()
	{
		double randon = new Random().nextDouble();	
		return (randon < Main.TAXA_MUTACA0 ? true : false);
	}
}
