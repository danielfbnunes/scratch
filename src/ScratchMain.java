import static java.lang.System.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.*;

public class ScratchMain
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			out.println("Usage: java -ea ScratchMain <source-file> ...");
			exit(0);
		}
		String srcFile = args[0];
		String[] dirs = srcFile.split("/");
		String name = dirs[dirs.length -1];
		
        runCompiler(srcFile, name);
	}

	public static void runCompiler(String sourceFile, String name)
	{
		assert sourceFile != null && !sourceFile.isEmpty();

		try
		{
			// create a CharStream that reads from standard input:
			CharStream input = CharStreams.fromStream(new FileInputStream(sourceFile));
			// create a lexer that feeds off of input CharStream:
			ScratchLexer lexer = new ScratchLexer(input);
			// create a buffer of tokens pulled from the lexer:
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			// create a parser that feeds off the tokens buffer:
			ScratchParser parser = new ScratchParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new ScratchErrorListener());
			// begin parsing at main rule:
			ParseTree tree = parser.main();
			if (parser.getNumberOfSyntaxErrors() == 0) {
				// print LISP-style tree:
				// System.out.println(tree.toStringTree(parser));
				ScratchSemanticCheck semanticCheck = new ScratchSemanticCheck();
				ScratchCompiler compiler = new ScratchCompiler();
				//Definir nome do jogo
				compiler.setFileName(name);
				semanticCheck.visit(tree);
				if (!ErrorHandling.error())
				{
					String target = "cpp";
					File f = new File(target + ".stg");
					if (!"cpp".equalsIgnoreCase(target) && f.exists() && f.isFile() && f.canRead())
					{
						err.println("ERROR: template group file for target "+target+" not found!");
						exit(2);
					}
					ST code = compiler.visit(tree);
					
					String filename = name + "." + target;
					try
					{
						code.add("name", name);
						PrintWriter pw = new PrintWriter(new File(filename));
						pw.print(code.render());
						pw.close();
					}
					catch(IOException e)
					{
						err.println("ERROR: unable to write in file "+filename);
						exit(3);
					}
					
				}
			}
		}
		catch(IOException e)
		{
			err.println("ERROR: unable to read from file "+sourceFile);
			exit(4);
		}
	}
}
