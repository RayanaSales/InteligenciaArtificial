package dermatology;

public class MatrizConfusao
{
	int id;	
	String[][] matriz = new String[7][7];
	
	public MatrizConfusao(int id)
	{
		this.id = id;	
		
		for (int i = 0; i < matriz.length; i++)
		{
			for (int j = 0; j < matriz.length; j++)
			{
				matriz[i][j] = "0";
			}
		}
		
		matriz[0][0] = "K = " + id;
		
		matriz[1][0] = Diagnostico.PSORIASIS.name();
		matriz[0][1] = Diagnostico.PSORIASIS.name();	
		matriz[2][0] = Diagnostico.SEBOREIC_DERMATITIS.name();
		matriz[0][2] = Diagnostico.SEBOREIC_DERMATITIS.name();
		matriz[3][0] = Diagnostico.LICHEN_PLANUS.name();
		matriz[0][3] = Diagnostico.LICHEN_PLANUS.name();
		matriz[4][0] = Diagnostico.PITYRIASIS_ROSEA.name();
		matriz[0][4] = Diagnostico.PITYRIASIS_ROSEA.name();
		matriz[5][0] = Diagnostico.CRONIC_DERMATITIS.name();
		matriz[0][5] = Diagnostico.CRONIC_DERMATITIS.name();
		matriz[6][0] = Diagnostico.PITYRIASIS_RUBRA_PILARIS.name();
		matriz[0][6] = Diagnostico.PITYRIASIS_RUBRA_PILARIS.name();
	}
	
	public void AtualizarMatriz(int respostaReal, int respostaClassificacao)
	{	
		String dataCell = this.matriz[respostaReal][respostaClassificacao];
		
		Integer value = Integer.parseInt(dataCell);
		value++;
		this.matriz[respostaReal][respostaClassificacao] = value.toString();		
	}
}
