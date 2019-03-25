import java.util.*;
import java.io.File;
import org.stringtemplate.v4.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;


public class SpriteInterpreter extends SpriteBaseVisitor<ST>{
    protected String name = "sprite1";
	protected int varCount = 0;
	protected String target = "dict";
	protected STGroup stg = null;

	public boolean validTarget(String target) 
	{
		File f = new File(target+".stg");
		return f.exists() && f.isFile() && f.canRead();
	}

	public void setTarget(String target) 
	{
		assert validTarget(target);
		this.target = target;
	}
    
    public void setVarName(String name){
        this.name = name;
    }

	@Override public ST visitProgram(SpriteParser.ProgramContext ctx) { 
        stg = new STGroupFile(target+".stg");
		ST file = stg.getInstanceOf("stats");
        file.add("stat", visit(ctx.mandatoryDefinitions()));
        for(SpriteParser.FieldDefinitionContext sc : ctx.fieldDefinition())
			file.add("stat", visit(sc));
		return file; 
    }

	@Override public ST visitMandatoryDefinitions(SpriteParser.MandatoryDefinitionsContext ctx) { 
        String type = visit(ctx.typeDefinition()).render();
        
        ST instr = stg.getInstanceOf("stats");

        ST decl = stg.getInstanceOf("declaration");
        ST leftSide = stg.getInstanceOf("leftSideExpr");
        ST attr = stg.getInstanceOf("classAtribution");
        
        attr.add("value",'"' + visit(ctx.nameDefinition()).render()+'"');
        attr.add("property", "name");
        attr.add("name", name);

        leftSide.add("type", type);
        decl.add("type", type);
        decl.add("varName", name);
        decl.add("value", leftSide.render()); 
        
        instr.add("stat", decl.render());
        instr.add("stat", attr.render());
        
        return instr;
    }

	@Override public ST visitFieldDefinition(SpriteParser.FieldDefinitionContext ctx) { 
        String field = ctx.fieldName().getText();
        ST res = stg.getInstanceOf("stats");
        for(SpriteParser.PropertyDefinitionContext sc : ctx.propertyDefinition())
			res.add("stat", visit(sc));
        return res;
    }

	@Override public ST visitNameDefinition(SpriteParser.NameDefinitionContext ctx) { 
        return visit(ctx.expr()); 
    }

	@Override public ST visitTypeDefinition(SpriteParser.TypeDefinitionContext ctx) { 
        ST value = stg.getInstanceOf("valueWrite");
        value.add("value", ctx.spriteType().res.name());
        return value;
    }

	@Override public ST visitPropertyDefinition(SpriteParser.PropertyDefinitionContext ctx) { 
        
        ST attr = stg.getInstanceOf("classAtribution"); 
        if(!ctx.property().getText().equals("source")){ 
            attr.add("name",name);
            attr.add("property", ctx.property().getText());
            ST args = stg.getInstanceOf("args");
            for (SpriteParser.ExprContext sc : ctx.expr())
                args.add("expr", visit(sc));   
            attr.add("value", args.render());
        }
        else{
            ST stats = stg.getInstanceOf("stats");
            ST inst = stg.getInstanceOf("instanciation");
            inst.add("class", "sf::Texture");
            inst.add("name", name+"text");
            stats.add("stat", inst.render());
            
            attr.add("name", name+"text");
            attr.add("property", "loadFromFile");
            attr.add("value", visit(ctx.expr().get(0)).render());
            stats.add("stat", attr.render());

            attr = stg.getInstanceOf("classAtribution");
            attr.add("name", name );
            attr.add("property", "setTexture");
            attr.add("value", name+"text");
            stats.add("stat", attr.render());
            return stats;
        
        }

        return attr;
    }

	@Override public ST visitStringExpr(SpriteParser.StringExprContext ctx) { 
        ST value = stg.getInstanceOf("valueWrite");
        value.add("value", ctx.STRING().getText().replace("\"",""));
        return value; 
    }

	@Override public ST visitParenthesisExpr(SpriteParser.ParenthesisExprContext ctx) { 
        ST parentesis = stg.getInstanceOf("parentesis");
        parentesis.add("value", visit(ctx.expr()).render());
        return parentesis; 
    }

	@Override public ST visitNumberExpr(SpriteParser.NumberExprContext ctx) { 
        ST value = stg.getInstanceOf("valueWrite");
        value.add("value", ctx.NUMBER().getText());
        return value; 
    }

	@Override public ST visitMultDivExpr(SpriteParser.MultDivExprContext ctx) { 
       ST expr = stg.getInstanceOf("binaryExpression");
       expr.add("e1", visit(ctx.e1).render());
       expr.add("e2", visit(ctx.e2).render());
       expr.add("op", ctx.op.getText());
       return expr; 
    }

	@Override public ST visitAddSubExpr(SpriteParser.AddSubExprContext ctx) { 
       ST expr = stg.getInstanceOf("binaryExpression");
       expr.add("e1", visit(ctx.e1).render());
       expr.add("e2", visit(ctx.e2).render());
       expr.add("op", ctx.op.getText());
       return expr; 
    }
}





