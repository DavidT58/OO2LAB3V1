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
	private int interval;
	private int brojKoraka;
	private Thread nit = new Thread(this);
	private int vrsta, kolona;
	private int ms;
	
	public Basta(int v, int k) {
		vrsta = v;
		kolona = k;
		povrce = 100;
		ms = 1000;
		setBackground(Color.GREEN);
		rupe = new Rupa[v][k];
		setLayout(new GridLayout(v, k, 20, 20));
		
		for(int i = 0; i < v; i++) {
			for(int j = 0; j < k; j++) {
				rupe[i][j] = new Rupa(this);
				rupe[i][j].setZivotinja(new Krtica(rupe[i][j]));
				Rupa t = rupe[i][j];
				rupe[i][j].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						System.out.println("Mouse clicked " + e.getX() + ", " + e.getY());
						t.zgazi();
					}
				});
				rupe[i][j].napraviNit();
				rupe[i][j].pokreni();
				add(rupe[i][j]);
			}
		}
		//nit.start();
	}
	
	/*
	@Override
	public void paint(Graphics g) {
		
		for(int i = 0; i < vrsta; i++) {
			for(int j = 0; j < kolona; j++) {
				rupe[i][j].paint(g);
				
			}
		}
		
	}
	*/
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {	
				}
				//repaint();
				Thread.sleep(ms);
			}
		} catch(InterruptedException e) {
			//?
		}
	}
	
	public synchronized void zavrsi() { 
		nit.interrupt(); 
		for(int i = 0; i < kolona; i++)
			for(int j = 0 ; j < vrsta; j++)
				rupe[i][j].zavrsi();
		
		
		//nit = null;
	}
	
}
