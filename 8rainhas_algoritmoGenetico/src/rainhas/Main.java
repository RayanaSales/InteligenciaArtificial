package rainhas;

public class Main
{
	public static int TAMANHO_POPULACAO = 20;
	
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
		
		//Evolucao.ImprimirGeracoes();
	}
}
