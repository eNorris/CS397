package dataContainers;

import java.io.File;

import javax.swing.JMenuItem;

public class DocumentFile extends MediaFile {

	/**
	 * 
	 */
	private static final long serialVersionUID = -432259262007877412L;

	public DocumentFile(File file) {
		super(file);
	}
	
	public class DocumentFilePopUp extends MediaFilePopUp{

		private static final long serialVersionUID = 7864855181664320942L;
		protected JMenuItem m_documentStuff = new JMenuItem("doc stuff...");

		public DocumentFilePopUp(){
//			add(m_documentStuff);
		}
	}

}
