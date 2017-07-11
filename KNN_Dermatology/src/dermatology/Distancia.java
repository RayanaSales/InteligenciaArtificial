package dermatology;

public abstract class Distancia
{
	Tupla treinamento;
	Tupla teste;
	double distancia;
	
	public Distancia()
	{
		
	}
	
	public Distancia(Tupla atual, Tupla teste)
	{
		this.treinamento = atual;
		this.teste = teste;
		Calcular();
	}
	
	public abstract double Calcular();
}
