package dermatology;

import java.io.IOException;
import java.util.Objects;

public class Main
{
	//TOTAL = 358
	public static GerenciadorMatrizConfusao MATRIZ_CONFUSAO = new GerenciadorMatrizConfusao();
	
	public static int QTD_ELEMENTOS_DISPONIVEIS = 344;
	public static int TESTE_PORCENTAGEM = 30;
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		Classificador classificador = new Classificador();
		
		System.out.println("Preparando ambiente...");
		classificador.PrepararAmbiente();
		
		System.out.println("Classificando...");
		
		Classificador.teste.removeIf(Objects::isNull);
		for (Tupla tupla : Classificador.teste)
		{
			if(tupla != null) //WORK AROUND
			{
				classificador.Classificar(tupla);
			}
		}
	
		MATRIZ_CONFUSAO.CriarXLS();
	}

}
