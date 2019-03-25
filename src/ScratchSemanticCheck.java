// Generated from Scratch.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Classe que faz a análise semântica do código e do(s) ficheiros de configuração.
 */
public class ScratchSemanticCheck extends ScratchBaseVisitor<Boolean> {

    /**
     * Instâncias de todos os tipos de dados possível.
     */
    private final BooleanType booleanType = new BooleanType();
    private final ListType    listType    = new ListType();
    private final NumberType  numberType  = new NumberType();
    private final VoidType    voidType    = new VoidType();
    private final SpriteType  spriteType  = new SpriteType();
    private final WindowType  windowType  = new WindowType();
    private final StringType  stringType  = new StringType();

    /**
     * ParseTreeProperty para ajudar na análise.
     */
    private ParseTreeProperty<Object> PTP = new ParseTreeProperty<>();

    /**
     * Sequência de contextos atuais.
     */
    private List<Integer> nodeSeq = new ArrayList<>();
    
    /**
     * Contador de contextos.
     */
    private int     contextID              = 0;
    /**
     * Saber se estamos dentro de uma função ou não.
     */
    private boolean insideFunctionDef      = false;
    /**
     * Se estivermos dentro de uma função, esta variável irá conter o seu nome.
     */
    private String  currentFunctionName    = null;

