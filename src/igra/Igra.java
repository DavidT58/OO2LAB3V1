package igra;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Igra extends Frame {
	
	private Basta basta;
	private boolean uToku;
	CheckboxGroup tezina;
	Checkbox lako;
	Checkbox srednje;
	Checkbox tesko;
	Button kreniStani;
	
	
	
	public Igra() {
		super("Whack-a-mole");
		basta = new Basta(4,4);
		add(basta, BorderLayout.CENTER);
		add(dodajMeni(), BorderLayout.EAST);
		setSize(700, 700);
		
		dodajOsluskivace();
		setVisible(true);
	}
	
	private void azuriraj() {
		basta = new Basta(4,4);
		add(basta, BorderLayout.CENTER);
		uToku = false;
	}
	
	private void dodajOsluskivace() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				basta.zavrsi();
				dispose();
			}
		});
		
		kreniStani.addActionListener(e -> {
			if(uToku) {
				kreniStani.setLabel("STANI");
				basta.zavrsi();
				azuriraj();
			}
			else {
				kreniStani.setLabel("KRENI");
				basta.setBrojKoraka(10);
				basta.pokreni();
				uToku = true;
			}
		});
		
	}
	
	private Panel dodajMeni() {
		Panel desniMeni = new Panel();
		desniMeni.setLayout(new GridLayout(2, 0));
		
		Panel p = new Panel();
		Panel q = new Panel();
		
		p.setLayout(new GridLayout(6, 0));
		Label tezinaLabel = new Label("Tezina");
		tezinaLabel.setAlignment(Label.CENTER);
		p.add(tezinaLabel);
		
		tezina = new CheckboxGroup();
		lako = new Checkbox("Lako", true, tezina);
		srednje = new Checkbox("Srednje", true, tezina);
		tesko = new Checkbox("Tesko", true, tezina);
		p.add(lako);
		p.add(srednje);
		p.add(tesko);
		
		kreniStani = new Button("KRENI");
		p.add(kreniStani);
		
		desniMeni.add(p);
		desniMeni.add(q);
		return desniMeni;
	}

	public static void main(String[] args) {
		new Igra();
	}
}
