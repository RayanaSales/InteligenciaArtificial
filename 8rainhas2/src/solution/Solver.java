package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Solver
{
	static ArrayList<Board> queue = new ArrayList<Board>();
	static ArrayList<Board> useds = new ArrayList<Board>();

	public static void solve(Board current)
	{
		boolean solved = false;
		queue.add(current);

		do
		{			
			current = queue.remove(queue.size() - 1);
			
			if (Help.Solved(current))
			{
				solved = true;
				break;
			}
			if (!useds.contains(current))
			{
				expand(current);
				useds.add(current);
			}
		} while (!solved);

		System.out.println("SOLUCAO ENCONTRADA:");
		Help.PrintSolution(current);
		System.out.println("FIM DA SOLUCAO! " + ++Help.steps + " passos executados.");
	}

	private static void expand(Board current)
	{
		// enquanto houver possibilidades de permuta��o
		// {
		// -permute
		// if !prune()
		// {
		// -calcule custo
		// -add na fila (ordenado por ataques attacks - menores primeiro)
		// }
		// }

		for (int column = 0; column <= 6; column++)
		{
			int nextColumn = column + 1;

			while (nextColumn <= 7)
			{
				Board swap = Swap(current, column, nextColumn);

				swap.previous = current;
//				if (!prune(swap))
//				{
					swap.countAttacks();
					queue.add(swap);
//				}
				nextColumn++;
			}
		}

		// ordene a lista
		Collections.sort(queue, new Comparator<Board>()
		{
			@Override
			public int compare(Board b, Board b1)
			{
				// -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
				return b.attacks > b1.attacks ? -1 : (b.attacks < b1.attacks) ? 1 : 0;
			}
		});
	}

	private static Board Swap(Board board, int a, int b)
	{
		Board newBoard = new Board();
		newBoard.config = Arrays.copyOf(board.config, 8);

		int help = 0;
		help = newBoard.config[a];
		newBoard.config[a] = newBoard.config[b];
		newBoard.config[b] = help;

		return newBoard;
	}

	private static boolean prune(Board board)
	{
		// vc eh igual ao seu pai?
		if (Help.Similars(board.config, board.previous.config))
		{
			return true;
		}

		// vc ja foi usado antes?
		if (useds.contains(board))
		{
			return true;
		}

		return false;
	}
}
