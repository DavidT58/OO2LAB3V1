package igra;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Igra extends Frame {
	
	private Basta basta = new Basta(4,4);
	
	
	public Igra() {
		super("Whack-a-mole");
		add(basta, BorderLayout.CENTER);
		setSize(700, 700);
		setVisible(true);
		dodajOsluskivace();
		
	}
	
	private void dodajOsluskivace() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
	}

	public static void main(String[] args) {
		new Igra();
	}
}
