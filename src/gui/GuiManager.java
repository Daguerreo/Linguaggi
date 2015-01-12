package gui;

import parser.visitor.custom.CardCreatorVisitor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.tree.DefaultMutableTreeNode;

import card.*;

public class GuiManager {
	private StatPanel statPanel;
	private CardPanel cardPanel;
	private CardRenderer cardRenderer;
	private GrammarPanel grammarPanel;
	private TreePanel treePanel;

	private CardCreatorVisitor visitor;
	private boolean parserInit;

	public GuiManager() {
		parserInit = false;
	}

	public CardRenderer getCardRenderer() {
		return cardRenderer;
	}

	public void setCardRenderer(CardRenderer cardRenderer) {
		this.cardRenderer = cardRenderer;
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

	public TreePanel getTreePanel() {
		return treePanel;
	}

	public void setTreePanel(TreePanel treePanel) {
		this.treePanel = treePanel;
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

	public void paintTree(DefaultMutableTreeNode t) {
		treePanel.repaintTree(t);
	}

	public boolean isParserInit() {
		return parserInit;
	}

	public void setParserInit(boolean parserInit) {
		this.parserInit = parserInit;
	}

	public void showResult(String s) {
		grammarPanel.setLblMsg(s);
	}

	public void writeCardType(String s) {
		if (cardPanel != null) {
			if (s.equalsIgnoreCase(CardType.CREATURE.getName())) {
				cardPanel.getLblType().setText(CardType.CREATURE.getName());
				cardRenderer.setType(CardType.CREATURE.getName());
				cardRenderer.setCreature(true);
			}

			else if (s.equalsIgnoreCase(CardType.SPELL.getName())) {
				cardPanel.getLblType().setText(CardType.SPELL.getName());
				cardRenderer.setType(CardType.SPELL.getName());
			}

			else if (s.equalsIgnoreCase(CardType.PERMANENT.getName())) {
				cardPanel.getLblType().setText(CardType.PERMANENT.getName());
				cardRenderer.setType(CardType.PERMANENT.getName());
			}
		}
	}

	public void WriteCardName(String s) {
		if (cardPanel != null) {
			cardPanel.getLblName().setText(s);
			cardRenderer.setName(s);
		}
	}

	public void WriteCardSubType(String s) {
		if (cardPanel != null) {
			cardPanel.getLblSubtype().setText(s);
			cardRenderer.setSubtype(s);
		}
	}

	public void WriteCardText(String s) {
		if (cardPanel != null) {
			cardPanel.getLblText().setText(s);
			cardRenderer.setText(s);
		}
	}

	public void WriteCost1(String c) {
		if (cardPanel != null) {
			cardPanel.getLblCost1().setText(c);
			cardPanel.getLblCost1().setVisible(true);
			cardRenderer.setCost1(Integer.parseInt(c));
		}
	}

	public void WriteCost2(String c) {
		if (cardPanel != null) {
			cardPanel.getLblCost2().setText(c);
			cardPanel.getLblCost2().setVisible(true);
			cardRenderer.setCost2(Integer.parseInt(c));
		}
	}

	public void WriteCost3(String c) {
		if (cardPanel != null) {
			cardPanel.getLblCost3().setText(c);
			cardPanel.getLblCost3().setVisible(true);
			cardRenderer.setCost3(Integer.parseInt(c));
		}
	}

	public void WriteAtk(String c) {
		if (cardPanel != null) {
			cardPanel.getLblAtk().setText(c);
			cardRenderer.setAttack(Integer.parseInt(c));
		}
	}

	public void WriteDif(String c) {
		if (cardPanel != null) {
			cardPanel.getLblDif().setText(c);
			cardRenderer.setDefence(Integer.parseInt(c));
		}
	}

	public void WriteRng(String c) {
		if (cardPanel != null) {
			cardPanel.getLblRng().setText(c);
			cardRenderer.setRange(Integer.parseInt(c));
		}
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
			cardRenderer.setCost2(-1);
			cardPanel.getLblCost2().setVisible(false);
			cardPanel.getLblMark2().setVisible(false);
		case 2:
			cardRenderer.setCost3(-1);
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
				paintCost(costNum, CardGraphic.INCOLOR);
				break;
			case "AIR":
				paintCost(costNum, Element.AIR.getId());
				paintCost(costNum, CardGraphic.AIR);
				break;
			case "EARTH":
				paintCost(costNum, Element.EARTH.getId());
				paintCost(costNum, CardGraphic.EARTH);
				break;
			case "WATER":
				paintCost(costNum, Element.WATER.getId());
				paintCost(costNum, CardGraphic.WATER);
				break;
			case "FIRE":
				paintCost(costNum, Element.FIRE.getId());
				paintCost(costNum, CardGraphic.FIRE);
				break;
			case "LIFE":
				paintCost(costNum, Element.LIFE.getId());
				paintCost(costNum, CardGraphic.LIFE);
				break;
			case "DEATH":
				paintCost(costNum, Element.DEATH.getId());
				paintCost(costNum, CardGraphic.DEATH);
				break;
			case "SPACE":
				paintCost(costNum, Element.SPACE.getId());
				paintCost(costNum, CardGraphic.SPACE);
				break;
			case "TIME":
				paintCost(costNum, Element.TIME.getId());
				paintCost(costNum, CardGraphic.TIME);
				break;
			case "LIGHT":
				paintCost(costNum, Element.LIGHT.getId());
				paintCost(costNum, CardGraphic.LIGHT);
				break;
			case "DARKNESS":
				paintCost(costNum, Element.DARKNESS.getId());
				paintCost(costNum, CardGraphic.DARKNESS);
				break;
			case "NOUS":
				paintCost(costNum, Element.NOUS.getId());
				paintCost(costNum, CardGraphic.NOUS);
				break;
			case "VOID":
				paintCost(costNum, Element.VOID.getId());
				paintCost(costNum, CardGraphic.VOID);
				break;
			}
		}
	}

