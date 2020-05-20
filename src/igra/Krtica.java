package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Krtica extends Zivotinja {

	public Krtica(Rupa r) {
		super(r);
		
	}

	@Override
	public void ispoljiEfekatUdarena() {
		
	}

	@Override
	public void ispoljiEfekatPobegla() {
		
	}

	@Override
	protected void crtaj(Graphics g) {
		//g.drawOval(10, 10, 10, 10);
		g.setColor(Color.DARK_GRAY);
		g.fillOval(10, 10, 10, 10);
		
	}
	
	
	
}
