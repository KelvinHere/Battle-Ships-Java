import java.util.ArrayList;
import java.awt.Point;

public class BattleShipGame {
	int boardXSize = 15;
	int boardYSize = 5;
	int shipAmount =3;
	int shipSize = 4;
	Point shot = new Point();
	ArrayList<Ship> shipList;
	
	public static void main(String[] args) {
		BattleShipGame game = new BattleShipGame();
		game.startGame();
	}
	
	
	public void startGame() {
		// Setup board
		GameBoard board = new GameBoard(boardXSize, boardYSize);
		
		// Create and place ships
		shipList = new ArrayList<Ship>();
		for (int x = 0; x <= shipAmount -1; x++) {
			Ship ship = new Ship();
			ship.setSize(shipSize);
			
			if (ship.place(board) == true) {
				shipList.add(ship);
				ship.setName("Ship " + (x+1));
			} else {
				System.out.println(ship.getName() + " is unable to enter the battle");
			}
		}
		
		// Game starts
		System.out.println(shipList.size() + " ships have entered the battle!\n Take your first shot");
		
		String result = "Miss";
		while (!shipList.isEmpty()) {
			// Get shot location
			board.printBoard();
			shot.x = UserInput.getNumber("Enter X co-ordinate");
			shot.y = UserInput.getNumber("Enter Y co-ordinate");
			
			// Check ships for hits
			for (int x = 0; x < shipList.size(); x++) {
				result = "Miss";
				Ship ship = shipList.get(x);
				result = ship.hitCheck(board, shot);
				if (!result.equals("Miss")) {
					System.out.println(result);
					break;
				}
				if (ship.sunk == true) {
					shipList.remove(ship);
				}
			}
			
			// If no ships were hit
			if (result.equals("Miss")) {
				System.out.println("Miss");
			}
				
			if (shipList.size() == 0) {
				System.out.println("WINNER!  All ships have been sunk.");
				break;
			}
			
		}
		
	}
}
