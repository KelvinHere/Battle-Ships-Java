import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoardTest {

	@Test
	public void testCreateBoardDefaultConstructor() {
		// Default constructor
		GameBoard b = new GameBoard();
		assertEquals(10, b.xSize());
		assertEquals(10, b.ySize());
	}
	
	@Test
	public void testCreateBoardSizeConstructor() {
		// Size constructor
		GameBoard b = new GameBoard(5,25);
		assertEquals(5, b.xSize());
		assertEquals(25, b.ySize());
	}
	
	@Test
	public void testCreateBoardSizeConstructorInvalidSizeX() {
		// Size constructor with invalid x should make a default 10x10 grid
		GameBoard b = new GameBoard(0,25);
		assertEquals(10, b.xSize());
		assertEquals(10, b.ySize());
	}
	
	@Test
	public void testCreateBoardSizeConstructorInvalidSizeY() {
		// Size constructor with invalid x should make a default 10x10 grid
		GameBoard b = new GameBoard(10,-3);
		assertEquals(10, b.xSize());
		assertEquals(10, b.ySize());
	}	
	
	@Test
	public void testGameBoardSize() {
		GameBoard b = new GameBoard(4,10);
		// Game board should return correct row and col length
		assertEquals(4, b.xSize());
		assertEquals(10, b.ySize());
	}
	
	@Test
	public void testSetCellandGetCell() {
		GameBoard b = new GameBoard(5,25);
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
		GameBoard b = new GameBoard(5,5);
		// Create and place a ship of size 1
		Ship s = new Ship(1);
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
		GameBoard b = new GameBoard(25,25);
		// Create and place a ship of size 1
		Ship s = new Ship(6);
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
