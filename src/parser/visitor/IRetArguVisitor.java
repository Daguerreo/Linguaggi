/* Generated by JTB 1.4.7 */
package parser.visitor;

import parser.syntaxtree.*;

public interface IRetArguVisitor<R, A> {

  public R visit(final NodeChoice n, final A argu);

  public R visit(final NodeList n, final A argu);

  public R visit(final NodeListOptional n, final A argu);

  public R visit(final NodeOptional n, final A argu);

  public R visit(final NodeSequence n, final A argu);

  public R visit(final NodeTCF n, final A argu);

  public R visit(final NodeToken n, final A argu);

  public R visit(final Scope n, final A argu);

  public R visit(final Spell n, final A argu);

  public R visit(final Permanent n, final A argu);

  public R visit(final Creature n, final A argu);

  public R visit(final Name n, final A argu);

  public R visit(final Element n, final A argu);

  public R visit(final Cost n, final A argu);

  public R visit(final Mono n, final A argu);

  public R visit(final Duo n, final A argu);

  public R visit(final Trio n, final A argu);

  public R visit(final Subtype n, final A argu);

  public R visit(final Text n, final A argu);

  public R visit(final Stat n, final A argu);

}
