package de.lubowiecki.ocp.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class StreamWiterTest {

	public static void main(String[] args) {
		
		// DataOutputStream: Schreibt primitive Werte in eine Datei
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
		
//		try(BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("count.txt"));
//				DataOutputStream dos = new DataOutputStream(out)) {
//			
//			dos.writeInt(1250);
//			
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
		
		// DataInputStream: Liest primitive Werte aus eine Datei
//		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream("count.txt"));
//				DataInputStream dis = new DataInputStream(in)) {
//			
//			int i = dis.readInt();
//			System.out.println(i);
//			
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
		
		try(CustomResource r1 = new CustomResource(1);
				CustomResource r2 = new CustomResource(2);
				CustomResource r3 = new CustomResource(3);) {
			
			// try-with-resources ruft automatisch close() auf der Resource
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
