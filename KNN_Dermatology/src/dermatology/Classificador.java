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
	private List<DistanciaEuclidiana> distancias = new ArrayList<DistanciaEuclidiana>();
	private List<Tupla> treinamento = new ArrayList<Tupla>();
	public static List<Tupla> teste = new ArrayList<Tupla>();	

	public void Classificar(Tupla teste) throws IOException
	{
		CalcularDistancias(teste);
		MontarMatrizConfusao(teste.RESPOSTA_REAL);
	}
	
	private void CalcularDistancias(Tupla teste)
	{
		// for each elementoTreinamento in tabela_treinamento
		//		calcule a distancia de teste para elementoTreinamento
		//		guarde o resultado no objeto distância, insira esse obj em uma lista		
		
		for (Tupla tupla : treinamento)
		{
			DistanciaEuclidiana distancia = new DistanciaEuclidiana(tupla, teste);
			distancia.Calcular();
			distancias.add(distancia);
		}
		
		//ordene a lista pela distância
		Collections.sort(distancias, new Comparator<DistanciaEuclidiana>()
		{
			@Override
			public int compare(DistanciaEuclidiana b, DistanciaEuclidiana b1)
			{
				// -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
				return b.resultado > b1.resultado ? -1 : (b.resultado < b1.resultado) ? 1 : 0;
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
			List<DistanciaEuclidiana> proximos = distancias.subList(0, k);
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
		 * 3- coloca esse objeto em uma lista de tuplas 
		 * 4- divide essa lista: sorteia 70 por cento para aprender, e 30 para testar
		 */
		
		BufferedReader in = new BufferedReader(new FileReader("dermatology.data"));
		
		String line;
		int id = 1;
		while((line = in.readLine()) != null)
		{
		    //System.out.println(line);
			String[] dataString = line.split(",");
			int[] data = Arrays.stream(dataString).mapToInt(Integer::parseInt).toArray();
			
			Diagnostico diagnosticoReal = Diagnostico.values()[data[34]];
			
			Tupla tupla = new Tupla(id, data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11], 
					data[12], data[13], data[14], data[15], data[16], data[17], data[18], data[19], data[20], data[21], data[22], data[23], data[24], 
					data[25], data[26], data[27], data[28], data[29], data[30], data[31], data[32], data[33], diagnosticoReal);
			
			treinamento.add(tupla);
			id++;
		}
		in.close();
		
		//sorteia que eh teste e quem eh treinamento		
		Random random = new Random();   
		for(int i = 0 ; i< Main.TUPLAS_TESTE ; i++)
		{			     
            int sorteado = random.nextInt(358); 
            Tupla tupla = BuscarElemento(sorteado, treinamento);
            teste.add(tupla);
            treinamento.remove(tupla);                       
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
	
	private Diagnostico AcharMaisComum(List<DistanciaEuclidiana> proximos)
	{
		List<Popular> populares = new ArrayList<Popular>();
		
		populares.add(new Popular(Diagnostico.PSORIASIS, Collections.frequency(proximos, Diagnostico.PSORIASIS)));
		populares.add(new Popular(Diagnostico.SEBOREIC_DERMATITIS, Collections.frequency(proximos, Diagnostico.SEBOREIC_DERMATITIS)));
		populares.add(new Popular(Diagnostico.LICHEN_PLANUS, Collections.frequency(proximos, Diagnostico.LICHEN_PLANUS)));
		populares.add(new Popular(Diagnostico.PITYRIASIS_ROSEA, Collections.frequency(proximos, Diagnostico.PITYRIASIS_ROSEA)));
		populares.add(new Popular(Diagnostico.CRONIC_DERMATITIS, Collections.frequency(proximos, Diagnostico.CRONIC_DERMATITIS)));
		populares.add(new Popular(Diagnostico.PITYRIASIS_RUBRA_PILARIS, Collections.frequency(proximos, Diagnostico.PITYRIASIS_RUBRA_PILARIS)));
		
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
		
		return populares.get(populares.size() - 1).diagnostico;
	}
}

class Popular 
{
	int popularidade;
	Diagnostico diagnostico;
	
	public Popular(Diagnostico diagnostico, int popularidade)
	{
		this.popularidade = popularidade;
		this.diagnostico = diagnostico;
	}
}
