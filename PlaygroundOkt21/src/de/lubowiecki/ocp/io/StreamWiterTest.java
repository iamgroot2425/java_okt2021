package de.lubowiecki.ocp.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class StreamWiterTest {

	public static void main(String[] args) {
		
		
//		try(InputStream in = new FileInputStream("test.txt");
//				Reader r = new InputStreamReader(in, "UTF-8")) {
//			
//			char[] buffer = new char[1000];
//			while(r.read(buffer) > 0) {
//				System.out.println(new StringBuilder().append(buffer));
//			}
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
		
		try(BufferedInputStream in = new FileInputStream("test.txt");
				Reader r = new InputStreamReader(in, "UTF-8")) {
			
			char[] buffer = new char[1000];
			while(r.read(buffer) > 0) {
				System.out.println(new StringBuilder().append(buffer));
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
