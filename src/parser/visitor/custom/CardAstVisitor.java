package parser.visitor.custom;

import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;

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
import parser.visitor.IVoidVisitor;

public class CardAstVisitor implements IVoidVisitor {
	private DefaultMutableTreeNode root;
	DefaultMutableTreeNode myParent = null;
	DefaultMutableTreeNode son = null;
	private String text = "";

	public DefaultMutableTreeNode getTree() {
		return root;
	}

	public void setTree(DefaultMutableTreeNode tree) {
		this.root = tree;
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
		root = new DefaultMutableTreeNode("Spell");
		myParent = root;
		
		// f0 -> <SPELL>
		//n.f0.accept(this);
		
		// f1 -> Name()
		son = new DefaultMutableTreeNode("Name");
		myParent.add(son);
		n.f1.accept(this);
		son.add(new DefaultMutableTreeNode(text));
		
		// f3 -> Element()
		son = new DefaultMutableTreeNode("Element");
		myParent.add(son);
		n.f3.accept(this);
		son.add(new DefaultMutableTreeNode(text));
		
		// f4 -> Cost()
		son = new DefaultMutableTreeNode("Cost");
		myParent.add(son);
		n.f4.accept(this);
		
		// f5 -> Subtype()
		son = new DefaultMutableTreeNode("Subtype");
		myParent.add(son);
		n.f5.accept(this);
		
		// f6 -> Text()
		son = new DefaultMutableTreeNode("Text");
		myParent.add(son);
		n.f6.accept(this);
		son.add(new DefaultMutableTreeNode(text));
		
	}

	@Override
	public void visit(final Permanent n) {
		root = new DefaultMutableTreeNode("Permanent");
		myParent = root;
		
		// f0 -> <PERMANENT>
		//n.f0.accept(this);
		
		// f1 -> Name()
		son = new DefaultMutableTreeNode("Name");
		myParent.add(son);
		n.f1.accept(this);
		son.add(new DefaultMutableTreeNode(text));
		
		// f3 -> Element()
		son = new DefaultMutableTreeNode("Element");
		myParent.add(son);
		n.f3.accept(this);
		son.add(new DefaultMutableTreeNode(text));
		
		// f4 -> Cost()
		son = new DefaultMutableTreeNode("Cost");
		myParent.add(son);
		n.f4.accept(this);
		
		// f5 -> Subtype()
		son = new DefaultMutableTreeNode("Subtype");
		myParent.add(son);
		n.f5.accept(this);
		
		// f6 -> Text()
		son = new DefaultMutableTreeNode("Text");
		myParent.add(son);
		n.f6.accept(this);
		son.add(new DefaultMutableTreeNode(text));
	}

	@Override
	public void visit(final Creature n) {
		root = new DefaultMutableTreeNode("Creature");
		myParent = root;
		
		// f0 -> <CREATURE>
		//n.f0.accept(this);
		
		// f1 -> Name()
		son = new DefaultMutableTreeNode("Name");
		myParent.add(son);
		n.f1.accept(this);
		son.add(new DefaultMutableTreeNode(text));

		// f3 -> Element()
		son = new DefaultMutableTreeNode("Element");
		myParent.add(son);
		n.f3.accept(this);
		son.add(new DefaultMutableTreeNode(text));
		
		// f4 -> Cost()
		son = new DefaultMutableTreeNode("Cost");
		myParent.add(son);
		n.f4.accept(this);
		
		// f5 -> Subtype()
		son = new DefaultMutableTreeNode("Subtype");
		myParent.add(son);
		n.f5.accept(this);
		
		// f6 -> Stat()
		son = new DefaultMutableTreeNode("Stat");
		myParent.add(son);
		n.f6.accept(this);
		
		// f7 -> Text()
		son = new DefaultMutableTreeNode("Text");
		myParent.add(son);
		n.f7.accept(this);
		son.add(new DefaultMutableTreeNode(text));


	}

	@Override
	public void visit(final Name n) {
		text = "";
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
	}

	@Override
	public void visit(final Element n) {
		// f0 -> <ELEMENT>
		n.f0.accept(this);

		// f2 -> <ELEMENTS>
		n.f2.accept(this);
		
		text = n.f2.tokenImage;
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
		
		// f2 -> <NUMBER>
		n.f2.accept(this);
		// f3 -> <ELEMENTS>
		n.f3.accept(this);

		myParent = son;
		son = new DefaultMutableTreeNode(n.f2.tokenImage + " " + n.f3.tokenImage);
		myParent.add(son);
		myParent = root;
	}

	@Override
	public void visit(final Duo n) {
		// f0 -> <DUO>
		n.f0.accept(this);
		
		// f2 -> <NUMBER>
		n.f2.accept(this);
		// f3 -> <ELEMENTS>
		n.f3.accept(this);
		
		// f4 -> <NUMBER>
		n.f4.accept(this);
		// f5 -> <ELEMENTS>
		n.f5.accept(this);
		
		myParent = son;
		son = new DefaultMutableTreeNode(n.f2.tokenImage + " " + n.f3.tokenImage);
		myParent.add(son);
		son = new DefaultMutableTreeNode(n.f4.tokenImage + " " + n.f5.tokenImage);
		myParent.add(son);
		myParent = root;
	}

	@Override
	public void visit(final Trio n) {
		// f0 -> <TRIO>
		n.f0.accept(this);

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

		myParent = son;
		son = new DefaultMutableTreeNode(n.f2.tokenImage + " " + n.f3.tokenImage);
		myParent.add(son);
		son = new DefaultMutableTreeNode(n.f4.tokenImage + " " + n.f5.tokenImage);
		myParent.add(son);
		son = new DefaultMutableTreeNode(n.f6.tokenImage + " " + n.f7.tokenImage);
		myParent.add(son);
		myParent = root;
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
		
		myParent = son;
		
		for (int i = 0; i < n.f2.nodes.size(); i++) 
		{
			NodeToken node = (NodeToken) n.f2.nodes.get(i);
			son = new DefaultMutableTreeNode( node.tokenImage );
			myParent.add(son);
		}
		
		myParent = root;
	}

	@Override
	public void visit(final Text n) {
		// f0 -> <TEXT>
		n.f0.accept(this);

		// f2 -> ( %0 <WORD>
		// .. .. | %1 <ELEMENTS>
		// .. .. | %2 <PUNCT>
		// .. .. | %3 <MATH>
		// .. .. | %4 <NUMBER> )*
		n.f2.accept(this);
		
		text = "";
		for (int i = 0; i < n.f2.nodes.size(); i++) {
			NodeToken node = (NodeToken) ((NodeChoice) n.f2.nodes.get(i)).choice;
			text += " " + node.tokenImage;
		}
	}

	@Override
	public void visit(final Stat n) {
		myParent = son;
		
		// f2 -> <NUMBER>
		n.f2.accept(this);
		son = new DefaultMutableTreeNode("Atk: " + n.f2.tokenImage );
		myParent.add(son);
		
		// f3 -> <NUMBER>
		n.f3.accept(this);
		son = new DefaultMutableTreeNode("Dif: " + n.f3.tokenImage );
		myParent.add(son);
		
		// f4 -> <NUMBER>
		n.f4.accept(this);
		son = new DefaultMutableTreeNode("Rng: " + n.f4.tokenImage );
		myParent.add(son);
		
		myParent = root;
	}
}