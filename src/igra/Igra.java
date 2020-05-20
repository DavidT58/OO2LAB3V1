package igra;

import java.awt.Frame;

public class Igra extends Frame {
	
	Basta basta;
	
	
	public Igra() {
		super("Whack-a-mole");
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Igra();
	}
}
