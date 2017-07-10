package kmeans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main
{
	public static void main(String[] args)
	{
		PrepararAmbiente();
		Classificador.Classificar();
		Classificador.Imprimir();
	}

	public static void PrepararAmbiente()
	{
		String line;
		int id = 1;
		Amostra amostra = null;
		double[] data = null;

		try
		{
			BufferedReader in = new BufferedReader(new FileReader("kmeans.data"));
			while ((line = in.readLine()) != null)
			{				
				String[] dataString = line.split(";");
				data = Arrays.stream(dataString).mapToDouble(Double::parseDouble).toArray();
				
				int grupoReal = (int) data[2];				
				amostra = new Amostra(id, data[0], data[1], (grupoReal == 1 ? Classificador.grupo1 : Classificador.grupo2));
				
				//SORTEIA O GRUPO DA AMOSTRA
				int valor_grupo = new Random().nextInt(3);
				if(valor_grupo == 1)
				{
					Classificador.grupo1.amostras.add(amostra);
				}
				else
				{
					Classificador.grupo2.amostras.add(amostra);
				}				
				id++;
			}
			in.close();
		}
		catch (IOException e)
		{
			System.out.println("Deu merda lendo o arquivo =(");
		}		
	}
}
