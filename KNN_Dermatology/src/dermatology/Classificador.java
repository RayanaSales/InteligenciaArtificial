package dermatology;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Classificador
{
	private List<Distancia> distancias = new ArrayList<Distancia>();
	public static List<Tupla> treinamento = new ArrayList<Tupla>();
	public static List<Tupla> teste = new ArrayList<Tupla>();	

	public void Classificar(Tupla teste) throws IOException, InterruptedException
	{
		CalcularDistancias(teste);
		MontarMatrizConfusao(teste.RESPOSTA_REAL);
	}
	
	private void CalcularDistancias(Tupla teste) throws InterruptedException
	{
		// for each elementoTreinamento in tabela_treinamento
		//		calcule a distancia de teste para elementoTreinamento
		//		guarde o distancia no objeto distância, insira esse obj em uma lista	
				
		for (Tupla tupla : treinamento)
		{		
			Distancia distancia = null;
			
			if(Main.TIPO_DISTANCIA == 1)
			{
				distancia = new DistanciaEuclidiana(tupla, teste);
			}
			else if(Main.TIPO_DISTANCIA == 2)
			{
				distancia = new DistanciaManhattan(tupla, teste);
			}						
			distancias.add(distancia);
		}
		
		//ordene a lista pela distância
		Collections.sort(distancias, new Comparator<Distancia>()
		{
			@Override
			public int compare(Distancia b, Distancia b1)
			{
				// -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
				return b1.distancia > b.distancia ? -1 : (b1.distancia < b.distancia) ? 1 : 0;
			}
		});
	}
	
	private void MontarMatrizConfusao(Diagnostico RESPOSTA_REAL)
	{
		// for (int k= 1; k <= 11 ; k = k + 2)
		//		var primeiros = k primeiros elementos da lista de distancias
		//		qual a doença mais comum entre os k primeiros? (resposta_classific)
		//		pegue no banco, a resposta_correta de Ti
		//		compare os resultados e atualize o objeto matrizConfusao onde id = k
						
		for (int k= 1; k <= 11 ; k = k + 2)
		{
			if(k < distancias.size())
			{
				List<Distancia> proximos = distancias.subList(0, k);
				Diagnostico resultadoClassificacao = AcharMaisComum(proximos);
				Main.MATRIZ_CONFUSAO.InserirResultado(k, RESPOSTA_REAL.getNumVal(), resultadoClassificacao.getNumVal());
			}
			else
			{
				break;
			}
		}
	}
		
	public void PrepararAmbiente() throws IOException
	{
		/*
		 * PREPARANDO O AMBIENTE 
		 * 1- ler cada linha do arquivo 
		 * 2- cria um objeto tupla com os dados da linha lida 
		 * 3- coloca esse objeto em uma lista de tuplas 
		 * 4- divide essa lista: sorteia 70 por cento para aprender, e 30 para testar
		 */
		Random random = new Random();
		
		int QTD_ELEMENTOS_PARA_TESTE = Math.round((treinamento.size() * Main.TESTE_PORCENTAGEM) / 100);		 
		int sorteado = random.nextInt(Main.QTD_ELEMENTOS_DISPONIVEIS);		
		List<Integer> sorteados = new ArrayList<>();
				
		BufferedReader in = new BufferedReader(new FileReader("dermatology.data"));		
		String line;
		int id = 1;
		Tupla tupla = null;
		int[] data = null;
		
			while((line = in.readLine()) != null)
			{
				String[] dataString = line.split(",");
				data = Arrays.stream(dataString).mapToInt(Integer::parseInt).toArray();
				
				Diagnostico diagnosticoReal = Diagnostico.values()[data[34] - 1]; //pq os elementos do diagnostico vao de 0 a 5. Mas no arquivo esta de 1 a 6
				
				tupla = new Tupla(id, data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11], 
						data[12], data[13], data[14], data[15], data[16], data[17], data[18], data[19], data[20], data[21], data[22], data[23], data[24], 
						data[25], data[26], data[27], data[28], data[29], data[30], data[31], data[32], data[33], diagnosticoReal);
				
				treinamento.add(tupla);
				id++;
			}
		in.close();
		
		
		//sorteia que eh teste e quem eh treinamento	
		QTD_ELEMENTOS_PARA_TESTE = Math.round((treinamento.size() * Main.TESTE_PORCENTAGEM) / 100);
				
		for(int i = 0 ; i< QTD_ELEMENTOS_PARA_TESTE ; i++)
		{		
			while(sorteados.contains(sorteado)) //sortei numeros diferentes dos ja sorteados
			{
				sorteado = random.nextInt(Main.QTD_ELEMENTOS_DISPONIVEIS); 				
			} 
			
			sorteados.add(sorteado);                 
            tupla = BuscarElemento(sorteado, treinamento);
            teste.add(tupla);
            treinamento.remove(tupla); 
            sorteado = random.nextInt(Main.QTD_ELEMENTOS_DISPONIVEIS);
		}		
	}
	
	private Tupla BuscarElemento(int id, List<Tupla> dataset)
	{
		for (Tupla tupla : dataset)
		{
			if(tupla.id == id)
			{
				return tupla;
			}
		}
		return null;
	}
	
	private Diagnostico AcharMaisComum(List<Distancia> proximos)
	{
		long popularidade = 0;		
		List<Popular> populares = new ArrayList<Popular>();
		
		for (Diagnostico d : Diagnostico.values())
		{
			popularidade = proximos.stream()
					        .filter(p -> p.teste.RESPOSTA_REAL.equals(d))
					        .count();	
			if(popularidade != 0)
			{
				populares.add(new Popular(d, popularidade));	
			}
		}		
				
		//ordene a lista pela popularidade
		Collections.sort(populares, new Comparator<Popular>()
		{
			@Override
			public int compare(Popular b, Popular b1)
			{
				// -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
				return b.popularidade > b1.popularidade ? -1 : (b.popularidade < b1.popularidade) ? 1 : 0;
			}
		});
		
		return populares.get(0).diagnostico;
	}
}

class Popular 
{
	long popularidade;
	Diagnostico diagnostico;
	
	public Popular(Diagnostico diagnostico, long popularidade)
	{
		this.popularidade = popularidade;
		this.diagnostico = diagnostico;
	}
}
