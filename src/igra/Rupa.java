package igra;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Rupa extends Canvas implements Runnable {
	
	private Basta basta;
	private Thread nit = new Thread(this);
	private Zivotinja zivotinja;
	
	public Rupa(Basta b) {
		basta = b;
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
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(210, 105, 30));
		g.fillRect(10, 10, 10, 10);
		g.setColor(Color.BLACK);
	}
}
