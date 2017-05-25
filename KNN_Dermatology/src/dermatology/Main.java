package dermatology;

import java.io.IOException;

public class Main
{
	//TOTAL = 358
	public static GerenciadorMatrizConfusao MATRIZ_CONFUSAO = new GerenciadorMatrizConfusao();
	
	public static int TUPLAS_TESTE = 10;
	public static int TUPLAS_TREINAMENTO = 348;
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		Classificador classificador = new Classificador();
		classificador.PrepararAmbiente();
		
		classificador.Classificar(Classificador.teste.get(0));
		
		//MATRIZ_CONFUSAO.ImprimirMatrizes();
		MATRIZ_CONFUSAO.CriarXLS();
	}

}
