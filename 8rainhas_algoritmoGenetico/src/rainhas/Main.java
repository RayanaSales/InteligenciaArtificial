package rainhas;

public class Main
{
	public static int TAMANHO_POPULACAO = 20;
	
	public static void main(String[] args)
	{		
		System.out.println("Criando gera��o: " + Evolucao.geracoes.size());
		Evolucao.GerarPopulacaoInicial();
		
		while(Evolucao.GetUltimaGeracao().AvaliarIndividuos())
		{
			Evolucao.GetUltimaGeracao().SelecionarMaisAptos();
			Evolucao.CriarNovaGeracao();
			System.out.println("Criando gera��o: " + Evolucao.geracoes.size());
		}
		
		Evolucao.ImprimirGeracoes();
	}
}
