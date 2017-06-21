package rainhas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

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
	
	public Individuo[] SelecaoNatural()
	{		
		/*
		 * TORNEIO - 250 MORREM
		 * 
		 * */
				
		Random sorteia = new Random();		
		Individuo[] sobreviventes = new Individuo[Main.TAMANHO_POPULACAO / 2];
		List<Integer> sorteados = new ArrayList<Integer>(); //para nao sortear o mesmo elemento duas vezes
				
		for(int a = 0 ; (a < Main.TAMANHO_POPULACAO / 2 ); a++)
		{
			int i = sorteia.nextInt(individuos.length);			
			while(sorteados.contains(i))
			{
				i = sorteia.nextInt(individuos.length);
			}
			sorteados.add(i);
			
			int j = sorteia.nextInt(individuos.length);				
			while(sorteados.contains(j))
			{
				j = sorteia.nextInt(individuos.length);
			}
			sorteados.add(j);
			
			int i_ataques = individuos[i].CalcularAptidao();
			int j_ataques = individuos[j].CalcularAptidao();
			
			sobreviventes[a] = (i_ataques < j_ataques ? individuos[i] : individuos[j]);			
		}
		
		return sobreviventes;
	}

	public Individuo[] Crossover(Individuo[] sobreviventes)
	{	
		/*
		 * GERA 250 NOVOS FILHOS A PARTIR DOS 250 SOBREVIVENTES.
		 * RETORNA A CONCATENACAO DOS SOBREVIVENTES COM OS FILHOS.
		 * 
		 * */
		
		int tamanho_cromossomo = 24;
		int qtd_filhos = Main.TAMANHO_POPULACAO - sobreviventes.length;
		
		Random sorteia = new Random();			
		String[] cromossomo_mascara = new String[tamanho_cromossomo];
		
		Individuo[] filhos = new Individuo[qtd_filhos];
		
		for(int i = 0; i < tamanho_cromossomo; i++)
		{
			cromossomo_mascara[i] = Integer.toString(sorteia.nextInt(2));
		}
		
		for(int i = 0 ; i < sobreviventes.length - 1; i++)
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
			
			filhos[i] = AplicarMutacao(new Individuo(cromossomo_filho));
			filhos[i + 1] = AplicarMutacao(new Individuo(cromossomo_filha));
		}
		
		Individuo[] novaPopulacao = Stream.concat(Arrays.stream(filhos), Arrays.stream(sobreviventes))
                .toArray(Individuo[]::new);
		
		return novaPopulacao;
	}
	
	private Individuo AplicarMutacao(Individuo filho)
	{
		double randon = new Random().nextDouble() * 1;		
		
		if(randon < Main.TAXA_MUTACA0)
		{
			//System.out.println("mutando individuo...");
			
			char[] novoTabuleiroStr = filho.tabuleiroStr.toCharArray();
			Random sorteia = new Random();
			int posicao = sorteia.nextInt(24);
		
			novoTabuleiroStr[posicao] = (filho.tabuleiroStr.charAt(posicao) == '1' ? '0' : '1');
			
			filho.tabuleiroStr = new String(novoTabuleiroStr);		
			return filho;
		}
		
		return filho;
	}
}
