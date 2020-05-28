package igra;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.concurrent.BrokenBarrierException;

@SuppressWarnings("serial")
public class Rupa extends Canvas implements Runnable {
	
	private Color boja;
	private Basta basta;
	private Thread nit;
	private Zivotinja zivotinja;
	private int brKoraka;
	private int trenKorak = 0;
	private boolean slobodna;
	
	public Rupa(Basta b) {
		basta = b;
		boja = new Color(210, 105, 30);
		setBackground(boja);
		slobodna = true;
	}
	
	public boolean getSlobodna() { return slobodna; }
	
	public void setSlobodna(boolean t) { slobodna = t; }
	
	public int getBrKoraka() { return brKoraka; }
	
	public void setBrKoraka(int k) { brKoraka = k; }

	public Zivotinja getZivotinja() { return zivotinja; }

	public void setZivotinja(Zivotinja z) { 
		zivotinja = z; 
		slobodna = (zivotinja == null) ? true : false;
	}
	

	public void zgazi() {
		if(zivotinja != null)
			zivotinja.ispoljiEfekatUdarena();
		slobodna = false;
	}
	
	public boolean nitPokrenuta() { return nit.isAlive(); }

	@Override
	public void run() { 
		try {
			while(!Thread.interrupted()) {
				repaint();
				synchronized(this) {
					if(trenKorak >= brKoraka) {
						trenKorak = 0;
						Thread.sleep(2000);
						zavrsi();
					}
					trenKorak++;
				}
				Thread.sleep(100);
				//System.out.println(trenKorak);
			}
		} catch (InterruptedException e) {}
	}
	
	public synchronized void napraviNit() {
		if(nit != null) {
			nit.interrupt();
			nit = null;
		}
		nit = new Thread(this);
	}
	
	public synchronized void pokreni() {
		nit.start();
	}
	
	public synchronized void zavrsi() { 
		if(nit != null)
			nit.interrupt();
		nit = null;
		setZivotinja(null);
		slobodna = true;
	}
	
	@Override
	public void paint(Graphics g) {
		if(zivotinja != null)
			zivotinja.crtaj(trenKorak);
	}
	
}
