package igra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

public class Basta extends Panel implements Runnable {
	
	private Rupa[][] matrica;
	private int povrce;
	private int interval;
	private int brojKoraka;
	private Thread nit = new Thread(this);
	private int vrsta, kolona;
	
	public Basta(int v, int k) {
		vrsta = v;
		kolona = k;
		povrce = 100;
		matrica = new Rupa[v][k];
		for(int i = 0; i < v; i++)
			for(int j = 0; j < k; j++) {
				matrica[i][j] = new Rupa(this);
				//matrica[i][j].kreni();
			}
				
		//nit.start();
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(0,255,0));
		g.fillRect(10, 10, 500, 500);
		//g.drawRect(10, 10, 100, 100);
		for(int i = 0; i < kolona; i++)
			for(int j = 0; j < vrsta; j++) {
				matrica[i][j].paint(g);
				
			}
	}
	
	@Override
	public void run() {
		
	}
	
	public void zavrsi() { nit.interrupt(); }
	
	public static void main(String[] args) {
		Basta t = new Basta(4,4);
	}

}
