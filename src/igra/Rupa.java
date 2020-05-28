package igra;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

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
		//slobodna = true; ???
	}
	
	public boolean nitPokrenuta() {
		boolean ret = (nit != null) ? nit.isAlive() : false;
		return ret;
	}

	@Override
	public void run() { 
		try {
			while(!Thread.interrupted()) {
				repaint();
				synchronized(this) {
					
				}
				if(trenKorak >= brKoraka) {
					trenKorak = 0;
					Thread.sleep(2000);
					zaustavi();
				}
				trenKorak++;
				Thread.sleep(100);
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
	
	public synchronized void zaustavi() { 
		if(nit != null)
			nit.interrupt();
		nit = null;
		if(zivotinja != null && !zivotinja.udarena()) {
			zivotinja.ispoljiEfekatPobegla();
			basta.smanjiPovrce();
		}
		setZivotinja(null);
		slobodna = true;
	}
	
	@Override
	public void paint(Graphics g) {
		if(zivotinja != null)
			zivotinja.crtaj(trenKorak);
	}
	
}
