/* CardGrammar.java */
/* Generated By:JavaCC: Do not edit this line. CardGrammar.java */
package parser;

import parser.visitor.*;
import java.awt.EventQueue;
import gui.MainWindow;
import parser.syntaxtree.*;


public class CardGrammar implements CardGrammarConstants {

  public static void main(String args[]) {
    EventQueue.invokeLater(new Runnable(){

      public void run() {
        try {
          MainWindow window = new MainWindow();
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
);
  }

  static final public Scope Scope() throws ParseException {// --- JTB generated node declarations ---
  NodeChoice n0 = null;
  Spell n1 = null;
  Permanent n2 = null;
  Creature n3 = null;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case SPELL:{
      n1 = Spell();
n0 = new NodeChoice(n1, 0, 3);
      break;
      }
    case PERMANENT:{
      n2 = Permanent();
n0 = new NodeChoice(n2, 1, 3);
      break;
      }
    case CREATURE:{
      n3 = Creature();
n0 = new NodeChoice(n3, 2, 3);
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return new Scope(n0);}
    throw new Error("Missing return statement in function");
  }

  static final public Spell Spell() throws ParseException {// --- JTB generated node declarations ---
  NodeToken n0 = null;
  Token n1 = null;
  Name n2 = null;
  NodeToken n3 = null;
  Token n4 = null;
  Element n5 = null;
  Cost n6 = null;
  Subtype n7 = null;
  Text n8 = null;
  NodeToken n9 = null;
  Token n10 = null;
    n1 = jj_consume_token(SPELL);
n0 = JTBToolkit.makeNodeToken(n1);
    n2 = Name();
    n4 = jj_consume_token(LBLOCK);
n3 = JTBToolkit.makeNodeToken(n4);
    n5 = Element();
    n6 = Cost();
    n7 = Subtype();
    n8 = Text();
    n10 = jj_consume_token(RBLOCK);
n9 = JTBToolkit.makeNodeToken(n10);
{if ("" != null) return new Spell(n0, n2, n3, n5, n6, n7, n8, n9);}
    throw new Error("Missing return statement in function");
  }

  static final public Permanent Permanent() throws ParseException {// --- JTB generated node declarations ---
  NodeToken n0 = null;
  Token n1 = null;
  Name n2 = null;
  NodeToken n3 = null;
  Token n4 = null;
  Element n5 = null;
  Cost n6 = null;
  Subtype n7 = null;
  Text n8 = null;
  NodeToken n9 = null;
  Token n10 = null;
    n1 = jj_consume_token(PERMANENT);
n0 = JTBToolkit.makeNodeToken(n1);
    n2 = Name();
    n4 = jj_consume_token(LBLOCK);
n3 = JTBToolkit.makeNodeToken(n4);
    n5 = Element();
    n6 = Cost();
    n7 = Subtype();
    n8 = Text();
    n10 = jj_consume_token(RBLOCK);
n9 = JTBToolkit.makeNodeToken(n10);
{if ("" != null) return new Permanent(n0, n2, n3, n5, n6, n7, n8, n9);}
    throw new Error("Missing return statement in function");
  }

  static final public Creature Creature() throws ParseException {// --- JTB generated node declarations ---
  NodeToken n0 = null;
  Token n1 = null;
  Name n2 = null;
  NodeToken n3 = null;
  Token n4 = null;
  Element n5 = null;
  Cost n6 = null;
  Subtype n7 = null;
  Stat n8 = null;
  Text n9 = null;
  NodeToken n10 = null;
  Token n11 = null;
    n1 = jj_consume_token(CREATURE);
n0 = JTBToolkit.makeNodeToken(n1);
    n2 = Name();
    n4 = jj_consume_token(LBLOCK);
n3 = JTBToolkit.makeNodeToken(n4);
    n5 = Element();
    n6 = Cost();
    n7 = Subtype();
    n8 = Stat();
    n9 = Text();
    n11 = jj_consume_token(RBLOCK);
n10 = JTBToolkit.makeNodeToken(n11);
{if ("" != null) return new Creature(n0, n2, n3, n5, n6, n7, n8, n9, n10);}
    throw new Error("Missing return statement in function");
  }

  static final public Name Name() throws ParseException {// --- JTB generated node declarations ---
  NodeToken n0 = null;
  Token n1 = null;
  NodeListOptional n2 = new NodeListOptional();
  NodeChoice n3 = null;
  NodeToken n4 = null;
  Token n5 = null;
  NodeToken n6 = null;
  Token n7 = null;
    n1 = jj_consume_token(WORD);
n0 = JTBToolkit.makeNodeToken(n1);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case WORD:
      case PUNCT:{
        ;
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case WORD:{
        n5 = jj_consume_token(WORD);
n4 = JTBToolkit.makeNodeToken(n5);
n3 = new NodeChoice(n4, 0, 2);
        break;
        }
      case PUNCT:{
        n7 = jj_consume_token(PUNCT);
n6 = JTBToolkit.makeNodeToken(n7);
n3 = new NodeChoice(n6, 1, 2);
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
n2.addNode(n3);
    }
n2.nodes.trimToSize();
{if ("" != null) return new Name(n0, n2);}
    throw new Error("Missing return statement in function");
  }

  static final public Element Element() throws ParseException {// --- JTB generated node declarations ---
  NodeToken n0 = null;
  Token n1 = null;
  NodeToken n2 = null;
  Token n3 = null;
  NodeToken n4 = null;
  Token n5 = null;
  NodeToken n6 = null;
  Token n7 = null;
    n1 = jj_consume_token(ELEMENT);
n0 = JTBToolkit.makeNodeToken(n1);
    n3 = jj_consume_token(LPAR);
n2 = JTBToolkit.makeNodeToken(n3);
    n5 = jj_consume_token(ELEMENTS);
n4 = JTBToolkit.makeNodeToken(n5);
    n7 = jj_consume_token(RPAR);
n6 = JTBToolkit.makeNodeToken(n7);
{if ("" != null) return new Element(n0, n2, n4, n6);}
    throw new Error("Missing return statement in function");
  }

  static final public Cost Cost() throws ParseException {// --- JTB generated node declarations ---
  NodeToken n0 = null;
  Token n1 = null;
  NodeChoice n2 = null;
  Mono n3 = null;
  Duo n4 = null;
  Trio n5 = null;
    n1 = jj_consume_token(COST);
n0 = JTBToolkit.makeNodeToken(n1);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case MONO:{
      n3 = Mono();
n2 = new NodeChoice(n3, 0, 3);
      break;
      }
    case DUO:{
      n4 = Duo();
n2 = new NodeChoice(n4, 1, 3);
      break;
      }
    case TRIO:{
      n5 = Trio();
n2 = new NodeChoice(n5, 2, 3);
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return new Cost(n0, n2);}
    throw new Error("Missing return statement in function");
  }

  static final public Mono Mono() throws ParseException {// --- JTB generated node declarations ---
  NodeToken n0 = null;
  Token n1 = null;
  NodeToken n2 = null;
  Token n3 = null;
  NodeToken n4 = null;
  Token n5 = null;
  NodeToken n6 = null;
  Token n7 = null;
  NodeToken n8 = null;
  Token n9 = null;
    n1 = jj_consume_token(MONO);
n0 = JTBToolkit.makeNodeToken(n1);
    n3 = jj_consume_token(LPAR);
n2 = JTBToolkit.makeNodeToken(n3);
    n5 = jj_consume_token(NUMBER);
n4 = JTBToolkit.makeNodeToken(n5);
    n7 = jj_consume_token(ELEMENTS);
n6 = JTBToolkit.makeNodeToken(n7);
    n9 = jj_consume_token(RPAR);
n8 = JTBToolkit.makeNodeToken(n9);
{if ("" != null) return new Mono(n0, n2, n4, n6, n8);}
    throw new Error("Missing return statement in function");
  }

  static final public Duo Duo() throws ParseException {// --- JTB generated node declarations ---
  NodeToken n0 = null;
  Token n1 = null;
  NodeToken n2 = null;
  Token n3 = null;
  NodeToken n4 = null;
  Token n5 = null;
  NodeToken n6 = null;
  Token n7 = null;
  NodeToken n8 = null;
  Token n9 = null;
  NodeToken n10 = null;
  Token n11 = null;
  NodeToken n12 = null;
  Token n13 = null;
    n1 = jj_consume_token(DUO);
n0 = JTBToolkit.makeNodeToken(n1);
    n3 = jj_consume_token(LPAR);
n2 = JTBToolkit.makeNodeToken(n3);
    n5 = jj_consume_token(NUMBER);
n4 = JTBToolkit.makeNodeToken(n5);
    n7 = jj_consume_token(ELEMENTS);
n6 = JTBToolkit.makeNodeToken(n7);
    n9 = jj_consume_token(NUMBER);
n8 = JTBToolkit.makeNodeToken(n9);
    n11 = jj_consume_token(ELEMENTS);
n10 = JTBToolkit.makeNodeToken(n11);
    n13 = jj_consume_token(RPAR);
n12 = JTBToolkit.makeNodeToken(n13);
{if ("" != null) return new Duo(n0, n2, n4, n6, n8, n10, n12);}
    throw new Error("Missing return statement in function");
  }

  static final public Trio Trio() throws ParseException {// --- JTB generated node declarations ---
  NodeToken n0 = null;
  Token n1 = null;
  NodeToken n2 = null;
  Token n3 = null;
  NodeToken n4 = null;
  Token n5 = null;
  NodeToken n6 = null;
  Token n7 = null;
  NodeToken n8 = null;
  Token n9 = null;
  NodeToken n10 = null;
  Token n11 = null;
  NodeToken n12 = null;
  Token n13 = null;
  NodeToken n14 = null;
  Token n15 = null;
  NodeToken n16 = null;
  Token n17 = null;
    n1 = jj_consume_token(TRIO);
n0 = JTBToolkit.makeNodeToken(n1);
    n3 = jj_consume_token(LPAR);
n2 = JTBToolkit.makeNodeToken(n3);
    n5 = jj_consume_token(NUMBER);
n4 = JTBToolkit.makeNodeToken(n5);
    n7 = jj_consume_token(ELEMENTS);
n6 = JTBToolkit.makeNodeToken(n7);
    n9 = jj_consume_token(NUMBER);
n8 = JTBToolkit.makeNodeToken(n9);
    n11 = jj_consume_token(ELEMENTS);
n10 = JTBToolkit.makeNodeToken(n11);
    n13 = jj_consume_token(NUMBER);
n12 = JTBToolkit.makeNodeToken(n13);
    n15 = jj_consume_token(ELEMENTS);
n14 = JTBToolkit.makeNodeToken(n15);
    n17 = jj_consume_token(RPAR);
n16 = JTBToolkit.makeNodeToken(n17);
{if ("" != null) return new Trio(n0, n2, n4, n6, n8, n10, n12, n14, n16);}
    throw new Error("Missing return statement in function");
  }

  static final public Subtype Subtype() throws ParseException {// --- JTB generated node declarations ---
  NodeToken n0 = null;
  Token n1 = null;
  NodeToken n2 = null;
  Token n3 = null;
  NodeList n4 = new NodeList();
  NodeToken n5 = null;
  Token n6 = null;
  NodeToken n7 = null;
  Token n8 = null;
    n1 = jj_consume_token(SUBTYPE);
n0 = JTBToolkit.makeNodeToken(n1);
    n3 = jj_consume_token(LPAR);
n2 = JTBToolkit.makeNodeToken(n3);
    label_2:
    while (true) {
      n6 = jj_consume_token(WORD);
n5 = JTBToolkit.makeNodeToken(n6);
n4.addNode(n5);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case WORD:{
        ;
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        break label_2;
      }
    }
n4.nodes.trimToSize();
    n8 = jj_consume_token(RPAR);
n7 = JTBToolkit.makeNodeToken(n8);
{if ("" != null) return new Subtype(n0, n2, n4, n7);}
    throw new Error("Missing return statement in function");
  }

  static final public Text Text() throws ParseException {// --- JTB generated node declarations ---
  NodeToken n0 = null;
  Token n1 = null;
  NodeToken n2 = null;
  Token n3 = null;
  NodeListOptional n4 = new NodeListOptional();
  NodeChoice n5 = null;
  NodeToken n6 = null;
  Token n7 = null;
  NodeToken n8 = null;
  Token n9 = null;
  NodeToken n10 = null;
  Token n11 = null;
  NodeToken n12 = null;
  Token n13 = null;
  NodeToken n14 = null;
  Token n15 = null;
  NodeToken n16 = null;
  Token n17 = null;
    n1 = jj_consume_token(TEXT);
n0 = JTBToolkit.makeNodeToken(n1);
    n3 = jj_consume_token(LPAR);
n2 = JTBToolkit.makeNodeToken(n3);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ELEMENTS:
      case NUMBER:
      case WORD:
      case PUNCT:
      case MATH:{
        ;
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        break label_3;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case WORD:{
        n7 = jj_consume_token(WORD);
n6 = JTBToolkit.makeNodeToken(n7);
n5 = new NodeChoice(n6, 0, 5);
        break;
        }
      case ELEMENTS:{
        n9 = jj_consume_token(ELEMENTS);
n8 = JTBToolkit.makeNodeToken(n9);
n5 = new NodeChoice(n8, 1, 5);
        break;
        }
      case PUNCT:{
        n11 = jj_consume_token(PUNCT);
n10 = JTBToolkit.makeNodeToken(n11);
n5 = new NodeChoice(n10, 2, 5);
        break;
        }
      case MATH:{
        n13 = jj_consume_token(MATH);
n12 = JTBToolkit.makeNodeToken(n13);
n5 = new NodeChoice(n12, 3, 5);
        break;
        }
      case NUMBER:{
        n15 = jj_consume_token(NUMBER);
n14 = JTBToolkit.makeNodeToken(n15);
n5 = new NodeChoice(n14, 4, 5);
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
n4.addNode(n5);
    }
n4.nodes.trimToSize();
    n17 = jj_consume_token(RPAR);
n16 = JTBToolkit.makeNodeToken(n17);
{if ("" != null) return new Text(n0, n2, n4, n16);}
    throw new Error("Missing return statement in function");
  }

  static final public Stat Stat() throws ParseException {// --- JTB generated node declarations ---
  NodeToken n0 = null;
  Token n1 = null;
  NodeToken n2 = null;
  Token n3 = null;
  NodeToken n4 = null;
  Token n5 = null;
  NodeToken n6 = null;
  Token n7 = null;
  NodeToken n8 = null;
  Token n9 = null;
  NodeToken n10 = null;
  Token n11 = null;
    n1 = jj_consume_token(STAT);
n0 = JTBToolkit.makeNodeToken(n1);
    n3 = jj_consume_token(LPAR);
n2 = JTBToolkit.makeNodeToken(n3);
    n5 = jj_consume_token(NUMBER);
n4 = JTBToolkit.makeNodeToken(n5);
    n7 = jj_consume_token(NUMBER);
n6 = JTBToolkit.makeNodeToken(n7);
    n9 = jj_consume_token(NUMBER);
n8 = JTBToolkit.makeNodeToken(n9);
    n11 = jj_consume_token(RPAR);
n10 = JTBToolkit.makeNodeToken(n11);
{if ("" != null) return new Stat(n0, n2, n4, n6, n8, n10);}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public CardGrammarTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[7];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x380,0x3000000,0x3000000,0x7000,0x1000000,0x7840000,0x7840000,};
   }

  /** Constructor with InputStream. */
  public CardGrammar(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public CardGrammar(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CardGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public CardGrammar(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CardGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public CardGrammar(CardGrammarTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(CardGrammarTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[29];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 7; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 29; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}


class MyVisitor extends DepthFirstVoidVisitor {

  public void visit(NodeToken n) {
    System.out.println("visit " + n.tokenImage);
  }
}

class JTBToolkit {

  static NodeToken makeNodeToken(final Token t) {
    return new NodeToken(t.image.intern(), t.kind, t.beginLine, t.beginColumn, t.endLine, t.endColumn);
  }
}
