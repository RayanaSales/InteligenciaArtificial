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
		
		//matriz[0][0] = "K=" + id;
		
		matriz[1][0] = Integer.toString(Diagnostico.PSORIASIS.getNumVal());
		matriz[0][1] = Integer.toString(Diagnostico.PSORIASIS.getNumVal());
		matriz[2][0] = Integer.toString(Diagnostico.SEBOREIC_DERMATITIS.getNumVal());
		matriz[0][2] = Integer.toString(Diagnostico.SEBOREIC_DERMATITIS.getNumVal());
		matriz[3][0] = Integer.toString(Diagnostico.LICHEN_PLANUS.getNumVal());
		matriz[0][3] = Integer.toString(Diagnostico.LICHEN_PLANUS.getNumVal());
		matriz[4][0] = Integer.toString(Diagnostico.PITYRIASIS_ROSEA.getNumVal());
		matriz[0][4] = Integer.toString(Diagnostico.PITYRIASIS_ROSEA.getNumVal());
		matriz[5][0] = Integer.toString(Diagnostico.CRONIC_DERMATITIS.getNumVal());
		matriz[0][5] = Integer.toString(Diagnostico.CRONIC_DERMATITIS.getNumVal());
		matriz[6][0] = Integer.toString(Diagnostico.PITYRIASIS_RUBRA_PILARIS.getNumVal());
		matriz[0][6] = Integer.toString(Diagnostico.PITYRIASIS_RUBRA_PILARIS.getNumVal());
	}
	
	public void AtualizarMatriz(int respostaReal, int respostaClassificacao)
	{	
		String dataCell = this.matriz[respostaReal][respostaClassificacao];
		
		Integer value = Integer.parseInt(dataCell);
		value++;
		this.matriz[respostaReal][respostaClassificacao] = value.toString();		
	}
}
