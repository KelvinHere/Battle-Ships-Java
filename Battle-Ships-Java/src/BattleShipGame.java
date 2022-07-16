import java.util.ArrayList;
import java.awt.Point;

public class BattleShipGame {
	int boardXSize = 10;
	int boardYSize = 5;
	int shipAmount = 4;
	int shipSize = 4;
	Point shot = new Point();
	ArrayList<Ship> shipList;
	
	public static void main(String[] args) {
		BattleShipGame game = new BattleShipGame();
		game.startGame();
	}
	
	
	public void startGame() {
		// Setup board
		GameBoard board = new GameBoard();
		board.createBoard(boardXSize, boardYSize);
		
		// Create and place ships
		shipList = new ArrayList<Ship>();
		for (int x = 0; x <= shipAmount; x++) {
			Ship ship = new Ship();
			
			if (ship.place(board) == true) {
				shipList.add(ship);
				ship.setName("Ship" + (x+1));
			} else {
				System.out.println(ship.getName() + " is unable to enter the battle");
			}
		}
		
		// Game starts
		System.out.println(shipList.size() + " ships have entered the battle!\n Take your first shot");
		
		while (!shipList.isEmpty()) {
			board.printBoard();
			shot.x = UserInput.getNumber("Enter X co-ordinate");
			shot.y = UserInput.getNumber("Enter Y co-ordinate");
			
			for (Ship ship : shipList) {
				
			}
		}
		
	}
}
