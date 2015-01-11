package gui;

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

import parser.ParseManager;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		frmCardCreator.getContentPane().setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPaneSx = new JScrollPane();
		scrollPaneSx.setViewportBorder(new EmptyBorder(10, 10, 10, 10));
		scrollPaneSx
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPaneSx
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmCardCreator.getContentPane().add(scrollPaneSx, BorderLayout.WEST);

		StatPanel leftpanel = new StatPanel();
		guimanager.setStatPanel(leftpanel);
		leftpanel.setGuiManager(guimanager);
		scrollPaneSx.setViewportView(leftpanel);

		CardPanel cardpanel = new CardPanel();
		cardpanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		guimanager.setCardPanel(cardpanel);
		cardpanel.setGuiManager(guimanager);
		frmCardCreator.getContentPane().add(cardpanel);

		JScrollPane scrollPaneDx = new JScrollPane();
		scrollPaneDx.setViewportBorder(new EmptyBorder(10, 10, 10, 10));
		scrollPaneDx.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmCardCreator.getContentPane().add(scrollPaneDx, BorderLayout.EAST);

		GrammarPanel rightpanel = new GrammarPanel();
		rightpanel.getTextFieldGrammar().setMinimumSize(new Dimension(110, 22));
		guimanager.setGrammarPanel( rightpanel );

		rightpanel.setManagers(guimanager, parseManager);
		GridBagLayout gridBagLayout_1 = (GridBagLayout) rightpanel.getLayout();
		gridBagLayout_1.rowHeights = new int[]{322, 36, 39, 0, 90};
		gridBagLayout_1.columnWidths = new int[]{151};
		scrollPaneDx.setViewportView(rightpanel);
	}
}
