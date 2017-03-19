package puzzle;

public class Quadrant
{
	int[][] puzzle = new int[3][3];

	Quadrant previous;
	Quadrant next;
	
	public Quadrant(int[][] puzzle, Quadrant previous, Quadrant next)
	{
		this.puzzle = puzzle;
		this.previous = previous;
		this.next = next;
	}
}
