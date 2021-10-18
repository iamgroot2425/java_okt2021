package de.lubowiecki.ocp.collections;

import java.util.HashMap;

public class Lang {

	public static final HashMap<String, String> EN;
	public static final HashMap<String, String> DE;
	
	static {
		EN = new HashMap<>();
		EN.put("welcome", "Welcome");
		EN.put("input_label", "Please give me some input");
		EN.put("input", "Your input");
		EN.put("end", "End of programm");
		
		DE = new HashMap<>();
		DE.put("welcome", "Herzlich Willkommen");
		DE.put("input_label", "Bitte gib etwas ein");
		DE.put("input", "Deine Eingabe");
		DE.put("end", "Programmende");
	}
}
