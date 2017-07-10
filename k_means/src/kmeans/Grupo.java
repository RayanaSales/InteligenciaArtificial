package kmeans;

import java.util.ArrayList;
import java.util.List;

public class Grupo
{
	double mediaAtributo1, mediaAtributo2;	
	public GrupoTipo grupoTipo; 
	
	public List<Amostra> amostras;
	
	public Grupo(GrupoTipo tipo)
	{
		grupoTipo = tipo;
		amostras = new ArrayList<Amostra>();
	}
}
