package de.lubowiecki.ocp.collections;

import java.util.Queue;

public class Robo {
	
	private String name;
	
	public Robo(String name) {
		this.name = name;
	}

	public void processCommands(Queue<Command> commands) {
		
		while(!commands.isEmpty()) {
			
			switch(commands.poll()) {
				
				case FORWARD:
					System.out.println(name + ": geht vorwärts");
					break;
					
				case BACKWARD: 
					System.out.println(name + ": geht rückwärts");
					break;
					
				case TURN_LEFT: 
					System.out.println(name + ": dreht nach links");
					break;
					
				case TURN_RIGHT: 
					System.out.println(name + ": dreht nach rechts");
					break;
					
				case JUMP: 
					System.out.println(name + ": springt");
					break;
					
				case USE: 
					System.out.println(name + ": benutzt etwas");
					break;
				
				default:
					System.out.println("Ungültiger Befehl");
			}
		}
		
		System.out.println(name + ": bleibt stehen und wartet auf neue Befehle...");
	}
	
	public static enum Command {
		
		FORWARD, BACKWARD, TURN_LEFT, TURN_RIGHT, JUMP, USE;
		
	}

}
