package de.lubowiecki.aufgaben.uebung3;

/**
 * Ein symetrisches 2d Spielfeld
 * @author tlubowiecki
 *
 */
public class Board {

	private final Bot[][] FIELDS;
	
	public Board(int size) {
		FIELDS = new Bot[size][size]; // Erzeugt ein zweidimensionales, symetrisches Array von Bot-Objekten
	}
	
	/**
	 * Zeigt den aktuellen Zustand des Spielfelds
	 */
	public void print() {
		
		for (Bot[] bots : FIELDS) { // Zeilen
			for (Bot bot : bots) { // Zellen
				if(bot == null) {
					System.out.print("[ ]");
				}
				else {
					System.out.print("[@]");
				}
			}
			System.out.println();
		}
		
	}

	/**
	 * 
	 * @param bot
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean set(Bot bot, int x, int y) {
		// TODO: Prüfen, ob das Feld bereits belegt ist
		// TODO: Prüfen, ob die neue Position noch innerhalb des Spielfelds ist
		FIELDS[x][y] = bot;
		
		return true;
	}

}
