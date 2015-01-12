package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CardRenderer extends JPanel {

	private CardGraphic style;
	private Image background;

	private String type = "";
	private String name = "";
	private String subtype = "";
	private String text = "";

	private int cost1 = -1;
	private int cost2 = -1;
	private int cost3 = -1;

	private Image costImage1;
	private Image costImage2;
	private Image costImage3;

	private boolean creature;

	private Image attackImage;
	private Image defenseImage;
	private Image rangeImage;

	private int attack;
	private int defence;
	private int range;

	private static final long serialVersionUID = -5219314188868032918L;

	public void setStyle(CardGraphic style) {
		this.style = style;
		if (this.background != null) {
			this.background.flush();
			this.background = null;
		}
		try {
			background = ImageIO.read(style.getTemplate());
			Dimension dim = new Dimension(background.getWidth(null),
					background.getHeight(null));
			this.setMinimumSize(dim);
			this.setPreferredSize(dim);
			this.setSize(dim);
			repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
		repaint();
	}

	public void setType(String type) {
		this.type = type;
		repaint();
	}

	public void setName(String name) {
		this.name = name;
		repaint();
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public void setCost1(int cost1, Image costImage1) {
		this.cost1 = cost1;
		this.costImage1 = costImage1;
		repaint();
	}

	public void setCost2(int cost2, Image costImage2) {
		this.cost2 = cost2;
		this.costImage2 = costImage2;
		repaint();
	}

	public void setCost3(int cost3, Image costImage3) {
		this.cost3 = cost3;
		this.costImage3 = costImage3;
		repaint();
	}

	public boolean isCreature() {
		return creature;
	}

	public void setCreature(boolean creature) {
		this.creature = creature;
		if (creature) {
			loadStatsImages();
		} else {
			flushStatsImages();

		}
		repaint();
	}

	private void loadStatsImages() {
		try {
			attackImage = ImageIO.read(style.getAtk());
			defenseImage = ImageIO.read(style.getDif());
			rangeImage = ImageIO.read(style.getRng());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void flushStatsImages() {
		attackImage.flush();
		attackImage = null;
		defenseImage.flush();
		defenseImage = null;
		rangeImage.flush();
		rangeImage = null;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
		repaint();
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
		repaint();
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
		repaint();
	}

	public CardGraphic getStyle() {
		return style;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public void saveImage(File file) {
		BufferedImage image = new BufferedImage(background.getWidth(null),
				background.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = image.createGraphics();
		paintComponent(graphics2D);
		try {
			ImageIO.write(image, "png", file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		renderBackground(g);
		renderName(g);
		renderType(g);
		renderSubtype(g);
		renderCost1(g);
		renderCost2(g);
		renderCost3(g);
		renderText(g);
		if (creature) {
			renderAttack(g);
			renderDefence(g);
			renderRange(g);
		}
	}

	private void renderBackground(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}

	private void renderName(Graphics g) {
		Font font = new Font("Plantagenet Cherokee", Font.PLAIN, 16);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString(name, 45, 60);
	}

	private void renderSubtype(Graphics g) {
		Font font = new Font("Plantagenet Cherokee", Font.PLAIN, 16);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString(subtype, 165, 90);
	}

	private void renderType(Graphics g) {
		Font font = new Font("Plantagenet Cherokee", Font.ITALIC, 13);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString(type, 55, 90);
	}

	private void renderCost1(Graphics g) {
		if (cost1 < 0)
			return;
		Font font = new Font("Plantagenet Cherokee", Font.BOLD, 17);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawImage(costImage1, 310, 40, null);
		g.drawString("" + cost1, 330, 70);
	}

	private void renderCost2(Graphics g) {
		if (cost2 < 0)
			return;
		Font font = new Font("Plantagenet Cherokee", Font.BOLD, 17);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawImage(costImage2, 275, 40, null);
		g.drawString("" + cost2, 295, 70);
	}

	private void renderCost3(Graphics g) {
		if (cost3 < 0)
			return;
		Font font = new Font("Plantagenet Cherokee", Font.BOLD, 17);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawImage(costImage3, 240, 40, null);
		g.drawString("" + cost3, 260, 70);
	}

	private void renderRange(Graphics2D g) {
		Font font = new Font("Plantagenet Cherokee", Font.BOLD, 17);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawImage(rangeImage, 320, 210, null);
		g.drawString("" + range, 340, 240);
	}

	private void renderDefence(Graphics2D g) {
		Font font = new Font("Plantagenet Cherokee", Font.BOLD, 17);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawImage(defenseImage, 320, 170, null);
		g.drawString("" + defence, 340, 200);
	}

	private void renderAttack(Graphics2D g) {
		Font font = new Font("Plantagenet Cherokee", Font.BOLD, 17);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawImage(attackImage, 320, 130, null);
		g.drawString("" + attack, 340, 160);
	}

	private void renderText(Graphics2D g) {
		Font font = new Font("Plantagenet Cherokee", Font.PLAIN, 13);
		g.setColor(Color.WHITE);
		g.setFont(font);
		drawStringRect(g, 50, 350, 335, 500, 1.5f, text);
	}

	private void drawStringRect(Graphics2D graphics, int x1, int y1, int x2,
			int y2, float interline, String txt) {
		if(txt.length() <= 0) return;
		AttributedString as = new AttributedString(txt);
		as.addAttribute(TextAttribute.FOREGROUND, graphics.getPaint());
		as.addAttribute(TextAttribute.FONT, graphics.getFont());
		AttributedCharacterIterator aci = as.getIterator();
		FontRenderContext frc = new FontRenderContext(null, true, false);
		LineBreakMeasurer lbm = new LineBreakMeasurer(aci, frc);
		float width = x2 - x1;

		while (lbm.getPosition() < txt.length()) {
			TextLayout tl = lbm.nextLayout(width);
			y1 += tl.getAscent();
			tl.draw(graphics, x1, y1);
			y1 += tl.getDescent() + tl.getLeading() + (interline - 1.0f)
					* tl.getAscent();
			if (y1 > y2) {
				break;
			}
		}
	}

}
