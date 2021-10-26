package de.lubowiecki.ocp.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoApp {
	
	private static final String SER_FILE = "data.ser";
	
	private final List<Record> todos;
	
	private Scanner scanner = new Scanner(System.in);
	
	public ToDoApp() {
		todos = readFromFile();
	}
	
	public static void main(String[] args) {
		new ToDoApp().start();
	}

	private void start() {
		
		Record r = new Record();
		
		System.out.print("Label: ");
		r.setLabel(scanner.nextLine());
		todos.add(r);
		System.out.println("Datensatz wurde gespeichert.");
		
		System.out.println();
		
		for (Record record : todos) {
			System.out.println(record);
		}
		
		writeToFile(todos);
	}
	
	private static List<Record> readFromFile() {
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(SER_FILE))) {
			return (List<Record>) in.readObject(); //Altdaten werden aus der Datei gelesen
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return new ArrayList<>();
		}
	}
	
	private static void writeToFile(List<Record> list) {
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SER_FILE))) {
			// Aktueller Zustand von todos wir in eine Datei gespeichert
			out.writeObject(list);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
