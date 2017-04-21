package paris;

import java.util.ArrayList;
import java.util.List;

public class Estacao
{
	int id; //numero da estacao	
		
	int percorrido, quantoFalta, heuristica;
	
	List<Linha> linhas = new ArrayList<>();;
	
	Estacao anterior;
	List<Estacao> proximas = new ArrayList<>();;

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
}
