import java.util.List;
import java.util.ArrayList;

public class ListType extends Type {

    private static String[][] methods = {
        {"List",   "1", "List"},
        {"insert", "0", "void",   "Sprite"},
        {"insert", "0", "void",   "number", "Sprite"},
        {"remove", "0", "void",   "Sprite"},
        {"remove", "0", "void",   "number"},
        {"get",    "0", "Sprite", "number"}
    };


    public ListType() {
        super("List");
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
