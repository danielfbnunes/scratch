// Generated from Sprite.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SpriteParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SpriteVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SpriteParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SpriteParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpriteParser#mandatoryDefinitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMandatoryDefinitions(SpriteParser.MandatoryDefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpriteParser#fieldDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDefinition(SpriteParser.FieldDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpriteParser#nameDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameDefinition(SpriteParser.NameDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpriteParser#typeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefinition(SpriteParser.TypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpriteParser#propertyDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyDefinition(SpriteParser.PropertyDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link SpriteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(SpriteParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link SpriteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(SpriteParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code signExpr}
	 * labeled alternative in {@link SpriteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignExpr(SpriteParser.SignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link SpriteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpr(SpriteParser.NumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link SpriteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpr(SpriteParser.BooleanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multDivExpr}
	 * labeled alternative in {@link SpriteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivExpr(SpriteParser.MultDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesisExpr}
	 * labeled alternative in {@link SpriteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisExpr(SpriteParser.ParenthesisExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpriteParser#spriteType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpriteType(SpriteParser.SpriteTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpriteParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldName(SpriteParser.FieldNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpriteParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(SpriteParser.PropertyContext ctx);
}