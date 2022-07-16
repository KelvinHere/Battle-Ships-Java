import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoardTest {

	@Test
	public void testCreateBoard() {
		GameBoard b = new GameBoard();
		// Valid arguments
		assertTrue(b.createBoard(5,5));
		// Invalid arguments
		assertFalse(b.createBoard(0,5));
		assertFalse(b.createBoard(5,0));
		assertFalse(b.createBoard(-5,10));
		assertFalse(b.createBoard(10,-5));
	}
	
	@Test
	public void testGameBoardSize() {
		GameBoard b = new GameBoard();
		// Game board should return correct row and col length
		b.createBoard(4, 10);
		assertEquals(4, b.xSize());
		assertEquals(10, b.ySize());
	}
	
	@Test
	public void testSetCellandGetCell() {
		GameBoard b = new GameBoard();
		b.createBoard(5, 25);
		//Minimum coordinates
		assertEquals(0, b.getCell(0,0)); //Initially 0
		b.setCell(0, 0, 1);
		assertEquals(1, b.getCell(0,0)); //Set to 1
		//Around middle of board
		assertEquals(0, b.getCell(3,12)); //Initially 0
		b.setCell(3, 12, 1);
		assertEquals(1, b.getCell(3,12)); //Set to 1
		//Maximum coordinates
		assertEquals(0, b.getCell(4,24)); //Initially 0
		b.setCell(4, 24, 1);
		assertEquals(1, b.getCell(4,24)); //Set to 1
	}
	
	@Test
	public void testShipIsMarkedOnBoard() {
		GameBoard b = new GameBoard();
		b.createBoard(5, 5);
		// Create and place a ship of size 1
		Ship s = new Ship();
		s.setSize(1);
		s.place(b);

		// Check one cell on the GameBoard contains value of 1
		int shipCellCount = 0;
		int[][] currentBoard = b.getBoard();
		for (int[] x : currentBoard) {
			for (int cell : x) {
				if (cell == 1) {
					shipCellCount++;
				}
			}
		}
		assertEquals(1, shipCellCount);
	}
	
	@Test
	public void testBiggerShipIsMarkedOnBoard() {
		GameBoard b = new GameBoard();
		b.createBoard(25, 25);
		// Create and place a ship of size 1
		Ship s = new Ship();
		s.setSize(6);
		s.place(b);

		// Check one cell on the GameBoard contains value of 1
		int shipCellCount = 0;
		int[][] currentBoard = b.getBoard();
		for (int[] x : currentBoard) {
			for (int cell : x) {
				if (cell == 1) {
					shipCellCount++;
				}
			}
		}
		assertEquals(6, shipCellCount);
	}
}
