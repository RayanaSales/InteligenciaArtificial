package controlers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import models.Amostra;

public class Main
{
	public static int k = 5;
	public static List<Amostra> amostras = new ArrayList<Amostra>();
	
	public static void main(String[] args)
	{
		PrepararAmbiente();
		Classificador.Classificar();
	}

	public static void PrepararAmbiente()
	{
		//le arquivo
		String line;
		int id = 1;
		Amostra amostra = null;
		double[] data = null;	
		
		//criar grupos
		GrupoControlador.getGrupoControlador().CriarGrupos(k);
				
		try
		{
			BufferedReader in = new BufferedReader(new FileReader("kmeans.data"));
			while ((line = in.readLine()) != null)
			{				
				String[] dataString = line.split(";");
				data = Arrays.stream(dataString).mapToDouble(Double::parseDouble).toArray();
				
				int grupoReal = (int) data[2];	
				
				int grupoClassificacao = new Random().nextInt(Main.k + 1);				
				while(grupoClassificacao == 0)
				{
					grupoClassificacao = new Random().nextInt(Main.k + 1);
				}
				
				amostra = new Amostra(id++, data[0], data[1], grupoReal, grupoClassificacao);
				Main.amostras.add(amostra);	
			}
			in.close();
			Classificador.getClassificador().CalcularCentros();			
		}
		catch (IOException e)
		{
			System.out.println("Deu merda lendo o arquivo =(");
		}		
	}
}
