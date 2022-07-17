import java.util.Random;
import java.util.HashMap;
import java.awt.Point;

public class Ship {
	Random r = new Random();
	private int shipSize = 4;
	private HashMap<Point, String> coords = new HashMap<Point, String>();
	private String shipName;
	boolean sunk = false;

	public HashMap<Point, String> getCoords() {
		return coords;
	}
	
	public void setName(String n) {
		shipName = n;
	}
	
	public String getName() {
		return shipName;
	}
	
	public void setSize(int s) {
		if (s > 0) {
			shipSize = s;
		}
	}
	
	public String hitCheck(GameBoard board, Point shot) {
		// Check if shot hit
		if (coords.containsKey(shot)) {
			board.setCell(shot.x, shot.y, 0);
			if (coords.get(shot).equals("Hit")) {
				return (shipName + " has already been hit here, it is now extra exploded!");
			} else {
				coords.replace(shot, "Hit");
				// If all coords are hit sink the ship
				if (!coords.containsValue("Alive")) {
					coords.clear();
					sunk = true;
					return (shipName + " has been sunk!");
				}
				return (shipName + " has been hit!");
			}
		}
		return "Miss";
	}
	
	public boolean place(GameBoard board) {
		// Give ship n chances to place its self on the board
		for (int attempt = 0; attempt <= 200; attempt++) {
			boolean invalidCoord = false;
			Point[] newCoords = generateCoordinates(board);
			
			// Check newCoords are valid
			for (Point coord : newCoords) {
				// If out of bounds
				if (coord.x >= board.xSize() || coord.y >= board.ySize()) {
					invalidCoord = true;
				} else {
					if (board.getCell(coord.x, coord.y) != 0) {
						invalidCoord = true;
					}
				}
				
			}
			
			// If valid place ship
			if (invalidCoord == false) {
				for (Point coord : newCoords) {
					coords.put(coord, "Alive");
					board.setCell(coord.x, coord.y, 1);
				}
				return true;
			}
		}
		// Failed to place ship
		return false;
	}
	
	public Point[] generateCoordinates(GameBoard board) {
		Point[] coordinates = new Point[shipSize];
		int placeX = r.nextInt(board.xSize());
		int placeY = r.nextInt(board.ySize());
		boolean vertical = r.nextBoolean();
		int xMod=0, yMod=0;
		
		// Generate coordinates
		for (int x = 0; x < shipSize; x++) {
			coordinates[x] = new Point((placeX + xMod), (placeY + yMod));
			// Increment direction
			if (vertical == true) {
				xMod++;
			} else {
				yMod++;
			}
		}
		return coordinates;
	}

}
