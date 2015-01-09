package gui;

import parser.visitor.CardCreatorVisitor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import card.*;

public class GuiManager {
	private StatPanel statPanel;
	private CardPanel cardPanel;
	private GrammarPanel grammarPanel;
	private CardCreatorVisitor visitor;
	private boolean parserInit;

	public GuiManager() {
		parserInit = false;
	}

	public StatPanel getStatPanel() {
		return statPanel;
	}

	public CardPanel getCardPanel() {
		return cardPanel;
	}

	public GrammarPanel getGrammarPanel() {
		return grammarPanel;
	}

	public CardCreatorVisitor getVisitor() {
		return visitor;
	}

	public void setStatPanel(StatPanel statPanel) {
		this.statPanel = statPanel;
	}

	public void setCardPanel(CardPanel cardPanel) {
		this.cardPanel = cardPanel;
	}

	public void setGrammarPanel(GrammarPanel grammarPanel) {
		this.grammarPanel = grammarPanel;
	}

	public void setVisitor(CardCreatorVisitor visitor) {
		this.visitor = visitor;
	}

	public boolean isParserInit() {
		return parserInit;
	}

	public void setParserInit(boolean parserInit) {
		this.parserInit = parserInit;
	}

	public void WriteCardType(String s) {
		if (cardPanel != null) {
			if (s.toUpperCase().equals(
					CardType.CREATURE.getName().toUpperCase()))
				cardPanel.getLblType().setText(CardType.CREATURE.getName());

			if (s.toUpperCase().equals(CardType.SPELL.getName().toUpperCase()))
				cardPanel.getLblType().setText(CardType.SPELL.getName());

			if (s.toUpperCase().equals(
					CardType.PERMANENT.getName().toUpperCase()))
				cardPanel.getLblType().setText(CardType.PERMANENT.getName());
		}
	}

	public void WriteCardName(String s) {
		if (cardPanel != null)
			cardPanel.getLblName().setText(s);
	}

	public void WriteCardSubType(String s) {
		if (cardPanel != null)
			cardPanel.getLblSubtype().setText(s);
	}

	public void WriteCardText(String s) {
		if (cardPanel != null)
			cardPanel.getLblText().setText(s);
	}

	public void WriteCost1(String c) {
		if (cardPanel != null) {
			cardPanel.getLblCost1().setText(c);
			cardPanel.getLblCost1().setVisible(true);
		}
	}

	public void WriteCost2(String c) {
		if (cardPanel != null) {
			cardPanel.getLblCost2().setText(c);
			cardPanel.getLblCost2().setVisible(true);
		}
	}

	public void WriteCost3(String c) {
		if (cardPanel != null) {
			cardPanel.getLblCost3().setText(c);
			cardPanel.getLblCost3().setVisible(true);
		}
	}

	public void WriteAtk(String c) {
		if (cardPanel != null)
			cardPanel.getLblAtk().setText(c);
	}

	public void WriteDif(String c) {
		if (cardPanel != null)
			cardPanel.getLblDif().setText(c);
	}

	public void WriteRng(String c) {
		if (cardPanel != null)
			cardPanel.getLblRng().setText(c);
	}

	public void showStat(boolean result) {
		cardPanel.getLblAtk().setVisible(result);
		cardPanel.getGifAtk().setVisible(result);

		cardPanel.getGifDif().setVisible(result);
		cardPanel.getGifRng().setVisible(result);

		cardPanel.getLblDif().setVisible(result);
		cardPanel.getLblRng().setVisible(result);
	}

	public void showCost(int idCost) {
		switch (idCost) {
		case 1:
			cardPanel.getLblCost2().setVisible(false);
			cardPanel.getLblMark2().setVisible(false);
		case 2:
			cardPanel.getLblCost3().setVisible(false);
			cardPanel.getLblMark3().setVisible(false);
		default:
		}
	}

	/*
	 * Visualizza l'icona dell'elemento. CostNum indica quale dei tre costi
	 * visualizzare
	 */
	public void paintCost(int costNum, String elem) {
		if (cardPanel != null) {
			switch (elem.toUpperCase()) {
			case "INCOLOR":
				paintCost(costNum, Element.INCOLOR.getId());
				break;
			case "AIR":
				paintCost(costNum, Element.AIR.getId());
				break;
			case "EARTH":
				paintCost(costNum, Element.EARTH.getId());
				break;
			case "WATER":
				paintCost(costNum, Element.WATER.getId());
				break;
			case "FIRE":
				paintCost(costNum, Element.FIRE.getId());
				break;
			case "LIFE":
				paintCost(costNum, Element.LIFE.getId());
				break;
			case "DEATH":
				paintCost(costNum, Element.DEATH.getId());
				break;
			case "SPACE":
				paintCost(costNum, Element.SPACE.getId());
				break;
			case "TIME":
				paintCost(costNum, Element.TIME.getId());
				break;
			case "LIGHT":
				paintCost(costNum, Element.LIGHT.getId());
				break;
			case "DARKNESS":
				paintCost(costNum, Element.DARKNESS.getId());
				break;
			case "NOUS":
				paintCost(costNum, Element.NOUS.getId());
				break;
			case "VOID":
				paintCost(costNum, Element.VOID.getId());
				break;
			}
		}
	}

