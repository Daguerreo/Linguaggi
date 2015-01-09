package parser.visitor;

import java.util.Iterator;

import gui.GuiManager;
import parser.syntaxtree.Cost;
import parser.syntaxtree.Creature;
import parser.syntaxtree.Duo;
import parser.syntaxtree.Element;
import parser.syntaxtree.INode;
import parser.syntaxtree.Mono;
import parser.syntaxtree.Name;
import parser.syntaxtree.NodeChoice;
import parser.syntaxtree.NodeList;
import parser.syntaxtree.NodeListOptional;
import parser.syntaxtree.NodeOptional;
import parser.syntaxtree.NodeSequence;
import parser.syntaxtree.NodeTCF;
import parser.syntaxtree.NodeToken;
import parser.syntaxtree.Permanent;
import parser.syntaxtree.Scope;
import parser.syntaxtree.Spell;
import parser.syntaxtree.Stat;
import parser.syntaxtree.Subtype;
import parser.syntaxtree.Text;
import parser.syntaxtree.Trio;

public class CardCreatorVisitor implements IVoidVisitor {
	private GuiManager gm;
	private String outMsg = "";

	public String getOutMsg() {
		return outMsg;
	}

	public void setGuiManager(GuiManager gm) {
		this.gm = gm;
	}

	@Override
	public void visit(final NodeChoice n) {
		n.choice.accept(this);
		return;
	}

	@Override
	public void visit(final NodeList n) {
		for (final Iterator<INode> e = n.elements(); e.hasNext();) {
			e.next().accept(this);
		}
		return;
	}

	@Override
	public void visit(final NodeListOptional n) {
		if (n.present()) {
			for (final Iterator<INode> e = n.elements(); e.hasNext();) {
				e.next().accept(this);
			}
			return;
		} else
			return;
	}

	@Override
	public void visit(final NodeOptional n) {
		if (n.present()) {
			n.node.accept(this);
			return;
		} else
			return;
	}

	@Override
	public void visit(final NodeSequence n) {
		for (final Iterator<INode> e = n.elements(); e.hasNext();) {
			e.next().accept(this);
		}
		return;
	}

	@Override
	public void visit(final NodeTCF n) {
		@SuppressWarnings("unused")
		final String tkIm = n.tokenImage;
		return;
	}

	@Override
	public void visit(final NodeToken n) {
		/*
		 * @SuppressWarnings("unused") final String tkIm = n.tokenImage; return;
		 */
		System.out.println("visit " + n.tokenImage);
		// outMsg += n.tokenImage + " ";
	}

	@Override
	public void visit(final Scope n) {
		// f0 -> . %0 Spell()
		// .. .. | %1 Permanent()
		// .. .. | %2 Creature()
		n.f0.accept(this);
	}

	@Override
	public void visit(final Spell n) {
		// f0 -> <SPELL>
		n.f0.accept(this);
		// f1 -> Name()
		n.f1.accept(this);
		// f2 -> <LBLOCK>
		n.f2.accept(this);
		// f3 -> Element()
		n.f3.accept(this);
		// f4 -> Cost()
		n.f4.accept(this);
		// f5 -> Subtype()
		n.f5.accept(this);
		// f6 -> Text()
		n.f6.accept(this);
		// f7 -> <RBLOCK>
		n.f7.accept(this);

		gm.showStat(false);
		gm.WriteCardType(n.f0.tokenImage);
	}

	@Override
	public void visit(final Permanent n) {
		// f0 -> <PERMANENT>
		n.f0.accept(this);
		// f1 -> Name()
		n.f1.accept(this);
		// f2 -> <LBLOCK>
		n.f2.accept(this);
		// f3 -> Element()
		n.f3.accept(this);
		// f4 -> Cost()
		n.f4.accept(this);
		// f5 -> Subtype()
		n.f5.accept(this);
		// f6 -> Text()
		n.f6.accept(this);
		// f7 -> <RBLOCK>
		n.f7.accept(this);

		gm.showStat(false);
		gm.WriteCardType(n.f0.tokenImage);
	}

	@Override
	public void visit(final Creature n) {
		// f0 -> <CREATURE>
		n.f0.accept(this);
		// f1 -> Name()
		n.f1.accept(this);
		// f2 -> <LBLOCK>
		n.f2.accept(this);
		// f3 -> Element()
		n.f3.accept(this);
		// f4 -> Cost()
		n.f4.accept(this);
		// f5 -> Subtype()
		n.f5.accept(this);
		// f6 -> Stat()
		n.f6.accept(this);
		// f7 -> Text()
		n.f7.accept(this);
		// f8 -> <RBLOCK>
		n.f8.accept(this);

		gm.showStat(true);
		gm.WriteCardType(n.f0.tokenImage);
	}

	@Override
	public void visit(final Name n) {
		String text;

		// f0 -> <WORD>
		n.f0.accept(this);
		text = n.f0.tokenImage;

		// f1 -> ( %0 <WORD>
		// .. .. | %1 <PUNCT> )*
		n.f1.accept(this);
		for (int i = 0; i < n.f1.nodes.size(); i++) {
			NodeToken node = (NodeToken) ((NodeChoice) n.f1.nodes.get(i)).choice;
			text += " " + node.tokenImage;
		}

		gm.WriteCardName(text);
	}

