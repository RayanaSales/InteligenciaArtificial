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
	
	public static void GerarCentrosAleatorios()
	{
//		double maiorAtributo1 = 0.0;
//		double maiorAtributo2 = 0.0;
//		for (Amostra amostra : Main.amostras)
//		{
//			if(amostra.Atributo1 > maiorAtributo1)
//			{
//				maiorAtributo1 = amostra.Atributo1;
//			}
//			if(amostra.Atributo2 > maiorAtributo2)
//			{
//				maiorAtributo2 = amostra.Atributo2;
//			}
//		}
//		
//		int qtdGrupos = Main.k;
//		for (Centro centro : centros)
//		{
//			centro.valor1 = 0 + (maiorAtributo1 - 0) * new Random().nextDouble();
//			centro.valor2 = 0 + (maiorAtributo2 - 0) * new Random().nextDouble();
//			
//			centro.grupo = GrupoControlador.getGrupoControlador().BuscarGrupo(qtdGrupos--);
//		}
		
		int qtdGrupos = Main.k;
		for (Centro centro : centros)
		{
			int amostra = new Random().nextInt(Main.amostras.size());
			
			centro.valor1 = Main.amostras.get(amostra).Atributo1;
			centro.valor2 = Main.amostras.get(amostra).Atributo2;	
			
			centro.grupo = GrupoControlador.getGrupoControlador().BuscarGrupo(qtdGrupos--);
		}
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
