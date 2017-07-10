package kmeans;

import java.util.ArrayList;
import java.util.List;

public class Classificador
{
	public static Grupo grupo1 = new Grupo(GrupoTipo.TIPO_1);
	public static Grupo grupo2 = new Grupo(GrupoTipo.TIPO_2);
	
	public static void CalcularCentros()
	{
		/*
		 * Calcula media dos atributos 1 e 2
		 * */
		
		//para o grupos 1	
		double somaAtributo1 = 0, somaAtributo2 = 0;
		for (Amostra amostra : grupo1.amostras)
		{
			somaAtributo1 += amostra.Atributo1;
			somaAtributo2 += amostra.Atributo2;
		}
		grupo1.mediaAtributo1 = somaAtributo1 / grupo1.amostras.size();
		grupo1.mediaAtributo2 = somaAtributo2 / grupo1.amostras.size();
		
		//para o grupos 2
		somaAtributo1 = 0; 
		somaAtributo2 = 0;
		for (Amostra amostra : grupo2.amostras)
		{
			somaAtributo1 += amostra.Atributo1;
			somaAtributo2 += amostra.Atributo2;
		}
		grupo2.mediaAtributo1 = somaAtributo1 / grupo2.amostras.size();
		grupo2.mediaAtributo2 = somaAtributo2 / grupo2.amostras.size();
	}
	
	public static double CalcularDistancia(Amostra amostra, Grupo grupo)
	{
		return Math.abs(grupo.mediaAtributo1 - amostra.Atributo1) + Math.abs(grupo.mediaAtributo2 - amostra.Atributo2);
	}
	
	public static boolean ReajustarGrupos()
	{		
		boolean houveTroca = true;
		
		CalcularCentros();
		
		//grupo 1
		List<Amostra> moverDeG1ParaG2 = new ArrayList<Amostra>();
		for (Amostra amostra : grupo1.amostras)
		{
			double dist_grupo1 = CalcularDistancia(amostra, grupo1);
			double dist_grupo2 = CalcularDistancia(amostra, grupo2);
			
			if(dist_grupo2 < dist_grupo1) //se o outro grupo estiver mais perto, troque
			{
				moverDeG1ParaG2.add(amostra);
			}			
		}
		
		//grupo 2
		List<Amostra> moverDeG2ParaG1 = new ArrayList<Amostra>();
		for (Amostra amostra : grupo2.amostras)
		{
			double dist_grupo1 = CalcularDistancia(amostra, grupo1);
			double dist_grupo2 = CalcularDistancia(amostra, grupo2);
			
			if(dist_grupo1 < dist_grupo2) //se o outro grupo estiver mais perto, troque
			{
				moverDeG2ParaG1.add(amostra);
			}			
		}
		
		//trocas
		for (Amostra amostra : moverDeG1ParaG2)
		{
			grupo1.amostras.remove(amostra);
			grupo2.amostras.add(amostra);
		}		
		for (Amostra amostra : moverDeG2ParaG1)
		{
			grupo2.amostras.remove(amostra);
			grupo1.amostras.add(amostra);
		}
		
		if(moverDeG1ParaG2.size() == 0 && moverDeG2ParaG1.size() == 0)
		{
			houveTroca = false;
		}
		
		return houveTroca;
	}
	
	public static void Classificar()
	{
		boolean houveTroca = true;
		int reajustes = 0;
		
		while(houveTroca)
		{
			reajustes++;
			houveTroca = ReajustarGrupos();
		}
		
		System.out.println("REAJUSTOU = " + reajustes + "\n\n\n");
	}
	
	public static void Imprimir()
	{
		int totalElementos = grupo1.amostras.size() + grupo2.amostras.size();
		System.out.println("TOTAL ELEMENTOS " + totalElementos + "\n");
		System.out.println("GRUPO 1 - QTD ELEMENTOS: " + grupo1.amostras.size());
		System.out.println("Centros: [" + grupo1.mediaAtributo1 + " , " + grupo1.mediaAtributo2 + "]");
		for (Amostra amostra : grupo1.amostras)
		{
			//System.out.println("id: " + amostra.id + " grupo real: " + amostra.Grupo.grupoTipo.getNumVal());
			System.out.println(amostra.Atributo1 + " ; " + amostra.Atributo2);
		}
		System.out.println();
		
		System.out.println("GRUPO 2 - QTD ELEMENTOS: " + grupo2.amostras.size());
		System.out.println("Centros: [" + grupo2.mediaAtributo1 + " , " + grupo2.mediaAtributo2 + "]");
		for (Amostra amostra : grupo1.amostras)
		{
			//System.out.println("id: " + amostra.id + " grupo real: " + amostra.Grupo.grupoTipo.getNumVal());
			System.out.println(amostra.Atributo1 + " ; " + amostra.Atributo2);
		}
	}
}
