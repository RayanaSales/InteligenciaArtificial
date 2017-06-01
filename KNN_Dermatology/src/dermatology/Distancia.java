package dermatology;

public abstract class Distancia
{
	Tupla atual;
	Tupla teste;
	double distancia;
	
	public Distancia()
	{
		
	}
	
	public Distancia(Tupla atual, Tupla teste)
	{
		this.atual = atual;
		this.teste = teste;
		Calcular();
	}
	
	public abstract double Calcular();
}
