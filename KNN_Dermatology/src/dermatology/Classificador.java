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
		//		guarde o distancia no objeto dist�ncia, insira esse obj em uma lista	
				
		for (Tupla tupla : treinamento)
		{		
			Distancia distancia = null;			
			
			switch (Main.TIPO_DISTANCIA)
			{
				case 1:
					distancia = new DistanciaEuclidiana(tupla, teste);
				break;
				case 2:
					distancia = new DistanciaManhattan(tupla, teste);
				break;
				case 3:
					distancia = new DistanciaMinkowski(tupla, teste);
				break;
			}
			
			distancias.add(distancia);
		}
		
		//ordene a lista pela dist�ncia
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
		//		qual a doen�a mais comum entre os k primeiros? (resposta_classific)
		//		pegue no banco, a resposta_correta de Ti
		//		compare os resultados e atualize o objeto matrizConfusao onde id = k
						
		for (int k= 1; k <= 11 ; k = k + 2)
		{
			List<Distancia> proximos = distancias.subList(0, k);
			Diagnostico resultadoClassificacao = AcharMaisComum(proximos);
			Main.MATRIZ_CONFUSAO.InserirResultado(k, RESPOSTA_REAL.getNumVal(), resultadoClassificacao.getNumVal());
		}
	}
		
	public void PrepararAmbiente() throws IOException
	{
		/*
		 * PREPARANDO O AMBIENTE 
		 * 1- ler cada linha do arquivo 
		 * 2- cria um objeto tupla com os dados da linha lida 
		 * 3- coloca esse objeto em uma lista de tuplas (treinamento)
		 * 4- separa quem eh teste e quem eh treinamento
		 */
		
		// LENDO ARQUIVO
				
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
		
		// SEPARANDO TESTE DE TREINAMENTO	
		
		Collections.sort(treinamento, new Comparator<Tupla>()
		{
			@Override
			public int compare(Tupla b, Tupla b1)
			{
				// -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
				return b1.RESPOSTA_REAL.getNumVal() > b.RESPOSTA_REAL.getNumVal() ? -1 : (b1.RESPOSTA_REAL.getNumVal() < b.RESPOSTA_REAL.getNumVal()) ? 1 : 0;
			}
		});
			
		/*
		 * 1- separo cada grupo em listas
		 * 2- os 10 primeiros elementos de cada lista, fica em treinamento, o resto vai para teste
		 */
		
		// adicionando os restos em teste
		AdicionarElementosAoTeste(new ArrayList<Tupla>(treinamento.subList(0, 111))); //GRUPO 1
		AdicionarElementosAoTeste(new ArrayList<Tupla>(treinamento.subList(111, 171))); //GRUPO 2
		AdicionarElementosAoTeste(new ArrayList<Tupla>(treinamento.subList(171, 242))); //GRUPO 3
		AdicionarElementosAoTeste(new ArrayList<Tupla>(treinamento.subList(242, 290))); //GRUPO 4
		AdicionarElementosAoTeste(new ArrayList<Tupla>(treinamento.subList(290, 338))); //GRUPO 5
		AdicionarElementosAoTeste(new ArrayList<Tupla>(treinamento.subList(338, 358))); //GRUPO 6
		
		// removendo de treinamento, todo mundo que eh de teste
		for (Tupla tupla2 : teste)
		{
			treinamento.remove(tupla2);
		}		
		Collections.shuffle(treinamento);
	}
		
	private void AdicionarElementosAoTeste(List<Tupla> grupo)
	{
		teste.addAll(grupo.subList(Main.QTD_ELEMENTOS_TESTE, grupo.size()));
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
