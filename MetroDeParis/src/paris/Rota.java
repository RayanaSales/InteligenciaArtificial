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

			if (atual.id != destino.id)
			{
				Expandir(atual);
				Ordenar();
			}

		} while (atual.id != destino.id);
		
		ImprimeSolucao(atual);
	}

	private void Expandir(Estacao atual)
	{
		for (Estacao proxima : atual.proximas)
		{
			proxima.anterior = atual;
			proxima.percorrido += AJUDA.GetCustoRealEmMinutos(atual.id, proxima.id);
			proxima.quantoFalta = AJUDA.GetCustoLinhaRetaEmMinutos(atual.id, proxima.id);
			proxima.heuristica = proxima.percorrido + proxima.quantoFalta;
		}

		fila.addAll(atual.proximas);
	}

	private void Ordenar()
	{
		Collections.sort(fila, new Comparator<Object>()
		{
			public int compare(Object o1, Object o2)
			{
				Estacao e1 = (Estacao) o1;	
				Estacao e2 = (Estacao) o2;				
				return e1.heuristica < e2.heuristica ? -1 : (e1.heuristica < e2.heuristica ? +1 : 0);
			}
		});
	}
	
	private void ImprimeSolucao(Estacao estacao)
	{
		if(estacao.anterior != null)
		{
			ImprimeSolucao(estacao.anterior);
		}		
		
		System.out.println("E" + estacao.id + " tempo(min) " + estacao.heuristica);
	}
}
