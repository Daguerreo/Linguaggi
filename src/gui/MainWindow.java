package gui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.GridBagLayout;

import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.ScrollPaneConstants;

import card.Cost;
import parser.ParseManager;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

public class MainWindow {

	private JFrame frmCardCreator;
	private GuiManager guimanager;
	private ParseManager parseManager;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { MainWindow window = new
	 * MainWindow(); } catch (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the application.
	 */
	public MainWindow() {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmCardCreator = new JFrame();
		frmCardCreator.setVisible(true);
		frmCardCreator.setTitle("Card Creator");
		frmCardCreator.setBounds(100, 100, 952, 652);
		frmCardCreator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		guimanager = new GuiManager();
		parseManager = new ParseManager();

		JMenuBar menuBar = new JMenuBar();
		frmCardCreator.setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu 1");
		menuBar.add(mnMenu);

		JMenuItem mntmLoad = new JMenuItem("Pota");
		mnMenu.add(mntmLoad);

		JMenuItem mntmSave = new JMenuItem("Save");
		mnMenu.add(mntmSave);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 248, -1, 380, 0, 262, 100 };
		gridBagLayout.rowHeights = new int[] { 14, 530, 100 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		frmCardCreator.getContentPane().setLayout(gridBagLayout);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 2;
		gbc_verticalStrut.gridy = 0;
		frmCardCreator.getContentPane().add(verticalStrut, gbc_verticalStrut);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 4;
		gbc_verticalStrut_1.gridy = 0;
		frmCardCreator.getContentPane().add(verticalStrut_1,
				gbc_verticalStrut_1);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_2.gridx = 0;
		gbc_verticalStrut_2.gridy = 1;
		frmCardCreator.getContentPane().add(verticalStrut_2,
				gbc_verticalStrut_2);

		JScrollPane scrollPaneSx = new JScrollPane();
		scrollPaneSx
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPaneSx
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPaneSx = new GridBagConstraints();
		gbc_scrollPaneSx.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneSx.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneSx.gridx = 1;
		gbc_scrollPaneSx.gridy = 1;
		frmCardCreator.getContentPane().add(scrollPaneSx, gbc_scrollPaneSx);

		StatPanel leftpanel = new StatPanel();
		guimanager.setStatPanel(leftpanel);
		leftpanel.setGuiManager(guimanager);
		scrollPaneSx.setViewportView(leftpanel);

		CardPanel cardpanel = new CardPanel();
		guimanager.setCardPanel(cardpanel);
		cardpanel.setGuiManager(guimanager);
		GridBagConstraints gbc_cardpanel = new GridBagConstraints();
		gbc_cardpanel.insets = new Insets(0, 0, 0, 5);
		gbc_cardpanel.fill = GridBagConstraints.BOTH;
		gbc_cardpanel.gridx = 3;
		gbc_cardpanel.gridy = 1;
		frmCardCreator.getContentPane().add(cardpanel, gbc_cardpanel);

		JScrollPane scrollPaneDx = new JScrollPane();
		scrollPaneDx.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPaneDx = new GridBagConstraints();
		gbc_scrollPaneDx.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneDx.gridx = 5;
		gbc_scrollPaneDx.gridy = 1;
		frmCardCreator.getContentPane().add(scrollPaneDx, gbc_scrollPaneDx);
		
		TreePanel treePanel = new TreePanel();
		guimanager.setTreePanel(treePanel);
		treePanel.setManagers(guimanager, parseManager);

		GrammarPanel rightpanel = new GrammarPanel();
		rightpanel.setTreePanel(treePanel);
		rightpanel.getTextFieldGrammar().setMinimumSize(new Dimension(110, 22));
		guimanager.setGrammarPanel( rightpanel );

		rightpanel.setManagers(guimanager, parseManager);
		GridBagLayout gridBagLayout_1 = (GridBagLayout) rightpanel.getLayout();
		gridBagLayout_1.rowHeights = new int[]{322, 36, 39, 0, 90};
		gridBagLayout_1.columnWidths = new int[]{151};
		scrollPaneDx.setViewportView(rightpanel);
		
		CardRenderer r = new CardRenderer();
		r.setStyle(CardGraphic.AIR);
		r.setCreature(true);
		r.setName("Nome");
		r.setSubtype("Gatto");
		r.setType("Tipo");
		r.setText("Google wasn’t awfully helpful while I was searching for solution to word wrapping a text when drawing in Java, so let’s teach Google this:");
		r.setCost1(2, ImageIO.read(CardGraphic.AIR.getMark10()));
		r.setCost2(2, ImageIO.read(CardGraphic.AIR.getMark10()));
		r.setCost3(2, ImageIO.read(CardGraphic.AIR.getMark10()));
		r.saveImage(new File("prova.png"));
		
		guimanager.setCardRenderer(r);
		
		JFrame jf = new JFrame();
		jf.getContentPane().add(r);
		jf.pack();
		jf.setVisible(true);
	}
}
