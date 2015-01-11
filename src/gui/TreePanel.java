package gui;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import parser.ParseManager;

public class TreePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5555791111661307939L;

	private GuiManager gm;
	private ParseManager pm;
	private JTree tree;
	
	public void setManagers(GuiManager guimanager, ParseManager parseManager) {
		gm = guimanager;
		pm = parseManager;

		pm.setGuiManager(gm);
	}
	
	public TreePanel() {

		tree = new JTree();
		add(tree);

	}
	
	public void repaintTree(DefaultMutableTreeNode t) {
		tree.setModel(new javax.swing.tree.DefaultTreeModel(t));
	}

}
