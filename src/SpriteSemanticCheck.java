import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

public class SpriteSemanticCheck extends SpriteBaseVisitor<Boolean>
{
  private final NumberType numberType = new NumberType();
  private final StringType stringType = new StringType();
  private final BooleanType booleanType = new BooleanType();

  /**
   * Entra na regra program e visita as regras mandatoryDefinitions e fieldDefinitions
   * @return res - resultado booleano da visita às regras
   */
  @Override
  public Boolean visitProgram (SpriteParser.ProgramContext ctx)
  {
    Boolean res = visitChildren(ctx);

    return res;
  }
  
  /**
   * Entra na regra mandatoryDefinitions e visita as regras nameDefinition e typeDefinition
   * @return res - resultado booleano da visita às regras
   */
  @Override
  public Boolean visitMandatoryDefinitions (SpriteParser.MandatoryDefinitionsContext ctx)
  {
    Boolean res = visitChildren(ctx);

    return res;
  }
  
  /**
   * Entra na regra fieldDefinition e visita as regras fieldName e propertyDefinition
   * @return res - resultado booleano da visita às regras
   */
  @Override
  public Boolean visitFieldDefinition (SpriteParser.FieldDefinitionContext ctx)
  {
    Boolean res = true;
    Field f = ctx.fieldName().field;
      
    if (f.isDefined())
    {
      ErrorHandling.printError(ctx, "Campo " + f.name() + " só pode ser definido uma vez!");
      res = false;
    }

    for (SpriteParser.PropertyDefinitionContext c : ctx.propertyDefinition())
    {
      
      if (fetchField(f, c.property().prop) == null)
      {
        ErrorHandling.printError(ctx, "Campo " + f.name() + " apenas aceita " + f.getProps() + "como propriedades!");
        res = false;
      }

      res = res && visit(c);
    }

    return res;
  }
  
  /**
   * 
   * @return
   */
  @Override
  public Boolean visitNameDefinition (SpriteParser.NameDefinitionContext ctx)
  {
    Boolean res = visit(ctx.expr());

    if (res)
      if (!ctx.expr().type.name().equals("string"))
      {
        ErrorHandling.printError(ctx, "Campo name tem de ser do tipo string!");
        res = false;
      }

    return res;
  }
  
  /**
   *
   *
   */
  @Override
  public Boolean visitTypeDefinition (SpriteParser.TypeDefinitionContext ctx)
  {
    Boolean res = true;
    Type t = ctx.spriteType().res;

    if (res)
      if (fetchType(t) == null)
      {
        ErrorHandling.printError("Texture, Rectangle, Triangle, Circle, Square, RegularPolygon são os únicos tipos que a Sprite pode assumir!");
        res = false;
      }

    return res;
  }
  
  /**
   *
   *
   */
  @Override
  public Boolean visitPropertyDefinition (SpriteParser.PropertyDefinitionContext ctx)
  {
    Boolean res = true;
    Property p = ctx.property().prop;

    if (p.isDefined())
    {
      ErrorHandling.printError(ctx, "Propriedade " + p.name() + " só pode ser definido uma vez!");
      res = false;
    }

    if (ctx.expr().size() == 1)
    {
      res = visit(ctx.expr().get(0));

      if (res)
        if (fetchProperty(p, ctx.expr().get(0)) == null)
        {
          ErrorHandling.printError(ctx, "Propriedade " + p.name() + " apenas aceita " + p.getExprType() + ", como tipo do valor atribuído!");
          res = false;
        }
    }
    else if (ctx.expr().size() == 4)
    {
      for (SpriteParser.ExprContext c : ctx.expr())
      {
        res = res && visit(c);

        if (res)
          if (fetchProperty(p, c) == null)
          {
            ErrorHandling.printError(ctx, "Propriedade " + p.name() + " apenas aceita " + p.getExprType() + ", como tipo do valor atribuído!");
            res = false;
          }
      }
    }
    else
    {
      ErrorHandling.printError(ctx, "Número de expressões válidas: 4 para crop e 1 para todas as outras!");
      res = false;
    }

    return res;
  }
  
  /**
   *
   *
   */
  @Override
  public Boolean visitBooleanExpr (SpriteParser.BooleanExprContext ctx)
  {
    ctx.type = booleanType;

    return true;
  }
  
  /**
   *
   *
   */
  @Override
  public Boolean visitStringExpr (SpriteParser.StringExprContext ctx)
  {
    ctx.type = stringType;

    return true;
  }
  
  /**
   *
   *
   */
  @Override
  public Boolean visitAddSubExpr (SpriteParser.AddSubExprContext ctx)
  {
    Boolean res = visit(ctx.e1) && checkNumericType(ctx, ctx.e1.type) && 
                  visit(ctx.e2) && checkNumericType(ctx, ctx.e2.type);

    if (res)
      ctx.type = fetchType(ctx.e1.type, ctx.e2.type);

    return res;
  }
  
