package parser;

import gui.GuiManager;

import java.io.InputStream;
import java.io.StringReader;

import parser.syntaxtree.*;
import parser.visitor.*;
import parser.visitor.custom.CardCreatorVisitor;
import parser.visitor.custom.CardSemanticVisitor;

public class ParseManager 
{
	private String in = "";
	private String out = "";
	private GuiManager gm;
	
	public ParseManager( )
	{	
	}
	
	public void setGuiManager( GuiManager gm )
	{
		this.gm = gm;
	}
	
	public void init()
	{
		System.out.println("Sono Card Grammar lolololoool...");
	    System.out.println("It's time to duel! :\n");
	    new CardGrammar( new StringReader(in) );
	    parse();
	}
	
	public void reInit()
	{
		System.out.println("Rematch! :\n");
		CardGrammar.ReInit( new StringReader(in) );
		parse();
	}
	
	public void parse()
	{
		out = "";
		try  
	    {
			Scope start = CardGrammar.Scope();
			CardCreatorVisitor v = new CardCreatorVisitor();
			CardSemanticVisitor s = new CardSemanticVisitor();
			v.setGuiManager(gm);
			start.accept(v);
			start.accept(s);
			//Semantic Error
			out = s.getOutMsg();
	    }
	    catch (Exception e)
	    {
	    	//Syntax Error
	    	out = "Syntax Error: " + e.getMessage();
	    	System.out.println(e.getMessage());
	    }
		catch (TokenMgrError e1)
		{
			//Lexical Error
			out += e1.getMessage();
			gm.showResult("bububu");
			System.err.println(e1.getMessage());
			 
		}
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
