package rainhas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Geracao
{
	int id = 0;
	Individuo[] individuos = new Individuo[20]; // pais
	//Individuo[] maisAptos = new Individuo[20]; // pais mais aptos
	
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
		System.out.print("");
		for (Individuo individuo : individuos)
		{
			if(individuo != null)
			{
				individuo.CalcularAptidao();
				if (individuo.ataques == 0)
				{
					return false;
				}
			}
		}		
		return true;
	}

	//TROCAR PARA DUELO
	public void SelecionarMaisAptos()
	{		
		Arrays.sort(individuos, new Comparator<Individuo>() {
		   
			@Override
			public int compare(Individuo i1, Individuo i2)
			{
				// TODO Auto-generated method stub
				return i1.compareTo(i2);
			}
		});
		
		//maisAptos = Arrays.copyOfRange(individuos, 0, 20);
	}

	public Individuo[] Crossover()
	{		
		//Individuo[] filhos = new Individuo[20];
		Random sorteia = new Random();		
		
		for (int i = 0; i < 20; i++)
		{
			int posicaoCorte = sorteia.nextInt(22);
			
			if (i < individuos.length - 1) //se nao for o ultimo
			{
				//trocar os rabinhos
				String f1 = individuos[i].tabuleiroStr.substring(0, posicaoCorte) + 
						individuos[i + 1].tabuleiroStr.substring(posicaoCorte, 24);
				
				String f2 = individuos[i + 1].tabuleiroStr.substring(0, posicaoCorte) + 
						individuos[i].tabuleiroStr.substring(posicaoCorte, 24);	
				
				Individuo i1 = new Individuo(f1);
				Individuo i2 = new Individuo(f2);
				individuos[individuos.length - 1] = i1;
				individuos[individuos.length - 1] = i2;
			}
		}		
		AplicarMutacao();		
		return individuos;
	}

	private void AplicarMutacao()
	{
		Random sorteia = new Random();		
		int filho = sorteia.nextInt(individuos.length);
		int posicao = sorteia.nextInt(24);			
				
		char[] tabuleiroCharArray = individuos[filho].tabuleiroStr.toCharArray();
	    tabuleiroCharArray[posicao] = (tabuleiroCharArray[posicao] == '0' ? '1' : '0');
	    String nova = new String(tabuleiroCharArray);
	    
	    individuos[filho].tabuleiroStr = nova;		
	}	
}
