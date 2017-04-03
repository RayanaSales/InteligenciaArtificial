package solucao;

public class Main
{

	public static void main(String[] args)
	{
		Node node = new Node(new int[] {4, 3, 2, 7, 7, 5, 4, 0});
		
		System.out.println("attacks: " + Help.countAttacksByColumn(node, 2));
	}

}
