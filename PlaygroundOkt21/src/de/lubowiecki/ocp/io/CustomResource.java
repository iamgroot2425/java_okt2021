package de.lubowiecki.ocp.io;

public class CustomResource implements AutoCloseable {
	
	private int nr;
	
	public CustomResource(int nr) {
		this.nr = nr;
		System.out.println(nr + ": wird geöffnet");
	}

	@Override
	public void close() throws Exception {
		System.out.println(nr + ": wird geschlossen");
	}
}
