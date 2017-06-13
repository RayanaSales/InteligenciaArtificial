package rainhas;

public class Main
{
	public static int TAMANHO_POPULACAO = 500;
	public static double TAXA_MUTACA0 = 0.001;
		
	public static void main(String[] args)
	{	
		Evolucao.GerarPopulacaoInicial();
		System.out.println("Geração " + Evolucao.GetUltimaGeracao().id + " criada");
		
		while(Evolucao.GetUltimaGeracao().AvaliarIndividuos())
		{
			Evolucao.GetUltimaGeracao().SelecionarMaisAptos();
			Evolucao.CriarNovaGeracao();
			System.out.println("Geração " + Evolucao.GetUltimaGeracao().id + " criada");
		}
		Evolucao.ImprimirUltimaGeracao();		
	}
}
