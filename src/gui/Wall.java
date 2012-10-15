package gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import dataContainers.AudioFile;
import dataContainers.GraphicFile;
import dataContainers.MediaFile;
import dataContainers.MediaLibrary;


public class Wall extends JPanel{

	private static final long serialVersionUID = -5495354692927105826L;
	MediaLibrary currentLib = new MediaLibrary();
	
	private boolean m_moving = false;
	private int m_x = 0;
	private int m_y = 0;
	private int m_lx = 0;
	private int m_ly = 0;

	Wall(){
		setBackground(Color.BLUE);
		
		final JPanel m_self = this;
		
		for(int i = 0; i < 5; i++){
			MediaFile next = new MediaFile("library/doc2.txt", "graphics/thumb1.bmp");
			AudioFile next2 = new AudioFile("library/test.mp3", "graphics/musicthumb.bmp");
			GraphicFile next3 = new GraphicFile("library/testpic.png", "graphics/picthumb.bmp");
			currentLib.add(next);
			currentLib.add(next2);
			currentLib.add(next3);
		}
		
		addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// left button => consum
				// middle button => do nothing
				// right button => pass to the lower level
				
				if(arg0.getButton() == MouseEvent.BUTTON1){
					// left click => consum
//System.out.print("wall consumed\n");
					m_moving = true;
					m_lx = arg0.getX();
					m_ly = arg0.getY();
				}else if(arg0.getButton() == MouseEvent.BUTTON2){
					// midle click => do nothing
//System.out.print("middle click");
				}else{
					// right click => pass on to the next level
					
					for(int i = 0; i < currentLib.size(); i++){
//System.out.print("checkingi = " + i + "\n");
//System.out.print("x = " + arg0.getX() + "  y = " + arg0.getY() + "   bounds = " + currentLib.get(i).getBounds().toString() + "\n");
						if( currentLib.get(i).isInBounds(arg0.getX(), arg0.getY())){
//								arg0.getX() > currentLib.get(i).getBounds().x && 
//								arg0.getX() <= currentLib.get(i).getBounds().x + currentLib.get(i).getBounds().width &&
//								arg0.getY() > currentLib.get(i).getBounds().y && 
//								arg0.getY() <= currentLib.get(i).getBounds().y + currentLib.get(i).getBounds().height){
//System.out.print("match found\n");
							currentLib.get(i).popUp(m_self, arg0.getX(), arg0.getY());
						}
					}
					
					Component redirectTo = SwingUtilities.getDeepestComponentAt(m_self, arg0.getX(), arg0.getY());
					if(redirectTo != null){
//System.out.print("redirect => file\n");
//						arg0 = SwingUtilities.convertMouseEvent(m_self, arg0, redirectTo);
//						java.awt.Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(arg0);
					}
//					Component redirectTo = SwingUtilities.getDeepestComponentAt(panel, e.getX(), e.getY());
//	                if (e.getID() == MouseEvent.MOUSE_PRESSED) {
//	                    lastPressed = redirectTo;
//	                } else if (e.getID() == MouseEvent.MOUSE_DRAGGED || e.getID() == MouseEvent.MOUSE_RELEASED) {
//	                    redirectTo = lastPressed;
//	                }
//	                if (redirectTo != null) {
//	                    lastMouseX = e.getX();
//	                    lastMouseY = e.getY();
//	                    panel.repaint(); //this line is just to update the glass pane
//	                    e = SwingUtilities.convertMouseEvent(panel, e, redirectTo);
//	                    java.awt.Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(e);
//	                }

					
					
				}

			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				m_moving = false;
			}
		});
		
		
		addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent arg0) {
				if(m_moving){
					m_x += arg0.getX() - m_lx;
					m_y += arg0.getY() - m_ly;
					
					// FIXME - replace this and m_x with a Util.XX
					MediaFile.worldShiftX = m_x;
					MediaFile.worldShiftY = m_y;
					
					m_lx = arg0.getX();
					m_ly = arg0.getY();
		//			m_lx = m_x;
		//			m_ly = m_y;
					repaint();
				}
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
			}
		});
		
		distribute();
	}
	
	public void distribute(){
		for(int i = 0; i < currentLib.size(); i++){
			
			int x = i * 150;
			int y = 0;
			
			while(x >= 450){
				x -= 450;
				y += 150;
			}
//System.out.print("Setting to " + x + " " + y + "\n");
			currentLib.get(i).setPos(x, y);
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		for(int i = 0; i < currentLib.size(); i++){
//			int x = i * 150;
//			int y = 0;
//			
//			while(x >= 450){
//				x -= 450;
//				y += 150;
//			}
			
//			System.out.print("@draw: mx = " + m_x + "\n");
			g.drawImage(currentLib.get(i).thumbnail, currentLib.get(i).x + m_x, currentLib.get(i).y + m_y, null);
		}
	}
}





















