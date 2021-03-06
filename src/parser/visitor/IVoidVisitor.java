/* Generated by JTB 1.4.7 */
package parser.visitor;

import parser.syntaxtree.*;

public interface IVoidVisitor {

  public void visit(final NodeChoice n);

  public void visit(final NodeList n);

  public void visit(final NodeListOptional n);

  public void visit(final NodeOptional n);

  public void visit(final NodeSequence n);

  public void visit(final NodeTCF n);

  public void visit(final NodeToken n);

  public void visit(final Scope n);

  public void visit(final Spell n);

  public void visit(final Permanent n);

  public void visit(final Creature n);

  public void visit(final Name n);

  public void visit(final Element n);

  public void visit(final Cost n);

  public void visit(final Mono n);

  public void visit(final Duo n);

  public void visit(final Trio n);

  public void visit(final Subtype n);

  public void visit(final Text n);

  public void visit(final Stat n);

}
