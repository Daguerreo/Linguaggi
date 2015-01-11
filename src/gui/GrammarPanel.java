package gui;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JEditorPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JInternalFrame;

import java.awt.BorderLayout;

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
	private JLabel lblMessage;
	private JTextArea textFieldGrammar;
	private Component horizontalStrut;
	//private boolean parserInit = false;

	private GuiManager gm;
	private ParseManager pm;
	private JScrollPane scrollPane;
	private JLabel lblResult;
	
	public void setManagers( GuiManager guimanager, ParseManager parseManager )
	{
		gm = guimanager;
		pm = parseManager;
		
		pm.setGuiManager(gm);
	}
	
	public GrammarPanel(  ) 
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{252, 0};
		gridBagLayout.rowHeights = new int[]{287, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
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
		
		JButton btnParse = new JButton("Parse");
		btnParse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				pm.setIn( textFieldGrammar.getText() );
				if( gm.isParserInit() )
				{
					pm.reInit();
				}
				else
				{
					gm.setParserInit(true);
					pm.init();
				}
				
				lblMessage.setText(pm.getOut());
			}
		});
		GridBagConstraints gbc_btnParse = new GridBagConstraints();
		gbc_btnParse.insets = new Insets(0, 0, 5, 0);
		gbc_btnParse.gridx = 0;
		gbc_btnParse.gridy = 1;
		add(btnParse, gbc_btnParse);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 2;
		add(horizontalStrut, gbc_horizontalStrut);
		
		lblResult = new JLabel("Result:");
		lblResult.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.anchor = GridBagConstraints.WEST;
		gbc_lblResult.insets = new Insets(0, 0, 5, 0);
		gbc_lblResult.gridx = 0;
		gbc_lblResult.gridy = 3;
		add(lblResult, gbc_lblResult);
		
		lblMessage = new JLabel();
		lblMessage.setText("suca");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.gridheight = 4;
		gbc_lblMessage.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMessage.gridx = 0;
		gbc_lblMessage.gridy = 4;
		add(lblMessage, gbc_lblMessage);

	}

	public JLabel getTextFieldResult() {
		return lblMessage;
	}

	public JTextArea getTextFieldGrammar() {
		return textFieldGrammar;
	}
	
	public void setLblMsg( String s )
	{
		lblMessage.setText( s );
	}
	
	

}
