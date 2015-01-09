package gui;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JButton;

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
	private JLabel textFieldResult;
	private JTextArea textFieldGrammar;
	private Component horizontalStrut;
	// private boolean parserInit = false;

	private GuiManager gm;
	private ParseManager pm;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;

	public void setManagers(GuiManager guimanager, ParseManager parseManager) {
		gm = guimanager;
		pm = parseManager;

		pm.setGuiManager(gm);
	}

	public GrammarPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 252, 0 };
		gridBagLayout.rowHeights = new int[] { 287, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		scrollPane = new JScrollPane();
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);

		textFieldGrammar = new JTextArea();
		textFieldGrammar.setLineWrap(true);
		scrollPane.setViewportView(textFieldGrammar);
		textFieldGrammar.setColumns(10);

		JButton btnNewButton = new JButton("Parse");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pm.setIn(textFieldGrammar.getText());
				if (gm.isParserInit()) {
					pm.reInit();
				} else {
					gm.setParserInit(true);
					pm.init();
				}

				textFieldResult.setText(pm.getOut());
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);

		horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 2;
		add(horizontalStrut, gbc_horizontalStrut);

		lblNewLabel = new JLabel("Result:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);

		textFieldResult = new JLabel();
		textFieldResult.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_textFieldResult = new GridBagConstraints();
		gbc_textFieldResult.gridheight = 4;
		gbc_textFieldResult.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldResult.gridx = 0;
		gbc_textFieldResult.gridy = 4;
		add(textFieldResult, gbc_textFieldResult);

	}

}
