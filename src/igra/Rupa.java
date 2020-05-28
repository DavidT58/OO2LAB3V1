package igra;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Rupa extends Canvas implements Runnable {
	
	private Color boja;
	private Basta basta;
	private Thread nit;
	private Zivotinja zivotinja;
	private int korak;
	
	public Rupa(Basta b) {
		basta = b;
		boja = new Color(210, 105, 30);
		setBackground(boja);
	}

	public Zivotinja getZivotinja() { return zivotinja; }

	public void setZivotinja(Zivotinja z) { zivotinja = z; }
	

	public void zgazi() {
		if(zivotinja != null)
			zivotinja.ispoljiEfekatUdarena(); 
	}
	
	public boolean nitPokrenuta() { return nit.isAlive(); }

	@Override
	public void run() { 
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {
					
				}
				repaint();
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {}
	}
	
	public synchronized void napraviNit() {
		nit = new Thread(this);
	}
	
	public synchronized void pokreni() {
		if(nit != null) {
			nit.start();
			korak = 1;
		}
	}
	
	public synchronized void zavrsi() { 
		nit.interrupt();
		nit = null;
	}
	
	@Override
	public void paint(Graphics g) {
		if(zivotinja != null)
			zivotinja.crtaj();
	}
	
}
