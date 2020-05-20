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
	
	public Basta(int v, int k) {
		povrce = 100;
		matrica = new Rupa[v][k];
		for(int i = 0; i < v; i++)
			for(int j = 0; j < k; j++) {
				matrica[i][j] = new Rupa(this);
				matrica[i][j].kreni();
			}
				
		nit.start();
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(0,255,0));
	}
	
	@Override
	public void run() {
		
		
	}
	
	public void zavrsi() { nit.interrupt(); }
	
	public static void main(String[] args) {
		Basta t = new Basta(4,4);
	}

}
