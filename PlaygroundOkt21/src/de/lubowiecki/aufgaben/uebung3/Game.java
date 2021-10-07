package de.lubowiecki.aufgaben.uebung3;

import java.util.Scanner;

public class Game {
	
	private Scanner scanner;
	
	private Board board;
	
	private Bot bot;
	
	private static final String KEYS = "\n*********************************************"
									 + "\n exit = Programm verlassen"
									 + "\n go 	= Programm ausführen"
									 + "\n*********************************************\n";
	
	public Game() {
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new Game().start();
	}

	private void start() {
		
		String input;
		
		
		app: while(true) {
			
			System.out.println(KEYS);
			
			System.out.print("Eingabe: ");
			
			input = scanner.next().trim().toLowerCase();
			
			switch(input) {
			
				case "exit": break app; // Bricht die Schleife mit dem label app ab
				
				default:
					
					if(board == null) {
						System.out.print("Wie groß soll das Spielfeld sein? ");
						board = new Board(scanner.nextInt()); // Liest Eingabe ein und baut ein Spielfeld in passender Größe
						board.print();
					}
					
					if(bot == null) {
						bot = new Bot("R2-D2", board);
					}
					
					System.out.print("Wie möchtest du den Bot bewegen? ");
					
					// split("") teilt einen String in einzelne Zeichen
					String[] steps = scanner.next().split("");
					
					for (String step : steps) {
						bot.move(step); // Bot wir Zeichen für Zeichen weiterbewegt
					}
					
					board.print(); // Ausgabe des Spielfeldes
			}
		}
		
		scanner.close();
		
		System.out.println("\nProgramm wurde beendet!");
		
	}

}
