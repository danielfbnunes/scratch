import java.util.List;
import java.util.ArrayList;

public class WindowType extends Type {

    private static String[][] methods = {
        {"close",     "1", "void"},
        {"getHeight", "1", "number"},
        {"getWidth",  "1", "number"},
        {"setSize",   "1", "void", "number", "number"},
        {"setTitle",  "1", "void", "string"}
    };

    public WindowType() {
        super("Window");
    }

    @Override
    public List<FunctionType> getMethod(String funName) {
        List<FunctionType> functions = new ArrayList<>();
        for (int m = 0; m < methods.length; m++)
            if (methods[m][0].equals(funName)) {
                 FunctionType f = new FunctionType(getType(methods[m][2]));
                 for (int i = 3; i < methods[m].length; i++)
                     f.addArg(getType(methods[m][i]));
                 f.isStatic = methods[m][1].equals("1");
                 functions.add(f);
            }
        return functions;
    }

    @Override
    public boolean hasMethod(String funName) {
        for (String[] sArray : methods)
            if (sArray[0].equals(funName))
                return true;
        return false;
    }
}
