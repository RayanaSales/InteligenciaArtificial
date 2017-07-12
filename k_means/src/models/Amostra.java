package models;

import controlers.GrupoControlador;

public class Amostra
{
	int id;
	public double Atributo1;
	public double Atributo2;
	
	public Grupo Grupo_Real;
	public Grupo Grupo_Classificacao;
	
	public Amostra(int id, double atributo1, double atributo2, int grupo_real, int grupo_classificao)
	{
		this.id = id;
		this.Atributo1 = atributo1;
		this.Atributo2 = atributo2;
		
		this.Grupo_Real = GrupoControlador.getGrupoControlador().BuscarGrupo(grupo_real);
		this.Grupo_Classificacao = GrupoControlador.getGrupoControlador().BuscarGrupo(grupo_classificao);
	}
	
	public void IrParaGrupo(int tipo)
	{
		this.Grupo_Classificacao = GrupoControlador.getGrupoControlador().BuscarGrupo(tipo);
	}
}
