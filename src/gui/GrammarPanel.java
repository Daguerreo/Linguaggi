package gui;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Component;

import javax.swing.Box;

import parser.ParseManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.Font;

public class GrammarPanel extends JPanel {
	private JTextArea lblMessage;
	private JTextArea textFieldGrammar;
	private Component horizontalStrut;
	// private boolean parserInit = false;

	private GuiManager gm;
	private ParseManager pm;
	private TreePanel treePanel;
	private JScrollPane scrollPane;
	private JLabel lblResult;
	private JScrollPane scrollPane_1;
	private JButton btnShowTree;
	private JFrame frmTree;

	public void setManagers(GuiManager guimanager, ParseManager parseManager) {
		gm = guimanager;
		pm = parseManager;

		pm.setGuiManager(gm);
	}
	
	public TreePanel getTreePanel() {
		return treePanel;
	}

	public void setTreePanel(TreePanel tp) {
		this.treePanel = tp;
	}

	public GrammarPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {100, 110, 0};
		gridBagLayout.rowHeights = new int[]{287, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);

		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);

		textFieldGrammar = new JTextArea();
		textFieldGrammar.setRows(15);
		textFieldGrammar.setLineWrap(true);
		scrollPane.setViewportView(textFieldGrammar);
		textFieldGrammar.setColumns(10);

		JButton btnParse = new JButton("Parse");
		btnParse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pm.setIn(textFieldGrammar.getText());
				if (gm.isParserInit()) {
					pm.reInit();
				} else {
					gm.setParserInit(true);
					pm.init();
				}

				//lblMessage.setText(pm.getOut());
			}
		});
		GridBagConstraints gbc_btnParse = new GridBagConstraints();
		gbc_btnParse.anchor = GridBagConstraints.WEST;
		gbc_btnParse.insets = new Insets(0, 0, 5, 5);
		gbc_btnParse.gridx = 0;
		gbc_btnParse.gridy = 1;
		add(btnParse, gbc_btnParse);

		btnShowTree = new JButton("Show Tree");
		btnShowTree.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frmTree = new JFrame();
				frmTree.getContentPane().add(treePanel);
				frmTree.setSize(400, 400);
				frmTree.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnShowTree = new GridBagConstraints();
		gbc_btnShowTree.anchor = GridBagConstraints.WEST;
		gbc_btnShowTree.insets = new Insets(0, 0, 5, 0);
		gbc_btnShowTree.gridx = 1;
		gbc_btnShowTree.gridy = 1;
		add(btnShowTree, gbc_btnShowTree);

		horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 2;
		add(horizontalStrut, gbc_horizontalStrut);

		lblResult = new JLabel("Result:");
		lblResult.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblResult.gridwidth = 2;
		gbc_lblResult.insets = new Insets(0, 0, 5, 0);
		gbc_lblResult.gridx = 0;
		gbc_lblResult.gridy = 3;
		add(lblResult, gbc_lblResult);

		scrollPane_1 = new JScrollPane();
		scrollPane_1
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 4;
		add(scrollPane_1, gbc_scrollPane_1);

		lblMessage = new JTextArea();
		lblMessage.setColumns(10);
		lblMessage.setRows(5);
		lblMessage.setEditable(false);
		lblMessage.setLineWrap(true);
		scrollPane_1.setViewportView(lblMessage);
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 11));

	}

	public JTextArea getTextFieldResult() {
		return lblMessage;
	}

	public JTextArea getTextFieldGrammar() {
		return textFieldGrammar;
	}

	public void setLblMsg(String s) {
		lblMessage.setText(s);
	}

}
