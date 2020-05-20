package igra;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Igra extends Frame {
	
	private Basta basta = new Basta(4,4);
	private Label test = new Label("test label");
	
	
	public Igra() {
		super("Whack-a-mole");
		add(basta, BorderLayout.CENTER);
		add(panel(), BorderLayout.SOUTH);
		setSize(500, 500);
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
	
	private Panel panel() {
		Panel p = new Panel(new GridLayout(2,2));
		p.add(test);
		
		return p;
	}

	public static void main(String[] args) {
		new Igra();
	}
}
