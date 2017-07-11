package rainhas;

public class Main
{
	public static int QUANTIDADE_GERACOES = 3000;
	public static int TAMANHO_POPULACAO = 20;
	public static double TAXA_MUTACA0 = 0.002;
		
	public static void main(String[] args)
	{	
		for (int i = 0; i < 1; i++)
		{
			System.out.print("Execução " + i + " => ");
			main2();
		}
	}
	
	public static void main2()
	{
		Evolucao.GerarPopulacaoInicial();		
		while(Evolucao.GetUltimaGeracao().AvaliarIndividuos() && Evolucao.GetUltimaGeracao().id < Main.QUANTIDADE_GERACOES)
		{
			Individuo[] sobreviventes = Evolucao.GetUltimaGeracao().SelecaoNatural();
			Evolucao.CriarNovaGeracao(sobreviventes);			
		}		
		Evolucao.ImprimirUltimaGeracao();
	}
}
