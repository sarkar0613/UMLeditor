package object;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;


public class ClassObj extends Shape  {
	private Point northPort, southPort, eastPort, westPort ;
	private Port[] ports = new Port[4] ;
	private int offSet = 5 ;
	public int width = 100 ;
	public int height = 120 ;
	int oneThree = height / 3 ;
	int stringLength ;
	double space ;
	String objName = "OBJName" ;	
	Font font = new Font(Font.SERIF, Font.BOLD, 12);	

	public  ClassObj(int x, int y){
		super();
		this.x = x ;
		this.y = y ;
		this.a = x + width;
		this.b = y + height;
		northPort = new Point(getX() + getWidth() / 2, getY());
	    southPort = new Point(getX() + getWidth() / 2, getY() + getHeight());
	    eastPort = new Point(getX() + getWidth(), getY() + getHeight() / 2);
	    westPort = new Point(getX(), getY() + getHeight() / 2);
	    setP();    
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(4));
		g2d.setColor(Color.PINK);
		g2d.drawRect(x, y, width, height);		
		g2d.drawLine(x, y + oneThree, a, b - oneThree * 2);
		g2d.drawLine(x, y + oneThree * 2, a, b - oneThree);	
		stringLength = g2d.getFontMetrics(font).stringWidth(objName);
		space = (100 - stringLength)/2;
		g2d.setFont(font);	
		g2d.drawString(objName, x + (int)space, y + 24);
	}
	
	public int getWidth() {
		return width ;
	}
	public int getHeight() {
		return height ;
	}	
	public Point getNorthPort() {
		return northPort ;
	}
	public Point getSouthPort() {
		return southPort ;
	}
	public Point getEastPort() {
		return eastPort ;
	}
	public Point getWestPort() {
		return westPort ;
	}
	
	
	// Port section
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

	@Override
	public boolean contains(Shape shape) {		
		return false;
	}
	public void setObjName(String name) {
	    this.objName = name;
	}
	public void setOffect( int x, int y ) {
		this.x = this.x - x;
		this.y = this.y - y;
		this.a = this.x + width;
		this.b = this.y + height;
		northPort = new Point(getX() + getWidth() / 2, getY());
	    southPort = new Point(getX() + getWidth() / 2, getY() + getHeight());
	    eastPort = new Point(getX() + getWidth(), getY() + getHeight() / 2);
	    westPort = new Point(getX(), getY() + getHeight() / 2);
	    setP();
	    
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
