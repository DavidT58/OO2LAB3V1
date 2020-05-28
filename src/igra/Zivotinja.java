package igra;

import java.awt.Color;

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
	
	public abstract void crtaj(int k);
}
