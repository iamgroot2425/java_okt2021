package de.lubowiecki.ocp.basics.vererbung;

public class Cat extends AbstractAnimal {

	@Override
	public String getSound() {
		return "MIAU... MIAU";
	}

	@Override
	public void setSound(String sound) {
		System.out.println("Du kannst einer Katze nicht sagen, was sie machen soll!");
	}

}
