package uml;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonDemo extends JPanel{   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton selectBtn, assocBtn, genBtn, compBtn, classBtn, useCaseBtn;
	public enum Mode {SELECT, ASSOCIATION, GENERALIZATION, COMPOSITION, CLASS, USECASE};
	private Mode currentMode ;
    
    public ButtonDemo() {
        // create buttons
        selectBtn = new JButton(new ImageIcon("image/select1.png"));
        assocBtn = new JButton(new ImageIcon("image/association1.png"));
        genBtn = new JButton(new ImageIcon("image/generalization1.png"));
        compBtn = new JButton(new ImageIcon("image/composition1.png"));
        classBtn = new JButton(new ImageIcon("image/class1.png"));
        useCaseBtn = new JButton(new ImageIcon("image/usecase1.png"));
        
        selectBtn.setBackground(Color.BLACK);
        assocBtn.setBackground(Color.BLACK);
        genBtn.setBackground(Color.BLACK);
        compBtn.setBackground(Color.BLACK);
        classBtn.setBackground(Color.BLACK);
        useCaseBtn.setBackground(Color.BLACK);
        
        // add action listeners to buttons
        selectBtn.addActionListener(new buttonListenerselect());
        assocBtn.addActionListener(new buttonListenerAssociation());
        genBtn.addActionListener(new buttonListenerGeneralization());
        compBtn.addActionListener(new buttonListenerComposition());
        classBtn.addActionListener(new buttonListenerClass());
        useCaseBtn.addActionListener(new buttonListenerUseCase());
           
        setLayout(new GridLayout(6, 1));
        add(selectBtn);
        add(assocBtn);
        add(genBtn);
        add(compBtn);
        add(classBtn);
        add(useCaseBtn);               
    }
       
    
    class buttonListenerClass implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		currentMode = Mode.CLASS;
    		setButtonSelected(classBtn);
    	}
    }
    class buttonListenerUseCase implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		currentMode = Mode.USECASE;
    		setButtonSelected(useCaseBtn);
    	}
    }
    
    class buttonListenerComposition implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		currentMode = Mode.COMPOSITION;
    		setButtonSelected(compBtn);
    	}
    }
    class buttonListenerGeneralization implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		currentMode = Mode.GENERALIZATION;
    		setButtonSelected(genBtn);
    	}
    }
    class buttonListenerAssociation implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		currentMode = Mode.ASSOCIATION;
    		setButtonSelected(assocBtn);
    	}
    }
    class buttonListenerselect implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		currentMode = Mode.SELECT;
    		setButtonSelected(selectBtn);
    	}
    }  
	public Mode getMode() {
		return currentMode ;
	}
	
	private void setButtonSelected(JButton button) {
		selectBtn.setBackground(Color.BLACK);
		assocBtn.setBackground(Color.BLACK);
		genBtn.setBackground(Color.BLACK);
		compBtn.setBackground(Color.BLACK);
		classBtn.setBackground(Color.BLACK);
        useCaseBtn.setBackground(Color.BLACK);
        button.setBackground(Color.PINK);
    }                

}
