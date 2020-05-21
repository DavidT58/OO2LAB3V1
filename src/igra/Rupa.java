package igra;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Rupa extends Canvas implements Runnable {
	
	private Color boja;
	private Basta basta;
	private Thread nit = new Thread(this);
	private boolean radi = false;
	private Zivotinja zivotinja;
	private int ms;
	public int x, y;
	private int brojKoraka;
	private int visina, sirina;
	
	public Rupa(Basta b) {
		basta = b;
		ms=500;
		boja = new Color(210, 105, 30);
		setZivotinja(new Krtica(this));
		sirina = visina = 150;
	}

	public int getX() { return x; }

	public void setX(int x) { this.x = x; }

	public int getY() { return y; }

	public void setY(int y) { this.y = y; }

	public Zivotinja getZivotinja() { return zivotinja; }

	public void setZivotinja(Zivotinja z) { zivotinja = z; }
	
	public int getBrojKoraka() { return brojKoraka; }

	public void setBrojKoraka(int brojKoraka) { this.brojKoraka = brojKoraka; }

	public void zgazi() {
		if(zivotinja != null)
			zivotinja.ispoljiEfekatUdarena(); 
	}
	
	public boolean nitPokrenuta() { return nit.isAlive(); }
	
	public synchronized void postaviNivo(int ms) { this.ms = ms; }

	@Override
	public void run() { 
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {
					while(!radi) wait();
				}
				Thread.sleep(ms);
				repaint();
			}
		}
		catch(InterruptedException e) {}
	}
	
	public synchronized void kreni() {
		repaint();
		radi = true;
		notify();
	}
	
	public synchronized void stani() { radi = false; }
	
	public void zavrsi() { 
		if(!zivotinja.udarena) {
			zivotinja.ispoljiEfekatPobegla();
		}
		zivotinja = null;
		
		nit.interrupt(); 
	}
	
	
	public void crtaj(Graphics g, int x, int y) {
		g.setColor(boja);
		g.fillRect(x, y, sirina, visina);
		
		if(zivotinja != null)
			zivotinja.crtaj(g, x, y, (int)(sirina * 0.5), (int)(visina * 0.5));
			
	}
}
