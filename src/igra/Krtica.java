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
	public void crtaj() {
		Graphics g = rupa.getGraphics();
		g.setColor(Color.DARK_GRAY);
		g.fillOval(0, 0, rupa.getWidth(), rupa.getHeight());
	}

}
