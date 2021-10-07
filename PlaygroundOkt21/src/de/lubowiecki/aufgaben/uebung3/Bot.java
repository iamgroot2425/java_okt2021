package de.lubowiecki.aufgaben.uebung3;

/**
 * Ein Roboter der sich auf einem Spielplan bewegen kann
 * @author tlubowiecki
 *
 */
public class Bot {
	
	private String name = "Unbekannt";
	
	private Direction direction = Direction.EAST;
	
	private int xPos;
	private int yPos;
	
	private Board board;

	public Bot(Board board) {
		this.board = board;
		move(); // Bot wird auf die Position 0, 0 gesetzt
	}
	
	public Bot(String name, Board board) {
		this(board);
		this.name = name;
	}

	public Bot(Board board, int xPos, int yPos) {
		this.board = board;
		this.xPos = xPos;
		this.yPos = yPos;
		move();
	}
	
	public Bot(String name, Board board, int xPos, int yPos) {
		this(board, xPos, yPos); // Aufruf eines anderen Konstruktors. Muss immer als erstes passieren
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public boolean move() { // Plaziert den Bot auf dem Spielfeld
		// this ist eine Referenz auf dieses Bot-Objekt
		return this.board.set(this, xPos, yPos);
	}
	
	public boolean move(String step) {
		
		switch(step) {
		
			case ">":
				return move(true);
				
			case "<":
				return move(false);
				
				
			case "r":
				direction = CompassUtil.turnRight(direction);
				return true;
				
			case "l":
				direction = CompassUtil.turnLeft(direction);
				return true;
				
			default:
				// TODO: Reaktion auf ungültige Zeichen
				return false;
		}
	}
	
	private boolean move(boolean forward) { 
		
		board.set(null, xPos, yPos); // entfernt die alte Position
		
		switch(direction) {
		
			case EAST:
				if(forward) {
					yPos++; // Aktuallisiert die aktuelle Position im Bot
				}
				else {
					yPos--;
				}
				return move(); // Aktuallisierung die Position auf dem Spielfeld
				
			case WEST:
				if(forward) {
					yPos--;
				}
				else {
					yPos++;
				}
				return move();
				
			case SOUTH:
				if(forward) {
					xPos++;
				}
				else {
					xPos--;
				}
				return move();
				
			case NORTH:
				if(forward) {
					xPos--;
				}
				else {
					xPos++;
				}
				return move();
				
			default:
				return false;
		}
		
	}
	
	
	
	

}
