
public class GameBoard {
	private int xSize;
	private int ySize;
	private int[][] board;
	
	public boolean createBoard(int x, int y) {
		if (x < 1 || y < 1) {
			return false;
		}
		
		xSize = x;
		ySize = y;
		
		board = new int[xSize][ySize];
		//System.out.println("Board created: " + xSize + "x" + ySize);
		return true;
	}
	
	public int xSize() {
		return board.length;
	}
	
	public int ySize() {
		return board[0].length;
	}
	
	public void setCell(int x, int y, int val) {
		board[x][y] = val;
	}
	
	public int getCell(int x, int y) {
		return board[x][y];
	}
	
	public void printBoard() {
		//Print board to console (rotate array 90deg CCW for proper x/y axis)
		for (int y = (board[0].length -1); y >=0 ; y--) {
			for (int x = 0; x <= (board.length -1); x++) {
				System.out.print(board[x][y]);
			}
			System.out.println("\n");
		}
	}
}
