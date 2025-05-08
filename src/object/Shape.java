package object;

import java.awt.Graphics;
//import java.awt.Point;
import java.awt.Point;

public abstract class Shape {
	protected int x, y, a, b, endX, endY;	

	public int getX() {
		return x ;
	}
	public int getY() {
		return y ;
	}
	public int getA() {
		return a ;
	}
	public int getB() {
		return b ;
	}
	public int getendX() {
		return endX ;
	}
	public int getendY() {
		return endY ;
	}
	
	public abstract void paint(Graphics g);
	public abstract void showP(Graphics g);
	public abstract void show(Graphics g);
	public abstract int getWidth();	
	public abstract int getHeight();
	public abstract Point getNorthPort();
	public abstract Point getSouthPort();
	public abstract Point getWestPort();
	public abstract Point getEastPort();
	public abstract boolean contains(Shape shape);
	public abstract void setObjName(String name);
	public abstract void setOffect( int x, int y );
	
	public abstract void getHead( Shape shape,int portnum ) ;
	public abstract void getTail( Shape shape,int portnum ) ;
	
	public boolean isPointInside(int pointX, int pointY) {
	    return (pointX >= x && pointX <= a && pointY >= y && pointY <= b);
	}
	
	public void setEndPoint(int endX, int endY) {
		this.endX = endX ;
		this.endY = endY ;		
	}
	public void setEndPoint1(Point e) {
		this.endX = e.x ;
		this.endY = e.y ;		
	}
	
	

}
