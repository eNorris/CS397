package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class CoreMenu extends JMenuBar{

	private static final long serialVersionUID = -6260232465922104398L;
	
	CoreMenu(){
		add(generateFileMenu());
		add(generateEditMenu());
		add(generateHelpMenu());
	}
	
	public JMenu generateFileMenu(){
		JMenu toReturn = new JMenu("File");
//		toReturn.setLabel("File");
		
		toReturn.add(new MenuItemFileAdd());
		toReturn.add(new MenuItemFileRemove());
		
		return toReturn;
	}
	
	public JMenu generateEditMenu(){
		JMenu toReturn = new JMenu("Edit");
//		toReturn.setLabel("Edit");
		
		toReturn.add(new MenuItemEditChange());
		toReturn.add(new MenuItemEditModify());
		
		return toReturn;
	}
	
	public JMenu generateHelpMenu(){
		JMenu toReturn = new JMenu("Help");
//		toReturn.setLabel("Help");
		
		toReturn.add(new MenuItemHelpAbout());
		
		return toReturn;
	}

	private class MenuItemFileAdd extends JMenuItem{
		private static final long serialVersionUID = 2614146146651816448L;
		public MenuItemFileAdd(){
//			this.setLabel("Add");
			super("Add");
			this.setEnabled(true);
			this.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
	}
	
	private class MenuItemFileRemove extends JMenuItem{
		private static final long serialVersionUID = 9216262717029878271L;

		public MenuItemFileRemove(){
			super("Remove");
//			this.setLabel("Remove");
			this.setEnabled(true);
			this.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
	}
	
	private class MenuItemEditChange extends JMenuItem{
		private static final long serialVersionUID = -5554978003547610060L;
		public MenuItemEditChange(){
			super("Change");
//			this.setLabel("Change");
			this.setEnabled(true);
			this.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
	}
	
	private class MenuItemEditModify extends JMenuItem{
		private static final long serialVersionUID = 1508756105178959414L;
		public MenuItemEditModify(){
			super("Modify");
//			this.setLabel("Modify");
			this.setEnabled(true);
			this.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
	}
	
	private class MenuItemHelpAbout extends JMenuItem{
		private static final long serialVersionUID = 70274194970378772L;
		public MenuItemHelpAbout(){
			super("About");
//			this.setLabel("About");
			this.setEnabled(true);
			this.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
	}
	
}


























