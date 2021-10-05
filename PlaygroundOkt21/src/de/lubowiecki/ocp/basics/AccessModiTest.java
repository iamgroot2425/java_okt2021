package de.lubowiecki.ocp.basics;

public class AccessModiTest {
	
	// Muss spätestens im statischen Initializer zugewiesen werden 
	public static final String WERT; // Klassenkonstante
	
	// static Initializer
	static {
		//...
		WERT = "...";
	}
	
	// Konstanten, die direkt ihren Wert zugewiesen bekommen, sollten static sein
	public static final double MWST = 0.16;
	
	// Muss spätestens im Konstruktor mit einem Wert initialisiert werden
	public final String ANDERER_WERT = "..."; // Instanzkonstante
	
	// Instanz Initializer - Wird vor dem Konstruktor ausgeführt
	{
		
	}
	
	public static void main(String[] args) {
		
		// Muss vor der Verwendung initialisiert werden
		final String ganzAndererWert = "..."; // Lokale Konstante
		
		
		String s1 = "..."; // Erzeugt ein String im StringLiteralPool
		String s2 = "..."; // Verweist auf das Objekt im Pool
		s1 += "xyz"; // Erzeugt ein neues Objekt im Pool und verweist darauf
		s1 = null; // Referenz wird auf null gesetzt und damit vom String-Objekt getrennt
		
		System.out.println(s1);
		//System.out.println(s1.toLowerCase()); // Produziert eine NullPointerException
		
		Person p = new Person("Bruce", "Banner");
		p.setFirstname(null); // Setter schützen das Objekt vor einem ungültigen Zustand
		System.out.println(p.getEmail());
		
		int i = 100;
		i++;
		i = 200;
		
		final int j = 100;
		//j++; // Fehler, Konstante darf nicht neu zugewiesen werden
		
		final Person p2 = new Person();
		//p2 = new Person("Peter"); // Fehler: Referenz darf nicht auf ein anderes Objekt gesetzt werden
		p2.setFirstname("Hans"); // Zustand des Objektes darf sich verändern
		
		
		int a = 100;
		int b = a; // Eine Kopie des aktuellen Wertes (100) wird auf b zugewiesen
		a = 200; // Hat keine Auswirkung auf b
		System.out.println(b);
		
		Person p3 = new Person(); // Person wird auf dem Heap abgelegt und p3 ist eine Referenz darauf
		Person p4 = p3; // Eine Kopie der Referenz - verweist auf das gleiche Objekt auf dem Heap
		p3.setFirstname("Peter"); // Ändert das Objekt auf dem Heap und hat auswirkungen auf ALLE Referenzen auf diese Objekt
		System.out.println(p4.getFirstname());
		
		
		final int c = 100; // Kompiletime-Konstante 
		
		final int d;
		d = 100; // Runtime-Konstante - Wert wird zur Laufzeit zugewiesen
		
		
		while(d < 1000) { // Kompiler kann den aktuellen Wert erst zur Laufzeit ermitteln
		}
		
		while(c < 1000) { // Kompiler ersetzt die Variable im ByteCode durch ihren aktuellen Wert
		}
		
		// System.out.println("Hallo"); // Error: Wegen der Endlosschleife kann diese Code nie erreicht werden
	}

}
