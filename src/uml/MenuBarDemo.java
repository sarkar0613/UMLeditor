package uml;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import object.GroupObj;
import object.Shape;


public class MenuBarDemo extends JMenuBar{   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CanvasDemo canvas ;
	public String new_name ;
	private Shape tempShape ;
	//private Shape tempSelectGroup ;
	private List<Shape> tempShapeList ;
	
	public MenuBarDemo()  {
		canvas = CanvasDemo.getInstance();
        JMenuItem item1, item2, item3;
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        add(file);
        add(edit);   
        item1 = new JMenuItem("Group");
        item2 = new JMenuItem("Ungroup");
        item3 = new JMenuItem("Change Object Name");
        edit.add(item1);
        edit.add(item2);
        edit.add(item3);
        
        item1.addActionListener(new MenuListenerGroup());
        item2.addActionListener(new MenuListenerUnGroup());
        item3.addActionListener(new MenuListenerChangeName());
        
                 
    }
	class MenuListenerChangeName implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		new_name = JOptionPane.showInputDialog(canvas, "Enter New Name !");
    		tempShape = canvas.getSelectShapes() ;		
    		if(tempShape != null && new_name != null && !new_name.trim().isEmpty()) {
    			tempShape.setObjName(new_name);
    			canvas.repaint();
    		}
    		
    	}
    }
	
	/*
	class MenuListenerGroup implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		tempShapeList = canvas.getgroupList() ;
    		GroupObj group = new GroupObj() ;
    		System.out.print(tempShapeList.size());
    		if(tempShapeList != null) {
    			for (int i = 0; i < tempShapeList.size(); i++) {
    				group.addShapes(tempShapeList.get(i));
    				canvas.addGroup(group);
    				canvas.repaint();
    			}
    			
    		}	
    	}
    }
    */
	
	class MenuListenerGroup implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        tempShapeList = canvas.getgroupList();
	        if (tempShapeList != null && tempShapeList.size() > 1) {
	            GroupObj group = new GroupObj();
	            for (Shape shape : tempShapeList) {
	                group.addShapes(shape);
	            }
	            canvas.addGroup(group);  // 只呼叫一次
	            canvas.removegroupList(); // 清空選取狀態
	            canvas.repaint();
	        }
	    }
	}
	class MenuListenerUnGroup implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        Shape selected = canvas.getSelectGroup();
	        if (selected instanceof GroupObj) {
	            GroupObj group = (GroupObj) selected;
	            List<Shape> members = group.getShapeList();
	            for (Shape s : members) {
	                canvas.add(s); // 加回個別 shape
	            }
	            canvas.removeGroup(group); // 從 group 移除
	            canvas.removeSelectGroup(); // 清除選取狀態
	            canvas.repaint();
	        }
	    }
	}
	/*
	class MenuListenerUnGroup implements ActionListener{
		public void actionPerformed(ActionEvent e){	
			tempShapeList = canvas.getGroup() ;
			if(tempShapeList != null) {
				tempShapeList.clear();
				canvas.removeSelectGroup();
				canvas.repaint();
			}
		}
		
	}
	*/
	
}
