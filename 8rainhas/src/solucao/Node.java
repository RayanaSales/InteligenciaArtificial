package solucao;

import java.util.Arrays;

public class Node
{
	Node anterior;	
	int[] board;
	int attacks;
	
	Node swap0;
	Node swap1;
	Node swap2;
	Node swap3;
	Node swap4;
	Node swap5;
	Node swap6;
	Node swap7;
	
	public Node(int[] board)
	{
		this.board = board;
		
		swap0 = new Node();
		swap1 = new Node();
		swap2 = new Node();
		swap3 = new Node();
		swap4 = new Node();
		swap5 = new Node();
		swap6 = new Node();
		swap7 = new Node();
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Arrays.hashCode(board);
	}
	
	public Node()
	{
		swap0 = new Node();
		swap1 = new Node();
		swap2 = new Node();
		swap3 = new Node();
		swap4 = new Node();
		swap5 = new Node();
		swap6 = new Node();
		swap7 = new Node();
	}
}
