package uml;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;
import javax.swing.*;

import object.Area1; 
import object.CLine;
import object.ClassObj;
import object.GLine;
import object.Line;
import object.UseCaseObj;
import object.Shape;
import uml.ButtonDemo.Mode;

public class Uml extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private MenuBarDemo menubar ;
	private ButtonDemo button ; 
	private CanvasDemo canvas ;
	private List<Shape> shapes ;
	private List<Shape> tempShapeList ;
	private List<Shape> group ;
	private Shape tempShape ;
	private Shape tempLine ;
	private Shape tempArea ;
	boolean isLineMode = false, isSelect = false, hasRun = false, selectDrag = false ;
	private Point begin, end ;
	public int nowX ;
	public int nowY ;
	public int portNum ;
	private Shape selectGroup = null;
	
	public Uml() {
		canvas = CanvasDemo.getInstance();
		menubar = new MenuBarDemo();
		button = new ButtonDemo();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(menubar, BorderLayout.NORTH);
		getContentPane().add(button, BorderLayout.WEST);
		getContentPane().add(canvas, BorderLayout.CENTER);
		canvas.addMouseListener(new CanvasMouseListener());
		canvas.addMouseMotionListener(new CanvasMouseMotionListener());	
		
	}
	
	public class CanvasMouseListener extends MouseAdapter {

        @Override
        public void mouseReleased(MouseEvent e) {
        	//System.out.print("Release\n");
        	shapes = canvas.getShape();
        	if ( isLineMode ) {  
        		for (int i = 0; i < shapes.size(); i++) {
        			if ( shapes.get(i).isPointInside(e.getX(), e.getY())) {  //release on object and set line on it
        				end = getClosestPort(shapes.get(i), e.getX(), e.getY());
        				portNum = getPortNum(shapes.get(i), e.getX(), e.getY());
        				tempLine = shapes.get(shapes.size()-1) ;        				
        				tempLine.getTail(shapes.get(i),portNum) ;       				
                		tempLine.setEndPoint1(end);
        				canvas.repaint();
        				isLineMode = false ;
        			} // if
        		} // for    		
        		if (isLineMode) {   // released on canvas
    				shapes.remove(shapes.size()-1) ;
    				canvas.repaint();
    				isLineMode = false ;
    			} // if
        		isLineMode = false ;
        	} // if
        	/*
        	else if ( isSelect && tempArea!= null  ) {
        		canvas.removeArea() ;
				canvas.repaint();
				isSelect = false ;        		
        	}
        	*/
        	else if (isSelect && tempArea != null) {
        	    canvas.removegroupList(); // 先清空前一次選取
        	    Area1 area = (Area1) tempArea;

        	    for (Shape s : shapes) {
        	        if (area.contains(s)) {
        	            canvas.addgroupList(s); // 加入選取清單
        	        }
        	    }
        	    
        	    if (canvas.getgroupList().isEmpty()) {
        	        for (Shape s : shapes) {
        	            //s.setSelected(false);  // 或對每個物件做 unselect 操作
        	        }
        	    }

        	    canvas.removeArea(); // 清除框選範圍
        	    canvas.repaint();
        	    isSelect = false;
        	}
        	selectDrag = false ;
        } // Released
        
        @Override
        public void mousePressed(MouseEvent e) {
        	//System.out.print("press\n");
        	shapes = canvas.getShape();
        
        	
            if ( button.getMode() == Mode.ASSOCIATION ) {     	
            	for (int i = 0; i < shapes.size(); i++) {
            		if ( shapes.get(i).isPointInside(e.getX(), e.getY())) {
            			isLineMode = true ;
            			begin = getClosestPort(shapes.get(i), e.getX(), e.getY());
            			
            			portNum = getPortNum(shapes.get(i), e.getX(), e.getY());         			
            			Line line = new Line(begin);
            			line.getHead(shapes.get(i),portNum);
            			
            			canvas.add(line); 
            		} // if	
            	} // for
            } // if
            else if ( button.getMode() == Mode.GENERALIZATION ) {     	
            	for (int i = 0; i < shapes.size(); i++) {
            		if ( shapes.get(i).isPointInside(e.getX(), e.getY())) {
            			isLineMode = true ;
            			begin = getClosestPort(shapes.get(i), e.getX(), e.getY());
            			
            			portNum = getPortNum(shapes.get(i), e.getX(), e.getY()); 
            			GLine line = new GLine(begin);
            			line.getHead(shapes.get(i),portNum);
            			
            			canvas.add(line); 
            		} // if	
            	} // for
            } // if
            else if ( button.getMode() == Mode.COMPOSITION ) {     	
            	for (int i = 0; i < shapes.size(); i++) {
            		if ( shapes.get(i).isPointInside(e.getX(), e.getY())) {
            			isLineMode = true ;
            			begin = getClosestPort(shapes.get(i), e.getX(), e.getY());
            			portNum = getPortNum(shapes.get(i), e.getX(), e.getY()); 
            			CLine line = new CLine(begin);
            			line.getHead(shapes.get(i),portNum);
            			canvas.add(line); 
            		} // if	
            	} // for
            } // if
            
            else if ( button.getMode() == Mode.CLASS ) {
            	ClassObj classObj = new ClassObj(e.getX(), e.getY());          	 
            	canvas.add(classObj);
            	canvas.repaint();
            } else if ( button.getMode() == Mode.USECASE) {
            	UseCaseObj useCase = new UseCaseObj(e.getX(), e.getY());
            	canvas.add(useCase);
            	canvas.repaint();
            } else if ( button.getMode() == Mode.SELECT ) {
            	nowX = e.getX();
            	nowY = e.getY();
            	isSelect = true ;
            	if ( !isOnObj(e.getX(), e.getY()) ) {  // 點擊空白的地方 取消被select的物件
            		tempShape = canvas.getSelectShapes() ;
            		tempShapeList = canvas.getgroupList();
            		if ( tempShape != null && !hasRun ) {           		
                		canvas.removeSelect() ;          
                		canvas.repaint() ;
                	}else if(tempShapeList != null) {
                		canvas.removegroupList();
                	}
            		// 準備畫Area
            		begin = getPort(e.getX(), e.getY());                	
                	Area1 area = new Area1(begin);
                	canvas.addArea(area); 
            	}
            	else {  // 點擊物件 show出4個Port
            		for (int i = 0; i < shapes.size(); i++) {        		
            			if ( shapes.get(i).isPointInside(e.getX(), e.getY())) {
            				tempShape = shapes.get(i) ;
            				canvas.removegroupList();
            				canvas.addSelect(tempShape) ;
            				canvas.repaint() ;
            				hasRun = true ;
            				selectDrag = true ;
            			} // if       			       			
            		} // for
            	} // else            	
            	hasRun = false ;
            	group = canvas.getGroup();
            	if( group!=null && isOnGroup(e.getX(), e.getY()) ) {
            		for (int i = 0; i < group.size(); i++) {        		
            			if ( group.get(i).isPointInside(e.getX(), e.getY())) {
            				tempShape = group.get(i) ;
            				canvas.removegroupList();
            				canvas.addSelectGroup(tempShape) ;
            				canvas.repaint() ;
            			}
            		}
            	}
            } // else if
            
        } // Pressed()        

	} // CanvasMouseListener()
	
    public class CanvasMouseMotionListener extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            shapes = canvas.getShape();       	
            tempShape = canvas.getSelectShapes();
            selectGroup = canvas.getSelectGroup();
            int offectX = nowX-e.getX();
            int offectY = nowY-e.getY();
            nowX = e.getX();
            nowY = e.getY();
            
            if (isLineMode) {  //畫線
                tempLine = shapes.get(shapes.size()-1);
                tempLine.setEndPoint(e.getX(), e.getY());
                canvas.repaint();
            }
            else if (isSelect && !selectDrag) { // 畫Area
                tempArea = canvas.getAreaShapes();
                tempArea.setEndPoint(e.getX(), e.getY());
                canvas.repaint();
                InArea(tempArea);
            }
            else if (isSelect && tempShape != null) { // 移動單個物件
                tempShape.setOffect(offectX, offectY);
                canvas.repaint();
            }
            else if (isSelect && selectGroup != null) { // 移動群組
                selectGroup.setOffect(offectX, offectY);
                canvas.repaint();
            }
        } // mouseDragged()
        
    } // CanvasMouseMotionListener
    public void InArea(Shape area) {
    	shapes = canvas.getShape();
    	for (int i = 0 ; i < shapes.size(); i++) {
    		if ( area.contains(shapes.get(i)) ) {
    			tempShape = shapes.get(i) ;
    			canvas.addgroupList(tempShape);  			
    			canvas.repaint() ;  		
    		}
    	}
    	
    	// 滑鼠框到某obj不放開，接著又沒框到某obj，則selected狀態應該取消
    	tempShapeList = canvas.getgroupList(); 
    	for (int i = 0 ; i < tempShapeList.size(); i++) {
    		if ( !area.contains(tempShapeList.get(i)) ) {   			
    			tempShapeList.remove(i);  			
    			canvas.repaint() ;  		
    		}
    	}   	
	}
    
    public boolean isOnObj(int x, int y) {
    	boolean has = false ;
    	shapes = canvas.getShape();
    	for (int i = 0; i < shapes.size(); i++) {
    		if ( shapes.get(i).isPointInside(x, y) ) {
    			has = true ;
    		}
    	}
    	return has ;
    }
    public boolean isOnGroup(int x, int y) {
    	boolean has = false ;
    	group = canvas.getGroup();
    	for (int i = 0; i < group.size(); i++) {
    		if ( group.get(i).isPointInside(x, y) ) {
    			has = true ;
    		}
    	}
    	return has ;
    }
    
    public Point getPort(int x, int y) {
    	Point start = new Point();
    	start.x = x ;
    	start.y = y ;
    	return start ;
    }
   
    public Point getClosestPort(Shape shape, int x, int y) {
        
        Point north = shape.getNorthPort();
        Point south = shape.getSouthPort();
        Point west = shape.getWestPort();
        Point east = shape.getEastPort();      
        // 找出距離最短的端點
        Point closest = north;
        double minDistance = distance(north, x, y);
        double distance;
        
        distance = distance(south, x, y);
        if (distance < minDistance) {
            closest = south;
            minDistance = distance;
        }
        
        distance = distance(west, x, y);
        if (distance < minDistance) {
            closest = west;
            minDistance = distance;
        }
        
        distance = distance(east, x, y);
        if (distance < minDistance) {
            closest = east;
            minDistance = distance;
        }      
        return closest;
    }
    
    public int getPortNum(Shape shape, int x, int y) {
        
        Point north = shape.getNorthPort();
        Point south = shape.getSouthPort();
        Point west = shape.getWestPort();
        Point east = shape.getEastPort();      
        // 找出距離最短的端點
        int  closest = 0;
        double minDistance = distance(north, x, y);
        double distance;
        
        distance = distance(south, x, y);
        if (distance < minDistance) {
            closest = 1;
            minDistance = distance;
        }
        
        distance = distance(west, x, y);
        if (distance < minDistance) {
            closest = 2;
            minDistance = distance;
        }
        
        distance = distance(east, x, y);
        if (distance < minDistance) {
            closest = 3;
            minDistance = distance;
        }      
        return closest;
    }

    private double distance(Point p, int x, int y) {
        int dx = p.x - x;
        int dy = p.y - y;
        return Math.sqrt(dx*dx + dy*dy);
    }
     
	public static void main(String[] args) {
		Uml window = new Uml();					
		window.setName("UMLeditor");
		window.setSize(1000, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		window.setLocationRelativeTo(null);      
		window.setVisible(true);				
	}

}
