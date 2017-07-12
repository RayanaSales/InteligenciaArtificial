package models;

import java.util.ArrayList;
import java.util.List;

public class Grupo
{
	public double somaAtributo1, somaAtributo2;	
	public int tipo; 
	public int qtdAmostras;
	
	public List<Amostra> amostras = new ArrayList<Amostra>(); //USADO APENAS PARA IMPRESSAO
		
	public Grupo(int tipo)
	{
		this.tipo = tipo;			
	}
}
