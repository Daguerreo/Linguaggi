/* Generated by JTB 1.4.7 */
package parser.syntaxtree;

import parser.visitor.*;

public class Element implements INode {

	public NodeToken f0;

	public NodeToken f1;

	public NodeToken f2;

	public NodeToken f3;

	private static final long serialVersionUID = 147L;

	public Element(final NodeToken n0, final NodeToken n1, final NodeToken n2,
			final NodeToken n3) {
		f0 = n0;
		f1 = n1;
		f2 = n2;
		f3 = n3;
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