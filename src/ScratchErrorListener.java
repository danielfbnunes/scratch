import org.antlr.v4.runtime.*;
import java.util.*;

public class ScratchErrorListener extends BaseErrorListener {
    @Override public void syntaxError ( Recognizer< ? , ?> recognizer,
            Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e)
    {
        Parser p = (( Parser ) recognizer );
        List<String> stack = p.getRuleInvocationStack();
        Collections.reverse ( stack );
        StringBuilder sb = new StringBuilder();
        sb.append(msg);
        sb.append("na linha "+line+" coluna "+charPositionInLine);
        ErrorHandling.printMessage("rule stack: "+stack+" na linha "+line+" posição "+
                charPositionInLine+" em "+((CommonToken)offendingSymbol).getText()+", msg: "+msg,3);
    }
}
