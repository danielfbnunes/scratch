// Generated from Scratch.g4 by ANTLR 4.7.1

import java.util.*;
import java.io.*;
import org.stringtemplate.v4.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ScratchCompiler extends ScratchBaseVisitor<ST> {
	
	protected boolean constructorDefined = false;
	protected int mainCtx ; 
	//Guarda o nome do jogo;
	protected String gameName;
	//Guarda o nome da ultima função declarada
	protected String funcName;
	//Verifica se nos encontramos dentro de um função
	protected boolean insideFunction = false;
	//Verifica se nos encontramos dentro de um ciclo while/for
	protected boolean insideLoop = false;
	//Check if sprite is declared inside loop
	protected boolean spriteDeclaredInsideLoop= false;
	//Guarda um ST com a ultima sprite declarada
	protected ST lastSpriteDeclared;
	//Lista de nodes com contextos
	private List<Integer> nodeSeq = new ArrayList<>();
	/*ID de um contexto
	 * Sempre que entramos dentro de uma função, de um condicional, ou
	 * de um ciclo for/while, o ID é incrementado.
	 * Esta funcionalidade permite-nos criar variáveis locais dentro 
	 * de cada um destes.
	*/
	private int contextID = -1;
	/*Se uma variavelfoi declarada dentro de um ciclo while/for esta 
	deve ser eliminada no final do ciclo*/
	protected boolean hasDeclarationInside = false;
	//Ultima variavel a ser declarada
	protected String recentDeclaredVariable = "";
	//Conta o numero de variaveis já criadas
	protected int varCount = 0;
	//Criação de um STGroup
	protected STGroup stg = null;

	//Geração de um novo nome de uma variável
	protected String newVarName() 
	{
	  varCount++;
	  return "v"+varCount;
	}
   
   
	protected void setFileName(String gameName)
	{
			this.gameName = gameName;
	}
	
	/* Criação de um novo contexto. Permite a criação de variáveis
	 * locais
	 */
    protected void newContext() 
    {
		contextID += 1;
        nodeSeq.add(0, contextID);
    }

	/* Obtenção de um símbolo, tendo em conta o contexto actual*/
	private Symbol getSymbol(String id) 
	{
		for (Integer i : nodeSeq)
			if (ScratchParser.contextSymbolTables.get(i).containsKey(id))
				return ScratchParser.contextSymbolTables.get(i).get(id);
		return null;
	}
	
	/*Usado para carregar ST da relativas à criação de sprites, vindas
	* do SpriteCompiler.java
	*/
	protected ST getSTFromSprite(String varName, String fName)
	{
		CharStream input = null;
		try{ input = CharStreams.fromFileName(fName); }
		catch (Exception e) {}
		// create a lexer that feeds off of input CharStream:
		SpriteLexer lexer = new SpriteLexer(input);
		// create a buffer of tokens pulled from the lexer:
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// create a parser that feeds off the tokens buffer:
		SpriteParser parser = new SpriteParser(tokens);
		// replace error listener:
		//parser.removeErrorListeners(); // remove ConsoleErrorListener
		//parser.addErrorListener(new ErrorHandlingListener());
		// begin parsing at program rule:
		ParseTree tree = parser.program();
		SpriteInterpreter visitor0 = new SpriteInterpreter();
		visitor0.setVarName(varName);         
		ST code = visitor0.visit(tree);
		return code;
	}
   
	
	@Override public ST visitMain(ScratchParser.MainContext ctx) 
	{
		//Entrada num novo contexto
		newContext();
		
		stg = new STGroupFile("cpp.stg");
		
		
		PrintWriter writer = null;
		
		
		//criar o game.h
		try 
		{
			writer = new PrintWriter(gameName + ".h", "UTF-8");
			ST gameh = stg.getInstanceOf("gameHeaderModule");
			gameh.add("name", gameName);
			writer.println(gameh.render());			
		}
		catch(IOException ex) 
		{ 
			System.err.println("Couldn't create " + gameName +".h ! Leaving..."); 
			System.exit(1);
		}
		finally {writer.close();}
		
		
		//criar o main.cpp
		try 
		{
			writer = new PrintWriter("main.cpp", "UTF-8");
			ST main = stg.getInstanceOf("mainModule");
			main.add("name", gameName);
			writer.println(main.render());			
		}
		catch(IOException ex) 
		{ 
			System.err.println("Couldn't create main.cpp! Leaving..."); 
			System.exit(1);
		}
		finally {writer.close();}
		
		
		ST res = stg.getInstanceOf("module");
		
		for(ScratchParser.HeaderDefContext sc : ctx.headerDef())
			res.add("header", visit(sc));
			
		for(ScratchParser.StatContext sc : ctx.stat())
			res.add("stat", visit(sc));
				
		if (!constructorDefined)
		{
			ST temp =  stg.getInstanceOf("initFunc");
			temp.add("name", gameName);
			res.add("stat",temp.render());
		}
		
		ScratchParser.contextSymbolTables.get(mainCtx)
		.entrySet()
		.forEach(e -> {
			if (e.getValue().type().name().equals("Sprite"))
			{
				ST drawSprite = stg.getInstanceOf("drawSprite");
				drawSprite.add("name", e.getValue().varName());
				res.add("sprite", drawSprite.render());
			}
			if (e.getValue().type().name().equals("List")) 
			{
				ST drawSpritesFromList = stg.getInstanceOf("drawSpritesFromList");
				drawSpritesFromList.add("name", e.getValue().varName());
				res.add("list", drawSpritesFromList.render());
			}
		});
		ScratchParser.contextSymbolTables.get(0)
		.entrySet()
		.forEach(e -> {
			if (e.getValue().type().name().equals("Sprite"))
			{
				ST drawSprite = stg.getInstanceOf("drawSprite");
				drawSprite.add("name", e.getValue().varName());
				res.add("sprite", drawSprite.render());
			}
			if (e.getValue().type().name().equals("List")) 
			{
				ST drawSpritesFromList = stg.getInstanceOf("drawSpritesFromList");
				drawSpritesFromList.add("name", e.getValue().varName());
				res.add("list", drawSpritesFromList.render());
			}
		});
		
		//saida do contexto
		nodeSeq.remove(0);
		return res;
	}


	@Override public ST visitHeaderDef(ScratchParser.HeaderDefContext ctx)
	{	
		
		ST header =  stg.getInstanceOf("headerDef");	
		header.add("funcName", ctx.ID().getText());
		header.add("type", ctx.dataType().getText());
		if (ctx.argsListDef() != null)
			header.add("args", visit(ctx.argsListDef()));
		return header;
	}
	
	
	@Override public ST visitVarDeclStat(ScratchParser.VarDeclStatContext ctx) { return visit(ctx.getChild(0)); }


	@Override public ST visitAssignStat(ScratchParser.AssignStatContext ctx) { return visit(ctx.getChild(0)); }
	
	
	@Override public ST visitFuncInvStat(ScratchParser.FuncInvStatContext ctx) {return visit(ctx.getChild(0));}


	@Override public ST visitClassInstStat(ScratchParser.ClassInstStatContext ctx) { return visit(ctx.getChild(0));}
	
	
	@Override public ST visitMethodInvStat(ScratchParser.MethodInvStatContext ctx) { return visit(ctx.getChild(0)); }
	
	
	@Override public ST visitFuncDefStat(ScratchParser.FuncDefStatContext ctx) { return visitChildren(ctx); }
	 
	 
	@Override public ST visitConditionalStat(ScratchParser.ConditionalStatContext ctx) { return visitChildren(ctx); }
	
	
	@Override public ST visitLoopDeclStat(ScratchParser.LoopDeclStatContext ctx) { return visitChildren(ctx); }


	@Override public ST visitRetStat(ScratchParser.RetStatContext ctx) { return visitChildren(ctx); }


	@Override public ST visitVarDeclOnly(ScratchParser.VarDeclOnlyContext ctx) 
	{
		ST res = stg.getInstanceOf("stats");
		
		String id;
		Symbol s;
		
		for (TerminalNode t : ctx.idList().ID())
		{
						
			//Definição do id e do símbolo
			id = t.getText();
			s = getSymbol(id);
			//Nova variável
			s.setVarName(newVarName());
			
			if( s.type().name().equals("Sprite"))
				res = stg.getInstanceOf("init");
			else
			{			
			//instanciar uma string template para a declaracao de variaveis
			ST decl = stg.getInstanceOf("decl");
			
			//adicionar respetivos parametros
			decl.add("type", s.type().name());
			decl.add("var", s.varName());
			res.add("stat", decl.render());
			}			
		}
		return res;
	}


	@Override public ST visitVarDeclAndAssign(ScratchParser.VarDeclAndAssignContext ctx) 
	{
		ST res;
		//Obtenção do símbolo e crição de uma nova variável.
		String id = ctx.ID().getText();
		Symbol s = getSymbol(id);
		s.setVarName(newVarName());
		
		
		recentDeclaredVariable = id;
		
		/* As sprites são declaradas com recurso ao spriteCompiler.java */
		if(s.type().name().equals("Sprite"))
		{
			/* Verifica se a declaração ocorreu no header de um loop */
			if(insideLoop)
			{
				spriteDeclaredInsideLoop = true;
				/* Guarda-se apenas o nome da sprite e nao a sua instanciação */
				res = stg.getInstanceOf("init");
				res.add("value", s.varName());

				lastSpriteDeclared = getSTFromSprite(s.varName(), visit(ctx.expression()).render().split("\"")[1]);
			}
			else
			{
				res = stg.getInstanceOf("stats");
				res.add("stat", getSTFromSprite(s.varName(), visit(ctx.expression()).render().split("\"")[1])) ;
			}
		}
		else
		{
		//instanciar uma string template para a declaracao de variaveis
		res = stg.getInstanceOf("stats");
		ST decl = stg.getInstanceOf("decl");
		
		//adicionar respetivos parametros
		decl.add("type", s.type().name());
		decl.add("var", s.varName());
				
		decl.add("value", visit(ctx.expression()).render());
		res.add("stat", decl.render());
		}
		
		return res;
	}
	
	
	@Override public ST visitIdList(ScratchParser.IdListContext ctx) { return visitChildren(ctx); }


	@Override public ST visitDataType(ScratchParser.DataTypeContext ctx) { return visitChildren(ctx); }
				
					 
	@Override public ST visitIsKeyPressed(ScratchParser.IsKeyPressedContext ctx) 
	{
		ST res = stg.getInstanceOf("keyPressed");
		visit(ctx.key());
		res.add("key", ctx.key().value);
		return res;
	}
		
	
	@Override public ST visitKey(ScratchParser.KeyContext ctx) 
	{
		return visitChildren(ctx);
	}
		
						 
	@Override public ST visitRandom(ScratchParser.RandomContext ctx) 
	{
		ST random = stg.getInstanceOf("random");
		String vMin = (visit(ctx.e1)).render();
		String vMax = (visit(ctx.e2)).render();
		random.add("vMin", vMax + "-" + vMin);
		random.add("vMax", vMax);
		return random;
	}
	
	
	@Override public ST visitAssignment(ScratchParser.AssignmentContext ctx) 
	{
		String id = ctx.ID().getText();
		Symbol s = getSymbol(id);
		
		ST res = stg.getInstanceOf("stats");
		
		
		/* As sprites são declaradas com recurso ao spriteCompiler.java */
		if(s.type().name().equals("Sprite"))
		{
			/* Verifica se a declaração ocorreu no header de um loop */
			if(insideLoop)
			{
				spriteDeclaredInsideLoop = true;
				/* Guarda-se apenas o nome da sprite e nao a sua instanciação */
				res = stg.getInstanceOf("init");
				res.add("value", s.varName());

				lastSpriteDeclared = getSTFromSprite(s.varName(), visit(ctx.expression()).render().split("\"")[1]);
			}
			else
			{
				res = stg.getInstanceOf("stats");
				res.add("stat", getSTFromSprite(s.varName(), visit(ctx.expression()).render().split("\"")[1])) ;
				System.out.println(res.render());
			}
		}
		else
		{
		//instanciar uma string template para o assign
		ST assign = stg.getInstanceOf("assign");
		
		//adicionar respetivos parametros
		assign.add("var", s.varName());
		
		//tratamento do value
		assign.add("value", visit(ctx.expression()).render());
		res.add("stat", assign.render());
		}

		
		
		return res;
	}
					 
					 
	@Override public ST visitFunctionInvocation(ScratchParser.FunctionInvocationContext ctx)
	{
		ST funcInv = stg.getInstanceOf("funcInvoc");
		funcInv.add("funcName", ctx.ID().getText());
		if (ctx.argsList() != null)
			funcInv.add("args", visit(ctx.argsList()));
		return funcInv;
	}
					 
					 
	@Override public ST visitClassInstanciation(ScratchParser.ClassInstanciationContext ctx) 
	{
		ST classInst =  stg.getInstanceOf("classInst");	
		classInst.add("type", ctx.dataType().getText());
		if (ctx.argsList() != null)
			classInst.add("args", visit(ctx.argsList()));
		return classInst;
	}
					 
					 
	@Override public ST visitArgsList(ScratchParser.ArgsListContext ctx) 
	{
		ST res = stg.getInstanceOf("args");
		for(ScratchParser.ExpressionContext sc: ctx.expression())
			res.add("expr", visit(sc));
		return res;
	}
					 

	@Override public ST visitArgsListDef(ScratchParser.ArgsListDefContext ctx) 
	{
		ST res = stg.getInstanceOf("args");
		for(int i = 0; i < ctx.dataType().size() ; i++ )
		{
			
			String id = ctx.ID(i).getText();
			Symbol s = getSymbol(id);
			s.setVarName(newVarName());
			
			ST def = stg.getInstanceOf("define");
			def.add("type" , s.type().name());
			def.add("var" , s.varName());
			
			res.add("expr", def.render());
		}
		return res;	
	}


	@Override public ST visitObjMethodInvocation(ScratchParser.ObjMethodInvocationContext ctx) 
	{	
		String var = ctx.id1.getText();
		Symbol s = getSymbol(var);
		String type = s.type().name();
		
		ST res = null;
		
		if ( type.equals("Sprite"))
		{
			res = stg.getInstanceOf("spriteMethodInvocation");
			res.add("id2", ctx.id2.getText());
			if (ctx.argsList() != null)
				res.add("args", visit(ctx.argsList()).render());
			res.add("id1", s.varName());
		}
		else if ( type.equals("List"))
		{
			
			if(ctx.id2.getText().equals("insert"))
			{
				res = stg.getInstanceOf("insertList");
				res.add("name", s.varName());
				if (ctx.argsList() != null)
					res.add("elem", visit(ctx.argsList()).render());
			}
			else if(ctx.id2.getText().equals("get"))
			{
				res = stg.getInstanceOf("getListPosition");
				res.add("name", s.varName());
				if (ctx.argsList() != null)
					res.add("pos", visit(ctx.argsList()).render());
			}
			else if(ctx.id2.getText().equals("remove"))
			{
				res = stg.getInstanceOf("removeListPosition");
				res.add("name", s.varName());
				if (ctx.argsList() != null)
					res.add("pos", visit(ctx.argsList()).render());
			}
		}
		else
		{
			res = stg.getInstanceOf("defaultMethodInvocation");
			res.add("id2", ctx.id2.getText());
			if (ctx.argsList() != null)
				res.add("args", visit(ctx.argsList()).render());
			res.add("id1", s.varName());
		}
		return res;	
	}


	@Override public ST visitStaticMethodInvocation(ScratchParser.StaticMethodInvocationContext ctx) 
	{
		
		ST res = stg.getInstanceOf("staticMethodInvocation");
		res.add("type", ctx.dataType().getText());
		res.add("id", ctx.ID().getText() );
		if (ctx.argsList() != null)
			res.add("args", visit(ctx.argsList()).render());
		if(ctx.ID().getText().equals("getHeight"))
			res.add("extra", "y");
		else if (ctx.ID().getText().equals("getWidth"))
			res.add("extra", "x");
		
		return res;
	}


	@Override public ST visitFunctionDefinition(ScratchParser.FunctionDefinitionContext ctx) 
	{ 
		insideFunction = true;
		funcName =  ctx.ID().getText();
		
		ST func;
		 
		if(funcName.equals("main"))
		{
			mainCtx = contextID+1;
			func =  stg.getInstanceOf("mainFunc");	
		}
		else if(funcName.equals("init"))
		{
			func =  stg.getInstanceOf("initFunc");	
			func.add("name", gameName);
			constructorDefined =  true;
		}
		else
		{
			func = stg.getInstanceOf("funcDef");
			func.add("funcName", ctx.ID().getText());
			func.add("type", ctx.dataType().getText());
			if (ctx.argsListDef() != null)
				func.add("args", visit(ctx.argsListDef()));
		}
		
		newContext();
		
		if(ctx.statList() != null)
			func.add("stat", visit(ctx.statList()).render());
		
		nodeSeq.remove(0);
		
		insideFunction = false;
		funcName = null;
		return func;
	}


	@Override public ST visitReturnStat(ScratchParser.ReturnStatContext ctx) 
	{
		ST res = stg.getInstanceOf("returnExpr");
		if (ctx.expression() != null)
			res.add("expression", visit(ctx.expression()).render());
		
		return res;
	}
	
	
	@Override public ST visitConditional(ScratchParser.ConditionalContext ctx) 
	{
		
		ST res = stg.getInstanceOf("conditional");
		res.add("var",visit(ctx.expression()).render());
		if ( ctx.trueStats != null) 
		{
			newContext();
			res.add("stat_true", visit(ctx.trueStats).render());
			nodeSeq.remove(0);
		}
		if(ctx.elseIfStat() != null)
		{
			//Todo Verificar
			ST elifs = stg.getInstanceOf("elifs");
			for(ScratchParser.ElseIfStatContext sc: ctx.elseIfStat())
				elifs.add("elif", visit(sc));
			res.add("elseIfStat" , elifs.render());
		}
		if(ctx.falseStats != null)
		{
			newContext();
			res.add("stat_false", visit(ctx.falseStats).render());
			nodeSeq.remove(0);
		}
		return res;
	}


	@Override public ST visitElseIfStat(ScratchParser.ElseIfStatContext ctx) 
	{
		ST res = stg.getInstanceOf("elif");
		res.add("expression",visit(ctx.expression()).render());
		if ( ctx.trueStats != null) 
		{
			newContext();
			res.add("stat_true", visit(ctx.trueStats).render());
			nodeSeq.remove(0);
		}
		return res;
	}


	@Override public ST visitWhileLoop(ScratchParser.WhileLoopContext ctx) 
	{
		hasDeclarationInside = false;
		
		newContext();
		
		ST res = stg.getInstanceOf("while");
		res.add("var",visit(ctx.expression()).render());
		if (ctx.statList() != null)
			res.add("stat", visit(ctx.statList()).render());
		
		if(spriteDeclaredInsideLoop)
			res.add("spriteInstanciation", lastSpriteDeclared.render());
		spriteDeclaredInsideLoop= false;
		
		nodeSeq.remove(0);
			
		return res;
	}


	@Override public ST visitForLoop(ScratchParser.ForLoopContext ctx) 
	{		
		newContext();
		
		
		hasDeclarationInside = false;
		insideLoop = true;
		 
		ST res = stg.getInstanceOf("for");
		
		if (ctx.expr1 != null)
		{
				res.add("expr1",visit(ctx.expr1).render().replaceAll(";",""));
				
				if(spriteDeclaredInsideLoop)
					res.add("spriteInstanciation", lastSpriteDeclared.render());
				spriteDeclaredInsideLoop= false;		
		}
		if (ctx.expr2 != null)
		{
				res.add("expr2",visit(ctx.expr2).render().replaceAll(";",""));
				if(spriteDeclaredInsideLoop)
					res.add("spriteInstanciation", lastSpriteDeclared.render());
				spriteDeclaredInsideLoop= false;		
		}
		if (ctx.expr3 != null)
		{
				res.add("expr3",visit(ctx.expr3).render().replaceAll(";",""));
				if(spriteDeclaredInsideLoop)
					res.add("spriteInstanciation", lastSpriteDeclared.render());
				spriteDeclaredInsideLoop= false;		
		}
		if (ctx.statList() != null)
			res.add("stat", visit(ctx.statList()).render());
		
		insideLoop = false;
		nodeSeq.remove(0);
		return res;
	}


	@Override public ST visitStatList(ScratchParser.StatListContext ctx) 
	{
	   ST res = stg.getInstanceOf("stats");
       for(ScratchParser.StatContext sc: ctx.stat())
         res.add("stat", visit(sc));
      return res;
	}

	



	@Override public ST visitPowExpr(ScratchParser.PowExprContext ctx) 
	{
		ST pow = stg.getInstanceOf("pow");
		pow.add("base", visit(ctx.e1));
		pow.add("exp", visit(ctx.e2));
		return pow;
	}


	@Override public ST visitMultDivExpr(ScratchParser.MultDivExprContext ctx) 
	{ 
		ST operation = stg.getInstanceOf("binaryExpression");
		operation.add("e1", visit(ctx.e1));
		operation.add("e2", visit(ctx.e2));
		operation.add("op", ctx.op.getText());
		return operation;
	}
	
	
	@Override public ST visitAddSubExpr(ScratchParser.AddSubExprContext ctx) 
	{
		ST operation = stg.getInstanceOf("binaryExpression");
		operation.add("e1", visit(ctx.e1));
		operation.add("e2", visit(ctx.e2));
		operation.add("op", ctx.op.getText());
		return operation;
	}


	@Override public ST visitComparisonExpr(ScratchParser.ComparisonExprContext ctx) 
	{ 
		ST operation = stg.getInstanceOf("binaryExpression");
		operation.add("e1", visit(ctx.e1));
		operation.add("e2", visit(ctx.e2));
		operation.add("op", ctx.op.getText());
		return operation;
	}
	
	
	@Override public ST visitParenExpr(ScratchParser.ParenExprContext ctx) 
	{
		ST expr = stg.getInstanceOf("parent");
		expr.add("value", visit(ctx.expression()));
		return expr;
	}
	
	
	@Override public ST visitSignalExpr(ScratchParser.SignalExprContext ctx) 
	{
		ST init = stg.getInstanceOf("init");
		init.add("value", ctx.signal.getText() + visit(ctx.expression()).render());
		return init;
	}
	
	
	@Override public ST visitLogicCompExpr(ScratchParser.LogicCompExprContext ctx) 
	{
		ST operation = stg.getInstanceOf("binaryExpression");
		ST logic = stg.getInstanceOf("literalLogic");
		operation.add("e1", visit(ctx.e1));
		operation.add("e2", visit(ctx.e2));
		logic.add("value", ctx.op.getText());
		operation.add("op", logic.render());
		return operation;
	}
	
	
	@Override public ST visitLogicNotExpr(ScratchParser.LogicNotExprContext ctx) 
	{ 
		ST init = stg.getInstanceOf("init");
		init.add("value", "!" + visit(ctx.expression()).render());
		return init;
	}


	@Override public ST visitFuncExpr(ScratchParser.FuncExprContext ctx) 
	{
		return visitChildren(ctx);
	}
	
	
	@Override public ST visitMethodExpr(ScratchParser.MethodExprContext ctx) 
	{
		return visitChildren(ctx);
	}
	
	
	@Override public ST visitClassInstExpr(ScratchParser.ClassInstExprContext ctx) 
	{
		return visitChildren(ctx);
	}
	
	
	@Override public ST visitAssignExpr(ScratchParser.AssignExprContext ctx) 
	{
		return visitChildren(ctx);
	}
	
	
	@Override public ST visitVarDeclExpr(ScratchParser.VarDeclExprContext ctx) 
	{
		hasDeclarationInside = true;
		return visitChildren(ctx);
	}
	
	
	@Override public ST visitIsKeyPressedExpr(ScratchParser.IsKeyPressedExprContext ctx) 
	{ 
		return visitChildren(ctx);
	}
	
	@Override public ST visitRandomExpr(ScratchParser.RandomExprContext ctx) 
	{
		return visitChildren(ctx);
	}
	
	
	@Override public ST visitNumExpr(ScratchParser.NumExprContext ctx) 
	{
		ST init = stg.getInstanceOf("init");
		init.add("value", ctx.NUM().getText());
		return init;
	}
	
	
	@Override public ST visitBooleanExpr(ScratchParser.BooleanExprContext ctx) 
	{
		ST init = stg.getInstanceOf("init");
		ST bool = stg.getInstanceOf("literalBoolean");
		bool.add("value", ctx.BOOLEAN().getText());
		init.add("value", bool.render());
		return init;
	}

	
	@Override public ST visitStringExpr(ScratchParser.StringExprContext ctx) 
	{
		ST init = stg.getInstanceOf("init");
		init.add("value", ctx.STRING().getText());
		return init;
	}

	@Override public ST visitVarExpr(ScratchParser.VarExprContext ctx) 
	{
		String var = getSymbol(ctx.ID().getText()).varName();
		ST init = stg.getInstanceOf("init");
		init.add("value", var);
		return init;
	}
}
