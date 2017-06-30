package dermatology;

import java.io.IOException;

public class Main
{
	//OBS: MATRIZ CONFUSAO = LINHA (RESPOSTA REAL), COLUNA (RESPOSTA CLASSIFICACAO)
	
	public static int TIPO_DISTANCIA = 3; //1 - EUCLIDIANDA 2- MANHATTAN 3- Minkowski	
	public static GerenciadorMatrizConfusao MATRIZ_CONFUSAO = new GerenciadorMatrizConfusao();
		
	public static void main(String[] args) throws IOException, InterruptedException
	{
		Classificador classificador = new Classificador();		
		classificador.PrepararAmbiente();
		
		System.out.println("Classificando...");		
		for (Tupla tupla : Classificador.teste)
		{
			classificador.Classificar(tupla);
		}
			
		MATRIZ_CONFUSAO.ImprimirMatrizes();
	}
}
