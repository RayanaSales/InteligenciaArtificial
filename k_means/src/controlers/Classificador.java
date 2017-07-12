package controlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import models.Amostra;
import models.Centro;
import models.Distancia;

public class Classificador
{
	private static Classificador c;
	
	private Classificador()
	{
		// TODO Auto-generated constructor stub
	}
	
	public static Classificador getClassificador()
	{
		if(c == null)
		{
			c = new Classificador();
		}
		return c;
	}
	
	public static void Classificar()
	{
		boolean houveTroca = true;
		int trocas = 0;
		
		while(houveTroca && trocas < 100)
		{
			houveTroca = ReajustarGrupos();
			trocas++;
		}
		
		//atualiza grupo.amostras para impressao
		for (Amostra amostra : Main.amostras)
		{
			amostra.Grupo_Classificacao.amostras.add(amostra);
		}
		GrupoControlador.getGrupoControlador().Imprimir();
	}
	
	public static void CalcularCentros()
	{	
		//somatorio
		for (Amostra amostra : Main.amostras)
		{
			GrupoControlador.getGrupoControlador().AtualizarSomatorio(amostra.Grupo_Classificacao.tipo, amostra.Atributo1, amostra.Atributo2);				
		}
		//divide pela qtd de cada elementos nos grupos
		GrupoControlador.getGrupoControlador().FinalizarCalculoCentros();
	}
	
	public static Distancia CalcularDistancia(Amostra amostra, int grupoTipo)
	{
		Distancia d = new Distancia(amostra, grupoTipo);
		
		Centro centroGrupo = CentroControlador.getCentroControlador().BuscarCentro(grupoTipo);		
		d.distancia = Math.abs(centroGrupo.valor1 - amostra.Atributo1) + Math.abs(centroGrupo.valor2 - amostra.Atributo2);
	
		return d;
	}
	
	public static boolean ReajustarGrupos()
	{		
		boolean houveTroca = true;	
		List<Distancia> distancias;
		
		for (Amostra amostra : Main.amostras)
		{
			distancias = new ArrayList<Distancia>();
			
			//calcule a distancia dela, para todos os outros grupos
			for (int g = 1; g <= Main.k; g++)
			{
				distancias.add(CalcularDistancia(amostra, g));
			}
			
			//ordene a lista pela distancia
			Collections.sort(distancias, new Comparator<Distancia>()
			{
				@Override
				public int compare(Distancia b, Distancia b1)
				{
					// -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
					return b1.distancia > b.distancia ? -1 : (b1.distancia < b.distancia) ? 1 : 0;
				}
			});
			
			//se precisar se mover, mova-se
			if(distancias.get(0).grupoTipo != amostra.Grupo_Classificacao.tipo)
			{
				amostra.IrParaGrupo(distancias.get(0).grupoTipo);	
			}	
		}
		
		CalcularCentros();		
		return houveTroca;
	}	
}
