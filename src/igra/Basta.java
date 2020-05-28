package igra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

@SuppressWarnings("serial")
public class Basta extends Panel implements Runnable {
	
	private Rupa[][] rupe;
	private int povrce;
	private int ms;
	private int brojKoraka;
	private Thread nit = new Thread(this);
	private int vrsta, kolona;
	
	public Basta(int v, int k) {
		vrsta = v;
		kolona = k;
		povrce = 100;
		ms = 1000;
		setBackground(Color.GREEN);
		rupe = new Rupa[v][k];
		setLayout(new GridLayout(v, k, 20, 20));
		
		for(int i = 0; i < vrsta; i++) {
			for(int j = 0; j < kolona; j++) {
				rupe[i][j] = new Rupa(this);
				
				Rupa t = rupe[i][j];
				rupe[i][j].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						System.out.println("Mouse clicked " + e.getX() + ", " + e.getY());
						t.zgazi();
					}
				});
				add(rupe[i][j]);
			}
		}
		//nit.start();
	}
	
	public void setBrojKoraka(int k) {
		brojKoraka = k;
		for(Rupa[] i: rupe)
			for(Rupa j: i)
				j.setBrKoraka(k);
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {
					Random r = new Random();
					int r1 = r.nextInt(vrsta);
					int r2 = r.nextInt(kolona);
					//repaint();
					if(rupe[r1][r2].getSlobodna())
						rupe[r1][r2].setZivotinja(new Krtica(rupe[r1][r2]));
				}
				Thread.sleep(ms);
			}
		} catch(InterruptedException e) {
			//?
		}
	}
	
	public synchronized void pokreni() {	
		nit.start();
		for(int i = 0; i < vrsta; i++) {
			for(int j = 0; j < kolona; j++) {
				rupe[i][j].napraviNit();
				rupe[i][j].pokreni();
			}
		}
	}
	
	public synchronized void zavrsi() { 
		nit.interrupt(); 
		for(int i = 0; i < kolona; i++)
			for(int j = 0 ; j < vrsta; j++)
				if(rupe[i][j].nitPokrenuta())
					rupe[i][j].zavrsi();	
	}
	
}
