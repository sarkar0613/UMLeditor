package object;

import java.awt.Rectangle;



public class Port extends Rectangle {		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public void setPort(int pX, int pY, int offSet) {
		int x = pX - offSet;
		int y = pY - offSet;
		int w = offSet * 2;
		int h = offSet * 2;
		setBounds(x, y, w, h);
	}

}
