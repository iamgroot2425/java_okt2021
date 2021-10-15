package de.lubowiecki.ocp.collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static de.lubowiecki.ocp.collections.Robo.Command;

public class RoboTest {
	
	public static void main(String[] args) {
		
		Robo r = new Robo("R2-D2");
		
		Queue<Command> commands = new LinkedList<>();
		
		commands.offer(Command.FORWARD);
		commands.offer(Command.JUMP);
		commands.offer(Command.FORWARD);
		commands.offer(Command.TURN_LEFT);
		commands.offer(Command.FORWARD);
		commands.offer(Command.USE);
		
		r.processCommands(commands);
		
		System.out.println();
		
		commands.offer(Command.FORWARD);
		
		r.processCommands(commands);
		
	}

}
