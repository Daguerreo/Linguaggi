package parser;

import gui.GuiManager;

import java.io.InputStream;
import java.io.StringReader;

import parser.syntaxtree.*;
import parser.visitor.*;

public class ParseManager 
{
	private String in;
	private String out;
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
	    //new CardGrammar(System.in);
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
		try  
	    {
	      Scope start = CardGrammar.Scope();
	     // DepthFirstVoidVisitor v = new MyVisitor();
	      CardCreatorVisitor v = new CardCreatorVisitor();
	      v.setGuiManager(gm);
	      start.accept(v);
	      //out = v.getOutMsg();
	      gm.showResult("lololo");
	    }
	    catch (Exception e)
	    {
	      System.out.println("Oops.");
	      System.out.println(e.getMessage());
	    }
		catch (TokenMgrError e1)
		{
			 //System.err.print("Lexical Error: ");
			//gm.showResult( e1.getMessage());
			gm.showResult("bububu");
			System.err.println(e1.getMessage());
			 
		}

	    
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
