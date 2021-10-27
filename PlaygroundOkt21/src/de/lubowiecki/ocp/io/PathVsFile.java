package de.lubowiecki.ocp.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathVsFile {
	
	public static void main(String[] args) {
		
		File f = new File("parant/child/file.txt");
		
		Path p1 = FileSystems.getDefault().getPath("parant/child/file.txt");
		//p1 = FileSystems.getDefault().getPath("parant", "child", "file.txt");
		
		// oder
		p1 = Paths.get("parant/child/file.txt");
		
		Path p2 = f.toPath(); // File to Path
		File f2 = p1.toFile(); // Path to File
		
		System.out.println(p2.toAbsolutePath()); // baut aus einem relativen einen absoluten Pfad
		
		p1 = Paths.get("/parant/child/file.txt");
		//p1 = Paths.get("c:/parant/child/file.txt"); // Für WIN
		
		System.out.println(p1.getNameCount());
		System.out.println(p1.getName(2));
		System.out.println(p1.getFileName());
		System.out.println(p1.getParent());
		System.out.println(p1.getRoot());
		System.out.println(p1.subpath(0, 2));
		
		p1 = Paths.get("../../file.txt");
		System.out.println(p1);
		p1 = p1.toAbsolutePath();
		System.out.println(p1);
		System.out.println(p1.normalize());
		
		p1 = Paths.get("count.txt");
		
		try {
			System.out.println(p1.toRealPath());
		} 
		catch (IOException e) {
			System.out.print("Exception...");
			System.out.println(e.getMessage());
		}
		
		// Pfade verbinden
		p1 = Paths.get("/parant/child/");
		p2 = Paths.get("files");
		System.out.println(p1.resolve(p2).resolve("test.txt"));
		
		System.out.println();
		
		// gibt einen relativen Pfad zurück
		p1 = Paths.get("parant/child/");
		System.out.println(p1);
		p2 = Paths.get("files");
		System.out.println(p2);
		System.out.println(p1.relativize(p2));
		
	}

}
