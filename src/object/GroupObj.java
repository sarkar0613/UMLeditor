package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class GroupObj extends Shape {
	private Point northPort, southPort, eastPort, westPort ;
	private Port[] ports = new Port[4] ;
	private int offSet = 5 ;
	
	private List<Shape> groupList = new ArrayList<Shape>();
	private Rectangle bound = new Rectangle();
	private int alpha = 30;; 
	int offset = 10 ;
	public  GroupObj(){
		
	}
	
	

	public void show(Graphics g) {
		setBounds();
		setP();
		g.setColor(new Color(255, 192, 203, alpha));
		g.fillRect(bound.x - offset, bound.y - offset, bound.width + offset * 2, bound.height + offset * 2);
		g.setColor(Color.PINK);
		g.drawRect(bound.x - offset, bound.y - offset, bound.width + offset * 2, bound.height + offset * 2);
		//g.setColor(Color.PINK);
	}
	
	public void addShapes(Shape shape) {
		groupList.add(shape);
	}
	
	public void paint(Graphics g) { 
		for (int i = 0; i < groupList.size(); i++) {
			Shape shape = groupList.get(i);
			shape.paint(g);
		}
	}
	
	public void setBounds() {		
		Point A, B;
		int left = 100000, right = 0;
		int top = 100000, bottom = 0;
		for (int i = 0; i < groupList.size(); i++) {
			Shape shape = groupList.get(i);
			if (shape.getX() < left) {
				left = shape.getX();
			}
			if (shape.getY() < top) {
				top = shape.getY();
			}
			if (shape.getA() > right) {
				right = shape.getA();
			}
			if (shape.getB() > bottom) {
				bottom = shape.getB();
			}
		}
		A = new Point(left, top);
		B = new Point(right, bottom);
		bound.setBounds(A.x, A.y, Math.abs(A.x - B.x),Math.abs(A.y - B.y));
		x = bound.x;
		y = bound.y;
		a = bound.x + bound.width;
		b = bound.y + bound.height;
		northPort = new Point(getX() + bound.width / 2, getY()-offset);
	    southPort = new Point(getX() + bound.width / 2, getY() + bound.height+offset);
	    eastPort = new Point(getX() + bound.width+offset, getY() + bound.height / 2);
	    westPort = new Point(getX()-offset, getY() + bound.height / 2);
	}
	
	public void showP(Graphics g) {
		for(int i = 0; i < ports.length; i++) {
			g.fillRect( ports[i].x, ports[i].y, ports[i].width, ports[i].height );
		}
	}
	
	public void setP( ) {
		Port tempPort = new Port() ;
	    tempPort.setPort(northPort.x, northPort.y, offSet);
	    ports[0] = tempPort ;
	    Port tempPort1 = new Port() ;
	    tempPort1.setPort(southPort.x, southPort.y, offSet);
	    ports[1] = tempPort1 ;
	    Port tempPort2 = new Port() ;
	    tempPort2.setPort(eastPort.x, eastPort.y, offSet);
	    ports[2] = tempPort2 ;
	    Port tempPort3 = new Port() ;
	    tempPort3.setPort(westPort.x, westPort.y, offSet);
	    ports[3] = tempPort3 ;
	}
	
	public List<Shape> getShapeList() {
	    return groupList;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point getNorthPort() {
	    return northPort;
	}
	@Override
	public Point getSouthPort() {
	    return southPort;
	}
	@Override
	public Point getEastPort() {
	    return eastPort;
	}
	@Override
	public Point getWestPort() {
	    return westPort;
	}

	@Override
	public boolean contains(Shape shape) {
		// TODO Auto-generated method stub
		return groupList.contains(shape);
	}

	@Override
	public void setObjName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOffect(int dx, int dy) {
		for (Shape shape : groupList) {
			shape.setOffect(dx, dy);
		}
		setBounds(); // 更新群組的邊界
	}

	@Override
	public void getHead(Shape shape, int portnum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTail(Shape shape, int portnum) {
		// TODO Auto-generated method stub
		
	}

}