    /**
     * Visit da regra main.
     * 
     * Adiciona o contexto global (nº 0), e visita todos os filhos.
     * Também verifica se a função main está definida e se estiver se foi definida
     * de maneira correta. Verifica se a função init está bem definida caso tenha
     * sido definida.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
    @Override public Boolean visitMain(ScratchParser.MainContext ctx) { 

        nodeSeq.add(0, 0);
        ScratchParser.contextSymbolTables.add(new HashMap<>());

        Boolean res = visitChildren(ctx);
        ScratchParser.funcsToBeDef.forEach((k, v) -> {
            if (!hasSymbol(k))
                ErrorHandling.printError((ParserRuleContext)v[0], (String)v[1]);
        });
        if (!hasSymbol("main")) {
            ErrorHandling.printError("A função main não foi definida!");
            res = false; 
        }
        else if (!((FunctionType)getSymbol("main").type()).getReturnValue().conformsTo(numberType)) {
            ErrorHandling.printError("A função main tem de retornar um number!");
            res = false; 
        }
        if (hasSymbol("init") && !((FunctionType)getSymbol("init").type()).getReturnValue().conformsTo(voidType)) {
            ErrorHandling.printError("A função void não pode retornar nenhum valor!");
            res = false; 
        }
        nodeSeq.remove(0);
        return res; 
    }
    
    /**
     * Visit da regra headerDef.
     * 
     * Aqui é criado o header das funções.
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
    @Override 
    @SuppressWarnings("unchecked")
    public Boolean visitHeaderDef(ScratchParser.HeaderDefContext ctx) { 
        List<Type> args = new ArrayList<>();
        if (ctx.argsListDef() != null) {
            visit(ctx.argsListDef());
            args = (List<Type>) PTP.get(ctx.argsListDef());
        }
        visit(ctx.dataType());
        FunctionType fType = new FunctionType(ctx.dataType().type);
        args.forEach(a -> fType.addArg(a));
        fType.isStatic = true;
        if (ctx.ID().getText().equals("main") && 
           (!ctx.dataType().type.conformsTo(numberType) || !(args.size() != 0))) {
            ErrorHandling.printError(ctx, "A função main tem de retornar um num e não possuí argumentos!");   
        }
        if (ctx.ID().getText().equals("init") && 
           (!ctx.dataType().type.conformsTo(voidType) || !(args.size() != 0))) {
            ErrorHandling.printError(ctx, "A função init não retorna nenhum valor e não possuí argumentos!");   
        }
        FunctionSymbol f = new FunctionSymbol(currentFunctionName, fType);
        ScratchParser.contextSymbolTables.get(0).put(ctx.ID().getText(), f);
        return visitChildren(ctx); 
    }
    /**
     * Visit da regra Expression (funcExpr callback)
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
    @Override 
    public Boolean visitFuncExpr(ScratchParser.FuncExprContext ctx) { 
        Boolean res = visitChildren(ctx);
        if (res)
            ctx.type = ctx.functionInvocation().type;
        return res; 
    }
    /**
     * Visit da regra Expression (addSubExpr callback)
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
    @Override 
    public Boolean visitAddSubExpr(ScratchParser.AddSubExprContext ctx) { 
        Boolean res = visit(ctx.e1);
        res &= visit(ctx.e2);
        res &= checkNumericType(ctx, ctx.e1.type);
        res &= checkNumericType(ctx, ctx.e1.type);
        if (res)
            ctx.type = numberType;
        return res; 
    }
    /**
     * Visit da regra Expression (boolean callback)
     * 
     * @param ctx
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
    @Override 
    public Boolean visitBooleanExpr(ScratchParser.BooleanExprContext ctx) { 
        ctx.type = booleanType;
        return true; 
    }
    /**
     * Visit da regra Expression (comparisonExpr callback)
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
    @Override 
    public Boolean visitComparisonExpr(ScratchParser.ComparisonExprContext ctx) { 
        Boolean res = visit(ctx.e1);
        res = visit(ctx.e2) && res;
        res &= ((checkNumericType(ctx, ctx.e1.type) && checkNumericType(ctx, ctx.e2.type))
               ||
               (checkBooleanType(ctx, ctx.e1.type)) && checkBooleanType(ctx, ctx.e2.type));
        if (res)
            ctx.type = booleanType;
        return res;
    }
    /**
     * Visit da regra Expression (logicNotExpr callback)
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
    @Override 
    public Boolean visitLogicNotExpr(ScratchParser.LogicNotExprContext ctx) { 
        Boolean res = visit(ctx.expression()) && checkBooleanType(ctx, ctx.expression().type);
        if (res)
            ctx.type = booleanType;
        return res;
    }
    /**
     * Visit da regra Expression (parenExpr callback)
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
    @Override 
    public Boolean visitParenExpr(ScratchParser.ParenExprContext ctx) {
        Boolean res = visit(ctx.expression());
        if (res)
            ctx.type = ctx.expression().type;
        return res;
    }
    /**
     * Visit da regra Expression (numExpr callback)
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
    @Override 
    public Boolean visitNumExpr(ScratchParser.NumExprContext ctx) {
        ctx.type = numberType;
        return true; 
    }
    /**
     * Visit da regra Expression (stringExpr callback)
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
    @Override 
    public Boolean visitStringExpr(ScratchParser.StringExprContext ctx) {
        ctx.type = stringType;
        return true; 
    }
    /**
     * Visit da regra Expression (signalExpr callback)
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
    @Override 
    public Boolean visitSignalExpr(ScratchParser.SignalExprContext ctx) {
        Boolean res = visit(ctx.e);
        res &= checkNumericType(ctx, ctx.e.type);
        if (res)
            ctx.type = ctx.e.type;
        return res;
    }
    /**
     * Visit da regra Expression (classInstExpr callback)
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitClassInstExpr(ScratchParser.ClassInstExprContext ctx) {
        Boolean res = visitChildren(ctx);
        if (res)
            ctx.type = ctx.classInstanciation().type;
        return res;
    }
    /**
     * Visit da regra Expression (methodExpr callback)
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitMethodExpr(ScratchParser.MethodExprContext ctx) {
        Boolean res = visitChildren(ctx);
        if (res)
            ctx.type = ctx.methodInvocation().type;
        return res;
    }
    /**
     * Visit da regra Expression (logicCompExpr callback)
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitLogicCompExpr(ScratchParser.LogicCompExprContext ctx) {
        Boolean res = visit(ctx.e1);
        res &= checkBooleanType(ctx, ctx.e1.type);
        res &= visit(ctx.e2);
        res &= checkBooleanType(ctx, ctx.e2.type);
        if (res)
            ctx.type = booleanType;
        return res;
    }
    /**
     * Visit da regra Expression (multDivExpr callback)
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitMultDivExpr(ScratchParser.MultDivExprContext ctx) {
        Boolean res = visit(ctx.e1) && visit(ctx.e2) && 
            checkNumericType(ctx, ctx.e1.type) && checkNumericType(ctx, ctx.e1.type);
        if (res)
            ctx.type = numberType;
        return res;
    }
    /**
     * Visit da regra Expression (powExpr callback)
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitPowExpr(ScratchParser.PowExprContext ctx) {
        Boolean res = visit(ctx.e1);
        res &= visit(ctx.e2);
        res &= checkNumericType(ctx, ctx.e1.type);
        res &= checkNumericType(ctx, ctx.e1.type);
        if (res)
            ctx.type = numberType;
        return res;
    }
    /**
     * Visit da regra Expression (assginExpr callback)
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitAssignExpr(ScratchParser.AssignExprContext ctx) {
        Boolean res = visitChildren(ctx);
        if (res)
            ctx.type = ctx.assignment().type;
        return res;
    }
    /**
     * Visit da regra Expression (varExpr callback)
     * 
     * Verificação da existência da variável, e se esta está definida ou não.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitVarExpr(ScratchParser.VarExprContext ctx) {
        Boolean res = true;
        String id = ctx.ID().getText();
        if (!hasSymbol(id)) {
            ErrorHandling.printError(ctx, "A variável \""+id+"\" não existe!");
            res = false;
        }
        else {
            Symbol vs = getSymbol(id);
            if (!vs.valueDefined()) {
                ErrorHandling.printError(ctx, "A variável \""+id+"\" não está definida!");
                res = false;
            }
            ctx.type = vs.type();
        }
        return res;
    }
    /**
     * Visit da regra varDeclOnly.
     * 
     * Verificação se a variável já existe e adicioná-la ao symbolTable do
     * contexto correspondente.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitVarDeclOnly(ScratchParser.VarDeclOnlyContext ctx) {
		Boolean res = true;
		for(TerminalNode t: ctx.idList().ID()) {
			String id = t.getText();
            if (ScratchParser.contextSymbolTables.get(nodeSeq.get(0)).containsKey(id)) {
                ErrorHandling.printError(ctx, "A variável \""+id+"\" já foi declarada!");
                res = false;
            } else {
				VariableSymbol vs = new VariableSymbol(id, ctx.dataType().type);
				if (ctx.dataType().type.conformsTo(listType))
					vs.setValueDefined();
                ScratchParser.contextSymbolTables.get(nodeSeq.get(0)).put(id, vs); 
                ctx.type = ctx.dataType().type;
            }
        }
		return res;
    }
    /**
     * Visit da regra varDeclAndAssign.
     * 
     * Verificação se a variável já foi declarada.E se o tipo da variável
     * corresponde com a expressão do lado direito.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitVarDeclAndAssign(ScratchParser.VarDeclAndAssignContext ctx) {
		Boolean res = visit(ctx.expression());
		String id = ctx.ID().getText();
        VariableSymbol vs = new VariableSymbol(id, ctx.dataType().type);
        if (ScratchParser.contextSymbolTables.get(nodeSeq.get(0)).containsKey(id)) {
            ErrorHandling.printError(ctx, "A variável \""+id+"\" já foi declarada!");
            res = false;
        }
        if (res) {
			if (vs.type().conformsTo(listType)) {
                ErrorHandling.printError(ctx, "As variáveis do tipo List são definidas automaticamente!");
                res = false;
			}	
            vs.setValueDefined();
            if (!ctx.expression().type.conformsTo(vs.type())) {
                ErrorHandling.printError(ctx, "O tipo da expressão não é conformante com o tipo da variável \""+id+"\"!");
                res = false;
            }
            else {
                ctx.type = ctx.dataType().type;
                ScratchParser.contextSymbolTables.get(nodeSeq.get(0)).put(id, vs);
            }
        }
    	return res;
    }
    /**
     * Visit da regra idList
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitIdList(ScratchParser.IdListContext ctx) {
        return visitChildren(ctx);
    }
    /**
     * Visit da regra assignment.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitAssignment(ScratchParser.AssignmentContext ctx) { 
		Boolean res = visit(ctx.expression());
		String id = ctx.ID().getText();
        if (!hasSymbol(id)) {
            ErrorHandling.printError(ctx, "A variável \""+id+"\" não existe!");
            res = false;
        }
        if (res) {
            Symbol sym = getSymbol(id);
			if (sym.type().conformsTo(listType)) {
                ErrorHandling.printError(ctx, "As variáveis do tipo List são definidas automaticamente!");
                res = false;
			} else {
				if (!ctx.expression().type.conformsTo(sym.type())) {
					ErrorHandling.printError(ctx, "O tipo da expressão não é conformante com o tipo da variável \""+id+"\"!");
					res = false;
				}
				else {
					sym.setValueDefined();
					ctx.type = ctx.expression().type;
				}
			}
        }
        return res;
    }
    /**
     * Visit da regra isKeyPressedExpr.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitIsKeyPressedExpr(ScratchParser.IsKeyPressedExprContext ctx) { 
        Boolean res = visitChildren(ctx);
        if (res)
            ctx.type = ctx.isKeyPressed().type;
        return visitChildren(ctx); 
    }
    /**
     * Visit da regra isKeyPressed.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitIsKeyPressed(ScratchParser.IsKeyPressedContext ctx) { 
        ctx.type = booleanType;
        return true; 
    }
    /**
     * Visit da regra random.
     * 
     * Verificação do tipo numérico dos operandos.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override public Boolean visitRandom(ScratchParser.RandomContext ctx) { 
        Boolean res = true;
        visit(ctx.e1);
        visit(ctx.e2);
        if (!checkNumericType(ctx, ctx.e1.type) || !checkNumericType(ctx, ctx.e2.type))
            res = false;
        return res; 
    }
    /**
     * Visit da regra randomExpr.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override public Boolean visitRandomExpr(ScratchParser.RandomExprContext ctx) { 
        Boolean res = visitChildren(ctx);
        ctx.type = numberType;
        return visitChildren(ctx); 
    }
    /**
     * Visit da regra varDeclExpr.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitVarDeclExpr(ScratchParser.VarDeclExprContext ctx) { 
        Boolean res = visitChildren(ctx);
        if (res)
            ctx.type = ctx.varDeclaration().type;
        return res;
    }
    /**
     * Visit da regra functionInvocation.
     * 
     * Verificação da se o contexto <bold>não</bold> é global, só aí se pode invocar funções.
     * Verificação se a função foi declarada.
     * Verificação se a função invocada é a main ou a init. (Não é possível invocar
     * estas funções, seja em que contexto for).
     * Verificação da validade dos argumentos.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
    @Override 
    @SuppressWarnings("unchecked")
    public Boolean visitFunctionInvocation(ScratchParser.FunctionInvocationContext ctx) {
        Boolean res = insideFunctionDef;
        if (!res) {
            ErrorHandling.printError(ctx, "Não é possível invocar funções fora de funções!");
            res = false;
        }
        else if (!hasSymbol(ctx.ID().getText())) {
            ErrorHandling.printError(ctx, "A função "+ctx.ID().getText()+" ainda não foi declarada!");
            return false; 
        } else {
            if (ctx.ID().getText().equals("init") || ctx.ID().getText().equals("main")) {
                ErrorHandling.printError(ctx, "Não é possível invocar a função "+ctx.ID().getText()+"()!");
                return false; 
            }
            // Se a função invocada não tiver argumentos, então a definição da função não pode ter argumentos.
            if (ctx.argsList() == null &&
                    ((FunctionType)getSymbol(ctx.ID().getText()).type()).getArgs().size() != 0)
                ErrorHandling.printError(ctx, "A função "+ctx.ID().getText()+" não é compatível com os argumentos: ()");
            else {
                List<Type> args = new ArrayList<>();
                if (ctx.argsList() != null) {
                    res = visit(ctx.argsList());
                    args = (List<Type>)((Object[]) PTP.get(ctx.argsList()))[0];
                }
                if (res) {
                    FunctionType fDef = (FunctionType)getSymbol(ctx.ID().getText()).type();
                    FunctionType fInv = new FunctionType(fDef.getReturnValue());
                    args.forEach(a -> fInv.addArg(a));
                    fInv.isStatic = true;
                    res = fInv.conformsTo(fDef);
                    if (!res) {
                        StringBuilder argPrintError = new StringBuilder();
                        argPrintError.append("A função "+ctx.ID().getText()+" não é compatível com os argumentos: (");
                        for (Type e : args)
                            argPrintError.append(e+",");
                        ErrorHandling.printError(ctx, argPrintError.substring(0, argPrintError.length()-1)+")");
                    } else
                        ctx.type = fDef.getReturnValue();
                }
            }
        }
        return res;
    }
    /**
     * Visit da regra classInstanciation.
     * 
     * Verificação se a classe é instanciável e da validade dos argumentos.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    @SuppressWarnings("unchecked")
    public Boolean visitClassInstanciation(ScratchParser.ClassInstanciationContext ctx) {
        Boolean res = true;
        visit(ctx.dataType());
        Type type = ctx.dataType().type;
        if (!type.conformsTo(spriteType) && !type.conformsTo(listType)) {
            ErrorHandling.printError(ctx, "Não é possível instanciar classes do tipo "+type+"!");
            res = false;
        } else {
            int errorNum = 0;
            String firstArg = null;
            List<Type> args = new ArrayList<>();
            if (ctx.argsList() != null) {
                visit(ctx.argsList());
                args = (List<Type>)((Object[]) PTP.get(ctx.argsList()))[0];
                firstArg = (String)((Object[]) PTP.get(ctx.argsList()))[1];
            }
            List<FunctionType> fDef = type.getMethod(type.name());
            for (FunctionType f : fDef) {
                if (ctx.argsList() == null && f.getArgs().size() != 0)
                        errorNum = 1;
                else {
                    FunctionType fInv = new FunctionType(f.getReturnValue());
                    args.forEach(a -> fInv.addArg(a));
                    fInv.isStatic = true;
                    res = fInv.conformsTo(f);
                    if (!res) {
                        errorNum = 2;

                    } else {
                        if (ctx.dataType().type.conformsTo(spriteType))
                            res = checkSprite(ctx, firstArg.substring(1, firstArg.length()-1));
                    }
                    res = true;
                    break;
                }
            }
            if (errorNum == 1)
                ErrorHandling.printError(ctx, "O construtor da classe "+type+" não é compatível com os argumentos: ()");
            else if (errorNum == 2) {
                StringBuilder argPrintError = new StringBuilder();
                argPrintError.append("O construtor da classe "+type+" não é compatível com os argumentos: (");
                for (Type e : args)
                    argPrintError.append(e+",");
                ErrorHandling.printError(ctx, argPrintError.substring(0, argPrintError.length()-1)+")");
            }
        }
        ctx.type = ctx.dataType().type;
        return true; 
    }
    /**
     * Visit da regra argsList.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitArgsList(ScratchParser.ArgsListContext ctx) { 
        List<Type> fArgs = new ArrayList<>();
        Boolean res = true;
        for (ScratchParser.ExpressionContext e : ctx.expression()) {
            res = visit(e) && res;
            fArgs.add(e.type);
        }
        PTP.put(ctx, new Object[]{fArgs, ctx.expression().size() == 0 ? null : ctx.expression(0).getText()});
        return res; 

    }
    /**
     * Visit da regra argsListDef.
     * 
     * Adicionar as variáveis da definição dos argumentos ao contexto correspondente.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitArgsListDef(ScratchParser.ArgsListDefContext ctx) { 
        Boolean res = (ctx.dataType().size() == ctx.ID().size());
        if (res) {
            List<Type> args = new ArrayList<>();
            for (int i = 0; i < ctx.dataType().size(); i++) {
                ScratchParser.DataTypeContext d = ctx.dataType(i);
                visit(d);
                args.add(d.type);
                String id = ctx.ID(i).getText();
                VariableSymbol vs = new VariableSymbol(id, d.type);
                vs.setValueDefined();
                ScratchParser.contextSymbolTables.get(nodeSeq.get(0)).put(id, vs);
            }
            PTP.put(ctx, args);
        }
        return res; 
    }
    /**
     * Visit da regra ObjMethodInvocation.
     * 
     * Verificação se a variável que contém o objeto existe e está definida.
     * Verificação se o método existe e da validade dos argumentos.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    @SuppressWarnings("unchecked")
    public Boolean visitObjMethodInvocation(ScratchParser.ObjMethodInvocationContext ctx) {
        String object = ctx.id1.getText();
        String method = ctx.id2.getText();
        Boolean res = false;
        if (hasSymbol(object)) {
            if (!getSymbol(object).valueDefined()) {
                ErrorHandling.printError(ctx, "A variável "+object+" não está definida!");
                res = false;
            } else {
                if (!getSymbol(object).type().hasMethod(method)) {
                    ErrorHandling.printError(ctx, "O método "+method+" não existe sobre um objeto do tipo "+getSymbol(object).type());
                    return res;
                }
                int errorNum = 0;
                String firstArg = null;
                List<Type> args = new ArrayList<>();
                if (ctx.argsList() != null) {
                    res = visit(ctx.argsList());
                    args = (List<Type>)((Object[]) PTP.get(ctx.argsList()))[0];
                }
                if (res) {
                    List<FunctionType> fDef = getSymbol(object).type().getMethod(method);
                    for (FunctionType f : fDef) {
                        if (ctx.argsList() == null && f.getArgs().size() != 0)
                                errorNum = 1;
                        else {
                            FunctionType fInv = new FunctionType(f.getReturnValue());
                            args.forEach(a -> fInv.addArg(a));
                            fInv.isStatic = true;
                            res = fInv.conformsTo(f);
                            if (!res)
                                errorNum = 2;
                            else {
                                ctx.type = f.getReturnValue();
                                res = true;
                                errorNum = 0;
                                break;
                            }
                        }
                    }
                    if (errorNum == 1)
                        ErrorHandling.printError("A função "+method+" não é compatível com os argumentos: ()");
                    else if (errorNum == 2) {
                        StringBuilder argPrintError = new StringBuilder();
                        argPrintError.append("A função "+method+" não é compatível com os argumentos: (");
                        for (Type e : args)
                            argPrintError.append(e+",");
                        ErrorHandling.printError(ctx, argPrintError.substring(0, argPrintError.length()-1)+")");
                    }
                }
            }
        } else {
            ErrorHandling.printError(ctx, "A variável "+object+" não existe!");
            res = false; 
        }
        return res;
    }
    /**
     * Visit da regra staticMethodInvocation.
     * 
     * Verificação se o método existe e da validade dos argumentos.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    @SuppressWarnings("unchecked")
    public Boolean visitStaticMethodInvocation(ScratchParser.StaticMethodInvocationContext ctx) {
        Type classe = ctx.dataType().type;
        String method = ctx.ID().getText();
        Boolean res = true;
        if (!classe.hasMethod(method)) {
            ErrorHandling.printError(ctx, "O método estático "+method+" não existe sobre a classe "+classe);
            return false;
        }
        int errorNum = 0;
        String firstArg = null;
        List<Type> args = new ArrayList<>();
        if (ctx.argsList() != null) {
            res = visit(ctx.argsList());
            args = (List<Type>)((Object[]) PTP.get(ctx.argsList()))[0];
        }
        if (res) {
            List<FunctionType> fDef = classe.getMethod(method);
            for (FunctionType f : fDef) {
                if (ctx.argsList() == null && f.getArgs().size() != 0)
                        errorNum = 1;
                else {
                    FunctionType fInv = new FunctionType(f.getReturnValue());
                    args.forEach(a -> fInv.addArg(a));
                    fInv.isStatic = true;
                    res = fInv.conformsTo(f);
                    if (!res) {
                        errorNum = 2;
                        res = false;
                    } else {
                        ctx.type = f.getReturnValue();
                        res = true;
                        errorNum = 0;
                        break;
                    }
                }
            }
            if (errorNum == 1)
                ErrorHandling.printError("O método "+method+" não é compatível com os argumentos: ()");
            else if (errorNum == 2) {
                StringBuilder argPrintError = new StringBuilder();
                argPrintError.append("O método "+method+" não é compatível com os argumentos: (");
                for (Type e : args)
                    argPrintError.append(e+",");
                ErrorHandling.printError(ctx, argPrintError.substring(0, argPrintError.length()-1)+")");
            }
        }
        return res;
    }
    /**
     * Visit da regra statList.
     * 
     * Inserir no ParseTreeProperty (PTP) se a última instrução é um return.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitStatList(ScratchParser.StatListContext ctx) { 
        PTP.put(ctx, ctx.stat(ctx.stat().size()-1) instanceof ScratchParser.RetStatContext);
        return visitChildren(ctx); 
    }
    /**
     * Visit da regra functionDefinition.
     * 
     * Verificação se o contexto atual é o global, pois só aí é possível definir 
     * funções.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    @SuppressWarnings("unchecked")
    public Boolean visitFunctionDefinition(ScratchParser.FunctionDefinitionContext ctx) { 
        Boolean res = !insideFunctionDef;
        currentFunctionName = ctx.ID().getText();
        insideFunctionDef = true;
        if (!res) {
            ErrorHandling.printError(ctx, "Não é possível definir funções dentro de funções!");
            res = false;
        } else if (hasSymbol(ctx.ID().getText())) {
            Symbol s = getSymbol(ctx.ID().getText());
            if (s.valueDefined()) {
                ErrorHandling.printError(ctx, "A função "+ctx.ID().getText()+" já foi definida!");
                res = false;
            } else
                s.setValueDefined();
        } else {
            List<Type> args = new ArrayList<>();
            if (ctx.argsListDef() != null) {
                visit(ctx.argsListDef());
                args = (List<Type>) PTP.get(ctx.argsListDef());
            }
            visit(ctx.dataType());
            FunctionType fType = new FunctionType(ctx.dataType().type);
            args.forEach(a -> fType.addArg(a));
            fType.isStatic = true;
            ctx.type = fType;
            FunctionSymbol f = new FunctionSymbol(currentFunctionName, ctx.type);
            f.setValueDefined();
            ScratchParser.contextSymbolTables.get(nodeSeq.get(0)).put(currentFunctionName, f);
        }
        nodeSeq.add(0, newContextID());
        ScratchParser.contextSymbolTables.add(new HashMap<>());
        if (ctx.statList() != null)
            visit(ctx.statList());
        nodeSeq.remove(0);
        insideFunctionDef = false;

        Boolean corretRetType = false;
        // Ou a função não tem instruções e é void, ou então a última instrução não é uma returnStat e a função é void.
        if((PTP.get(ctx.statList()) == null || !(Boolean)PTP.get(ctx.statList())) && ctx.dataType().type.conformsTo(voidType))
            corretRetType = true;
        else
            corretRetType = (Boolean)PTP.get(ctx.statList());
        if (!corretRetType) {
            ErrorHandling.printError(ctx, "O valor de retorno definido para a função "+currentFunctionName+" é do tipo "+ctx.dataType().type);
            res = false;
        }
        currentFunctionName = null;
        return res;
    }
    /**
     * Visit da regra returnStat.
     * 
     * Verificação se a função retorna algum valor, e se sim, a última instrução
     * tem de ser um return.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitReturnStat(ScratchParser.ReturnStatContext ctx) { 
        Boolean res = true;
        if (ctx.expression() != null) {
            res = visit(ctx.expression());
            ctx.type = ctx.expression().type;
        } else
            ctx.type = voidType;
        Type retType = ((FunctionType)getSymbol(currentFunctionName).type()).getReturnValue();
        if (!retType.conformsTo(ctx.type)) {
            if (retType.conformsTo(voidType))
                ErrorHandling.printError(ctx, "A função "+currentFunctionName+" não retorna nenhum valor!");
            else 
                ErrorHandling.printError(ctx, "A função "+currentFunctionName+" tem de retornar um "+retType+"!");
            res = false;
        }
        return res; 
    }
    /**
     * Visit da regra Conditional.
     * 
     * Verificação se a expressão é condicional.
     * Verificação se o contexto <bold>não</bold> é o global, pois só aí se pode definir
     * expressões condicionais.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitConditional(ScratchParser.ConditionalContext ctx) {

        Boolean res = visit(ctx.expression());
        
        nodeSeq.add(0, newContextID());
        ScratchParser.contextSymbolTables.add(new HashMap<>());
        if (ctx.trueStats != null)
            visit(ctx.trueStats);
        nodeSeq.remove(0);

        for (ScratchParser.ElseIfStatContext s : ctx.elseIfStat()) {
            nodeSeq.add(0, newContextID());
            ScratchParser.contextSymbolTables.add(new HashMap<>());
            res &= visit(s);
            nodeSeq.remove(0);
        }
        if (ctx.falseStats != null) {
            nodeSeq.add(0, newContextID());
            ScratchParser.contextSymbolTables.add(new HashMap<>());
            visit(ctx.falseStats);
            nodeSeq.remove(0);
        }
        if (res && !ctx.expression().type.name().equals("boolean")) {
            ErrorHandling.printError(ctx, "É necessário uma expressão booleana na instrução condicional!");
            res = false;
        }
        if (!insideFunctionDef) {
            res = insideFunctionDef;
            ErrorHandling.printError(ctx, "Não é possível definir expressões condicionais fora de funções!");
        }
        return res;
    }
    /**
     * Visit da regra elseIfStat.
     * 
     * Verificação se a expressão é booleana.
     * Verificação se o contexto <bold>não</bold> é o global, pois só aí se pode definir
     * expressões condicionais.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitElseIfStat(ScratchParser.ElseIfStatContext ctx) { 
        Boolean res = visit(ctx.expression());
        if (ctx.trueStats != null)
            visit(ctx.trueStats);
        if (!ctx.expression().type.name().equals("boolean")) {
            ErrorHandling.printError(ctx, "É necessário uma expressão booleana na instrução condicional!");
            res = false;
        }
        return res;
    }
    /**
     * Visit da regra whileLoop.
     * 
     * Verificação se a expressão é booleana.
     * Verificação se o contexto <bold>não</bold> é o global, pois só aí se pode definir
     * expressões de ciclo.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitWhileLoop(ScratchParser.WhileLoopContext ctx) {

        nodeSeq.add(0, newContextID());
        ScratchParser.contextSymbolTables.add(new HashMap<>());

        Boolean res = visit(ctx.expression());
        if (ctx.statList() != null)
            visit(ctx.statList());
        if (res) {
            if (!ctx.expression().type.name().equals("boolean")) {
                ErrorHandling.printError(ctx, "É necessário uma expressão booleana na instrução while!");
                res = false;
            }
        }
        if (!insideFunctionDef) {
            res = insideFunctionDef;
            ErrorHandling.printError(ctx, "Não é possível definir expressões de ciclo fora de funções!");
        }

        nodeSeq.remove(0);

        return res; 
    }
    /**
     * Visit da regra forLoop.
     * 
     * Verificação se a expressão é booleana.
     * Verificação se o contexto <bold>não</bold> é o global, pois só aí se pode definir
     * expressões de ciclo.
     * 
     * @param ctx Contexto.
     * @return <code>true</code> se não houve erro, <code>false</code> caso contrário.
     */
	@Override 
    public Boolean visitForLoop(ScratchParser.ForLoopContext ctx) {

        nodeSeq.add(0, newContextID());
        ScratchParser.contextSymbolTables.add(new HashMap<>());

        Boolean res = false;
        res = (ctx.expr1 != null && visit(ctx.expr1) && ctx.expr1.type.name().equals("boolean"));
        res = (ctx.expr2 != null && visit(ctx.expr2) && ctx.expr2.type.name().equals("boolean")) && res;
        res = (ctx.expr3 != null && visit(ctx.expr3) && ctx.expr3.type.name().equals("boolean")) && res;
        if (ctx.statList() != null)
            visit(ctx.statList());
        if (!insideFunctionDef) {
            res = insideFunctionDef;
            ErrorHandling.printError("Não é possível definir expressões de ciclo fora de funções!");
        }

        nodeSeq.remove(0);

        return res;
    }
    /**
     * Função auxiliar para verificação do tipo de dados numérico.
     * 
     * @param ctx Contexto.
     * @param t Tipo para efetuar a verificação.
     * @return <code>true</code> se for do tipo numérico, <code>false</code> caso contrário.
     */
    private Boolean checkNumericType(ParserRuleContext ctx, Type t) {
        if (t == null) return false;
        if (!t.isNumeric()) {
            ErrorHandling.printError(ctx, "Operador numérico aplicado a um operando não numérico!");
            return false;
        }
        return true;
    }
    /**
     * Função auxiliar para verificação do tipo de dados booleano.
     * 
     * @param ctx Contexto.
     * @param t Tipo para efetuar a verificação.
     * @return <code>true</code> se for do tipo booleano, <code>false</code> caso contrário.
     */
    private Boolean checkBooleanType(ParserRuleContext ctx, Type t) {
        if (t == null) return false;
        if (!t.isBoolean()) {
            ErrorHandling.printError(ctx, "Operador lógico aplicado a um operando não booleano!");
            return false;
        }
        return true;
    }
    /**
     * 
     * Verificação do ficheiro de configuração sprite.
     * Este método invoca a análise semântica do sprite.
     * 
     * @param spriteFileName Caminho para o ficheiro sprite.
     * @return <code>true</code> se não houve erro na análise da sprite, <code>false</code> caso contrário.
     */
    private Boolean checkSprite(ParserRuleContext ctx, String spriteFileName) {
        Boolean res = false;
        FileInputStream fis = null;
        CharStream input = null;
        try {
          fis = new FileInputStream(new File(spriteFileName));
          input = CharStreams.fromStream(fis);
        } catch (FileNotFoundException e) {
          ErrorHandling.printError(ctx, spriteFileName+": Ficheiro não encontrado!");
          return false;
        } catch (IOException e) {
          ErrorHandling.printError(ctx, spriteFileName+": Não foi possível ler o ficheiro!");
          return false;
        }
        SpriteLexer lexer = new SpriteLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SpriteParser parser = new SpriteParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ScratchErrorListener());
        ParseTree tree = parser.program();
        if (parser.getNumberOfSyntaxErrors() == 0) {
           SpriteSemanticCheck semanticCheck = new SpriteSemanticCheck();
           res = semanticCheck.visit(tree);
        }
        res = true;
        return res;
    }
    /**
     * Retorna um id para o novo contexto.
     * 
     * @return id para o novo contexto.
     */
    private int newContextID() {
        contextID += 1;
        return contextID;
    }
    /**
     * Função auxiliar para saber se um símbolo foi declarado.
     * 
     * @param id Nome do símbolo a procurar.
     * @return <code>true</code> se existe, <code>false</code> caso contrário.
     */
    private boolean hasSymbol(String id) {
        for (Integer i : nodeSeq)
            if (ScratchParser.contextSymbolTables.get(i).containsKey(id))
                return true;
        return false;
    }
    /**
     * Função auxiliar para retornar um símbolo declarado através do seu
     * nome.
     * 
     * @param id Nome do símbolo a retornar.
     * @return Símbolo encontrado.
     */
    private Symbol getSymbol(String id) {
        for (Integer i : nodeSeq)
            if (ScratchParser.contextSymbolTables.get(i).containsKey(id))
                return ScratchParser.contextSymbolTables.get(i).get(id);
        return null;
    }
}
