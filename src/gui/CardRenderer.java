package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
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

	private CardGraphic costStyle1;
	private CardGraphic costStyle2;
	private CardGraphic costStyle3;

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
		repaint();
	}

	public void setCost1(int cost1) {
		this.cost1 = cost1;
		repaint();
	}

	public void setCost2(int cost2) {
		this.cost2 = cost2;
		repaint();
	}

	public void setCost3(int cost3) {
		this.cost3 = cost3;
		repaint();
	}

	public void setCostStyle1(CardGraphic style1) {
		this.costStyle1 = style1;
		repaint();
	}

	public void setCostStyle2(CardGraphic style2) {
		this.costStyle2 = style2;
		repaint();
	}

	public void setCostStyle3(CardGraphic style3) {
		this.costStyle3 = style3;
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
				background.getHeight(null), BufferedImage.TYPE_INT_ARGB_PRE);
		Graphics2D graphics2D = image.createGraphics();
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		paintComponent(graphics2D);
		image = image.getSubimage(2, 2, background.getWidth(null) - 4,
				background.getHeight(null) - 4);
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
		g.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		renderBackground(g);
		renderName(g);
		renderType(g);
		renderSubtype(g);
		try {
			renderCost1(g);
			renderCost2(g);
			renderCost3(g);
		} catch (IOException e) {
			e.printStackTrace();
		}
		renderText(g);
		if (creature) {
			renderAttack(g);
			renderDefence(g);
			renderRange(g);
		}
	}

	private void renderBackground(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
	}

	private void renderName(Graphics2D g) {
		Font font = new Font("Plantagenet Cherokee", Font.BOLD , 15);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString(name, 45, 60);
	}

	private void renderSubtype(Graphics2D g) {
		Font font = new Font("Plantagenet Cherokee", Font.BOLD , 13);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString(subtype, 165, 90);
	}

	private void renderType(Graphics2D g) {
		Font font = new Font("Plantagenet Cherokee", Font.BOLD | Font.ITALIC, 13);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString(type, 55, 90);
	}

	private void renderCost1(Graphics2D g) throws IOException {
		if (cost1 < 0)
			return;
		Font font = new Font("Plantagenet Cherokee", Font.BOLD, 17);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawImage(ImageIO.read(costStyle1.getMark10()), 310, 40, null);
		g.drawString("" + cost1, 330, 70);
	}

	private void renderCost2(Graphics2D g) throws IOException {
		if (cost2 < 0)
			return;
		Font font = new Font("Plantagenet Cherokee", Font.BOLD, 17);
		g.setColor(Color.WHITE);
		g.setFont(font);
		if (costStyle2 != null)
			g.drawImage(ImageIO.read(costStyle2.getMark10()), 275, 40, null);
		else
			g.drawImage(ImageIO.read(CardGraphic.INCOLOR.getMark10()), 275, 40,
					null);
		g.drawString("" + cost2, 295, 70);
	}

	private void renderCost3(Graphics2D g) throws IOException {
		if (cost3 < 0)
			return;
		Font font = new Font("Plantagenet Cherokee", Font.BOLD, 17);
		g.setColor(Color.WHITE);
		g.setFont(font);
		if (costStyle3 != null)
			g.drawImage(ImageIO.read(costStyle3.getMark10()), 240, 40, null);
		else
			g.drawImage(ImageIO.read(CardGraphic.INCOLOR.getMark10()), 240, 40,
					null);
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
		Font font = new Font("Plantagenet Cherokee", Font.BOLD, 13);
		g.setColor(Color.WHITE);
		g.setFont(font);
		drawStringRect(g, 50, 350, 335, 500, 1.5f, text);
	}

	private void drawStringRect(Graphics2D graphics, int x1, int y1, int x2,
			int y2, float interline, String txt) {
		if (txt.length() <= 0)
			return;
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
