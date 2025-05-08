package uml;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import object.GroupObj;
import object.Shape;

public class CanvasDemo extends JPanel {			
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Shape> shapes = new ArrayList<Shape>(); // 所有物件
	private List<Shape> groupList = new ArrayList<Shape>(); // 框選的object
	private List<Shape> group = new ArrayList<Shape>(); // Group的object
	
	private Shape areaShapes = null ; // 劃出的框框
	private Shape selectShapes = null ; // 點選的object
	private Shape selectGroup = null ; // 點選的group
	private static CanvasDemo instance = null;
	public Shape tempLine = null;
	
	public  CanvasDemo(){
		setLayout(new BorderLayout());
		JLabel label = new JLabel("Canvas");
		label.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
		label.setForeground(Color.PINK);
		add(label,BorderLayout.NORTH);		
		setBackground(Color.BLACK);
	}
	
	public void addSelectGroup(Shape shape) {
		this.selectGroup = shape ;
	}
	public Shape getSelectGroup() {
		return this.selectGroup ;
	}
	public void removeSelectGroup() {
		this.selectGroup = null ;
	}
	public void removeGroup(Shape groupShape) {
	    group.remove(groupShape);
	}
	
	public static CanvasDemo getInstance() {
		if (instance == null) {
			instance = new CanvasDemo();
		}
		return instance;
	}
	
	public void addGroup( GroupObj group) {
		this.group.add(group);
	}
	public List<Shape> getGroup() {
		return this.group;
	}
	public void removegroup() {
		groupList.clear();
	}
	
	
	
	
	public void add(Shape shape) {
		this.shapes.add(shape);
	}
	public List<Shape> getShape() {
		return this.shapes;
	}
	
	
	public void addgroupList(Shape shape) {
		this.groupList.add(shape);
	}
	public List<Shape> getgroupList() {
		return this.groupList;
	}
	public void removegroupList() {
		groupList.clear();
	}
	
	/////////////////////////////////
	public void addSelect(Shape shape) {
		this.selectShapes = shape ;
	}
	public void addArea(Shape shape) {
		this.areaShapes = shape ;
	}
	
	public void removeSelect() {
		this.selectShapes = null ;
	}
	public void removeArea() {
		this.areaShapes = null ;
	}
	
	public Shape getSelectShapes() {
		return this.selectShapes;
	}
	public Shape getAreaShapes() {
		return this.areaShapes;
	}
////////////////////////////////////////////////	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g) ;
		for (int i = 0; i < shapes.size(); i++) {
			Shape shape = shapes.get(i);
			shape.paint(g);
		}
		for (int j = 0; j < groupList.size(); j++) {
			Shape shape = groupList.get(j);
			shape.showP(g);
		}
		for (int k = 0; k < group.size(); k++) {
			Shape shape = group.get(k);		
			shape.paint(g);
			shape.show(g);
		}
		if ( selectShapes != null) {
			selectShapes.showP(g) ;		
		}
		if ( areaShapes != null) {
			areaShapes.paint(g) ;		
		}
		if(selectGroup != null) {
			selectGroup.showP(g);
		}
		
	}
	
	
	
		

}


