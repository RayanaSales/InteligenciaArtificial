package dermatology;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

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
	
	public void CriarXLS()
	{ /*
		 * https://sourceforge.net/projects/jexcelapi/files/jexcelapi/2.6.12/
		 * https://jmmwrite.wordpress.com/2011/02/09/gerar-xls-planilha-excell-com-java/
		 */

		int i = 0, j = 0;
		try
		{
			for (MatrizConfusao matriz : matrizes)
			{
				WritableWorkbook workbook = Workbook.createWorkbook(new File("RESULTADO_K" + matriz.id + ".xls"));
				WritableSheet sheet = workbook.createSheet("k = " + matriz.id, 0);

				System.out.println("Imprimindo matriz " + matriz.id + " no arquivo: RESULTADO_K" + matriz.id + ".xls" );
				for (i = 0; i < 7; i++)
				{
					for (j = 0; j < 7; j++)
					{
						Label label = new Label(i, j, matriz.matriz[i][j]);
						sheet.addCell(label);
					}
				}
				workbook.write();
				workbook.close();
				System.out.println();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (RowsExceededException e)
		{
			e.printStackTrace();
		}
		catch (WriteException e)
		{
			e.printStackTrace();
		}

		System.out.println("Verifique o diretorio git\\InteligenciaArtificial\\KNN_Dermatology...");
	}
}
