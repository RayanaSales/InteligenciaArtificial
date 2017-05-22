package dermatology;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
		Predicate<MatrizConfusao> predicate = c-> c.id == id;
		MatrizConfusao obj = this.matrizes.stream().filter(predicate).findFirst().get();
		return obj;
	}
	
	public void ImprimirMatrizes()
	{
		/* parei aqui */
	}
}
