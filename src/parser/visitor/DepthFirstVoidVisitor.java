/* Generated by JTB 1.4.7 */
package parser.visitor;

import parser.syntaxtree.*;
import java.util.*;

public class DepthFirstVoidVisitor implements IVoidVisitor {


  public void visit(final NodeChoice n) {
    n.choice.accept(this);
    return;
  }

  public void visit(final NodeList n) {
    for (final Iterator<INode> e = n.elements(); e.hasNext();) {
      e.next().accept(this);
    }
    return;
  }

  public void visit(final NodeListOptional n) {
    if (n.present()) {
      for (final Iterator<INode> e = n.elements(); e.hasNext();) {
        e.next().accept(this);
        }
      return;
    } else
      return;
  }

  public void visit(final NodeOptional n) {
    if (n.present()) {
      n.node.accept(this);
      return;
    } else
      return;
  }

  public void visit(final NodeSequence n) {
    for (final Iterator<INode> e = n.elements(); e.hasNext();) {
      e.next().accept(this);
    }
    return;
  }

  public void visit(final NodeTCF n) {
    @SuppressWarnings("unused")
    final String tkIm = n.tokenImage;
    return;
  }

  public void visit(final NodeToken n) {
    @SuppressWarnings("unused")
    final String tkIm = n.tokenImage;
    return;
  }

  public void visit(final Scope n) {
    // f0 -> . %0 Spell()
    // .. .. | %1 Permanent()
    // .. .. | %2 Creature()
    n.f0.accept(this);
  }

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
  }

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
  }

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
  }

  public void visit(final Name n) {
    // f0 -> <WORD>
    n.f0.accept(this);
    // f1 -> ( %0 <WORD>
    // .. .. | %1 <PUNCT> )*
    n.f1.accept(this);
  }

  public void visit(final Element n) {
    // f0 -> <ELEMENT>
    n.f0.accept(this);
    // f1 -> <LPAR>
    n.f1.accept(this);
    // f2 -> <ELEMENTS>
    n.f2.accept(this);
    // f3 -> <RPAR>
    n.f3.accept(this);
  }

  public void visit(final Cost n) {
    // f0 -> <COST>
    n.f0.accept(this);
    // f1 -> ( %0 Mono()
    // .. .. | %1 Duo()
    // .. .. | %2 Trio() )
    n.f1.accept(this);
  }

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
  }

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
  }

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
  }

  public void visit(final Subtype n) {
    // f0 -> <SUBTYPE>
    n.f0.accept(this);
    // f1 -> <LPAR>
    n.f1.accept(this);
    // f2 -> ( <WORD> )+
    n.f2.accept(this);
    // f3 -> <RPAR>
    n.f3.accept(this);
  }

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
  }

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
  }

}
