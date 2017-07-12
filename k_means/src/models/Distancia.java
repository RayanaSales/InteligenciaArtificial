package models;

public class Distancia
{
	public int grupoTipo;
	public Amostra amostra;
	
	public double distancia; //distancia da amostra para o grupoTipo
	
	public Distancia(Amostra amostra, int grupo)
	{
		this.amostra = amostra;
		this.grupoTipo = grupo;
	}
}
