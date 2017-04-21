package paris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ajuda
{
	private List<Estacao> estacoes = new ArrayList<>();

	private int[][] custoReal_MIN = new int[15][15];
	private int[][] custoLinhaReta_KM = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 11, 20, 27, 40, 43, 39, 28, 18, 10, 18, 30, 30, 32 },
			{ 0, 11, 0, 9, 16, 29, 32, 28, 19, 11, 4, 17, 23, 21, 24 },
			{ 0, 20, 9, 0, 7, 20, 22, 19, 15, 10, 11, 21, 21, 13, 18 },
			{ 0, 27, 16, 7, 0, 13, 16, 12, 13, 13, 18, 26, 21, 11, 17 },
			{ 0, 40, 29, 20, 13, 0, 3, 2, 21, 25, 31, 38, 27, 16, 20 },
			{ 0, 43, 22, 22, 16, 3, 0, 4, 23, 28, 33, 41, 30, 17, 20 },
			{ 0, 39, 28, 19, 12, 2, 4, 0, 22, 25, 29, 38, 28, 13, 17 },
			{ 0, 28, 19, 15, 13, 21, 23, 22, 0, 9, 22, 18, 7, 25, 30 },
			{ 0, 18, 11, 10, 13, 25, 28, 25, 9, 0, 13, 12, 12, 23, 28 },
			{ 0, 10, 4, 11, 18, 31, 33, 29, 22, 13, 0, 20, 27, 20, 23 },
			{ 0, 18, 17, 21, 26, 38, 41, 38, 18, 12, 20, 0, 15, 35, 39 },
			{ 0, 30, 23, 21, 21, 27, 30, 28, 7, 12, 27, 15, 0, 31, 37 },
			{ 0, 30, 21, 13, 11, 16, 17, 13, 25, 23, 20, 35, 31, 0, 5 },
			{ 0, 32, 24, 18, 17, 20, 20, 17, 30, 28, 23, 39, 37, 5, 0 } };

	public Ajuda()
	{
		CriarEstacoes();
		PopularCustoReal();
	}

	// INICIALIZADORES

	private void CriarEstacoes()
	{
		// criando estacoes
		estacoes.add(null);
		estacoes.add(new Estacao(1, new ArrayList<Linha>(Arrays.asList(Linha.AMARELA))));
		estacoes.add(new Estacao(2, new ArrayList<Linha>(Arrays.asList(Linha.AMARELA, Linha.AZUL))));
		estacoes.add(new Estacao(3, new ArrayList<Linha>(Arrays.asList(Linha.VERMELHA, Linha.AZUL))));
		estacoes.add(new Estacao(4, new ArrayList<Linha>(Arrays.asList(Linha.VERDE, Linha.AZUL))));
		estacoes.add(new Estacao(5, new ArrayList<Linha>(Arrays.asList(Linha.AMARELA, Linha.AZUL))));
		estacoes.add(new Estacao(6, new ArrayList<Linha>(Arrays.asList(Linha.AZUL))));
		estacoes.add(new Estacao(7, new ArrayList<Linha>(Arrays.asList(Linha.AMARELA))));
		estacoes.add(new Estacao(8, new ArrayList<Linha>(Arrays.asList(Linha.VERDE, Linha.AMARELA))));
		estacoes.add(new Estacao(9, new ArrayList<Linha>(Arrays.asList(Linha.VERMELHA, Linha.AMARELA))));
		estacoes.add(new Estacao(10, new ArrayList<Linha>(Arrays.asList(Linha.AMARELA))));
		estacoes.add(new Estacao(11, new ArrayList<Linha>(Arrays.asList(Linha.VERMELHA))));
		estacoes.add(new Estacao(12, new ArrayList<Linha>(Arrays.asList(Linha.VERDE))));
		estacoes.add(new Estacao(13, new ArrayList<Linha>(Arrays.asList(Linha.VERDE, Linha.VERMELHA))));
		estacoes.add(new Estacao(14, new ArrayList<Linha>(Arrays.asList(Linha.VERDE))));

		// relaciona
		estacoes.get(1).AdicionarProximaEstacao(estacoes.get(2));

		estacoes.get(2).AdicionarProximaEstacao(estacoes.get(3));
		estacoes.get(2).AdicionarProximaEstacao(estacoes.get(9));
		estacoes.get(2).AdicionarProximaEstacao(estacoes.get(10));

		estacoes.get(3).AdicionarProximaEstacao(estacoes.get(4));
		estacoes.get(3).AdicionarProximaEstacao(estacoes.get(9));
		estacoes.get(3).AdicionarProximaEstacao(estacoes.get(13));

		estacoes.get(4).AdicionarProximaEstacao(estacoes.get(5));
		estacoes.get(4).AdicionarProximaEstacao(estacoes.get(8));
		estacoes.get(4).AdicionarProximaEstacao(estacoes.get(13));

		estacoes.get(5).AdicionarProximaEstacao(estacoes.get(6));
		estacoes.get(5).AdicionarProximaEstacao(estacoes.get(7));
		estacoes.get(5).AdicionarProximaEstacao(estacoes.get(8));

		estacoes.get(8).AdicionarProximaEstacao(estacoes.get(9));
		estacoes.get(8).AdicionarProximaEstacao(estacoes.get(12));

		estacoes.get(9).AdicionarProximaEstacao(estacoes.get(11));

		estacoes.get(13).AdicionarProximaEstacao(estacoes.get(14));
	}

	private void PopularCustoReal()
	{
		// e1 -> e2 = 22 min
		custoReal_MIN[1][2] = 22;

		// e2 -> e3 = 18 min
		custoReal_MIN[2][3] = 18;

		// e2 -> e9 = 22 min
		custoReal_MIN[2][9] = 22;

		// e2 -> e10 = 8 min
		custoReal_MIN[2][10] = 8;

		// e3 -> e4 = 14 min
		custoReal_MIN[3][4] = 14;

		// e3 -> e9 = 20 min
		custoReal_MIN[3][9] = 20;

		// e3 -> e13 = 38 min
		custoReal_MIN[3][13] = 38;

		// e4 -> e5 = 28 min
		custoReal_MIN[4][5] = 28;

		// e4 -> e8 = 32 min
		custoReal_MIN[4][8] = 32;

		// e4 -> e13 = 24 min
		custoReal_MIN[4][13] = 24;

		// e5 -> e6 = 6 min
		custoReal_MIN[5][6] = 6;

		// e5 -> e7 = 4 min
		custoReal_MIN[5][7] = 4;

		// e5 -> e8 = 66 min
		custoReal_MIN[5][8] = 66;

		// e8 -> e9 = 20 min
		custoReal_MIN[8][9] = 20;

		// e8 -> e12 = 14 min
		custoReal_MIN[8][12] = 14;

		// e9 -> e11 = 28 min
		custoReal_MIN[9][11] = 28;

		// e13 -> e14 = 10 min
		custoReal_MIN[13][14] = 10;
	}

	// GETS
	public Estacao GetEstacao(int numero)
	{
		return this.estacoes.get(numero);
	}

	public int GetCustoLinhaRetaEmMinutos(Estacao estacaoAtual, Estacao estacaoDestino)
	{
		int linhaRetaKm = custoLinhaReta_KM[estacaoAtual.id][estacaoDestino.id];		
		 return (60 * linhaRetaKm) / 30;
	}

	public int GetCustoRealEmMinutos(Estacao atual, Estacao proximo)
	{
		int custo = 0;

		if (atual != null)
		{
			custo = custoReal_MIN[atual.id][proximo.id];
		}

		return custo;
	}

}
