package rainhas;

public class Main
{
	public static int TAMANHO_POPULACAO = 500;
	public static double TAXA_MUTACA0 = 0.002;
		
	public static void main(String[] args)
	{	
		for (int i = 0; i < 50; i++)
		{
			System.out.print("Execu��o " + i);
			main2();
		}
	}
	
	public static void main2()
	{
		Evolucao.GerarPopulacaoInicial();
		//System.out.println("Gera��o " + Evolucao.GetUltimaGeracao().id + " criada");
		
		while(Evolucao.GetUltimaGeracao().AvaliarIndividuos())
		{
			Individuo[] sobreviventes = Evolucao.GetUltimaGeracao().SelecaoNatural();
			Evolucao.CriarNovaGeracao(sobreviventes);
			//System.out.println("Gera��o " + Evolucao.GetUltimaGeracao().id + " criada");
		}
		//Evolucao.ImprimirUltimaGeracao();	
		
		System.out.println(" acabou na gera��o " + Evolucao.GetUltimaGeracao().id);
	}
}
