package dataContainers;

import java.io.File;

import javax.swing.JLabel;
import javax.swing.JMenuItem;

public class AudioFile extends MediaFile{
	
//	protected AudioFilePopUp m_popup = new AudioFilePopUp();

	private static final long serialVersionUID = 7906650163065032773L;

	public AudioFile(File file) {
		super(file);
//System.out.print("calling audio creat");
		m_popUp = new AudioFilePopUp();
	}
	
	public AudioFile(String filePath){
		this(new File(filePath));
	}
	
	public AudioFile(String filePath, String imgFilePath){
		this(new File(filePath), new File(imgFilePath));
	}
	
	public AudioFile(File file, File imgFile){
		this(file);
		loadImg(imgFile);
	}
	
//	public void popUp(Component caller, int x, int y){
//		m_popUp.setEnabled(true);
//		m_popUp.setVisible(true);
//		m_popUp.show(caller, x, y);
//	}
	
	public class AudioFilePopUp extends MediaFilePopUp{
		
		private static final long serialVersionUID = -15185330828987922L;
		protected JMenuItem m_soundStuff = new JMenuItem("Sound stuff...");
		
		public AudioFilePopUp(){
//System.out.print("audio\n");
			add(new JLabel("  == TEST LABEL =="));
			add(m_soundStuff);
		}
	}

}
