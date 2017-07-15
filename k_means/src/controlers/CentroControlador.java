package controlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Amostra;
import models.Centro;
import models.Grupo;

public class CentroControlador
{
	private static CentroControlador cc;
	private static List<Centro> centros = new ArrayList<Centro>();
	
	private CentroControlador()
	{
		// TODO Auto-generated constructor stub
	}
	
	public static CentroControlador getCentroControlador()
	{
		if(cc == null)
			cc = new CentroControlador();
		
		return cc;
	}
	
	public void CriarCentro(Grupo grupo)
	{
		Centro c = new Centro(grupo);			
		centros.add(c);
	}
	
	public Centro BuscarCentro(int grupo)
	{
		for (Centro centro : centros)
		{
			if(centro.grupo.tipo == grupo)
			{
				return centro;
			}
		}
		return null;
	}
	
	public List<Centro> getCentros()
	{
		return this.centros;
	}
}
