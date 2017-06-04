package rainhas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Evolucao
{
	private static List<Geracao> geracoes = new ArrayList<>();
	
	public static void GerarPopulacaoInicial()
	{
		Geracao geracao = new Geracao();
		
		for(int i = 0 ; i < Main.TAMANHO_POPULACAO ; i++)
		{			
			List<Integer> tabuleiro = Arrays.asList(0,1,2,3,4,5,6,7);
			Collections.shuffle(tabuleiro);		
			
			Integer[] tabuleiroArray = tabuleiro.toArray(new Integer[tabuleiro.size()]);
			geracao.individuos.add(new Individuo(tabuleiroArray));
		}
		
		geracoes.add(geracao);
	}
	
	public static void CriarNovaGeracao()
	{
		/*
		 * crossover / mutacao
		 * adiciona em nova populaca
		 * 		  
		 * */
		
		List<Individuo> novos = GetUltimaGeracao().Crossover();
		Geracao geracao = new Geracao(novos);
		geracoes.add(geracao);		
	}
	
	public static Geracao GetUltimaGeracao() 
	{
		return geracoes.get(geracoes.size() - 1);
	}
	
	public static void ImprimirGeracoes()
	{
		int solucao_geracao = 0, solucao_individuo = 0;
		
		for(int a = 0; a<geracoes.size() ; a++)
		{
			System.out.println("GERAÇÃO: " + a);
			for (int b = 0 ; b < geracoes.get(a).individuos.size() ; b++)
			{	
				Individuo individuoAuxiliar = geracoes.get(a).individuos.get(b);
				System.out.println("INDIVIDUO: " + b);
				for (int r = 0; r < 8; r++)
				{
					if (r == 7)
					{
						System.out.print(individuoAuxiliar.tabuleiro[r] + " => attacks: " + individuoAuxiliar.ataques + "\n");
					}
					else
					{
						System.out.print(individuoAuxiliar.tabuleiro[r] + ", ");
					}
				}

				for (int i = 0 ; i <= 7; i++) //linha
				{
					for (int j = 0; j <= 7; j++) //coluna
					{
						if (individuoAuxiliar.tabuleiro[j] == i)
							System.out.print(" r ");
						else
							System.out.print(" * ");
					}
					System.out.println();
				}
				
				if(individuoAuxiliar.ataques == 0)
				{
					solucao_geracao = a;
					solucao_individuo = b;
				}
				System.out.println("\n");
			}
		}
		
		System.out.println("SOLUÇÃO ENCONTRADA NA GERAÇÃO: " + solucao_geracao + " NO INDIVÍDUO: " + solucao_individuo);
	}
}
