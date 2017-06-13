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
			
			geracao.individuos[i] = new Individuo(tabuleiroBase2, i);			
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
	
	public static void ImprimirUltimaGeracao()
	{
		for (Individuo individuo : geracoes.get(geracoes.size() - 1).individuos)
		{			
			boolean solucao = individuo.ataques == 0;
			ImprimirIndividuo(individuo, solucao);
		}
	}

	public static void ImprimirIndividuo(Individuo individuo, boolean solucao)
	{
		String solucaoStr = ""; 
		if(solucao){
			solucaoStr = " -> SOLUวรรรรรรรรรรรรรรรรรรรรO";
		}
		System.out.print("Id: " + individuo.id + " Binario: " + individuo.tabuleiroStr);
		for (int r = 0; r < 8; r++)
		{
			if(r == 0)
			{
				System.out.print(" => [");
			}
			if (r == 7)
			{
				System.out.println(individuo.tabuleiroArray[r] + "] => attacks: " + individuo.ataques + solucaoStr);
			}
			else
			{
				System.out.print(individuo.tabuleiroArray[r] + ", ");
			}
		}
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
