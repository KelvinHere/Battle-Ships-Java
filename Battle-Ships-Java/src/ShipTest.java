import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.awt.Point;

class ShipTest {
	
	@Test
	void testValidPlacement() {
		// Test that given space on the board the ship will be placed
		GameBoard board = new GameBoard();
		board.createBoard(10,5);
		Ship s = new Ship();
		s.generateCoordinates(board);
		assertTrue(s.place(board));
	}
	
	@Test
	void testInvalidPlacement() {
		// Test if a ship is too big for the board it will not be placed and return false
		GameBoard board = new GameBoard();
		board.createBoard(3, 3);
		Ship s = new Ship();
		s.setSize(4);
		assertFalse(s.place(board));
	}
	
	@Test
	void testShipsOfSizeOneFillGameBoard() {
		// Test if game-board can be completely filled (2x2 = 4 ships size 1 test)
		GameBoard board = new GameBoard();
		board.createBoard(2, 2);
		for (int x = 0; x <= 3; x++) {
			Ship s = new Ship();
			s.setSize(1);
			assertTrue(s.place(board));
		}
	}
	
	@Test
	void testShipMarksPlaceOnBoardCorrectly() {
		// Test checks GameBoard after a successful hit to make sure the ship marks it on the board 
		GameBoard board = new GameBoard();
		board.createBoard(5, 5);
		Ship s = new Ship();
		s.setSize(3);
		s.place(board);
		HashMap<Point, String> coords = s.getCoords();
		for (Point each : coords.keySet()) {
			assertEquals(1, board.getCell(each.x, each.y));
		}
	}
	
	@Test
	void testHitCheckHits() {
		// Test checks a valid hit returns the message ship has been hit
		GameBoard board = new GameBoard();
		board.createBoard(5, 5);
		Ship s = new Ship();
		s.setSize(3);
		s.place(board);
		HashMap<Point, String> coords = s.getCoords();
		for (Point each : coords.keySet()) {
			assertEquals((s.getName() + " has been hit!"), s.hitCheck(board, each));
			break;
		}
	}
	
	@Test
	void testHitCheckHitTwiceInSamePlace() {
		// Test checks a second hit in the same place returns correct message 
		GameBoard board = new GameBoard();
		board.createBoard(5, 5);
		Ship s = new Ship();
		s.setSize(3);
		s.place(board);
		HashMap<Point, String> coords = s.getCoords();
		for (Point each : coords.keySet()) {
			s.hitCheck(board, each);
			assertEquals((s.getName() + " has already been hit here, it is now extra exploded!"), s.hitCheck(board, each));
			break;
		}
	}
	
	@Test
	void testHitCheckShipSinksAndCoordsAreRemoved() {
		// Test checks that when all ship cells are hit correct message is returned and its coordinates are removed
		GameBoard board = new GameBoard();
		board.createBoard(5, 5);
		Ship s = new Ship();
		s.setSize(3);
		s.place(board);
		HashMap<Point, String> coords = s.getCoords();
		for (Point each : coords.keySet()) {
			String result = s.hitCheck(board, each);
			if (result.equals(s.getName() + " has been sunk!")) {
				assertEquals(0, s.getCoords().size());
				return;
			}
		}
	}
}
