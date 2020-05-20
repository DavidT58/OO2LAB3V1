package igra;

import java.awt.Color;

public abstract class Zivotinja {
	protected Color boja;
	protected Rupa rupa;
	
	public Zivotinja(Rupa r) {
		rupa = r;
	}
	
	public abstract void ispoljiEfekatUdarena();
	
	public abstract void ispoljiEfekatPobegla();
}
