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
			// Percorrido é o custo real ate o atual, heurística eh a distância em linha reta até o objetivo

			proxima.anterior = atual;
			proxima.percorrido = atual.percorrido + AJUDA.GetCustoRealEmMinutos(atual, proxima);
			proxima.heuristica = AJUDA.GetCustoLinhaRetaEmMinutos(proxima, destino);

			// poda do pai
			if (proxima.id != proxima.anterior.id)
			{
				fila.add(proxima);
			}
		}
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
