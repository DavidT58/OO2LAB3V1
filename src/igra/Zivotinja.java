package igra;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Zivotinja {
	protected Color boja;
	protected Rupa rupa;
	protected boolean udarena;
	
	public Zivotinja(Rupa r) {
		rupa = r;
		udarena = false;
	}
	
	public boolean udarena() { return udarena; }
	
	public abstract void ispoljiEfekatUdarena();
	
	public abstract void ispoljiEfekatPobegla();
	
	protected abstract void crtaj(Graphics g, int x, int y, int sirina, int visina);
}
