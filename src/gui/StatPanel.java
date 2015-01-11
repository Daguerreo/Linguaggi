package gui;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Graphics2D;
import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JTextPane;

import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;

import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

import java.awt.Checkbox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import card.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StatPanel extends JPanel {
	private JTextField textFieldNome;
	private JTextField textFieldSubtype;
	private JTextArea textAreaText;
	private JSpinner spinAtk;
	private JSpinner spinDif;
	private JSpinner spinRng;
	
	public JComboBox comboCost;
	
	private GuiManager gm;
	private Element element;
	private Font txtFont;
	private JSpinner spinCost;
	private Checkbox checkbox1;
	private JComboBox comboCost2;
	private JSpinner spinCost2;
	private Checkbox checkbox2;
	private JComboBox comboCost3;
	private JSpinner spinCost3;
	private boolean bCost2 = false;
	private boolean bCost3 = false;

	/**
	 * Create the panel.
	 */
	public void setGuiManager( GuiManager guimanager )
	{
		gm = guimanager;
	}
	
	public StatPanel(  ) 
	{
		//setBackground(Color.ORANGE);
		txtFont = new Font("Tahoma", Font.BOLD, 11);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{70, 65, 54, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		JLabel lblType = new JLabel("Tipo");
		lblType.setFont(txtFont);
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.anchor = GridBagConstraints.EAST;
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 0;
		add(lblType, gbc_lblType);
		
		
		Vector<String> vecType = new Vector<String>();
		vecType.add("");
		for( CardType c : CardType.values() )
		{
			vecType.add(c.getName());
		}
		
		JComboBox comboType = new JComboBox(vecType);
		comboType.setSelectedIndex(0);
		comboType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				String o = (String) ((JComboBox) ae.getSource()).getSelectedItem();
				gm.writeCardType( o );
				
				if( o.equals(CardType.CREATURE.getName()) )
				{
					spinAtk.setEnabled( true );
					spinDif.setEnabled( true );
					spinRng.setEnabled( true );
					gm.showStat( true );
					
				}
				else
				{
					spinAtk.setEnabled( false );
					spinDif.setEnabled( false );
					spinRng.setEnabled( false );
					gm.showStat( false );
				}
			}
		});
		
		
		GridBagConstraints gbc_comboType = new GridBagConstraints();
		gbc_comboType.gridwidth = 2;
		gbc_comboType.insets = new Insets(0, 0, 5, 0);
		gbc_comboType.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboType.gridx = 1;
		gbc_comboType.gridy = 0;
		add(comboType, gbc_comboType);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(txtFont);
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.getDocument().addDocumentListener( new DocumentListener() 
		{
			@Override
            public void insertUpdate(DocumentEvent de) 
            {
            	gm.WriteCardName( textFieldNome.getText() );
            }
			@Override
            public void removeUpdate(DocumentEvent de) 
            {
				gm.WriteCardName( textFieldNome.getText() );
            }
			@Override
            public void changedUpdate(DocumentEvent de) 
            {
            }
        });


		GridBagConstraints gbc_textFieldNome = new GridBagConstraints();
		gbc_textFieldNome.gridwidth = 2;
		gbc_textFieldNome.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNome.gridx = 1;
		gbc_textFieldNome.gridy = 1;
		add(textFieldNome, gbc_textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setFont(txtFont);
		GridBagConstraints gbc_lblCosto = new GridBagConstraints();
		gbc_lblCosto.anchor = GridBagConstraints.EAST;
		gbc_lblCosto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCosto.gridx = 0;
		gbc_lblCosto.gridy = 2;
		add(lblCosto, gbc_lblCosto);
		
		Vector<String> vecElem = new Vector<String>();
		for( Element e : Element.values() )
		{
			if( e.getName() != Element.NONE.getName())
			vecElem.add(e.getName());
		}
		
		comboCost = new JComboBox(vecElem);
		comboCost.setSelectedIndex(0);
		comboCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				int result =((JComboBox) ae.getSource()).getSelectedIndex();
				gm.paintTemplate( result );
				gm.paintCost(1, result);
			}
		});
		GridBagConstraints gbc_comboCost = new GridBagConstraints();
		gbc_comboCost.insets = new Insets(0, 0, 5, 5);
		gbc_comboCost.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCost.gridx = 1;
		gbc_comboCost.gridy = 2;
		add(comboCost, gbc_comboCost);
		
		spinCost = new JSpinner();
		spinCost.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)
			{
				JSpinner mySpinner = (JSpinner)(e.getSource());
				gm.WriteCost1( Integer.toString( (int) mySpinner.getValue() ) );
			}
		});
		GridBagConstraints gbc_spinCost = new GridBagConstraints();
		gbc_spinCost.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinCost.insets = new Insets(0, 0, 5, 0);
		gbc_spinCost.gridx = 2;
		gbc_spinCost.gridy = 2;
		add(spinCost, gbc_spinCost);
		
		checkbox1 = new Checkbox("");
		comboCost2 = new JComboBox(vecElem);
		spinCost2 = new JSpinner();
		spinCost2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				JSpinner mySpinner = (JSpinner)(e.getSource());
				gm.WriteCost2( Integer.toString( (int) mySpinner.getValue() ) );
			}
		});
		checkbox2 = new Checkbox("");
		comboCost3 = new JComboBox(vecElem);
		spinCost3 = new JSpinner();
		spinCost3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)
			{
				JSpinner mySpinner = (JSpinner)(e.getSource());
				gm.WriteCost3( Integer.toString( (int) mySpinner.getValue() ) );
			}
		});
		
		checkbox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) 
			{
				bCost2 = !bCost2;
				comboCost2.setEnabled( bCost2 );
				spinCost2.setEnabled( bCost2 );
				checkbox2.setEnabled( bCost2 );
				gm.getCardPanel().getLblCost2().setVisible(bCost2);
				gm.getCardPanel().getLblMark2().setVisible(bCost2);
				
				if( bCost2 == false )
				{
					bCost3 = false;
					checkbox2.setState(bCost3);
					comboCost3.setEnabled( bCost3 );
					spinCost3.setEnabled( bCost3 );
					gm.getCardPanel().getLblCost3().setVisible(bCost3);
					gm.getCardPanel().getLblMark3().setVisible(bCost3);
				}
			}
		});
		GridBagConstraints gbc_checkbox1 = new GridBagConstraints();
		gbc_checkbox1.anchor = GridBagConstraints.EAST;
		gbc_checkbox1.insets = new Insets(0, 0, 5, 5);
		gbc_checkbox1.gridx = 0;
		gbc_checkbox1.gridy = 3;
		add(checkbox1, gbc_checkbox1);
		
		comboCost2.setEnabled(false);
		comboCost2.setSelectedIndex(0);
		comboCost2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				int result =((JComboBox) ae.getSource()).getSelectedIndex();
				gm.paintCost(2, result);
			}
		});
		GridBagConstraints gbc_comboCost2 = new GridBagConstraints();
		gbc_comboCost2.insets = new Insets(0, 0, 5, 5);
		gbc_comboCost2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCost2.gridx = 1;
		gbc_comboCost2.gridy = 3;
		add(comboCost2, gbc_comboCost2);
		
		spinCost2.setEnabled(false);
		GridBagConstraints gbc_spinCost2 = new GridBagConstraints();
		gbc_spinCost2.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinCost2.insets = new Insets(0, 0, 5, 0);
		gbc_spinCost2.gridx = 2;
		gbc_spinCost2.gridy = 3;
		add(spinCost2, gbc_spinCost2);
		
		
		checkbox2.setEnabled(false);
		checkbox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) 
			{
				bCost3 = !bCost3;
				comboCost3.setEnabled( bCost3 );
				spinCost3.setEnabled( bCost3 );
				gm.getCardPanel().getLblCost3().setVisible(bCost3);
				gm.getCardPanel().getLblMark3().setVisible(bCost3);
			}
		});
		GridBagConstraints gbc_checkbox2 = new GridBagConstraints();
		gbc_checkbox2.anchor = GridBagConstraints.EAST;
		gbc_checkbox2.insets = new Insets(0, 0, 5, 5);
		gbc_checkbox2.gridx = 0;
		gbc_checkbox2.gridy = 4;
		add(checkbox2, gbc_checkbox2);
		
		
		comboCost3.setEnabled(false);
		comboCost3.setSelectedIndex(0);
		comboCost3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				int result =((JComboBox) ae.getSource()).getSelectedIndex();
				gm.paintCost(3, result);
			}
		});
		GridBagConstraints gbc_comboCost3 = new GridBagConstraints();
		gbc_comboCost3.insets = new Insets(0, 0, 5, 5);
		gbc_comboCost3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCost3.gridx = 1;
		gbc_comboCost3.gridy = 4;
		add(comboCost3, gbc_comboCost3);
		
		
		spinCost3.setEnabled(false);
		GridBagConstraints gbc_spinCost3 = new GridBagConstraints();
		gbc_spinCost3.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinCost3.insets = new Insets(0, 0, 5, 0);
		gbc_spinCost3.gridx = 2;
		gbc_spinCost3.gridy = 4;
		add(spinCost3, gbc_spinCost3);
		
		JLabel lblSubtype = new JLabel("Sottotipo");
		lblSubtype.setFont(txtFont);
		GridBagConstraints gbc_lblSubtype = new GridBagConstraints();
		gbc_lblSubtype.anchor = GridBagConstraints.EAST;
		gbc_lblSubtype.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubtype.gridx = 0;
		gbc_lblSubtype.gridy = 5;
		add(lblSubtype, gbc_lblSubtype);
		
		textFieldSubtype = new JTextField();
		textFieldSubtype.getDocument().addDocumentListener( new DocumentListener() 
		{
			@Override
            public void insertUpdate(DocumentEvent de) 
            {
            	gm.WriteCardSubType( textFieldSubtype.getText() );
            }
			@Override
            public void removeUpdate(DocumentEvent de) 
            {
				gm.WriteCardSubType( textFieldSubtype.getText() );
            }
			@Override
            public void changedUpdate(DocumentEvent de) 
            {
            }
        });
		GridBagConstraints gbc_textFieldSubtype = new GridBagConstraints();
		gbc_textFieldSubtype.gridwidth = 2;
		gbc_textFieldSubtype.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldSubtype.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSubtype.gridx = 1;
		gbc_textFieldSubtype.gridy = 5;
		add(textFieldSubtype, gbc_textFieldSubtype);
		textFieldSubtype.setColumns(10);
		
		JLabel lblAtk = new JLabel("Atk");
		lblAtk.setFont(txtFont);
		GridBagConstraints gbc_lblAtk = new GridBagConstraints();
		gbc_lblAtk.anchor = GridBagConstraints.EAST;
		gbc_lblAtk.insets = new Insets(0, 0, 5, 5);
		gbc_lblAtk.gridx = 1;
		gbc_lblAtk.gridy = 6;
		add(lblAtk, gbc_lblAtk);
		
		spinAtk = new JSpinner();
		spinAtk.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)
			{
				JSpinner mySpinner = (JSpinner)(e.getSource());
				gm.WriteAtk( Integer.toString( (int) mySpinner.getValue() ) );
			}
		});
		
		GridBagConstraints gbc_SpinAtk = new GridBagConstraints();
		gbc_SpinAtk.fill = GridBagConstraints.HORIZONTAL;
		gbc_SpinAtk.insets = new Insets(0, 0, 5, 0);
		gbc_SpinAtk.gridx = 2;
		gbc_SpinAtk.gridy = 6;
		add(spinAtk, gbc_SpinAtk);
		
		JLabel lblStat = new JLabel("Stat");
		lblStat.setFont(txtFont);
		GridBagConstraints gbc_lblStat = new GridBagConstraints();
		gbc_lblStat.anchor = GridBagConstraints.EAST;
		gbc_lblStat.insets = new Insets(0, 0, 5, 5);
		gbc_lblStat.gridx = 0;
		gbc_lblStat.gridy = 7;
		add(lblStat, gbc_lblStat);
		
		JLabel lblDif = new JLabel("Dif");
		lblDif.setFont(txtFont);
		GridBagConstraints gbc_lblDif = new GridBagConstraints();
		gbc_lblDif.anchor = GridBagConstraints.EAST;
		gbc_lblDif.insets = new Insets(0, 0, 5, 5);
		gbc_lblDif.gridx = 1;
		gbc_lblDif.gridy = 7;
		add(lblDif, gbc_lblDif);
		
		spinDif = new JSpinner();
		spinDif.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)
			{
				JSpinner mySpinner = (JSpinner)(e.getSource());
				gm.WriteDif( Integer.toString( (int) mySpinner.getValue() ) );
			}
		});
		
		GridBagConstraints gbc_SpinDif = new GridBagConstraints();
		gbc_SpinDif.fill = GridBagConstraints.HORIZONTAL;
		gbc_SpinDif.insets = new Insets(0, 0, 5, 0);
		gbc_SpinDif.gridx = 2;
		gbc_SpinDif.gridy = 7;
		add(spinDif, gbc_SpinDif);
		
		JLabel lblRange = new JLabel("Range");
		lblRange.setFont(txtFont);
		GridBagConstraints gbc_lblRange = new GridBagConstraints();
		gbc_lblRange.anchor = GridBagConstraints.EAST;
		gbc_lblRange.insets = new Insets(0, 0, 5, 5);
		gbc_lblRange.gridx = 1;
		gbc_lblRange.gridy = 8;
		add(lblRange, gbc_lblRange);
		
		spinRng = new JSpinner();
		spinRng.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)
			{
				JSpinner mySpinner = (JSpinner)(e.getSource());
				gm.WriteRng( Integer.toString( (int) mySpinner.getValue() ) );
			}
		});
		
		
		GridBagConstraints gbc_SpinRng = new GridBagConstraints();
		gbc_SpinRng.fill = GridBagConstraints.HORIZONTAL;
		gbc_SpinRng.insets = new Insets(0, 0, 5, 0);
		gbc_SpinRng.gridx = 2;
		gbc_SpinRng.gridy = 8;
		add(spinRng, gbc_SpinRng);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 9;
		add(scrollPane, gbc_scrollPane);
		
		textAreaText = new JTextArea();
		textAreaText.setRows(4);
		scrollPane.setViewportView(textAreaText);
		textAreaText.setColumns(10);
		
		JLabel lblText = new JLabel("Text");
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		lblText.setFont(txtFont);
		GridBagConstraints gbc_lblText = new GridBagConstraints();
		gbc_lblText.anchor = GridBagConstraints.EAST;
		gbc_lblText.insets = new Insets(0, 0, 5, 5);
		gbc_lblText.gridx = 0;
		gbc_lblText.gridy = 10;
		add(lblText, gbc_lblText);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				gm.WriteCardName( textFieldNome.getText() );
				gm.WriteCardSubType(textFieldSubtype.getText() );
				gm.WriteCardText(textAreaText.getText() );
			}
		});
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdate.gridx = 1;
		gbc_btnUpdate.gridy = 13;
		add(btnUpdate, gbc_btnUpdate);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				gm.getCardPanel().saveImage();
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.gridx = 2;
		gbc_btnSave.gridy = 13;
		add(btnSave, gbc_btnSave);

	}

	
}
