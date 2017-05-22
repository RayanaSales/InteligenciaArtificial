package dermatology;

public class MatrizConfusao
{
	int id;	
	int[][] matriz = new int[7][7];
	
	public MatrizConfusao(int id)
	{
		this.id = id;		
	}
	
	public void AtualizarMatriz(int respostaReal, int respostaClassificacao)
	{
		this.matriz[respostaReal][respostaClassificacao] = this.matriz[respostaReal][respostaClassificacao] + 1;
	}
}
