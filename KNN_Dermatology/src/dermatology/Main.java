package dermatology;

import java.io.IOException;

public class Main
{
	//OBS: MATRIZ CONFUSAO = LINHA (RESPOSTA REAL), COLUNA (RESPOSTA CLASSIFICACAO)
	
	public static int TIPO_DISTANCIA = 2; //1 - EUCLIDIANDA 2- MANHATTAN 3- Minkowski
	public static int QTD_ELEMENTOS_TESTE = 10; // QTS ELEMENTOS DE CADA GRUPO VAI PARA TREINAMENTO? SOBRA VAI PRA TESTE
	
	public static GerenciadorMatrizConfusao MATRIZ_CONFUSAO = new GerenciadorMatrizConfusao();
		
	public static void main(String[] args) throws IOException, InterruptedException
	{
		Classificador classificador = new Classificador();
		
		System.out.println("Preparando ambiente...");
		classificador.PrepararAmbiente();
		
		System.out.println("Classificando...");		
		for (Tupla tupla : Classificador.teste)
		{
			classificador.Classificar(tupla);
		}
	
		MATRIZ_CONFUSAO.CriarXLS();		
	}

}
