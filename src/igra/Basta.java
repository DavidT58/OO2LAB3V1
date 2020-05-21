package igra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

@SuppressWarnings("serial")
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
				matrica[i][j].setX(j*150 + j*20 + 20);
				matrica[i][j].setY(i*150 + i*20 + 20);
			}
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(0,255,0));
		g.fillRect(0, 0, 700, 700);
		for(int i = 0; i < kolona; i++)
			for(int j = 0; j < vrsta; j++) {
				matrica[i][j].crtaj(g, matrica[i][j].getX(), matrica[i][j].getY());
			}
	}
	
	@Override
	public void run() {
		
	}
	
	public void zavrsi() { nit.interrupt(); }
	
	/*
	public static void main(String[] args) {
		Basta t = new Basta(4,4);
	}
	*/

}
