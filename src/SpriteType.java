import java.util.List;
import java.util.ArrayList;

public class SpriteType extends Type {

    private static String[][] methods = {
        {"Sprite",        "1", "Sprite",  "string"},
        {"move",          "0", "void"  ,  "number", "number"},
        {"goto",          "0", "void"  ,  "number", "number"},
        {"getX",          "0", "number"}, 
        {"getY",          "0", "number"}, 
        {"changeCostume", "0", "void"  ,  "string"},
        {"rotate",        "0", "void"  ,  "number"},
        {"setSize",       "0", "void"  ,  "number", "number"},
        {"getWidth",      "0", "number"},
        {"getHeight",     "0", "number"},
        {"touching",      "0", "boolean", "Sprite"},
        {"setGravity",    "0", "void"  , "number"}
    };

    public SpriteType() {
        super("Sprite");
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