	@Override
	public void visit(final Element n) {
		// f0 -> <ELEMENT>
		n.f0.accept(this);
		// f1 -> <LPAR>
		n.f1.accept(this);

		// f2 -> <ELEMENTS>
		n.f2.accept(this);
		gm.paintTemplate(n.f2.tokenImage);

		// f3 -> <RPAR>
		n.f3.accept(this);
	}

	@Override
	public void visit(final Cost n) {
		// f0 -> <COST>
		n.f0.accept(this);
		// f1 -> ( %0 Mono()
		// .. .. | %1 Duo()
		// .. .. | %2 Trio() )
		n.f1.accept(this);
	}

	@Override
	public void visit(final Mono n) {
		// f0 -> <MONO>
		n.f0.accept(this);
		// f1 -> <LPAR>
		n.f1.accept(this);
		// f2 -> <NUMBER>
		n.f2.accept(this);
		// f3 -> <ELEMENTS>
		n.f3.accept(this);
		// f4 -> <RPAR>
		n.f4.accept(this);

		gm.WriteCost1(n.f2.tokenImage);
		gm.paintCost(1, n.f3.tokenImage);
		gm.showCost(1);
	}

	@Override
	public void visit(final Duo n) {
		// f0 -> <DUO>
		n.f0.accept(this);
		// f1 -> <LPAR>
		n.f1.accept(this);
		// f2 -> <NUMBER>
		n.f2.accept(this);
		// f3 -> <ELEMENTS>
		n.f3.accept(this);
		// f4 -> <NUMBER>
		n.f4.accept(this);
		// f5 -> <ELEMENTS>
		n.f5.accept(this);
		// f6 -> <RPAR>
		n.f6.accept(this);

		gm.WriteCost1(n.f2.tokenImage);
		gm.paintCost(1, n.f3.tokenImage);
		gm.WriteCost2(n.f4.tokenImage);
		gm.paintCost(2, n.f5.tokenImage);
		gm.showCost(2);
	}

	@Override
	public void visit(final Trio n) {
		// f0 -> <TRIO>
		n.f0.accept(this);
		// f1 -> <LPAR>
		n.f1.accept(this);
		// f2 -> <NUMBER>
		n.f2.accept(this);
		// f3 -> <ELEMENTS>
		n.f3.accept(this);
		// f4 -> <NUMBER>
		n.f4.accept(this);
		// f5 -> <ELEMENTS>
		n.f5.accept(this);
		// f6 -> <NUMBER>
		n.f6.accept(this);
		// f7 -> <ELEMENTS>
		n.f7.accept(this);
		// f8 -> <RPAR>
		n.f8.accept(this);

		gm.WriteCost1(n.f2.tokenImage);
		gm.paintCost(1, n.f3.tokenImage);
		gm.WriteCost2(n.f4.tokenImage);
		gm.paintCost(2, n.f5.tokenImage);
		gm.WriteCost3(n.f6.tokenImage);
		gm.paintCost(3, n.f7.tokenImage);
		gm.showCost(3);
	}

	@Override
	public void visit(final Subtype n) {
		// f0 -> <SUBTYPE>
		n.f0.accept(this);
		// f1 -> <LPAR>
		n.f1.accept(this);
		// f2 -> ( <WORD> )+
		n.f2.accept(this);
		// f3 -> <RPAR>
		n.f3.accept(this);

		String text = "";
		for (int i = 0; i < n.f2.nodes.size(); i++) {
			NodeToken node = (NodeToken) n.f2.nodes.get(i);
			text += " " + node.tokenImage;
		}
		gm.WriteCardSubType(text);
	}

	@Override
	public void visit(final Text n) {
		// f0 -> <TEXT>
		n.f0.accept(this);
		// f1 -> <LPAR>
		n.f1.accept(this);
		// f2 -> ( %0 <WORD>
		// .. .. | %1 <ELEMENTS>
		// .. .. | %2 <PUNCT>
		// .. .. | %3 <MATH>
		// .. .. | %4 <NUMBER> )*
		n.f2.accept(this);
		// f3 -> <RPAR>
		n.f3.accept(this);

		String text = "";
		for (int i = 0; i < n.f2.nodes.size(); i++) {
			NodeToken node = (NodeToken) ((NodeChoice) n.f2.nodes.get(i)).choice;
			text += " " + node.tokenImage;
		}
		gm.WriteCardText(text);
	}

	@Override
	public void visit(final Stat n) {
		// f0 -> <STAT>
		n.f0.accept(this);
		// f1 -> <LPAR>
		n.f1.accept(this);
		// f2 -> <NUMBER>
		n.f2.accept(this);
		// f3 -> <NUMBER>
		n.f3.accept(this);
		// f4 -> <NUMBER>
		n.f4.accept(this);
		// f5 -> <RPAR>
		n.f5.accept(this);

		gm.WriteAtk(n.f2.tokenImage);
		gm.WriteDif(n.f3.tokenImage);
		gm.WriteRng(n.f4.tokenImage);
	}

}
