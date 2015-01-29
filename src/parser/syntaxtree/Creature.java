/* Generated by JTB 1.4.7 */
package parser.syntaxtree;

import parser.visitor.*;

public class Creature implements INode {

  public NodeToken f0;

  public Name f1;

  public NodeToken f2;

  public Element f3;

  public Cost f4;

  public Subtype f5;

  public Stat f6;

  public Text f7;

  public NodeToken f8;

  private static final long serialVersionUID = 147L;

  public Creature(final NodeToken n0, final Name n1, final NodeToken n2, final Element n3, final Cost n4, final Subtype n5, final Stat n6, final Text n7, final NodeToken n8) {
    f0 = n0;
    f1 = n1;
    f2 = n2;
    f3 = n3;
    f4 = n4;
    f5 = n5;
    f6 = n6;
    f7 = n7;
    f8 = n8;
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
