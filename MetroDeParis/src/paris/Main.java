package paris;

public class Main
{	
	public static void main(String[] args)
	{
		Rota rota = new Rota();
		
		Estacao atual = rota.AJUDA.GetEstacao(1);
		Estacao destino = rota.AJUDA.GetEstacao(1);
		
		rota.Buscar(atual, destino);
	}
}
