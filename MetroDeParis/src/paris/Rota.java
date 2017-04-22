package paris;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Rota
{
	public final Ajuda AJUDA = new Ajuda();
	List<Estacao> fila = new ArrayList<>();

	public void Buscar(Estacao atual, Estacao destino)
	{
		fila.add(atual);

		do
		{
			atual = fila.remove(0);
			Expandir(atual, destino);
			Ordenar();

		} while (atual.id != destino.id);

		ImprimeSolucao(atual);
	}

	private void Expandir(Estacao atual, Estacao destino)
	{
		for (Estacao proxima : atual.proximas)
		{
			if (atual.anterior == null || proxima.id != atual.anterior.id)
			{
				proxima.anterior = atual;	
				proxima.percorrido = atual.percorrido + AJUDA.GetCustoRealEmMinutos(atual, proxima);
				proxima.heuristica = AJUDA.GetCustoLinhaRetaEmMinutos(proxima, destino);

				proxima.percorrido += TrocarLinha(proxima);

				fila.add(proxima);
			}
		}
	}

	private int TrocarLinha(Estacao proxima)
	{
		int custo = 0;

		if (proxima.anterior != null && proxima.anterior.anterior != null)
		{
			Linha linha = proxima.anterior.getLinhasIguais(proxima.anterior.anterior);
			if (!proxima.linhas.contains(linha))
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
				Estacao e1 = (Estacao) o1;
				Estacao e2 = (Estacao) o2;
				int custo1 = e1.percorrido + e1.heuristica;
				int custo2 = e2.percorrido + e2.heuristica;
				return custo1 < custo2 ? -1 : (custo1 < custo2 ? +1 : 0);
			}
		});
	}

	private void ImprimeSolucao(Estacao estacao)
	{
		if (estacao.anterior != null)
		{
			ImprimeSolucao(estacao.anterior);
		}

		System.out.println("E" + estacao.id + " tempo (minutos): " + estacao.percorrido);
	}
}
