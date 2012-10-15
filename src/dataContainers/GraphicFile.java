package dataContainers;

import java.io.File;

import javax.swing.JMenuItem;

public class GraphicFile extends MediaFile{

	private static final long serialVersionUID = -7780276326943050864L;

	public GraphicFile(File file) {
		super(file);

		m_popUp = new GraphicFilePopUp();
	}
	
	public GraphicFile(String filePath){
		this(new File(filePath));
	}
	
	public GraphicFile(String filePath, String imgFilePath){
		this(new File(filePath), new File(imgFilePath));
	}
	
	public GraphicFile(File file, File imgFile){
		this(file);
		loadImg(imgFile);
	}

	public class GraphicFilePopUp extends MediaFilePopUp{
		/**
		 * 
		 */
		private static final long serialVersionUID = -3771804445786297498L;

		protected JMenuItem m_stuff = new JMenuItem("pic stuff...");
		
		public GraphicFilePopUp(){
//System.out.print("audio\n");
			addSeparator();
			add(m_stuff);
		}
		
	}
}







