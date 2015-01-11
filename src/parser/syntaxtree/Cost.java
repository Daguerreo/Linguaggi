/* Generated by JTB 1.4.7 */
package parser.syntaxtree;

import parser.visitor.*;

public class Cost implements INode {

  public NodeToken f0;

  public NodeChoice f1;

  private static final long serialVersionUID = 147L;

  public Cost(final NodeToken n0, final NodeChoice n1) {
    f0 = n0;
    f1 = n1;
  }

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }

  public <R> R accept(final IRetVisitor<R> vis) {
    return vis.visit(this);
  }

  public <A> void accept(final IVoidArguVisitor<A> vis, final A argu) {
    vis.visit(this, argu);
  }

  public void accept(final IVoidVisitor vis) {
    vis.visit(this);
  }

}
