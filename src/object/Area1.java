package object;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Area1 extends Shape {
	private int alpha = 30;
	
	public Area1(Point s) {
		this.x = s.x ;
		this.y = s.y ;
		this.endX = s.x ;
		this.endY = s.y ;
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(255, 192, 203, alpha));
		if ( endX > x && endY > y ) {					
			g2d.fillRect(x, y, Math.abs(endX-x), Math.abs(endY-y));
			g2d.setColor(Color.PINK);
			g2d.setStroke(new BasicStroke(2));
			g2d.drawRect(x, y, Math.abs(endX-x), Math.abs(endY-y));
		}else if ( endX < x && endY < y ) {
			g2d.fillRect(endX, endY, Math.abs(x-endX), Math.abs(y-endY));
			g2d.setColor(Color.PINK);
			g2d.setStroke(new BasicStroke(2));
			g2d.drawRect(endX, endY, Math.abs(x-endX), Math.abs(y-endY));
		}else if ( endX > x && endY < y ) {
			g2d.fillRect(x, endY, Math.abs(endX-x), Math.abs(y-endY));
			g2d.setColor(Color.PINK);
			g2d.setStroke(new BasicStroke(2));
			g2d.drawRect(x, endY, Math.abs(endX-x), Math.abs(y-endY));
		}else if ( endX < x && endY > y ) {
			g2d.fillRect(endX, y, Math.abs(x-endX), Math.abs(endY-y));
			g2d.setColor(Color.PINK);
			g2d.setStroke(new BasicStroke(2));
			g2d.drawRect(endX, y, Math.abs(x-endX), Math.abs(endY-y));
		}
	}
	
	public boolean contains(Shape shape) {
		if ( endX > x && endY > y ) {
			if( x<shape.getX() && shape.getA()<endX && y < shape.getY() && shape.getB()<endY ) {
				return true ;	
			}
			else {return false ;}
			
		}else if ( endX < x && endY < y ) {
			if( endX<shape.getX() && shape.getA()<x && endY < shape.getY() && shape.getB()<y ) {
				return true ;	
			}
			else {return false ;}
		}else if ( endX > x && endY < y ) {
			if( x<shape.getX() && shape.getA()<endX && endY < shape.getY() && shape.getB()<y ) {
				return true ;	
			}
			else {return false ;}
		}else if ( endX < x && endY > y ) {
			if( endX<shape.getX() && shape.getA()<x && y < shape.getY() && shape.getB()<endY ) {
				return true ;	
			}
			else {return false ;}
		}else {return false ;}
	}
	
	@Override
	public void showP(Graphics g) {			
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
	public void setObjName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOffect(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getHead(Shape shape, int portnum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTail(Shape shape, int portnum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
