package kmeans;

public class Amostra
{
	int id;
	public double Atributo1;
	public double Atributo2;
	
	public Grupo Grupo;//SO EH USADO PARA COMPARAR NA MATRIZ CONFUSAO
					   //o resultado da classificacao, esta em Classificador.grupo1 e Classificador.grupo2
	
	
	public Amostra(int id, double atributo1, double atributo2, Grupo grupo)
	{
		this.id = id;
		this.Atributo1 = atributo1;
		this.Atributo2 = atributo2;	
		Grupo = grupo;
	}
}
