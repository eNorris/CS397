package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import util.SpaceTimeInt;
import util.SpringEq;
import util.World;

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
	
	private SpringEq m_springEq = new SpringEq();

	Wall(){
		setBackground(Color.BLUE);
		
		final JPanel m_self = this;
		
		for(int i = 0; i < 150; i++){
			
			int randomness = World.rand.nextInt();
			
			if(randomness % 3 == 0){
				currentLib.add(new MediaFile("library/doc2.txt", "graphics/thumb1.bmp"));
			}else if(randomness % 3 == 1){
				currentLib.add(new AudioFile("library/test.mp3", "graphics/musicthumb.bmp"));
			}else{
				currentLib.add(new GraphicFile("library/testpic.png", "graphics/picthumb.bmp"));
			}
		}
		
		addMouseListener(new MouseListener(){
			
			public void mouseClicked(MouseEvent ev) {}
			public void mouseEntered(MouseEvent ev) {}
			public void mouseExited(MouseEvent ev) {}
			
			public void mousePressed(MouseEvent ev) {
				
				if(ev.getButton() == MouseEvent.BUTTON1){
					// left click => consum
					m_moving = true;
					m_lx = ev.getX();
					m_ly = ev.getY();
					
//					World.space.chronicle();
					World.space.wormHole(m_x, m_y);
				}else if(ev.getButton() == MouseEvent.BUTTON2){
					// midle click => do nothing
				}else{
					// right click => open context menu
					for(int i = 0; i < currentLib.size(); i++){
						if( currentLib.get(i).isInBounds(ev.getX(), ev.getY())){
							currentLib.get(i).popUp(m_self, ev.getX(), ev.getY());
						}
					}
				}
			}

			public void mouseReleased(MouseEvent arg0) {
				m_moving = false;
				bounder();
				
for(SpaceTimeInt i : World.space.history){
	System.out.print(i.toString() + "\n");
}
System.out.print("\n=========\n");
				
				
			}
		});
		
		
		addMouseMotionListener(new MouseMotionListener(){

			public void mouseDragged(MouseEvent arg0) {
				
				// Dampened spring equation: mu'' + yu' + ku = 0
				// omega = sqrt(k/m)
				// dampeningRatio = y/(2sqrt(mk))
				// when dampening ration = 1, critically dampened
				//
				// Overdampened: Ae^(r1t) + Be^(-r2t)
				// Underdampened: 
				
				
				if(m_moving){
					m_x += arg0.getX() - m_lx;
					m_y += arg0.getY() - m_ly;
					
					// FIXME - replace this and m_x with a Util.XX
					MediaFile.worldShiftX = m_x;
					MediaFile.worldShiftY = m_y;
					
					m_lx = arg0.getX();
					m_ly = arg0.getY();
					
					World.space.universalUpdate(m_x, m_y);
					World.space.chronicle();
					
					repaint();
				}
			}

			public void mouseMoved(MouseEvent arg0) {}
		});
		
		// places the media files on the screen
		distribute();
		
		// Start the timer
		World.space.bigBang();
		
		// Initialize the spring equation
		m_springEq.mass = 1.0;
		m_springEq.spring = 1.0;
		m_springEq.dampen = m_springEq.getCriticalDampening();
//		m_springEq.dampen = 1.0;
		m_springEq.A = 1.0;
	}
	
	/**
	 * Places the media files on the screen
	 */
	public void distribute(){
		
		// FIXME - calculate this
		final int rows = 5;
		
		for(int i = 0; i < currentLib.size(); i++){
			
			int x = World.config.bufferSpace;
			int y = i*(World.config.getDimension().height + World.config.bufferSpace) + World.config.bufferSpace;//150;
			
			while(y >= (World.config.getDimension().height + World.config.bufferSpace)*rows){
				y -= (World.config.getDimension().height + World.config.bufferSpace)*rows;
				x += World.config.getDimension().width + World.config.bufferSpace;
			}
			currentLib.get(i).setPos(x, y);
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		for(int i = 0; i < currentLib.size(); i++){
			g.drawImage(currentLib.get(i).thumbnail, currentLib.get(i).x + m_x, currentLib.get(i).y + m_y, null);
		}
	}
	

	public void bounder(){
		if(m_springEq.critdampen(World.space.t) < 1){
			System.out.print("Done with dampening.\n");
		}else{
		m_x += 1;
		repaint();
		if(World.rand.nextInt(30) != 0)
			bounder();
	}
	
}





















