package igra;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Mouse clicked " + e.getX() + ", " + e.getY());
				zgazi();
			}
		});
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
	
	public synchronized void zgazi() {
		if(zivotinja != null)
			zivotinja.ispoljiEfekatUdarena();
	}
	
	public boolean nitPokrenuta() {
		boolean ret = (nit != null) ? nit.isAlive() : false;
		return ret;
	}

	@Override
	public void run() { 
		try {
			while(!Thread.interrupted()) {
				//
				synchronized(this) {
					trenKorak++;
					repaint();
					if(trenKorak >= brKoraka) {
						Thread.sleep(2000);
						zaustavi();
						repaint();
					}
				}
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
	
	public void zivotinjaEfekatNaBastu() {
		basta.smanjiPovrce();
	}
	
	public synchronized void zaustavi() { 
		if(nit != null)
			nit.interrupt();
		nit = null;
		if(zivotinja != null && !zivotinja.udarena()) {
			zivotinja.ispoljiEfekatPobegla();
		}
		setZivotinja(null);
		slobodna = true;
		trenKorak = 0;
	}
	
	@Override
	public void paint(Graphics g) {
		if(zivotinja != null)
			zivotinja.crtaj(trenKorak);
	}
	
}
