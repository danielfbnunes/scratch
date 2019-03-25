// Generated from Scratch.g4 by ANTLR 4.7.1

	import java.util.Map;
	import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ScratchParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ScratchVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ScratchParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(ScratchParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScratchParser#headerDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeaderDef(ScratchParser.HeaderDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code retStat}
	 * labeled alternative in {@link ScratchParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetStat(ScratchParser.RetStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclStat}
	 * labeled alternative in {@link ScratchParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclStat(ScratchParser.VarDeclStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link ScratchParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStat(ScratchParser.AssignStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcInvStat}
	 * labeled alternative in {@link ScratchParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncInvStat(ScratchParser.FuncInvStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classInstStat}
	 * labeled alternative in {@link ScratchParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstStat(ScratchParser.ClassInstStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvStat}
	 * labeled alternative in {@link ScratchParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvStat(ScratchParser.MethodInvStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcDefStat}
	 * labeled alternative in {@link ScratchParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDefStat(ScratchParser.FuncDefStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalStat}
	 * labeled alternative in {@link ScratchParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalStat(ScratchParser.ConditionalStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loopDeclStat}
	 * labeled alternative in {@link ScratchParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopDeclStat(ScratchParser.LoopDeclStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclOnly}
	 * labeled alternative in {@link ScratchParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclOnly(ScratchParser.VarDeclOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclAndAssign}
	 * labeled alternative in {@link ScratchParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclAndAssign(ScratchParser.VarDeclAndAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScratchParser#idList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdList(ScratchParser.IdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScratchParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(ScratchParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScratchParser#isKeyPressed}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsKeyPressed(ScratchParser.IsKeyPressedContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScratchParser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(ScratchParser.KeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScratchParser#random}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRandom(ScratchParser.RandomContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScratchParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(ScratchParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScratchParser#functionInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionInvocation(ScratchParser.FunctionInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScratchParser#classInstanciation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanciation(ScratchParser.ClassInstanciationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScratchParser#argsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgsList(ScratchParser.ArgsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScratchParser#argsListDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgsListDef(ScratchParser.ArgsListDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objMethodInvocation}
	 * labeled alternative in {@link ScratchParser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjMethodInvocation(ScratchParser.ObjMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticMethodInvocation}
	 * labeled alternative in {@link ScratchParser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticMethodInvocation(ScratchParser.StaticMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScratchParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(ScratchParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScratchParser#returnStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(ScratchParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScratchParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(ScratchParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScratchParser#elseIfStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStat(ScratchParser.ElseIfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link ScratchParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(ScratchParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link ScratchParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(ScratchParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScratchParser#statList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatList(ScratchParser.StatListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isKeyPressedExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsKeyPressedExpr(ScratchParser.IsKeyPressedExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpr(ScratchParser.FuncExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(ScratchParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code randomExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRandomExpr(ScratchParser.RandomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpr(ScratchParser.BooleanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpr(ScratchParser.ComparisonExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicNotExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicNotExpr(ScratchParser.LogicNotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(ScratchParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumExpr(ScratchParser.NumExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(ScratchParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(ScratchParser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code signalExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignalExpr(ScratchParser.SignalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classInstExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstExpr(ScratchParser.ClassInstExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodExpr(ScratchParser.MethodExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicCompExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicCompExpr(ScratchParser.LogicCompExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclExpr(ScratchParser.VarDeclExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multDivExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivExpr(ScratchParser.MultDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(ScratchParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link ScratchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(ScratchParser.AssignExprContext ctx);
}