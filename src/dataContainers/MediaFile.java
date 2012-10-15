package dataContainers;

import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class MediaFile extends Component{
	

	private static final long serialVersionUID = -5359135092454708630L;

	/**Enumeration of possible file size types (Byte, kByte, MByte, GByte)*/
	public static enum FileSizeEnum{
		BYTE, KB, MB, GB
	}
	
	public File file = null;
	public Image thumbnail = null;
	public String description = null;
	public int fileSize = 0;
	public FileSizeEnum fileSizeType = FileSizeEnum.BYTE;
	
	protected MediaFilePopUp m_popUp = new MediaFilePopUp();
	
	/**Name of the file without extension ("C:\temp\file.txt" => "file")*/
	public String fileName = null;
	
	/**Extension of the file ("C:\temp\file.txt" => "txt")*/
	public String fileExt = null;
	
	public int x = 0, y = 0, w = 0, h = 0;
	public static int worldShiftX = 0, worldShiftY = 0;
	
	// This is the main constructor that everyone else calls
	public MediaFile(File file){
		setFile(file);
//		this.addMouseListener(new MediaFilePopUpListener());
//		this.add(new MediaFilePopUp());
//		this.setComponentPopupMenu();
	}
	
	public MediaFile(String filePath){
		this(new File(filePath));
	}
	
	public MediaFile(String filePath, String imgFilePath){
		this(new File(filePath), new File(imgFilePath));
	}
	
	public MediaFile(File file, File imgFile){
		this(file);
		loadImg(imgFile);
	}
	
	public void setThumbnail(Image thumbnail){
		this.thumbnail = thumbnail;
	}
	
	public void setFile(File file){
		this.file = file;
		setThumbnail(null);
		resolveFileSize();
		
		description = null;
		fileName = null;
		fileExt = null;
	}
	
	public void fetchMetaData(){
		
	}
	
	protected void resolveFileSize(){
		long sizeB = file.length();
		long sizeKB = sizeB / 1024;
		long sizeMB = sizeKB / 1024;
		long sizeGB = sizeMB / 1024;
		
		if(sizeKB < 10){
			fileSize = (int) sizeB;
			fileSizeType = FileSizeEnum.BYTE;
		}else if(sizeMB < 10){
			fileSize = (int) sizeKB;
			fileSizeType = FileSizeEnum.KB;
		}else if(sizeGB < 10){
			fileSize = (int) sizeMB;
			fileSizeType = FileSizeEnum.MB;
		}else{
			fileSize = (int) sizeGB;
			fileSizeType = FileSizeEnum.GB;
		}
	}
	
	
	public void loadImg(String filePath){
		loadImg(new File(filePath));
	}
	
	public void loadImg(File file){
		try {
			thumbnail = ImageIO.read(file);
		} catch (IOException e) {
			System.out.print("Failed to load image for file: " + file.getAbsolutePath() + "\n\n");
			e.printStackTrace();
		}
		w = thumbnail.getWidth(null);
		h = thumbnail.getHeight(null);
	}
	
	public void setPos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x + worldShiftX;
	}
	
	public int getY(){
		return y + worldShiftY;
	}
	
	public boolean isInBoundsLocal(int x, int y){
		return (x >= this.x && 			// left bound
				x <= this.x + w && 		// right bound
				y >= this.y && 			// top bound
				y <= this.y + this.h);	// bottom bound
	}
	
	public boolean isInBounds(int x, int y){
		return (x >= this.x + worldShiftX && 			// left bound
				x <= this.x + worldShiftX + w && 		// right bound
				y >= this.y + worldShiftY && 			// top bound
				y <= this.y + worldShiftY + this.h);	// bottom bound
	}
	
	public class MediaFilePopUp extends JPopupMenu{
		
		protected JMenuItem m_open = new JMenuItem("Open");
		protected JMenuItem m_edit = new JMenuItem("Edit");
		protected JMenuItem m_delete = new JMenuItem("Delete");

		private static final long serialVersionUID = -8357288887563917285L;
		
		public MediaFilePopUp(){
			add(m_open);
			add(m_edit);
			add(m_delete);
			
//System.out.print("created\n");
			
		}
	}
	
	public void popUp(Component caller, int x, int y){
//		MediaFilePopUp menu = new MediaFilePopUp();
//		this.setVisible(true);
	//	menu.setVisible(true);
 //       menu.show(menu.getComponent(), 0,0);//x,y);//e.getX(), e.getY());
//		this.setEnabled(true);
//		this.setVisible(true);
		m_popUp.setEnabled(true);
		m_popUp.setVisible(true);
		m_popUp.show(caller, x, y);
        
        
        
//        PopUpDemo menu = new PopUpDemo();
//      menu.show(e.getComponent(), e.getX(), e.getY());
	}
	
//	public class MediaFilePopUpListener extends MouseAdapter{
//		
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
////System.out.print("click!");
//		}
//		
//		@Override
//		public void mouseEntered(MouseEvent arg0) {
//		}
//		
//		@Override
//		public void mouseExited(MouseEvent arg0) {
//		}
//		
//		public void mousePressed(MouseEvent e){
////System.out.print("file press\n");
//	        if (e.isPopupTrigger())
//	            doPop(e);
//	    }
//	
//	    public void mouseReleased(MouseEvent e){
//	        if (e.isPopupTrigger())
//	            doPop(e);
//	    }
//	
//	    private void doPop(MouseEvent e){
////System.out.print("doPop\n");
//	    	MediaFilePopUp menu = new MediaFilePopUp();
//	        menu.show(e.getComponent(), 0,0);//e.getX(), e.getY());
//	    }
//	}
}


//class PopClickListener extends MouseAdapter {
//    public void mousePressed(MouseEvent e){
//        if (e.isPopupTrigger())
//            doPop(e);
//    }
//
//    public void mouseReleased(MouseEvent e){
//        if (e.isPopupTrigger())
//            doPop(e);
//    }
//
//    private void doPop(MouseEvent e){
//        PopUpDemo menu = new PopUpDemo();
//        menu.show(e.getComponent(), e.getX(), e.getY());
//    }
//}
//
//// Then on your component(s)
//component.addMouseListener(new PopClickListener());














