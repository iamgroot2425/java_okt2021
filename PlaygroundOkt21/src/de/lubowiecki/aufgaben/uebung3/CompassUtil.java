package de.lubowiecki.aufgaben.uebung3;

/**
 * Ist ein Kompass
 * @author tlubowiecki
 *
 */
public class CompassUtil {
	
	private CompassUtil() {
	}
	
	/**
	 * Liefert gem dem Kompass die passe Direction nach einer Linksdrehung abhängig von der aktuellen Richtung
	 */
	public static Direction turnLeft(Direction cur) {
		
		// TODO: Prüfen, ob cur null ist
		
		switch(cur) {
		
			case EAST:
				return Direction.NORTH;
				
			case SOUTH:
				return Direction.EAST;
				
			case WEST:
				return Direction.SOUTH;
				
			case NORTH:
				return Direction.WEST;	
		
		}
		
		return null;
	}
	
	/**
	 * Liefert gem dem Kompass die passe Direction nach einer Rechtsdrehung abhängig von der aktuellen Richtung
	 */
	public static Direction turnRight(Direction cur) {
		
		// TODO: Prüfen, ob cur null ist
		
		switch(cur) {
		
			case EAST:
				return Direction.SOUTH;
				
			case SOUTH:
				return Direction.WEST;
				
			case WEST:
				return Direction.NORTH;
				
			case NORTH:
				return Direction.EAST;	
		
		}
		
		return null;
	}

}
