package controlers;

import java.util.ArrayList;
import java.util.List;

import models.Amostra;
import models.Centro;
import models.Grupo;

public class GrupoControlador
{
	private static GrupoControlador gc;
	private List<Grupo> grupos = new ArrayList<Grupo>();
	
	private GrupoControlador()
	{
		// TODO Auto-generated constructor stub
	}
	
	public static GrupoControlador getGrupoControlador()
	{
		if(gc == null)
		{
			gc = new GrupoControlador();
		}
		return gc;
	}
	
	public void CriarGrupos(int qtd)
	{
		for (int i = 1; i <= qtd; i++)
		{
			Grupo grupo = new Grupo(i);
			this.grupos.add(grupo);
			CentroControlador.getCentroControlador().CriarCentro(grupo);
		}
	}
	
	public Grupo BuscarGrupo(int tipo)
	{
		for (Grupo grupo : grupos)
		{
			if(grupo.tipo == tipo)
			{
				return grupo;
			}
		}
		return null;
	}
	
	public void AtualizarSomatorio(int tipo, double amostra1, double amostra2)
	{
		Grupo g = BuscarGrupo(tipo);
		g.somaAtributo1 += amostra1;
		g.somaAtributo2 += amostra2;
		
		g.qtdAmostras++;
	}
	
	public void FinalizarCalculoCentros()
	{
		for (Grupo grupo : grupos)
		{
			//busque o centro desse grupoTipo
			Centro c = CentroControlador.getCentroControlador().BuscarCentro(grupo.tipo);
			//atualize ele			
			c.valor1 = grupo.somaAtributo1 / grupo.qtdAmostras;
			c.valor2 = grupo.somaAtributo2 / grupo.qtdAmostras;			
		}
	}
	
	public void Imprimir()
	{
		for (Grupo grupo : grupos)
		{
			System.out.println("Grupo: " + grupo.tipo);
			System.out.println("Quantidade elementos: " + grupo.amostras.size());
			
			Centro centro = CentroControlador.getCentroControlador().BuscarCentro(grupo.tipo);
			System.out.println("Centros [ " + centro.valor1 + " ; " + " " + centro.valor2 + " ]\n");
			
			for (Amostra amostra : grupo.amostras)
			{
				System.out.println(amostra.Atributo1 + " ; " + amostra.Atributo2 + " => grupo real: " + amostra.Grupo_Real.tipo);
			}
			System.out.println();
			System.out.println();
		}
	}
}
