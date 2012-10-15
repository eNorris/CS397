package gui;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Core extends JPanel{

	private static final long serialVersionUID = -5499945898085501882L;

	public Core(){
		setLayout(new BorderLayout());
		
		add(new FileTree(), BorderLayout.WEST);
		add(new Wall(), BorderLayout.CENTER);
	}
	
	public void paint(Graphics g){
		super.paint(g);
	}
	
}
