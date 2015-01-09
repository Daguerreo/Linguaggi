/* Generated by JTB 1.4.7 */
package parser.syntaxtree;

import parser.visitor.IRetArguVisitor;
import parser.visitor.IRetVisitor;
import parser.visitor.IVoidArguVisitor;
import parser.visitor.IVoidVisitor;
import java.util.*;

public class NodeList implements INodeList {

	public ArrayList<INode> nodes;

	private static final int allocTb[] = { 1, 2, 3, 4, 5, 10, 20, 50 };

	private int allocNb = 0;

	private static final long serialVersionUID = 147L;

	public NodeList() {
		nodes = new ArrayList<INode>(allocTb[allocNb]);
	}

	public NodeList(final int sz) {
		nodes = new ArrayList<INode>(sz);
	}

	public NodeList(final INode firstNode) {
		nodes = new ArrayList<INode>(allocTb[allocNb]);
		addNode(firstNode);
	}

	public NodeList(final int sz, final INode firstNode) {
		nodes = new ArrayList<INode>(sz);
		addNode(firstNode);
	}

	@Override
	public void addNode(final INode n) {
		if (++allocNb < allocTb.length)
			nodes.ensureCapacity(allocTb[allocNb]);
		else
			nodes.ensureCapacity((allocNb - allocTb.length + 2)
					* allocTb[(allocTb.length - 1)]);
		nodes.add(n);
	}

	@Override
	public INode elementAt(final int i) {
		return nodes.get(i);
	}

	@Override
	public Iterator<INode> elements() {
		return nodes.iterator();
	}

	@Override
	public int size() {
		return nodes.size();
	}

	@Override
	public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
		return vis.visit(this, argu);
	}

	@Override
	public <R> R accept(final IRetVisitor<R> vis) {
		return vis.visit(this);
	}

	@Override
	public <A> void accept(final IVoidArguVisitor<A> vis, final A argu) {
		vis.visit(this, argu);
	}

	@Override
	public void accept(final IVoidVisitor vis) {
		vis.visit(this);
	}

}
