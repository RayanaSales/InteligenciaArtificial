package rainhas;

import java.util.ArrayList;
import java.util.List;

public class Evolucao
{
	static List<Geracao> geracoes = new ArrayList<>();
	
	public static void GerarPopulacaoInicial()
	{		
		Geracao geracao = new Geracao(0);		
		for(int i = 0 ; i < Main.TAMANHO_POPULACAO ; i++)
		{				
			String tabuleiroBase10 = ShuffleString.shuffle("01234567");
			String tabuleiroBase2 = "";
			
			for (int j = 0; j < tabuleiroBase10.length(); j++)
			{
				int valorBase10 = Character.getNumericValue(tabuleiroBase10.charAt(j));
				String valorBase2 = Integer.toBinaryString(valorBase10);				
				while(valorBase2.length() != 3)
				{
					valorBase2 = "0" + valorBase2;
				}				
				tabuleiroBase2 += valorBase2;
			}
			
			geracao.individuos[i] = new Individuo(tabuleiroBase2);			
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
		
		Individuo[] filhos = GetUltimaGeracao().Crossover();
		Geracao geracao = new Geracao(GetUltimaGeracao().id + 1, filhos);
		geracoes.add(geracao);		
	}
	
	public static Geracao GetUltimaGeracao() 
	{
		return geracoes.get(geracoes.size() - 1);
	}
	
	public static void ImprimirGeracoes()
	{
		int solucao_geracao = 0, solucao_individuo = 0;
		
		System.out.println();
		System.out.println();
		for (Geracao geracao : geracoes)
		{	
			for (int b = 0 ; b < geracao.individuos.length ; b++)
			{	
				Individuo individuoAuxiliar = geracao.individuos[b];
				System.out.println("INDIVIDUO: " + b + " GERAÇÃO: " + geracao.id);
				
				System.out.print("Binario: " + individuoAuxiliar.tabuleiroStr);
				for (int r = 0; r < 8; r++)
				{
					if(r == 0)
					{
						System.out.print(" => [");
					}
					if (r == 7)
					{
						System.out.print(individuoAuxiliar.tabuleiroArray[r] + "] => attacks: " + individuoAuxiliar.ataques + "\n\n");
					}
					else
					{
						System.out.print(individuoAuxiliar.tabuleiroArray[r] + ", ");
					}
				}

				for (int i = 0 ; i <= 7; i++) //linha
				{
					for (int j = 0; j <= 7; j++) //coluna
					{
						if (individuoAuxiliar.tabuleiroArray[j] == i)
							System.out.print(" r ");
						else
							System.out.print(" * ");
					}
					System.out.println();
				}
				
				if(individuoAuxiliar.ataques == 0)
				{
					solucao_geracao = geracao.id;
					solucao_individuo = b;
				}
				System.out.println("\n");
			}
		}		
		System.out.println("SOLUÇÃO ENCONTRADA NA GERAÇÃO: " + solucao_geracao + " NO INDIVÍDUO: " + solucao_individuo);
	}
	
	public static void ImprimirUltimaGeracao()
	{
		int solucao_geracao = 0, solucao_individuo = 0;
		Geracao aux = GetUltimaGeracao();
		
		for (int b = 0 ; b < aux.individuos.length ; b++)
		{	
			Individuo individuoAuxiliar = aux.individuos[b];
			System.out.println("INDIVIDUO: " + b + " GERAÇÃO: " + aux.id);
			
			System.out.print("Binario: " + individuoAuxiliar.tabuleiroStr);
			for (int r = 0; r < 8; r++)
			{
				if(r == 0)
				{
					System.out.print(" => [");
				}
				if (r == 7)
				{
					System.out.print(individuoAuxiliar.tabuleiroArray[r] + "] => attacks: " + individuoAuxiliar.ataques + "\n\n");
				}
				else
				{
					System.out.print(individuoAuxiliar.tabuleiroArray[r] + ", ");
				}
			}
			for (int i = 0 ; i <= 7; i++) //linha
			{
				for (int j = 0; j <= 7; j++) //coluna
				{
					if (individuoAuxiliar.tabuleiroArray[j] == i)
						System.out.print(" r ");
					else
						System.out.print(" * ");
				}
				System.out.println();
			}
			if(individuoAuxiliar.ataques == 0)
			{
				solucao_geracao = aux.id;
				solucao_individuo = b;
			}	
		}
		
		System.out.println("SOLUÇÃO ENCONTRADA NA GERAÇÃO: " + solucao_geracao + " NO INDIVÍDUO: " + solucao_individuo);
	}
}

class ShuffleString
{
    public static String shuffle(String s)
    {
        String shuffledString = ""; 
        while (s.length() != 0)
        {
            int index = (int) Math.floor(Math.random() * s.length());
            char c = s.charAt(index);
            s = s.substring(0,index)+s.substring(index+1);
            shuffledString += c;
        }
        return shuffledString;

    }
}
