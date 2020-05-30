package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Krtica extends Zivotinja {

	public Krtica(Rupa r) {
		super(r);
		boja = Color.DARK_GRAY;
	}

	@Override
	public synchronized void ispoljiEfekatUdarena() {
		udarena = true;
		rupa.zaustavi();
	}

	@Override
	public synchronized void ispoljiEfekatPobegla() {
		rupa.zivotinjaEfekatNaBastu();
	}

	@Override
	public void crtaj(int k) {
		Graphics g = rupa.getGraphics();
		g.setColor(Color.DARK_GRAY);
		double procenat = k * 0.1;
		int newWidth = (int)(rupa.getWidth() * procenat);
		int newHeight = (int)(rupa.getHeight() * procenat);
		int newX = rupa.getWidth()/2 - newWidth/2;
		int newY = rupa.getHeight()/2 - newHeight/2;
		g.fillOval(newX, newY, newWidth, newHeight);
		
		
	}
	/*
	 * test
	int newWidth = (int)(rupa.getWidth() * procenat);
	int newHeight = (int)(rupa.getHeight() * procenat);
	int newX = (int)(0.4);
	int newY = (int)(rupa.getY() * procenat);
	*/
}
