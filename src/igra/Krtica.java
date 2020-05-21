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
	protected void crtaj(Graphics g, int x, int y) {
		g.setColor(Color.DARK_GRAY);
		g.fillOval(x, y, 150, 150);
		
	}
	
	
	
}