  /**
   * 
   *
   */
  @Override
  public Boolean visitNumberExpr (SpriteParser.NumberExprContext ctx)
  {
    ctx.type = numberType;

    return true;
  }
  
  /**
   *
   *
   */
  @Override
  public Boolean visitParenthesisExpr (SpriteParser.ParenthesisExprContext ctx)
  {
    Boolean res = visit(ctx.expr());

    if (res)
      ctx.type = ctx.expr().type;

    return res;
  }

  /**
   *
   *
   */
  @Override
  public Boolean visitSignExpr (SpriteParser.SignExprContext ctx)
  {
    Boolean res = visit(ctx.e) && checkNumericType(ctx, ctx.e.type);

    if (res)
      ctx.type = ctx.e.type;

    return res;
  }
  
  /**
   *
   *
   */
  @Override
  public Boolean visitMultDivExpr (SpriteParser.MultDivExprContext ctx)
  {
    Boolean res = visit(ctx.e1) && checkNumericType(ctx, ctx.e1.type) &&
                  visit(ctx.e2) && checkNumericType(ctx, ctx.e2.type);

    if (res)
      ctx.type = fetchType(ctx.e1.type, ctx.e2.type);

    return res;
  }

  /**
   *
   *
   */
  private Boolean checkNumericType (ParserRuleContext ctx, Type t)
  {
    Boolean res = true;

    if (!t.isNumeric())
    {
      ErrorHandling.printError(ctx, "Operador numerico aplicado a um operando não numerico!");
      res = false;
    }

    return res;
  }

  /**
   *
   *
   */
  private Type fetchType (Type t1, Type t2)
  {
    Type res = null;

    if (t1.isNumeric() && t2.isNumeric())
    {
      if ("real".equals(t1.name()))
        res = t1;
      else if ("real".equals(t2.name()))
        res = t2;
      else
        res = t1;
    }

    return res;
  }

  /**
   *
   *
   */
  private Type fetchType (Type t1)
  {
    Type res = null;

    if ("Texture".equals(t1.name()))
      res = t1;
    else if ("Rectangle".equals(t1.name()))
      res = t1;
    else if ("Circle".equals(t1.name()))
      res = t1;
    else if ("Triangle".equals(t1.name()))
      res = t1;
    else if ("Square".equals(t1.name()))
      res = t1;
    else if ("RegularPolygon".equals(t1.name()))
      res = t1;
    else if ("string".equals(t1.name()))
      res = t1;
    else if ("boolean".equals(t1.name()))
      res = t1;

    return res;
  }

  /**
   *
   *
   */
  private Field fetchField (Field f1, Property p1)
  {
    Field res = null;

    if ("costume".equals(f1.name()) && f1.contains(p1.name()))
      res = f1;
    else if ("physics".equals(f1.name()) && f1.contains(p1.name()))
      res = f1;
    else if ("geometry".equals(f1.name()) && f1.contains(p1.name()))
      res = f1;

    return res;
  }

  /**
   *
   *
   */
  private Property fetchProperty (Property p1, SpriteParser.ExprContext expr)
  {
    Property res = null;
    Type t1 = expr.type;

    if ("name".equals(p1.name()) && p1.getExprType().equals(t1.name()))
      res = p1;
    else if ("type".equals(p1.name()) && p1.getExprType().equals(t1.name()))
      res = p1;
    else if ("crop".equals(p1.name()) && p1.getExprType().equals(t1.name()))
      res = p1;
    else if ("source".equals(p1.name()) && p1.getExprType().equals(t1.name()))
      res = p1;
    else if ("height".equals(p1.name()) && p1.getExprType().equals(t1.name()))
      res = p1;
    else if ("width".equals(p1.name()) && p1.getExprType().equals(t1.name()))
      res = p1;
    else if ("gravity".equals(p1.name()) && p1.getExprType().equals(t1.name()))
      res = p1;
    else if ("collidable".equals(p1.name()) && p1.getExprType().equals(t1.name()))
      res = p1;
    else if ("boundingBoxType".equals(p1.name()) && p1.getExprType().equals(t1.name()))
      res = p1;
    else if ("radius".equals(p1.name()) && p1.getExprType().equals(t1.name()))
      res = p1;
    else if ("xPosition".equals(p1.name()) && p1.getExprType().equals(t1.name()))
      res = p1;
    else if ("yPosition".equals(p1.name()) && p1.getExprType().equals(t1.name()))
      res = p1;
    else if ("nSides".equals(p1.name()) && p1.getExprType().equals(t1.name()))
      res = p1;

    return res;
  }
}