	public void paintCost(int costNum, CardGraphic cg) {
		if (costNum == 1) {
			cardRenderer.setCostStyle1(cg);
		} else if (costNum == 2) {
			cardRenderer.setCostStyle2(cg);
		} else {
			cardRenderer.setCostStyle3(cg);
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
				paintCost(costNum,CardGraphic.INCOLOR);
				label.setIcon(new ImageIcon(CardGraphic.INCOLOR.getMark10()));
			} else if (id == Element.WATER.getId()) {
				paintCost(costNum,CardGraphic.WATER);
				label.setIcon(new ImageIcon(CardGraphic.WATER.getMark10()));
			} else if (id == Element.FIRE.getId()) {
				paintCost(costNum,CardGraphic.FIRE);
				label.setIcon(new ImageIcon(CardGraphic.FIRE.getMark10()));
			} else if (id == Element.AIR.getId()) {
				paintCost(costNum,CardGraphic.AIR);
				label.setIcon(new ImageIcon(CardGraphic.AIR.getMark10()));
			} else if (id == Element.EARTH.getId()) {
				paintCost(costNum,CardGraphic.EARTH);
				label.setIcon(new ImageIcon(CardGraphic.EARTH.getMark10()));
			} else if (id == Element.LIGHT.getId()) {
				paintCost(costNum,CardGraphic.LIGHT);
				label.setIcon(new ImageIcon(CardGraphic.LIGHT.getMark10()));
			} else if (id == Element.DARKNESS.getId()) {
				paintCost(costNum,CardGraphic.DARKNESS);
				label.setIcon(new ImageIcon(CardGraphic.DARKNESS.getMark10()));
			} else if (id == Element.LIFE.getId()) {
				paintCost(costNum,CardGraphic.LIFE);
				label.setIcon(new ImageIcon(CardGraphic.LIFE.getMark10()));
			} else if (id == Element.DEATH.getId()) {
				paintCost(costNum,CardGraphic.DEATH);
				label.setIcon(new ImageIcon(CardGraphic.DEATH.getMark10()));
			} else if (id == Element.SPACE.getId()) {
				paintCost(costNum,CardGraphic.SPACE);
				label.setIcon(new ImageIcon(CardGraphic.SPACE.getMark10()));
			} else if (id == Element.TIME.getId()) {
				paintCost(costNum,CardGraphic.TIME);
				label.setIcon(new ImageIcon(CardGraphic.TIME.getMark10()));
			} else if (id == Element.NOUS.getId()) {
				paintCost(costNum,CardGraphic.NOUS);
				label.setIcon(new ImageIcon(CardGraphic.NOUS.getMark10()));
			} else if (id == Element.VOID.getId()) {
				paintCost(costNum,CardGraphic.VOID);
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
				cardRenderer.setStyle(CardGraphic.INCOLOR);
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.INCOLOR.getTemplate()));
			} else if (id == Element.WATER.getId()) {
				cardRenderer.setStyle(CardGraphic.WATER);
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.WATER.getTemplate()));
			} else if (id == Element.FIRE.getId()) {
				cardRenderer.setStyle(CardGraphic.FIRE);
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.FIRE.getTemplate()));
			} else if (id == Element.AIR.getId()) {
				cardRenderer.setStyle(CardGraphic.AIR);
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.AIR.getTemplate()));
			} else if (id == Element.EARTH.getId()) {
				cardRenderer.setStyle(CardGraphic.EARTH);
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.EARTH.getTemplate()));
			} else if (id == Element.LIGHT.getId()) {
				cardRenderer.setStyle(CardGraphic.LIGHT);
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.LIGHT.getTemplate()));
			} else if (id == Element.DARKNESS.getId()) {
				cardRenderer.setStyle(CardGraphic.DARKNESS);
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.DARKNESS.getTemplate()));
			} else if (id == Element.LIFE.getId()) {
				cardRenderer.setStyle(CardGraphic.LIFE);
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.LIFE.getTemplate()));
			} else if (id == Element.DEATH.getId()) {
				cardRenderer.setStyle(CardGraphic.DEATH);
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.DEATH.getTemplate()));
			} else if (id == Element.SPACE.getId()) {
				cardRenderer.setStyle(CardGraphic.SPACE);
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.SPACE.getTemplate()));
			} else if (id == Element.TIME.getId()) {
				cardRenderer.setStyle(CardGraphic.TIME);
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.TIME.getTemplate()));
			} else if (id == Element.NOUS.getId()) {
				cardRenderer.setStyle(CardGraphic.NOUS);
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.NOUS.getTemplate()));
			} else if (id == Element.VOID.getId()) {
				cardRenderer.setStyle(CardGraphic.VOID);
				cardPanel.getLblTemplate().setIcon(
						new ImageIcon(CardGraphic.VOID.getTemplate()));
			}

		}

	}
}
