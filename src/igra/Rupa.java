package igra;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Rupa extends Canvas implements Runnable {
	
	private Color boja;
	private Basta basta;
	private Thread nit = new Thread(this);
	private boolean radi = false;
	private Zivotinja zivotinja;
	private int ms;
	public int x, y;
	
	public Rupa(Basta b, int x, int y) {
		basta = b;
		ms=500;
		boja = new Color(210, 105, 30);
		this.x = x;
		this.y = y;
	}

	public Zivotinja getZivotinja() { return zivotinja; }

	public void setZivotinja(Zivotinja z) { zivotinja = z; }
	
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
	
	public void zavrsi() { nit.interrupt(); }
	
	@Override
	public void paint(Graphics g) {
		
		g.setColor(boja);
		g.fillRect(x, y, 150, 150);
		setZivotinja(new Krtica(this));
		if(zivotinja != null)
			zivotinja.crtaj(g, x, y);
			
	}
}
