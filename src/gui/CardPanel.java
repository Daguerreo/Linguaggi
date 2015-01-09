package gui;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.SwingConstants;

public class CardPanel extends JPanel {
	private GuiManager gm;
	private CardGraphic cg;
	private JLabel lblName;
	private JLabel lblType;
	private JLabel lblSubtype;
	private JLabel lblTemplate;
	private JLabel lblText;
	private JLabel lblMark3;
	private JLabel lblMark2;
	private JLabel lblMark1;
	private JLabel lblCost1;
	private JLabel lblCost2;
	private JLabel lblCost3;
	private JLabel lblAtk;
	private JLabel lblDif;
	private JLabel lblRng;
	private JLabel gifAtk;
	private JLabel gifDif;
	private JLabel gifRng;

	public void setGuiManager(GuiManager guimanager) {
		gm = guimanager;
	}

	public CardPanel() {
		// setBackground(Color.ORANGE);
		setLayout(null);
		Font fontNum = new Font("Plantagenet Cherokee", Font.BOLD, 17);
		Font fontName = new Font("Plantagenet Cherokee", Font.PLAIN, 16);
		Font fontType = new Font("Plantagenet Cherokee", Font.ITALIC, 13);
		Font font = new Font("Plantagenet Cherokee", Font.PLAIN, 13);

		lblAtk = new JLabel("0");
		lblAtk.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAtk.setForeground(Color.WHITE);
		lblAtk.setFont(fontNum);
		lblAtk.setBounds(317, 142, 29, 18);
		lblAtk.setVisible(false);
		add(lblAtk);

		gifAtk = new JLabel("");
		gifAtk.setIcon(new ImageIcon(
				"C:\\Users\\Mau\\workspace\\CardGame\\img\\atk.png"));
		gifAtk.setBounds(320, 125, 28, 28);
		gifAtk.setVisible(false);
		add(gifAtk);

		lblDif = new JLabel("0");
		lblDif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDif.setForeground(Color.WHITE);
		lblDif.setFont(fontNum);
		lblDif.setBounds(317, 188, 29, 18);
		lblDif.setVisible(false);
		add(lblDif);

		gifDif = new JLabel("");
		gifDif.setIcon(new ImageIcon(
				"C:\\Users\\Mau\\workspace\\CardGame\\img\\dif.png"));
		gifDif.setBounds(320, 171, 28, 28);
		gifDif.setVisible(false);
		add(gifDif);

		lblRng = new JLabel("0");
		lblRng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRng.setForeground(Color.WHITE);
		lblRng.setFont(fontNum);
		lblRng.setBounds(317, 234, 29, 18);
		lblRng.setVisible(false);
		add(lblRng);

		gifRng = new JLabel("");
		gifRng.setIcon(new ImageIcon(
				"C:\\Users\\Mau\\workspace\\CardGame\\img\\rng.png"));
		gifRng.setBounds(320, 217, 28, 28);
		gifRng.setVisible(false);
		add(gifRng);

		lblCost1 = new JLabel("0");
		lblCost1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCost1.setForeground(Color.WHITE);
		lblCost1.setFont(fontNum);
		lblCost1.setBounds(313, 50, 29, 18);
		add(lblCost1);

		lblCost2 = new JLabel("0");
		lblCost2.setVisible(false);
		lblCost2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCost2.setForeground(Color.WHITE);
		lblCost2.setFont(fontNum);
		lblCost2.setBounds(276, 50, 29, 18);
		add(lblCost2);

		lblCost3 = new JLabel("0");
		lblCost3.setVisible(false);
		lblCost3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCost3.setForeground(Color.WHITE);
		lblCost3.setFont(fontNum);
		lblCost3.setBounds(238, 50, 29, 18);
		add(lblCost3);

		lblMark1 = new JLabel("");
		lblMark1.setIcon(new ImageIcon(CardGraphic.INCOLOR.getMark10()));
		lblMark1.setBounds(311, 39, 28, 28);
		add(lblMark1);

		lblMark2 = new JLabel("");
		lblMark2.setVisible(false);
		lblMark2.setBounds(274, 39, 28, 28);
		lblMark2.setIcon(new ImageIcon(CardGraphic.INCOLOR.getMark10()));
		add(lblMark2);

		lblMark3 = new JLabel("");
		lblMark3.setVisible(false);
		lblMark3.setBounds(238, 39, 28, 28);
		lblMark3.setIcon(new ImageIcon(CardGraphic.INCOLOR.getMark10()));
		add(lblMark3);

		// Font cardFont = new Font("Times New Roman", Font.BOLD, 18);

		lblName = new JLabel("");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(fontName);
		lblName.setBounds(42, 40, 166, 28);
		add(lblName);

		lblType = new JLabel("");
		lblType.setForeground(Color.WHITE);
		lblType.setFont(fontType);
		lblType.setBounds(58, 77, 85, 16);
		add(lblType);

		lblSubtype = new JLabel("");
		lblSubtype.setForeground(Color.WHITE);
		lblSubtype.setFont(font);
		lblSubtype.setBounds(163, 79, 166, 14);
		add(lblSubtype);

		lblText = new JLabel("");
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		lblText.setForeground(new Color(255, 255, 255));
		lblText.setFont(font);
		lblText.setBounds(45, 345, 294, 132);
		add(lblText);

		lblTemplate = new JLabel("");
		lblTemplate.setFont(new Font("Cambria", Font.PLAIN, 11));
		lblTemplate.setIcon(new ImageIcon(CardGraphic.INCOLOR.getTemplate()));
		lblTemplate.setBounds(0, 0, 381, 531);
		add(lblTemplate);

	}

	public void saveImage() {

		BufferedImage image = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = image.createGraphics();

		paint(graphics2D);

		try {
			ImageIO.write(image, "png",
					new File("C:\\Users\\Mau\\workspace\\CardGame\\save\\"
							+ lblName.getText() + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JLabel getLblSubtype() {
		return lblSubtype;
	}

	public JLabel getLblTemplate() {
		return lblTemplate;
	}

	public JLabel getLblText() {
		return lblText;
	}

	public JLabel getLblType() {
		return lblType;
	}

	public JLabel getLblMark3() {
		return lblMark3;
	}

	public JLabel getLblMark2() {
		return lblMark2;
	}

	public JLabel getLblMark1() {
		return lblMark1;
	}

	public JLabel getLblCost1() {
		return lblCost1;
	}

	public JLabel getLblCost2() {
		return lblCost2;
	}

	public JLabel getLblCost3() {
		return lblCost3;
	}

	public JLabel getLblAtk() {
		return lblAtk;
	}

	public JLabel getLblDif() {
		return lblDif;
	}

	public JLabel getLblRng() {
		return lblRng;
	}

	public GuiManager getGm() {
		return gm;
	}

	public CardGraphic getCg() {
		return cg;
	}

	public JLabel getGifAtk() {
		return gifAtk;
	}

	public JLabel getGifDif() {
		return gifDif;
	}

	public JLabel getGifRng() {
		return gifRng;
	}

}
