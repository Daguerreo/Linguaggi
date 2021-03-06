/* Generated by JTB 1.4.7 */
package parser.visitor;

import parser.syntaxtree.*;

public interface IRetVisitor<R> {

  public R visit(final NodeChoice n);

  public R visit(final NodeList n);

  public R visit(final NodeListOptional n);

  public R visit(final NodeOptional n);

  public R visit(final NodeSequence n);

  public R visit(final NodeTCF n);

  public R visit(final NodeToken n);

  public R visit(final Scope n);

  public R visit(final Spell n);

  public R visit(final Permanent n);

  public R visit(final Creature n);

  public R visit(final Name n);

  public R visit(final Element n);

  public R visit(final Cost n);

  public R visit(final Mono n);

  public R visit(final Duo n);

  public R visit(final Trio n);

  public R visit(final Subtype n);

  public R visit(final Text n);

  public R visit(final Stat n);

}
