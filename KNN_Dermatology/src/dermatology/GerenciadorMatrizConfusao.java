package dermatology;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorMatrizConfusao
{
	private List<MatrizConfusao> matrizes = new ArrayList<MatrizConfusao>();

	public GerenciadorMatrizConfusao()
	{
		for (int i = 1; i <= 11; i = i + 2)
		{
			MatrizConfusao matriz = new MatrizConfusao(i);
			matrizes.add(matriz);
		}
	}

	public void InserirResultado(int id, int respostaReal, int respostaClassificacao)
	{
		buscarMatriz(id).AtualizarMatriz(respostaReal, respostaClassificacao);
	}

	private MatrizConfusao buscarMatriz(int id)
	{
		MatrizConfusao obj = null;

		for (MatrizConfusao matrizConfusao : matrizes)
		{
			if (matrizConfusao.id == id)
			{
				obj = matrizConfusao;
			}
		}

		return obj;
	}

	public void ImprimirMatrizes()
	{
		for (MatrizConfusao matriz : matrizes)
		{
			System.out.println("Para k = " + matriz.id);
			for (int i = 0; i < 7; i++)
			{
				for (int j = 0; j < 7; j++)
				{
					if(Integer.parseInt(matriz.matriz[i][j]) < 10) //se tiver um digito, completa com 0 a esquerda
					{
						matriz.matriz[i][j] = "0" + matriz.matriz[i][j];
					}
					System.out.print(" | " + matriz.matriz[i][j] + " | ");
				}
				System.out.println();
			}	
			
		}
	}
}