	public void paintCost(int costNum, int id) {
		if (cardPanel != null) {
			JLabel label = cardPanel.getLblMark1();

			if (costNum == 2)
				label = cardPanel.getLblMark2();

			if (costNum == 3)
				label = cardPanel.getLblMark3();

			label.setVisible(true);

			if (id == Element.INCOLOR.getId()) {
				label.setIcon(new ImageIcon(CardGraphic.INCOLOR.getMark10()));
			} else if (id == Element.WATER.getId()) {
				label.setIcon(new ImageIcon(CardGraphic.WATER.getMark10()));
			} else if (id == Element.FIRE.getId()) {
				label.setIcon(new ImageIcon(CardGraphic.FIRE.getMark10()));
			} else if (id == Element.AIR.getId()) {
				label.setIcon(new ImageIcon(CardGraphic.AIR.getMark10()));
			} else if (id == Element.EARTH.getId()) {
				label.setIcon(new ImageIcon(CardGraphic.EARTH.getMark10()));
			} else if (id == Element.LIGHT.getId()) {
				label.setIcon(new ImageIcon(CardGraphic.LIGHT.getMark10()));
			} else if (id == Element.DARKNESS.getId()) {
				label.setIcon(new ImageIcon(CardGraphic.DARKNESS.getMark10()));
			} else if (id == Element.LIFE.getId()) {
				label.setIcon(new ImageIcon(CardGraphic.LIFE.getMark10()));
			} else if (id == Element.DEATH.getId()) {
				label.setIcon(new ImageIcon(CardGraphic.DEATH.getMark10()));
			} else if (id == Element.SPACE.getId()) {
				label.setIcon(new ImageIcon(CardGraphic.SPACE.getMark10()));
			} else if (id == Element.TIME.getId()) {
				label.setIcon(new ImageIcon(CardGraphic.TIME.getMark10()));
			} else if (id == Element.NOUS.getId()) {
				label.setIcon(new ImageIcon(CardGraphic.NOUS.getMark10()));
			} else if (id == Element.VOID.getId()) {
				label.setIcon(new ImageIcon(CardGraphic.VOID.getMark10()));
			}

		}
	}

	public void paintTemplate(String elem) {
		if (cardPanel != null) {
			switch (elem.toUpperCase()) {
			case "INCOLOR":
				paintTemplate(Element.INCOLOR.getId());
				break;
			case "AIR":
				paintTemplate(Element.AIR.getId());
				break;
			case "EARTH":
				paintTemplate(Element.EARTH.getId());
				break;
			case "WATER":
				paintTemplate(Element.WATER.getId());
				break;
			case "FIRE":
				paintTemplate(Element.FIRE.getId());
				break;
			case "LIFE":
				paintTemplate(Element.LIFE.getId());
				break;
			case "DEATH":
				paintTemplate(Element.DEATH.getId());
				break;
			case "SPACE":
				paintTemplate(Element.SPACE.getId());
				break;
			case "TIME":
				paintTemplate(Element.TIME.getId());
				break;
			case "LIGHT":
				paintTemplate(Element.LIGHT.getId());
				break;
			case "DARKNESS":
				paintTemplate(Element.DARKNESS.getId());
				break;
			case "NOUS":
				paintTemplate(Element.NOUS.getId());
				break;
			case "VOID":
				paintTemplate(Element.VOID.getId());
				break;
			}
		}
	}

	public void paintTemplate(Element e) {
		paintTemplate(e.getId());
	}

	public void paintTemplate(int id) {
		if (cardPanel != null) {
			if (id == Element.INCOLOR.getId()) {
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.INCOLOR.getTemplate()));
			} else if (id == Element.WATER.getId()) {
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.WATER.getTemplate()));
			} else if (id == Element.FIRE.getId()) {
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.FIRE.getTemplate()));
			} else if (id == Element.AIR.getId()) {
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.AIR.getTemplate()));
			} else if (id == Element.EARTH.getId()) {
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.EARTH.getTemplate()));
			} else if (id == Element.LIGHT.getId()) {
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.LIGHT.getTemplate()));
			} else if (id == Element.DARKNESS.getId()) {
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.DARKNESS.getTemplate()));
			} else if (id == Element.LIFE.getId()) {
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.LIFE.getTemplate()));
			} else if (id == Element.DEATH.getId()) {
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.DEATH.getTemplate()));
			} else if (id == Element.SPACE.getId()) {
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.SPACE.getTemplate()));
			} else if (id == Element.TIME.getId()) {
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.TIME.getTemplate()));
			} else if (id == Element.NOUS.getId()) {
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.NOUS.getTemplate()));
			} else if (id == Element.VOID.getId()) {
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.VOID.getTemplate()));
			}

		}

	}
}
