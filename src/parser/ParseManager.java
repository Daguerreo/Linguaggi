package parser;

import gui.GuiManager;

import java.io.StringReader;

import parser.syntaxtree.*;
import parser.visitor.custom.CardAstVisitor;
import parser.visitor.custom.CardCreatorVisitor;
import parser.visitor.custom.CardSemanticVisitor;

public class ParseManager {
	private String in = "";
	private String out = "";
	private GuiManager gm;
	private boolean completed = true;
	
	public ParseManager() {
	}

	public void setGuiManager(GuiManager gm) {
		this.gm = gm;
	}

	public void init() {
		new CardGrammar(new StringReader(in));
		parse();
	}

	public void reInit() {
		CardGrammar.ReInit(new StringReader(in));
		parse();
	}

	public void parse() {
		out = "";
		try {
			Scope start = CardGrammar.Scope();
			CardCreatorVisitor v = new CardCreatorVisitor();
			CardSemanticVisitor s = new CardSemanticVisitor();
			CardAstVisitor a = new CardAstVisitor();
			v.setGuiManager(gm);
			start.accept(v);
			start.accept(s);
			start.accept(a);
			
			// Semantic Error
			out = s.getOutMsg();
			// Show AST
			gm.paintTree(a.getTree());
		} catch (Exception e) {
			// Syntax Error
			out = "Syntax Error: " + e.getMessage();
			System.err.println(e.getMessage());
			completed = false;
		} catch (TokenMgrError e1) {
			// Lexical Error
			out += e1.getMessage();
			System.err.println(e1.getMessage());
			completed = false;
		}
		if( completed );
			out += "Build Succeded.";
		gm.showResult(out);
	}

	public String getIn() {
		return in;
	}

	public void setIn(String in) {
		this.in = in;
	}

	public String getOut() {
		return out;
	}

	public void setOut(String out) {
		this.out = out;
	}

}
