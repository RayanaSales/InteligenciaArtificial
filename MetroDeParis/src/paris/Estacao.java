package paris;

import java.util.ArrayList;
import java.util.List;

public class Estacao
{
	int id; // numero da estacao
	int heuristica;
	
	List<Linha> linhas = new ArrayList<>();
	List<Estacao> proximas = new ArrayList<>();
	
	public Estacao(int id, List<Linha> linhas)
	{
		this.id = id;
		for (Linha linha : linhas)
		{
			this.linhas.add(linha);
		}
	}

	public void AdicionarProximaEstacao(Estacao e)
	{
		this.proximas.add(e);
	}

	@Override
	public boolean equals(Object estacao)
	{
		Estacao e = (Estacao) estacao;
		return e.id == this.id;
	}

	public Linha getLinhasIguais(Estacao estacao)
	{
		Linha linhaIgual = null;
		for (Linha linha : linhas)
		{
			if (estacao.linhas.contains(linha))
			{
				linhaIgual = linha;
				break;
			}
		}
		return linhaIgual;
	}
}
