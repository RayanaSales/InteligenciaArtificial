package rainhas;

public class Main
{
	public static int TAMANHO_POPULACAO = 20;
	
	public static void main(String[] args)
	{		
		Evolucao.GerarPopulacaoInicial();
		
		while(Evolucao.GetUltimaGeracao().AvaliarIndividuos())
		{
			Evolucao.GetUltimaGeracao().SelecionarMaisAptos();
			Evolucao.CriarNovaGeracao();
		}
		
		Evolucao.ImprimirGeracoes();
	}
}
