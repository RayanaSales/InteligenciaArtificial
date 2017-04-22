package paris;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Rota
{
	public final Ajuda AJUDA = new Ajuda();
	List<No> fila = new ArrayList<>();

	public void Buscar(Estacao estacaoAtual, Estacao estacaoDestino)
	{
		No atual = new No(estacaoAtual);
		fila.add(atual);

		do
		{
			atual = fila.remove(0);
			Expandir(atual, estacaoDestino);
			Ordenar();

		} while (atual.estacao.id != estacaoDestino.id);

		ImprimeSolucao(atual);
	}

	private void Expandir(No atual, Estacao destino)
	{
		for (Estacao proxima : atual.estacao.proximas)
		{
			if (atual.anterior == null || proxima.id != atual.anterior.estacao.id)
			{
				No no = new No(proxima);

				no.anterior = atual;
				no.percorrido = atual.percorrido + AJUDA.GetCustoRealEmMinutos(atual.estacao, proxima);
				no.percorrido += TrocarLinha(no);

				proxima.heuristica = AJUDA.GetCustoLinhaRetaEmMinutos(proxima, destino);

				fila.add(no);
			}
		}
	}

	private int TrocarLinha(No no)
	{
		int custo = 0;

		if (no.anterior != null && no.anterior.anterior != null)
		{
			Linha linha = no.anterior.estacao.getLinhasIguais(no.anterior.anterior.estacao);
			if (!no.estacao.linhas.contains(linha))
			{
				custo = 5;
			}
		}
		return custo;
	}

	private void Ordenar()
	{
		Collections.sort(fila, new Comparator<Object>()
		{
			public int compare(Object o1, Object o2)
			{
				No e1 = (No) o1;
				No e2 = (No) o2;
				int custo1 = e1.percorrido + e1.estacao.heuristica;
				int custo2 = e2.percorrido + e2.estacao.heuristica;
				return custo1 < custo2 ? -1 : (custo1 < custo2 ? +1 : 0);
			}
		});
	}

	private void ImprimeSolucao(No no)
	{
		if (no.anterior != null)
		{
			ImprimeSolucao(no.anterior);
		}

		System.out.println("E" + no.estacao.id + " tempo (minutos): " + no.percorrido);
	}
}
