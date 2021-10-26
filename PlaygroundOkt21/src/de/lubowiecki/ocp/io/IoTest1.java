package de.lubowiecki.ocp.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IoTest1 {

	public static void main(String[] args) {
		
		File f1 = new File("test.txt"); // relativ
		File f2 = new File("c://xyz/test.txt"); // absolut (WIN)
		File f3 = new File("/xyz/test.txt"); // absolut (Linux, Unix, OSX)
		
		try {
			if(!f1.exists()) {
				f1.createNewFile();
			}
			
			// schreiben
//			try(BufferedWriter out = new BufferedWriter(new FileWriter(f1))) {
//				
//				out.write("Das ist ein Haus von Nikigraus!");
//				// out.close(); // wird automatisch verwendet
//			}
			
			long start = System.currentTimeMillis();
			
			// lesen
			try(BufferedReader in = new BufferedReader(new FileReader(f1))) {
				
				// Lesen Zeichen für Zeich (Low-Level)
//				int zeichen;
//				while((zeichen = in.read()) != -1) {
//					System.out.print((char) zeichen);
//				}
				
				// Lesen Zeile für Zeile (Heigh-Level)
				String row = null;
				while((row = in.readLine()) != null) {
					System.out.println(row);
				}
			}
			
			long end = System.currentTimeMillis();
			
			System.out.println();
			System.out.println(end - start + "ms");
			
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
