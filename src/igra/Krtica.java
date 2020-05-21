package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Krtica extends Zivotinja {

	public Krtica(Rupa r) {
		super(r);
		boja = Color.DARK_GRAY;
	}

	@Override
	public void ispoljiEfekatUdarena() {
		
	}

	@Override
	public void ispoljiEfekatPobegla() {
		
	}

	@Override
	protected void crtaj(Graphics g, int x, int y, int sirina, int visina) {
		g.setColor(Color.DARK_GRAY);
		g.fillOval(x*sirina + sirina/2, y*visina + visina/2, sirina, visina);
		
	}
	
	
	
}
