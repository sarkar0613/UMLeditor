package object;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Line extends Shape {
	Shape Hobj ;
	Shape Tobj ;
	int port1 ;
	int port2 ;
	Point point1 ;
	Point point2 ;
	
	public Line(Point b){
		this.x = b.x ;
		this.y = b.y ;
		this.endX = b.x ;
		this.endY = b.y ;
	}
	
	@Override
	public void paint(Graphics g) {		
		setPort() ;
		this.x = point1.x ;
		this.y = point1.y ;
		if(point2 != null) {
			this.endX = point2.x ;
			this.endY = point2.y ;
		}
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.PINK);
		g2d.setStroke(new BasicStroke(4));
		g2d.drawLine(x, y, endX, endY);
	}
	
	@Override
	public int getWidth() {
		return 0;
	}
	@Override
	public int getHeight() {
		return 0;
	}
	@Override
	public Point getNorthPort() {
		return null;
	}
	@Override
	public Point getSouthPort() {
		return null;
	}
	@Override
	public Point getWestPort() {
		return null;
	}
	@Override
	public Point getEastPort() {
		return null;
	}

	@Override
	public void showP(Graphics g) {
		
	}

	@Override
	public boolean contains(Shape shape) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setObjName(String name) {
		// TODO Auto-generated method stub	
	}


	public void getHead( Shape shape,int portnum ) {
		Hobj = shape ;
		port1 = portnum ;
	}
	public void getTail( Shape shape,int portnum ) {
		Tobj = shape ;
		port2 = portnum ;
	}
	public void setPort() {
		if(Hobj !=null) {
			if(port1 == 0) {
				point1 = Hobj.getNorthPort() ;
			}
			if(port1 == 1) {
				point1 = Hobj.getSouthPort() ;
			}
			if(port1 == 2) {
				point1 = Hobj.getWestPort() ;
			}
			if(port1 == 3) {
				point1 = Hobj.getEastPort() ;
			}
		}
		if(Tobj !=null) {
			if(port2 == 0) {
				point2 = Tobj.getNorthPort() ;
			}
			if(port2 == 1) {
				point2 = Tobj.getSouthPort() ;
			}
			if(port2 == 2) {
				point2 = Tobj.getWestPort() ;
			}
			if(port2 == 3) {
				point2 = Tobj.getEastPort() ;
			}
		}
		
	}

	@Override
	public void setOffect(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
