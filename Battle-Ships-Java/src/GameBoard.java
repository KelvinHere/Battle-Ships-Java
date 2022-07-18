
public class GameBoard {
	private int xSize;
	private int ySize;
	private int[][] board;
	
	public GameBoard() {
		System.out.println("Default board of size 10x10 created");
		xSize = 10;
		ySize = 10;
		board = new int[xSize][ySize];
	}
	
	public GameBoard(int x, int y) {
		if (x > 1 && y > 1) {
			xSize = x;
			ySize = y;
			System.out.println("Game board of size " + xSize + "x" + ySize + " created");
		} else {
			System.out.println("Game board too small default size of 10x10 created");
			xSize = 10;
			ySize = 10;
		}
		board = new int[xSize][ySize];
	}
	
	public int[][] getBoard() {
		return board;
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
