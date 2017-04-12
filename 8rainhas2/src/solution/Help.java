package solution;

public class Help
{
	public static boolean Solved(Board current)
	{
		// verifica se o array atual possui ataques = 0
		if (current.countAttacks() == 0)
		{
			return true;
		}

		return false;
	}
	
	protected static boolean Similars(int[] config, int[] config2)
	{
		for (int i = 0; i < 3; i++)
		{
			if (config[i] != config2[i])
			{
				return false;
			}
		}
		return true;
	}

	public static int steps = 0;

	protected static void PrintSolution(Board solution)
	{
		if (solution.previous != null)
		{
			++steps;
			PrintSolution(solution.previous);
		}

		// qd chega no head, ele vai retornando e imprimindo o puzzle atual.
		for (int i = 0; i < 8; i++)
		{
                    if(i == 7){
                       System.out.print(solution.config[i]); 
                    }
                    else{
                        System.out.print(solution.config[i] + ", "); 
                    }
		}
		System.out.println();
	}

	
}
