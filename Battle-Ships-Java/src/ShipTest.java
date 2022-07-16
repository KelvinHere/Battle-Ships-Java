import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {
	
	
//	@BeforeEach
//	public void setUp() {
// Create GameBoard and initialise
//	}
	
	@Test
	void testValidPlacement() {
		// Test given space on the board ship will be placed
		GameBoard board = new GameBoard();
		board.createBoard(10,5);
		Ship s = new Ship();
		s.generateCoordinates(board);
		assertTrue(s.place(board));
	}
	
	@Test
	void testInvalidPlacement() {
		// Test ship is too big and will not be placed
		GameBoard board = new GameBoard();
		board.createBoard(3, 3);
		Ship s = new Ship();
		s.setSize(4);
		assertFalse(s.place(board));
	}
	
	@Test
	void testShipsOfSizeOneFillGameBoard() {
		// Test if game-board can be completely filled 2x2 = 4 ship test
		GameBoard board = new GameBoard();
		board.createBoard(2, 2);
		for (int x = 0; x <= 3; x++) {
			Ship s = new Ship();
			s.setSize(1);
			assertTrue(s.place(board));
		}
	}

}
